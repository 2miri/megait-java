package com.day25;

import java.util.Scanner;

public class RemindQuiz01 {
	public static void main(String[] args) {
		// 사용자에게 정수 입력 받고
		// 정수만큼의 int[] 생성 (3 입력하면 3칸짜리로 생성)
		// 사용자에게 원소들을 입력 받음
		// 사용자에게 인덱스 입력 받음 ~> 해당 인덱스에 위치한 원소 출력
		// ~> 발생할 수 있는 모든 예외 상황에 대한 처리를 꼭 할 것!
		Scanner sc = new Scanner(System.in);
		int num;

		while (true) {
			try {
				System.out.println("정수를 입력하세용");
				num = sc.nextInt();
				int[] arr = new int[num];

				for (int i = 0; i < arr.length; ++i) {
					System.out.println("원소 입력");
					num = sc.nextInt();
					arr[i] = num;
				}

				System.out.println("인덱스를 입력하세용");
				num = sc.nextInt();
				System.out.println(arr[num]);
				break; // try문 닫기전에 break; try문제없으면 끝~
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("정수를 입력하세용");
			} catch (NegativeArraySizeException e) {
				System.out.println("배열의 범위가 음수면 안됩니당");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 범위를 벗어났습니다");
			} catch (Throwable e) {
				System.out.println("예기치못한 문제가 발생했습니다.");
			}
		} // while끝

	}

}
