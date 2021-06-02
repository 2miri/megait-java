package com.day30;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;

public class Study01 {
	public static void main(String[] args) {
		// ObjectOutputStream 연습
		List<Object> list = List.of(10, 3.14, "ABC", new Date());

		try (FileOutputStream fOut = new FileOutputStream("아무거나");
				ObjectOutputStream oOut = new ObjectOutputStream(fOut)) {

			oOut.writeObject(list);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
