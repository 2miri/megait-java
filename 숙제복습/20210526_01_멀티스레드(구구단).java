package com.day26;

import java.util.ArrayList;

import javax.swing.JOptionPane;

//스레드1 : 3초 단위로 룰루랄라~~ 를 10번 sysout함

class LulluThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			System.out.println("룰루랄라~~");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

}

//스레드2 : 다섯문제를 모두 맞힐 때 까지 초 단위를 sysout 함.
//각 문제들을 몇 초에 입력했는지 기록. 
class GuguThread extends Thread {
	private int seconds = 1;
	private boolean gugudan = true;
	ArrayList<Integer> list = new ArrayList<Integer>();
	StringBuilder sb = new StringBuilder("===정답기록===");

	public void terminate() {
		gugudan = false;
	}

	public void setSum() {
		list.add(this.seconds);
	}

	public StringBuilder getSumTotal() {
		for (int i = 0; i < list.size(); ++i) {
			sb.append("\n" + list.get(i) + "초");
		}
		return sb;

	}

	@Override
	public void run() {
		while (gugudan) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(seconds + "초");
			++seconds;

		}
	}

}

public class RemindHomework01 {
	public static void main(String[] args) {
		// 메인스레드 : 구구단 랜덤하게 5문제를 냄.
		LulluThread lullu = new LulluThread();
		GuguThread gugu = new GuguThread();
		StringBuilder sb = new StringBuilder("==정답기록==");

		lullu.start();
		gugu.start();
		for (int i = 0; i < 5; ++i) {
			int a = (int) (Math.random() * 9) + 1;
			int b = (int) (Math.random() * 9) + 1;
			int answer = Integer.parseInt(JOptionPane.showInputDialog(a + " X " + b + " = ? "));
			if (a * b == answer) {
				gugu.setSum();
			} else {
				--i;
			}

		}

		gugu.terminate();
		lullu.interrupt();
		JOptionPane.showMessageDialog(null, gugu.getSumTotal());

	}

}
