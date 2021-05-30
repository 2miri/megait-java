package com.day27.homework;

import java.util.Arrays;

// N개의 임의의 정수를 생성한다. 이때 임의의 수 범위는 1 ~ 10이다.
// N은 10000의 배수이다. 

// 싱글스레드로 1번째 정수 ~ N번째 정수를 모두 더했을 때의 시간은 T1이라 한다.
// 5개의 스레드로 1번째 정수 ~ N번째 정수를 5분할 하여 모두 더했을 때의 시간은 T2이라 한다.

// T2가 T1보다 적게 소요되는 것은 N이 몇일 때부터인가?

class AddThread extends Thread {
	private int[] arr;
	private int sum;

	AddThread(int[] arr) {
		this.arr = arr;
	}

	@Override
	public void run() {
		for (int e : arr) {
			sum += e;
		}
	}

	public int getSum() {
		return sum;
	}

}

public class Homework01 {
	public static void main(String[] args) {
		// 1 ~ 10000 개의 임의의 정수 뽑기
		int n = 0;
		int[] arr;
		long start, end;
		long t1 = 0, t2 = 0;
		while (t1 <= t2) {
			// 랜덤 수 N개 생성
			n += 10000;
			arr = new int[n];
			for (int i = 0; i < arr.length; ++i) {
				arr[i] = (int) (Math.random() * 10) + 1;
			}

			// 싱글 스레드로 모두 더했을때?
			start = System.currentTimeMillis();
			int total = 0;
			for (int e : arr) {
				total += e;
			}
			end = System.currentTimeMillis();
			t1 = end - start;
			System.out.println("싱글 t1 : " + t1 + "ms");

			// 멀티 스레드로 모두 더했을때?
			start = System.currentTimeMillis();
			AddThread[] threads = new AddThread[5];
			for (int i = 0; i < threads.length; ++i) {
				int from = i * (n / 5);
				int to = from + (n / 5);
				threads[i] = new AddThread(Arrays.copyOfRange(arr, from, to));
				threads[i].start();
			}
			for (Thread th : threads) {
				try {
					th.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			end = System.currentTimeMillis();
			t2 = end - start;
			System.out.println("멀티 t2 : " + t2 + "ms");

			System.out.println("N : " + n);
			System.out.println("총합 : " + total);
			System.out.println();
		} // while 문 끝

		System.out.println("최종 N : " + n);

	}
}
