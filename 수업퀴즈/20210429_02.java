package com.day08;

import java.util.Arrays;

public class Quiz02 {
	public static void main(String[] args) {
		/*
		 * 'A' : 65 , 'Z' : 90
		 * 
		 * chArr[i] >= 65 && chArr[i] <= 90 ===> 대문자니? chArr[i] >= 'A' && chArr[i] <=
		 * 'Z' ===> 대문자니?
		 * 
		 * 대문자 + 32 == 소문자 소문자 - 32 == 대문자
		 * 
		 */

		char[] chArr = { 'p', 'o', 'k', 'E', 'M', 'o', 'N' };
		System.out.println(chArr); // pokEMoN

		// for문 사용

		for (int a = 0; a < chArr.length; ++a) {
			if (chArr[a] >= 'a' && chArr[a] <= 'z') {
				chArr[a] -= 32;
			}
		}

		System.out.println(chArr); // POKEMON

		// for문 사용

		for (int a = 0; a < chArr.length; ++a) {
			if (chArr[a] >= 'A' && chArr[a] <= 'Z') {
				chArr[a] += 32;
			}
		}

		System.out.println(chArr); // pokemon

//	위 세 단어(각각 pokEMoN, POKEMON, pokemon)가 잘 출력되도록 sysout 중간 중간에 for문을 사용하여 코드를 완성하세요.

	}
}
