# getter and setter

Student 클래스 만들기 

  필드 : 이름, 국, 영, 수, 평균, 등급(gpa), 학년(grade) --> private
  
  메서드 : 
  
	1) 생성자 
		Student()
		Student(이름)
		Student(이름, 국, 영, 수)
	2) getter
	3) setter
		setName(String name) ~> 10글자 이하만 저장
		setKr(int kr), setEn(), setMa() ~> 0점 이상 100점 이하만 저장
		setAvg() ~> 국, 영, 수 필드로 평균 계산 및 avg 필드에 저장
		setGqa() ~> 평균 가지고 A, B, C, D, F 중 1개를 gpa 필드에 저장
		setGrade() ~> 1 ~ 4 학년만 저장
	4) getInfo()

​		모든 정보를 1개의 String 형태로 return

# 메서드 Student

```java
package com.day16;

public class Student {
//	Student 클래스 만들기 
//	  필드 : 이름, 국, 영, 수, 평균, 등급(gpa), 학년(grade) --> private
	private String name;
	private int kr;
	private int en;
	private int ma;
	private double avg;
	private String gpa;
	private int grade;

//	  메서드 : 
//		1) 생성자 
//			Student()
//			Student(이름)
//			Student(이름, 국, 영, 수)
	Student() {

	}

	Student(String name) {
		setName(name);
	}

	Student(String name, int kr, int en, int ma) {
		setName(name);
		setKr(kr);
		setEn(en);
		setMa(ma);
		setAvg();
		setGpa();
	}

	Student(int grade, String name, int kr, int en, int ma) {
		setGrade(grade);
		setName(name);
		setKr(kr);
		setEn(en);
		setMa(ma);
		setAvg();
		setGpa();
	}

//		2) getter
	public String getName() {
		return name;
	}

	public int getKr() {
		return kr;
	}

	public int getEn() {
		return en;
	}

	public int getMa() {
		return ma;
	}

	public double getAvg() {
		return avg;
	}

	public String getGpa() {
		return gpa;
	}

	public int getGrade() {
		return grade;
	}

//		3) setter
//			setName(String name) ~> 10글자 이하만 저장
	public void setName(String name) {
		if (name.length() < 11) {
			this.name = name;
		}
	}

//			setKr(int kr), setEn(), setMa() ~> 0점 이상 100점 이하만 저장
	public void setKr(int kr) {
		if (kr >= 0 && kr <= 100) {
			this.kr = kr;
		}
	}

	public void setEn(int en) {
		if (en >= 0 && en <= 100) {
			this.en = en;
		}
	}

	public void setMa(int ma) {
		if (ma >= 0 && ma <= 100) {
			this.kr = ma;
		}
	}

//			setAvg() ~> 국, 영, 수 필드로 평균 계산 및 avg 필드에 저장
	public void setAvg() {
		this.avg = (kr + en + ma) / 3.0;
	}

//			setGpa() ~> 평균 가지고 A, B, C, D, F 중 1개를 gpa 필드에 저장
	public void setGpa() {
		if (avg >= 90) {
			this.gpa = "A";
		} else if (avg >= 80) {
			this.gpa = "B";
		} else if (avg >= 70) {
			this.gpa = "C";
		} else if (avg >= 60) {
			this.gpa = "D";
		} else {
			this.gpa = "F";
		}
	}

//			setGrade() ~> 1 ~ 4 학년만 저장
	public void setGrade(int grade) {
		if (grade >= 1 && grade <= 4) {
			this.grade = grade;
		}
	}

//		4) getInfo()
//			모든 정보를 1개의 String 형태로 return
	public String getInfo() {
		return "이름 : " + name + " / 국 : " + kr + " / 영 : " + en + " / 수 : " + ma + " / 평균 : " + avg + " / 학년 : "
				+ grade;
	}
}


```

메인메서드는 마음대로..

메뉴

1. 학생 정보 입력
   학년 / 이름 / 나이 / 국 / 영 / 수 점수 입력하기
2. 원하는 학년 정보 보기
3. 전체 학생 정보 보기
4. 프로그램 종료



# 메인메서드

```java
package com.day16;

import javax.swing.JOptionPane;

public class Homework01 {
	public static void main(String[] args) {
		String menu = "1. 학생 정보 입력 \n2. 원하는 학년 정보 보기" + "\n3.전체 학생 정보 보기\n0.프로그램 종료";
		String choice = "";
		int people = 0;

		int max = 5; // 최대인원수
		Student[] st = new Student[max];
		String message = "";

		while (true) {
			choice = JOptionPane.showInputDialog(menu);
			if ("1".equals(choice)) {// 1. 학생 정보 입력 (학년 / 이름 / 나이 / 국 / 영 / 수 점수 입력하기)
				if (people == max) {
					JOptionPane.showMessageDialog(null, "최대인원수는 5명입니다");
					continue;
				}

				int grade = Integer.parseInt(JOptionPane.showInputDialog("학년 : "));
				String name = JOptionPane.showInputDialog("이름 : ");
				int age = Integer.parseInt(JOptionPane.showInputDialog("나이 : "));
				int kr = Integer.parseInt(JOptionPane.showInputDialog("국어점수 : "));
				int en = Integer.parseInt(JOptionPane.showInputDialog("영어점수 : "));
				int ma = Integer.parseInt(JOptionPane.showInputDialog("수학점수 : "));

				st[people] = new Student(grade, name, kr, en, ma);
				++people;
			} else if ("2".equals(choice)) { // 원하는 학년 정보 보기
				int grade = Integer.parseInt(JOptionPane.showInputDialog("원하는 학년 : "));
				message = grade + "학년의 정보";
				int notGrade = 0;
				for (int i = 0; i < people; ++i) {
					if (st[i].getGrade() == grade) {
						message += "\n" + st[i].getInfo();
					} else if (st[i].getGrade() != grade) {
						++notGrade;
					}
				}
				if (notGrade == people) {
					message += "\n등록된 정보가 없습니다";
				}
				JOptionPane.showMessageDialog(null, message);
			} else if ("3".equals(choice)) { // 전체 학생 정보 보기
				message = "---전체 학생 정보---";
				for (int i = 0; i < people; ++i) {
					message += "\n" + st[i].getInfo();
				}
				JOptionPane.showInternalMessageDialog(null, message);
			} else if ("0".equals(choice)) { // 프로그램 종료
				JOptionPane.showMessageDialog(null, "프로그램 종료");
				break;
			} else {
				JOptionPane.showMessageDialog(null, "잘못된 메뉴입니다");
			}
		}

	}

}

```

