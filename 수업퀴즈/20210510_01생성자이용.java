package com.day14;

import javax.swing.JOptionPane;

class Student {
//	 * Student 클래스 만들기 
//	 *  필드 : 이름, 국, 영, 수, 평균, 등급
	String name;
	int kr;
	int en;
	int ma;
	double avg;
	String grade;

//	 *  메소드 : 
//	 *   1. 생성자 
//	 *   	1) 아무것도 안넣어도 생성될 수 있게
	Student() {

	}

//	 *   	2) 이름만 넣고 생성될 수 있게
	Student(String name) {
		this.name = name;
	}

//	 *   	3) 이름, 국, 영, 수를 넣고 생성될 수 있게 => 평균, 등급 자동 계산
	Student(String name, int kr, int en, int ma) {
		this.name = name;
		this.kr = kr;
		this.en = en;
		this.ma = ma;
		setAvg();
		setGrade();
	}

//	 *   2. setAvg() - 국,영,수로 평균을 계산하여 평균 필드에 저장
	void setAvg() {
		avg = (kr + en + ma) / 3.0;
	}

//	 *   3. setGrade() - 평균 점수로 A,B,C,D,F를 계산하여 등급 필드에 저장
	void setGrade() {
		switch ((int) avg / 10) {
		case 100:
		case 90:
			grade = "A";
			break;
		case 80:
			grade = "B";
			break;
		case 70:
			grade = "C";
			break;
		case 60:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
	}

//	 *   4. printData() - 이름, 평균, 등급을 sysout
	void printData() {
		System.out.println(getData());
	}

//	 *   5. getData() - 이름, 국, 영, 수, 평균, 등급을 String으로 묶어서 return
//	 *  ** 참고! 생성자 안에서도 일반 메소드 호출할 수 있음! 
	String getData() {
		return "이름 : " + name + " / 국 : " + kr + " / 영 : " + en + " / 수 : " + ma + " / 평균 : " + avg + " / 등급 : "
				+ grade;
	}
}

public class Quiz01 {
	public static void main(String[] args) {
		/*
		 * Quiz01 메인 클래스 메뉴 : 1. 3명 학생 정보 입력 2. 3명 학생 정보 보기 3. 종료하기
		 */

		Student[] st = new Student[3];
		String menu = "1. 3명 학생 정보 입력 \n" + "2. 3명 학생 정보 보기\n" + "3. 종료하기";
		String choice = "";
		loop: while (true) {
			choice = JOptionPane.showInputDialog(menu);
			switch (choice) {
			case "1":
				for (int i = 0; i < st.length; ++i) {
					st[i] = new Student(JOptionPane.showInputDialog(null, i + 1 + "번 학생 이름"),
							Integer.parseInt(JOptionPane.showInputDialog(i + 1 + "번 학생 국어점수")),
							Integer.parseInt(JOptionPane.showInputDialog(i + 1 + "번 학생 영어점수")),
							Integer.parseInt(JOptionPane.showInputDialog(i + 1 + "번 학생 수학점수")));
				}
				break;
			case "2":
				String tt = "===학생 정보====";
				for (Student s : st) {
					if (s == null) {
						JOptionPane.showMessageDialog(null, tt+"\n입력된 학생 정보가 없습니다");
						break;
					}
					tt += "\n" + s.getData();
				}
				JOptionPane.showMessageDialog(null, tt);
				break;
			case "3":
				JOptionPane.showMessageDialog(null, "프로그램 종료");
				break loop;
			default:
				JOptionPane.showMessageDialog(null, "잘못된 메뉴입니다");
				break;
			}

		}
	}

}
