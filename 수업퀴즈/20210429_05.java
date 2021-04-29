package com.day08;

import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
//	 dates 배열은 다음과 같이 1~12월의 최대 일자가 들어있습니다. 
//	 ==> int[] dates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
//	
//	1) dates 배열을 활용하여 1/1일부터 사용자에게 입력 받은 월/일 까지 며칠이 소요되는지 출력하세요.
//	   단, 사용자에게 해는 따로 입력받지 않기때문에 윤년은 없다고 가정합니다.
//
//		예) 월 : 12   일 : 31  ==> 364일 소요!
//		    월 : 4    일 : 12   ==> 101일
//		원리) 4/12 의 결과를 계산하려면
//		    1 / 1 ~ 1 / 31  => 31 (dates[0]) 
//		    2 / 1 ~ 2 / 28  => 28 (dates[1])
//		    3 / 1 ~ 3 / 31  => 31 (dates[2])
//        	4 / 1 ~ 4 / 12  => 12 (사용자가 입력한 일)
//		 => 31 + 28 + 31 + 12 - 1 = 101일 

		int[] dates = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int month;
		int day;
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요");
		month = sc.nextInt();
		System.out.println("일을 입력하세요");
		day = sc.nextInt();
		int sum = 0;
		for (int a = 0; a < month - 1; ++a) {
			sum += dates[a];
		}

		int dDays = sum + day - 1;
		System.out.println("입력하신 " + month + "월" + day + "일까지 총 " + dDays + "일 남았습니다.");
	}
}
