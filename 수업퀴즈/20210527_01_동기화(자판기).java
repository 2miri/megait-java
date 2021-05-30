package com.day27;
//	VendingMachine : 자원
//		음료수 10개
//PersonThread :
//run() : VendingMachine의 음료수를 한개씩 뽑는다. (감소)
//
//~> 동기화 활용

class VendingMachine {
	private static int drink = 10;

	synchronized public static void getDrink(Thread t) {
		System.out.println(t.getName() + " : 음료수 하나 뽑음");
		--drink;
		System.out.println("남은 음료수 : " + drink);
		if (drink == 0) {
			System.out.println("음료수가 없습니다");
		}
	}
}


class PersonThread extends Thread {
	@Override
	public void run() {
		VendingMachine.getDrink(this);
	}
}

public class RemindQuiz01 {
	public static void main(String[] args) {
		PersonThread[] p = new PersonThread[10];
		for (int i = 0; i < p.length; ++i) {
			p[i] = new PersonThread();
			p[i].setName("스레드 " + (i + 1));
			p[i].start();
		}

	}

}
