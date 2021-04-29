package com.day08;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Quiz04 {
public static void main(String[] args) {

//	 하-3 : 사용자에게 배열의 칸 개수를 입력 받고, 해당 정수의 크기만큼 정수형 배열을 생성하세요.
//		입력 : 3  ===> 결과 : [ 0, 0, 0 ] 
//		입력 : 5  ===> 결과 : [ 0, 0, 0, 0, 0 ]
System.out.println("배열의 칸 개수를 입력하세요");
Scanner sc = new Scanner(System.in);

int [] answer = new int[sc.nextInt()];

System.out.println(Arrays.toString(answer));
	
//	 하-4 : (3)번에서 생성된 배열에 다음 기능을 추가하세요.
//		ㄱ. 0 ~ n-1 까지의 숫자를 배열에 순서대로 저장하세요.
//			입력 : 3  ===> 결과 : [0, 1, 2]
//			입력 : 5  ===> 결과 : [0, 1, 2, 3, 4]

for (int a=0; a<answer.length; ++a) {
	answer[a]=a;
}

System.out.println(Arrays.toString(answer));

//		ㄴ. 배열의 가장 마지막 원소부터 0번 원소까지 역순으로 출력하세요.
for (int a=answer.length-1; a>=0; --a) {
	System.out.println(answer[a]);
}

//		ㄷ. for문을 사용하여 배열에 저장된 실제 원소들을 역순으로 재배치 하세요. (난이도 중)
//		    sysout(배열[0]); // 3
//		    sysout(배열[1]); // 2
//		    sysout(배열[2]); // 1
//		    sysout(배열[3]); // 0
//		   (for문을 쓰되 for문의 실행 횟수가 n/2이 되도록하세요. 
//	         (5칸 배열이면 2회만에, 10칸 배열이면 5회만에 for문이 종료되도록))


for (int a=0; a<(answer.length)/2; ++a) {
	int b=0;
	b=answer[a];
	answer[a]=answer.length-1-a;
	answer[answer.length-1-a]=b;
System.out.println("실행횟수 : "+(a+1));	
}
System.out.println(Arrays.toString(answer));



//	하-5 : 사용자에게 배열의 칸 개수를 입력 받고, 해당 정수의 크기만큼 String형 배열을 생성하고
//		입력 : 3  ===> 결과 : [ null, null, null ] 
//		입력 : 5  ===> 결과 : [ null, null, null, null, null ]
//		
//		사용자에게 입력받은 단어들을 순차적으로 배열에 저장하세요.  

System.out.println("배열의 칸 개수를 입력하세요");
String[] an = new String[sc.nextInt()];
System.out.println(Arrays.toString(an));

for (int a=0; a<an.length; ++a) {
	System.out.println((a+1)+"번째 단어 : ");
	an[a]=sc.next();
}
System.out.println(Arrays.toString(an));
}
}
