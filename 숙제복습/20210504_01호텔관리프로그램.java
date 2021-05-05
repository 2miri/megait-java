package com.day11;

import javax.swing.JOptionPane;

//중-5: 호텔관리 프로그램 만들기 

public class RemindHomework01 {
	public static void main(String[] args) {
//	step1) 사용자에게 호텔의 방 개수를 입력 받습니다.
		int room = Integer.parseInt(JOptionPane.showInputDialog("호텔의 방 개수를 입력하세요"));

//	step2) 방개수와 동일한 크기의 배열을 생성합니다. (5개면 5칸짜리 배열 생성)
		int[] hotel = new int[room];

//  step3) 사용자 메뉴를 메시지로 보여주고 메뉴를 선택 받습니다.
//  < 메뉴 >
//  1. 체크인
//  2. 체크아웃
//  3. 현황 보기
//  0. 종료하기

//      step4) 사용자가 메뉴에서 0을 입력할 때까지 (3) 과정을 진행합니다.

		String menu = "1. 체크인 \n" + "2. 체크아웃 \n" + "3. 현황보기 \n" + "0. 종료하기";
		int number = 0;
		String msg = null;

		while (true) {
			String choice = JOptionPane.showInputDialog(menu);

//      1. 체크인
//      방 호수(1번부터 시작)를 입력 받습니다.
//      방이 이미 입실 중이면 "입실 중인 방은 체크인 하실 수 없습니다."를 출력하세요.
//      빈 방인 경우 "입실 완료!"를 출력하고 메뉴로 돌아갑니다.
//   (힌트 : 사용자가 4호에 입실한다면 [3]번칸에 1을 저장하고 퇴실한다면 0을 저장합니다. 
//	즉 투숙객이 있음은 1로 없으면 0으로 표시합니다.)

			if (choice.equals("1")) {
				number = Integer.parseInt(JOptionPane.showInputDialog("방 호수를 입력해주세요" + "1 ~ " + room + "호까지"));
				if (number < 1 || number > room) {
					JOptionPane.showMessageDialog(null, "잘못된 방 번호입니다.");
				} else if (hotel[number - 1] == 1) {
					JOptionPane.showMessageDialog(null, "이미 입실 중인 방입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "체크인 완료 ! ");
					++hotel[number - 1];
				}
			}
//      2. 체크아웃
//      방 호수(1번부터 시작)를 입력 받습니다.
//      방이 빈 방이면 "빈 방은 체크아웃 하실 수 없습니다."를 출력하세요.
//      체크인 상태인 경우 "퇴실 완료!"를 출력하고 메뉴로 돌아갑니다.
			if (choice.equals("2")) {
				number = Integer.parseInt(JOptionPane.showInputDialog("방 호수를 입력해주세요" + "1 ~ " + room + "호까지"));
				if (number < 1 || number > room) {
					JOptionPane.showMessageDialog(null, "잘못된 방 번호입니다.");
				} else if (hotel[number - 1] == 0) {
					JOptionPane.showMessageDialog(null, "빈 방은 체크아웃 하실 수 없습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "체크아웃 완료 ! ");
					--hotel[number - 1];
				}
			}

//      3. '방호수 - 상태'를 출력합니다.
//      출력 예)
//          1호 : 빈 방
//          2호 : 입실 중
//          3호 : 입실 중
//          4호 : 빈 방
//          5호 : 빈 방

			if (choice.equals("3")) {
				msg = "----- 현 황 -----";
				for (int i = 0; i < hotel.length; ++i) {
					if (hotel[i] == 0) {
						msg += "\n" + (i + 1) + "호 빈 방";
					} else {
						msg += "\n" + (i + 1) + "호 입실 중";
					}
				}
				JOptionPane.showMessageDialog(null, msg);
			}

//      0. 종료
//       반복을 종료하고 '영업 종료' 를 출력합니다.
//

			if (choice.equals("0")) {
				JOptionPane.showMessageDialog(null, "영업 종료");
				break;
			}

		}
	}
}
