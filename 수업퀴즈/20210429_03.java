package com.day08;

import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		int nums[] = new int[6];
//	1. Scanner를 사용하여 6개의 데이터를 입력 받고, 이들을 nums 배열에 저장
		Scanner sc = new Scanner(System.in);
		for (int a = 0; a < nums.length; ++a) {
			System.out.println((a + 1) + "번째 숫자 : ");
			nums[a] = sc.nextInt();
		}
//	2. 입력 받은 값 중, 20 이상 100 이하인 원소만 출력
		for (int a = 0; a < nums.length; ++a) {
			if (nums[a] > 20 && nums[a] <= 100) {
				System.out.println("20 이상 100 이하인 원소 : " + nums[a]);
			}
		}
//	3. 입력 받은 값 중, 최댓값과 최솟값을 출력
//	int max = nums[0];
//	int min = nums[0];
//	(for문 사용)
//	System.out.println("최솟값 : " + max);
//	System.out.println("최댓값 : " + min);	
		int max = nums[0];
		int min = nums[0];
		for (int a = 0; a < nums.length; ++a) {
			if (max >= nums[a]) {
				max = nums[a];
			}
			if (min <= nums[a]) {
				min = nums[a];
			}
		}

		System.out.println("최솟값 : " + max);
		System.out.println("최댓값 : " + min);

//	4. 오름차순(작은->큰)으로 정렬하여 모든 원소를 출력  ==> 버블 정렬 알고리즘 검색해서 ...
		int b;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					b = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = b;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

	}
}
