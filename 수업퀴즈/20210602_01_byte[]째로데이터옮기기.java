package com.day30;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class TimerThread extends Thread {
	private int time;
	private boolean run = true;

	@Override
	public void run() {
		while (run) {
			System.out.println(++time + "초");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void terminate() {
		run = false;
	}

	public String getTimer() {
		return time + "초";
	}
}

public class Quiz01 {
	public static void main(String[] args) {
		// 원본 : toeicLab.mp4
		// 복사본 : copy.mp4

		// Thread를 사용하여 1초.. 2초.. sysout
		// 복사가 총 몇 초 소요되었는지 출력

		TimerThread timer = new TimerThread();
		FileInputStream fIn = null;
		FileOutputStream fOut = null;

		timer.start();
		try {
			fIn = new FileInputStream("toeicLab.mp4");
			fOut = new FileOutputStream("copy.mp4");

			File file = new File("toeicLab.mp4");
			long size = file.length();
			byte[] temp = new byte[(int) size];

			fIn.read(temp);
			fOut.write(temp);
//			int data;
//			while(true) {
//				data = fIn.read();
//				if(data==-1) {
//					break;
//				}
//			같은의미로 줄여보면 
//			while((data=fIn.read())!=-1) {
//				fOut.write(data);

			timer.terminate();
			System.out.println("복사완료!");
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			try {
				if (fOut != null)
					fOut.close();
				if (fIn != null)
					fIn.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

	}

}
