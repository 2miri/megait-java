package com.day11;

import java.util.Scanner;

public class RemindHomework04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = 0;
		int c = 0;
		int fire = 0;

		int startc = 0;
		int endc = 0;
		int startr = 0;
		int endr = 0;

		int sum = 0;

//	3. 10 X 10 짜리 이차원 배열 'map'이 있다.
		int[][] map = new int[10][10];
//	 (3-1) 랜덤한 위치에 30마리의 몬스터를 배치해보자.
//		몬스터는 1로 표시한다.
//	    (중복 위치 허용)
//		배치된 몬스터를 map에 출력해보자
		for (int i = 0; i < 30; ++i) {
			int a = (int) (Math.random() * 10);
			int b = (int) (Math.random() * 10);
			map[a][b] = 1;
		}

		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}

//	 (3-2) 사용자에게 행, 열 순서로 2개의 정수를 입력 받고 
//	    map 에 사용자의 위치를 출력해보자. (유저는 2로 표시한다.)
		System.out.println("행을 입력하세요");
		r = sc.nextInt();
		System.out.println("열을 입력하세요");
		c = sc.nextInt();

		map[r][c] = 2;

		for (int i = 0; i < map.length; ++i) {
			for (int j = 0; j < map[i].length; ++j) {
				System.out.print(map[i][j] + "  ");
			}
			System.out.println();
		}

//	    (3-3) 사용자에게 원하는 공격 범위를 정수형으로 입력 받고 
//	    사용자의 위치에서 공격 가능한 몬스터의 개수를 출력해보자.

		System.out.println("공격 범위를 입력하세요");
		fire = sc.nextInt();

		startr = r - fire > 0 ? r - fire : 0; // 시작행
		endr = r + fire < 9 ? r + fire : 9; // 끝행
		startc = c - fire > 0 ? c - fire : 0; // 시작열
		endc = c + fire < 9 ? c + fire : 9; // 끝열

		for (int i = startr; i <= endr; ++i) {
			for (int j = startc; j <= endc; ++j) {
				if (map[i][j] == 1) {
					++sum;
				}
			}
		}

		System.out.println("사용자 위치에서 공격 가능한 몬스터 수는 " + sum + "마리입니다.");
	}
}
