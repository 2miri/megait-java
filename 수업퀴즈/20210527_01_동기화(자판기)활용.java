package com.day26;
//VendingMachine가 3개가 있다. (음료수는 무한)

//	음료수를 뽑는데 각각 3초, 5초, 7초가 걸린다.
//	List<PersonThread> queue;
//	 	
//	PersonThread 를 30개 생성하여
//	1초 단위로 자판기를 선택 시킨다.
//	가장 효율적으로 줄을 세워보자.

class Machine {
	static int m3, m5, m7;

	synchronized static void getMachine(Thread th) throws InterruptedException {
		if (3 * m3 <= 5 * m5 && 3 * m3 <= 7 * m7) {
			machine3(th);
		} else if (5 * m5 <= 3 * m3 && 5 * m5 <= 7 * m7) {
			machine5(th);
		} else if (7 * m7 <= 3 * m3 && 7 * m7 <= 5 * m5) {
			machine7(th);
		}
	}

	synchronized static void machine3(Thread th) throws InterruptedException {
		System.out.println(th.getName() + " : 3초 자판기");
		Thread.sleep(3000);
		++m3;
	}

	synchronized static void machine5(Thread th) throws InterruptedException {
		System.out.println(th.getName() + " : 5초 자판기");
		Thread.sleep(5000);
		++m5;
	}

	synchronized static void machine7(Thread th) throws InterruptedException {
		System.out.println(th.getName() + " : 7초 자판기");
		Thread.sleep(7000);
		++m7;
	}

}

class PeopleThread extends Thread {

	@Override
	public void run() {
		try {
			Machine.getMachine(this);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Quiz02 {
	public static void main(String[] args) {
		PeopleThread[] p = new PeopleThread[30];
		for (int i = 0; i < p.length; ++i) {
			p[i] = new PeopleThread();
			p[i].setName("스레드 " + (i + 1));
			p[i].start();
		}
	}

}
