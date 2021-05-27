package com.day26;

import java.util.ArrayList;

// N개의 임의의 정수를 생성한다. 이때 임의의 수 범위는 1 ~ 10이다.
// N은 10000의 배수이다. 
//싱글스레드로 1번째 정수 ~ N번째 정수를 모두 더했을 때의 시간은 T1이라 한다.
// T2가 T1보다 적게 소요되는 것은 N이 몇일 때부터인가?

// System.currentTimeMillis()

// 5개로 나누는건 sublist활용해보기

class AddThread extends Thread {
	private int random = (int) (Math.random() * 10) + 1;
	private long total;
	private int n = 10000;
	private long start, end;

	ArrayList<Integer> list = new ArrayList<Integer>();

	public void addList() {
		for (int i = 1; i <= n * getRandom(); ++i) {
			list.add(i);
		}
	}

	@Override
	public void run() {
		start = System.currentTimeMillis();
		for (int i = 1; i <= n * getRandom(); ++i) {
			total += i;
		}
		end = System.currentTimeMillis();
		setRequiredTime();
	}

	public int getRandom() {
		return this.random;
	}

	public void setRandom(int random) {
		this.random = random;
	}

	public long getTotal() {
		return this.total;
	}

	public int getN() {
		return this.n;
	}

	public long getRequiredTime() {
		return end - start;
	}

	public void setRequiredTime() {
		System.out.println(getName() + " 총 소요시간 : " + getRequiredTime() + "밀리초");

	}
}

public class Homework01 {
	public static void main(String[] args) {
		// 싱글스레드로 1번째 정수 ~ N번째 정수를 모두 더했을 때의 시간은 T1이라 한다.
		// 5개의 스레드로 1번째 정수 ~ N번째 정수를 5분할 하여 모두 더했을 때의 시간은 T2이라 한다.
		AddThread single = new AddThread();
		AddThread[] multi = new AddThread[5];
		long T1 = 0;
		long T2 = 0;

		single.setName("싱글스레드");

		for (int i = 0; i < multi.length; ++i) {
			multi[i] = new AddThread();
			multi[i].setName("멀티스레드" + i);
		}

		int i = 2;
		multi[0].setRandom(i);
		multi[1].setRandom(i);
		multi[2].setRandom(i);
		multi[3].setRandom(i);
		multi[4].setRandom(i);

		multi[0].addList();
		multi[1].addList();
		multi[2].addList();
		multi[3].addList();
		multi[4].addList();

		single.setRandom(i);
		single.addList();
		single.start();

		int n = single.getN() / 5;
		multi[0].list.subList(0, n);
		multi[1].list.subList(n, n * 2);
		multi[2].list.subList(n * 2, n * 3);
		multi[3].list.subList(n * 3, n * 4);
		multi[4].list.subList(n * 4, n * 5);

		T2 = multi[0].getRequiredTime() + multi[1].getRequiredTime() + multi[2].getRequiredTime()
				+ multi[3].getRequiredTime() + multi[4].getRequiredTime();

		T1 = single.getRequiredTime();

		if (T1 > T2) {
			System.out.println("싱글 스레드 : " + T1 + "밀리초");
			System.out.println("멀티 스레드 : " + T2 + "밀리초");
			System.out.println("=== N :" + single.getN() + " / 멀티스레드가 더 빠름 ===");
		} else if (T1 < T2) {
			System.out.println("싱글 스레드 : " + T1 + "밀리초");
			System.out.println("멀티 스레드 : " + T2 + "밀리초");
			System.out.println("=== N :" + single.getN() + " / 싱글스레드가 더 빠름 ===");
		} else {
			System.out.println("싱글 스레드 : " + T1 + "밀리초");
			System.out.println("멀티 스레드 : " + T2 + "밀리초");
			System.out.println("=== 소요시간 동일 ===");
		}



	}
}
