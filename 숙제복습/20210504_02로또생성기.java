package com.day11;

import java.util.Arrays;
import java.util.Scanner;

//중-6: 로또생성기 만들기 
//	step1) 사용자에게 1 ~ 45 중 6개의 숫자를 입력 받습니다.
//	step2) 컴퓨터는 로또 번호 6개를 생성합니다. 배열의 크기는 6이고 int형입니다.
//	step3) 1 ~ 45 중 6개의 숫자를 배열에 담습니다. 중복된 원소가 있으면 안됩니다.
//	step4) (구현 가능하다면) 오름차순 정렬을 합니다.
//	step5) 배열 결과를 출력합니다.
//	step6) 사용자가 몇 개의 번호를 맞췄는지 출력하세요.
public class RemindHomework02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] user = new int[6];
		int[] lotto = new int[6];
		int winCnt = 0;

		for (int i = 0; i < user.length; ++i) {
			System.out.println((i + 1) + "번째 숫자 입력 (1~45까지)");
			int userNumber = sc.nextInt();
			user[i] = userNumber;

			if (userNumber < 1 || userNumber > 45) {
				System.out.println("잘못된 번호 입니다. 다시 입력하세요.");
				--i;
			}
			for (int j = 0; j < i; ++j) {
				if (user[i] == user[j]) {
					System.out.println("중복된 숫자 입니다. 다른 수를 입력하세요");
					--i;
				}
			}
		}

		for (int i = 0; i < lotto.length; ++i) {
			int a = (int) ((Math.random() * 45) + 1);
			lotto[i] = a;
			for (int j = 0; j < i; ++j) {
				if (lotto[i] == lotto[j]) {
					--i;
				}
			}
		}

		Arrays.sort(lotto);
		Arrays.sort(user);

		for (int i = 0; i < user.length; ++i) {
			for (int j = 0; j < lotto.length && user[i] >= lotto[j]; ++j) {
				if (user[i] == lotto[j]) {
					++winCnt;
				}
			}
		}
		System.out.println("내 번호 : " + Arrays.toString(user));
		System.out.println("당첨 번호 : " + Arrays.toString(lotto));
		System.out.println("당첨 개수 : " + winCnt);

	}
}
