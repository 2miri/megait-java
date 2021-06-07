package com.day33.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ServerInputThread extends Thread {

	private BufferedReader br;
	private boolean run = true;

	public boolean isRun() {
		return run;
	}

	ServerInputThread(Socket socket) {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			String fromClient;
			while ((fromClient = br.readLine()) != null) {
				System.out.println("Client의 메시지 : " + fromClient);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		run = false;
	}

}

public class MyServer {
	private ServerSocket serverSocket;
	private Socket socket;

	public MyServer() {
		try {
			serverSocket = new ServerSocket(50000);

			System.out.println("서버 소켓 실행!! 클라이언트를 기다립니다..");

			socket = serverSocket.accept();
			System.out.println("클라이언트와 연결됨! 클라이언트 IP : " + socket.getInetAddress());

			Scanner sc = new Scanner(System.in);

//			BufferedReader br = new BufferedReader(
//					new InputStreamReader(socket.getInputStream()));
			ServerInputThread thread = new ServerInputThread(socket);
			thread.start();

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			String toClient;
			while (thread.isRun()) {
				System.out.print("클라이언트에게 : ");
				toClient = sc.nextLine();

				bw.write(toClient + "\r\n");
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null)
					serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MyServer();
	}
}
