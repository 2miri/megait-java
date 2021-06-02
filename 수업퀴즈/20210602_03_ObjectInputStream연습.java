package com.day30;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Study02 {
	public static void main(String[] args) {
		// ObjectInputStream 연습
		FileInputStream fIn = null;
		ObjectInputStream oIn = null;
		
		try {
			
			fIn = new FileInputStream("C:\\miri\\eclipse-workspace\\java-basic\\아무거나");
			oIn = new ObjectInputStream(fIn);
			
			if (oIn instanceof Object) {
				Object o = oIn.readObject();
				System.out.println(o);
			}
			
		}catch(Throwable e) {
			e.printStackTrace();
		}finally {
			try{
				if(oIn!=null) oIn.close();
				if(fIn!=null) fIn.close();
			}catch(Throwable e) {
				e.printStackTrace();
			}
		}
	}

}
