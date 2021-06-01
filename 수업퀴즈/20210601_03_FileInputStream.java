package com.day29;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Study03 {
	public static void main(String[] args) {
		try {
			FileInputStream fIn = new FileInputStream("aa.txt");
			Scanner sc = new Scanner(fIn);
			String s;

			while (sc.hasNext()) {
				s = sc.nextLine();
				System.out.println(s);
			}
			sc.close();
			fIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
