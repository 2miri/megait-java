package com.day19;
//Transportation 인터페이스 (교통수단 인터페이스)

//	상수 : 
//		성인 기본 요금 : 1250원 (DEFAULT_ADULT_CHARGE)
//		미성년자 기본 요금 : 700원 (DEFAULT_KID_CHARGE)
//	메서드 : 
//		int getCharge(int age, int km)

import java.util.Scanner;

interface Transportation {
	int DEFAULT_ADULT_CHARGE = 1250;
	int DEFAULT_KID_CHARGE = 700;

	int getCharge(int age, int km);
}

//구현 클래스1 : Bus 
//	필드 : X
//	메서드 : 
//		int getCharge(int age, int km) 오버라이드
//			(나이에 따른)기본요금 + 10km 당 100원 추가
//			미성년자면 20% 추가 할인
//			책정된 요금을 리턴
class Bus implements Transportation {

	@Override
	public int getCharge(int age, int km) {
		int price = age > 0 && age < 20 ? DEFAULT_KID_CHARGE : DEFAULT_ADULT_CHARGE;
		price += km / 10 * 100;
		if (age > 0 && age < 20) {
			price *= 0.8;
		}
		return price;
	}
}

//구현 클래스2 : Taxi 
//	필드 : X
//	메서드 : 
//		int getCharge(int age, int km) 오버라이드
//			시작요금 : 4000 
//			10km 까지는 기본요금
//			10km 초과되면 1km 당 100원 추가
//			책정된 요금을 리턴
class Taxi implements Transportation {

	@Override
	public int getCharge(int age, int km) {
		int price = 4000;
		price += km - 10 > 0 ? (km - 10) * 100 : 0;
		return price;
	}

}
//구현 클래스3 : Subway
//	필드 : X
//	메서드 : 
//		int getCharge(int age, int km) 오버라이드
//			기본요금 + 10km 당 성인은 100원 추가, 미성년자는 50원 추가
//			책정된 요금을 리턴

class Subway implements Transportation {

	@Override
	public int getCharge(int age, int km) {
		int price = age > 0 && age < 20 ? DEFAULT_KID_CHARGE : DEFAULT_ADULT_CHARGE;

		price += (km / 10) * (age > 0 && age < 20 ? 50 : 100);

		return price;

	}

}

//구현 클래스4 : Train
//	필드 : X
//	메서드 : 
//		int getCharge(int age, int km) 오버라이드
//			시작요금 : 15000 원
//			30km 단위로 1000원씩 추가
//			미성년자는 50% 할인
//			책정된 요금을 리턴
class Train implements Transportation {

	@Override
	public int getCharge(int age, int km) {
		int price = 15000;
		price += km / 30 > 0 ? (km / 30) * 1000 : 0;
		price *= age > 0 && age < 20 ? 0.5 : 1;
		return price;
	}

}

public class Quiz01 {
	public static void main(String[] args) {
//	Quiz 클래스 : 메인
//	원하는 교통수단(버스, 전철, 택시, 기차)과 나이, 거리(km)를 입력 받고
//	요금을 출력하세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 교통수단을 입력하세요.");
		System.out.println("1. 버스\n2. 전철\n3. 택시\n4. 기차");
		int answer = sc.nextInt();

		Transportation tr = null;
		switch (answer) {
		case 1:
			tr = new Bus();
			break;
		case 2:
			tr = new Subway();
			break;
		case 3:
			tr = new Taxi();
			break;
		case 4:
			tr = new Train();
			break;
		default:
			break;
		}
		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		System.out.println("거리를 입력하세요");
		int km = sc.nextInt();

		if (tr != null) {
			int price = tr.getCharge(age, km);
			System.out.println("요금은 " + price + "원입니다.");
		} else {
			System.out.println("잘못된 교통수단입니다.");
		}

	}
}
