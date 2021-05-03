package com.day10;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
/*
 총 4학년 각 학년에는 3반씩있음 
 각 반에는 4명의 학생들이 있음 
 총 학생들의 이름을 저장할 배열을 생성하세요.
*/
		Scanner sc = new Scanner(System.in);

		String[][][] names = new String[4][3][4];

		for (int i = 0; i < names.length; ++i) {
			for (int j = 0; j < names[i].length; ++j) {
				for (int k = 0; k < names[i][j].length; ++k) {
					System.out.println((i + 1) + "학년 " + (j + 1) + "반 " + (k + 1) + "번 학생의 이름을 입력하세용");
					names[i][j][k] = sc.next();
				}
			}
		}

	}
}
