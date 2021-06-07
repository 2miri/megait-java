package com.day33.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

class ClientInputThread extends Thread {
	private BufferedReader br;
	private boolean run = true;

	void terminate() {
		run = false;
	}

	ClientInputThread(Socket socket) {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String fromServer;
		try {
			while (run) {
				fromServer = br.readLine();
				JOptionPane.showMessageDialog(null, "Server의 메시지 : " + fromServer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class MyClient {
	private Socket socket;

	public MyClient() {

		try {
			socket = new Socket("127.0.0.1", 50000);
			System.out.println("서버와 연결됨!");

			Scanner sc = new Scanner(System.in);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			ClientInputThread thread = new ClientInputThread(socket);
			thread.start();

			String toServer;
			while (true) {
				toServer = JOptionPane.showInputDialog("서버에게");
				if ("exit".equalsIgnoreCase(toServer)) {
					thread.terminate();
					break;
				}
				bw.write(toServer + "\r\n");
				bw.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new MyClient();
	}
}
