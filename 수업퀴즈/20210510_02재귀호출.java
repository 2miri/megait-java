package com.day14;

import java.util.Scanner;

/*
	재귀호출(Recursive call) 
	- 함수가 함수 내부에서 자기 자신을 호출하는 것.
*/
class Sample {
	// 5! = 5 x 4 x 3 x 2 x 1 = 120
	int factorial(int a) {
		if (a == 1) {
			return 1;
		}
		return a * factorial(a - 1);
	}
}

public class RemindStudy {
	public static void main(String[] args) {
		Sample sp = new Sample();
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 1개를 입력하세용");
		int a = sc.nextInt();
		System.out.println(a + "!의 값 : " + sp.factorial(a));
	}

}
