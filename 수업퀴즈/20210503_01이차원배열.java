package com.day10;

import java.util.Arrays;

public class Quiz01 {
	public static void main(String[] args) {
		String[][] names = { 
						{ "김", "이", "박" }, 
						{ "은지", "민지", "지연", "성민" }, 
						{ "피카츄", "라이츄" } 
						};

		// 일반 이중 for문 사용하여 모든 String들 출력
		System.out.println("일반 이중 for문 사용하여 모든 String 출력");
		for (int i = 0; i < names.length; ++i) {
			for (int j = 0; j < names[i].length; ++j) {

			}
			System.out.println(Arrays.toString(names[i]));
		}

		// 확장 이중 for문 사용하여 모든 String들 출력
		System.out.println("확장 이중 for문 사용하여 모든 String 출력");
		for (String[] s : names) {
			for (String a : s) {

			}
			System.out.println(Arrays.toString(s));
		}

	}
}
