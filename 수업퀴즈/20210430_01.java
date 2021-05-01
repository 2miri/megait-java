package com.day09;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {
//		1. Scanner를 사용하여 6개의 데이터를 입력 받고, 이들을 nums 배열에 저장
		Scanner sc = new Scanner(System.in);
		int nums[] = new int[6];

		for (int i = 0; i < nums.length; ++i) {
			System.out.println((i + 1) + "번째 숫자");
			nums[i] = sc.nextInt();
		}
//		2. 입력 받은 값 중, 20 이상 100 이하인 원소만 출력
		System.out.println("----20이상 100이하 원소 출력----");
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] >= 20 && nums[i] <= 100) {
				System.out.println(nums[i]);
			}
		}

//		3. 입력 받은 값 중, 최댓값과 최솟값을 출력
		int max = nums[0];
		int min = nums[0];
		for (int i = 0; i < nums.length; ++i) {
			if (max < nums[i]) {
				max = nums[i];
			}
			if (min > nums[i]) {
				min = nums[i];
			}
		}

		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);

//		4. 오름차순(작은->큰)으로 정렬하여 모든 원소를 출력 
		// 선택정렬(Selection sort) :
		// 1번째로 작은 수를 선택해서 첫 번째 칸에
		// 2번째로 작은 수를 선택해서 두 번째 칸에
		// ....

		for (int i = 0; i < nums.length - 1; ++i) {
			for (int j = i + 1; j < nums.length; ++j) {
				if (nums[i] > nums[j]) {
					int a = nums[i];
					nums[i] = nums[j];
					nums[j] = a;
				}
			}
		}
		System.out.println("오름차순 정렬 : " + Arrays.toString(nums));

		// 참고) 정렬해주는 명령 // 퀵 소트 알고리즘 실행
		Arrays.sort(nums);
		System.out.println("오름차순 정렬 : " + Arrays.toString(nums));
	}
}
