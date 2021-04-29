package com.day08;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz01 {
	/*
	 * double형 4칸짜리 배열을 생성하고 
	 * Scanner를 사용하여 각 원소를 입력 받음
	 * 입력 후 모든 원소를 출력
	 *   a[0] = sc.nextDouble();
	 */
	public static void main(String[] args) {
	
	Scanner sc = new Scanner (System.in);
	double [] answer = new double [4];
	
	for(int an = 0; an < answer.length ; ++an) {
		System.out.println("숫자를 입력하세요");
		answer[an] = sc.nextDouble();
	}
	
	System.out.println("입력한 숫자는 : "+Arrays.toString(answer));
	}
}
