package com.day21;

public class RemindHomework01 {
	public static void main(String[] args) {
//		1 ~ 1백만까지를 출력하는 for문을 만들고, 
//		for문 소요 시간(밀리초)출력 ~> System.currentTimeMillis() 활용
		
		long start, end;
		start = System.currentTimeMillis();
		for(int i = 1; i <= 1000000; ++i) {
			
		}
		end = System.currentTimeMillis();
		
		System.out.println("소요시간 : "+ (end-start)+"밀리초!");
	}

}
