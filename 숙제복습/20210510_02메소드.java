package com.day14;

import javax.swing.JOptionPane;

class MyMath {
	// * 클래스 : MyMath
	// * - 필드 : 없음
	// * - 메소드
	// * 1) getTotal() : 정수 1개를 인자값으로 받고, 1 부터 그 수까지의 모든 합을 return
	// * e.g. 인자값 : 5 -> 리턴값 : 15
	// * 인자값 : 3 -> 리턴값 : 6
	int getTotal(int a) {
		int sum = 0;
		for (int i = 1; i <= a; ++i) {
			sum += i;
		}
		return sum;
	}

	// * 2) getGugudan() : 정수 1개를 인자값으로 받고, 해당 단을 String형태로 return
	String getGugudan(int a) {
		String gugu = "";
		for (int i = 1; i < 10; ++i) {
			gugu += a + " X " + i + " = " + (a * i) + "\n";
		}
		return gugu;
	}
}

public class RemindHomework02 {
	public static void main(String[] args) {
		// * 메인 클래스 : Quiz02
		// * 메뉴 :
		// * 1. 총합 구하기
		// * 2. 구구단 보기
		// * 3. 종료하기
		MyMath mm = new MyMath();
		String menu = "1. 총합 구하기" + "\n2. 구구단 보기" + "\n3. 종료하기";

		// * - 1번 선택 시 : 정수 1개를 입력 받아 1 ~ 정수까지의 합 출력
		// * - 2번 선택 시 : 정수 1개를 입력 받아 해당 단 출력
		// * - 3번 선택 시 : 프로그램 종료
		// * (3번을 선택해야 메뉴창 띄우기를 반복 종료함.)

		loop: while (true) {
			String choice = JOptionPane.showInputDialog(menu);
			switch (choice) {
			case "1":
				int a = Integer.parseInt(JOptionPane.showInputDialog("정수 1개를 입력하세요"));
				JOptionPane.showMessageDialog(null, "1부터 " + a + "까지의 총 합 : " + mm.getTotal(a));
				break;
			case "2":
				int total = Integer.parseInt(JOptionPane.showInputDialog("정수 1개를 입력하세요"));
				JOptionPane.showMessageDialog(null, total + "단\n" + mm.getGugudan(total));
				break;
			case "3":
				JOptionPane.showMessageDialog(null, "프로그램 종료");
				break loop;
			default:
				JOptionPane.showMessageDialog(null, "잘못된 메뉴입니다.");
				break;
			}
		}
	}

}
