package com.day22;

import java.util.Scanner;

public class RemindHomework01 {
	public static void main(String[] args) {
//		 사용자에게 이메일, 비밀번호를 입력 받아서 
//		 이메일, 비번, 아이디 출력 
		Scanner sc = new Scanner(System.in);
		String email, pw1, pw2, id, regex, message;

		while (true) {
			System.out.println("이메일을 입력하세요");
			email = sc.next();
			email.strip();

//			 1) 이메일 조건
//				- 반드시 @ 가 있어야 한다. ~> contains()
			if (!email.contains("@")) {
				System.out.println("이메일 주소에 @가 포함되어있지 않습니다.");
				continue;
			}
//				- .com , .co.kr, .net, .org 중 1개로 끝나야 한다. ~> endsWith()
			regex = "^.*\\.(com|co\\.kr|net|org)$";
			if (!email.matches(regex)) {
				System.out.println(".com , .co.kr, .net, .org 중 1개로 끝나야 합니다");
				continue;
			}
//				- 메일서버가 있어야 한다. (gmail, naver, hanmail 등)
//					email.split("@|\\.") ~> {"issell", "","com"}
//				  aa@a.com (O)  
//				  aa@.co.kr (X)
			String[] arr = email.split("@|\\.");
			if (arr[1].isBlank()) {
				System.out.println("메일 서버가 있어야 합니다.");
				continue;
			}
//				- 유저네임이 있어야 한다. ~> startsWith()
//				  @a.com (X)  
//				- 정규식 사용해도 되고.. String 메서드 사용해도 됨.
			if (email.startsWith("@")) {
				System.out.println("유저네임이 있어야합니다");
			}

			break;
		}

//		 2) 아이디 : 이메일에서 아이디 부분을 추출 ~> split()
//			이메일 : aa@a.com
//			아이디 : aa
		String[] arr = email.split("@", 2);
		id = arr[0];

		regex = "^(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
		while (true) {
//			 3) 패스워드 : 비밀번호 정규식 사용
//			(8자 이상. 대소문자/특수기호 최소 1개 포함)
//		       패스워드를 한 번 더 입력 받고 두 패스워드가 일치해야 한다.

			System.out.println("비밀번호를 입력하세요");
			pw1 = sc.next();

			if (!pw1.matches(regex)) {
				System.out.println("8자 이상. 대소문자/특수기호 최소 1개 포함되어야 합니다");
				continue;
			}

			System.out.println("비밀번호를 한번 더 입력하세요");
			pw2 = sc.next();
			if (pw1.equals(pw2)) {
				break;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}

		}
//		 조건에 부합하지 않다면 다시 입력 받기.
//		 주의! 잘못 입력된 부분만 입력 받아야 한다.

//		 결과 : 
//			E-MAIL : issell@naver.com
//			ID : issell
//			PASSWORD : (pika1234! 일 경우,) pi******* ~> substring(), repeat()
		pw2 = pw1.substring(0, 2) + "*".repeat(pw1.length() - 2);

		message = String.format("E-MAIL : %s\nID : %s\nPASSWORD : %s", email, id, pw2);
		System.out.println(message);

	}

}
