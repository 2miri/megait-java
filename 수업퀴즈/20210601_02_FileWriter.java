package com.day29;

import java.io.FileWriter;
import java.io.IOException;

public class Study02 {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("aa.txt");

			fw.write("피카츄\n");
			fw.write("라이츄\n");
			fw.write("파이리\n");

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
