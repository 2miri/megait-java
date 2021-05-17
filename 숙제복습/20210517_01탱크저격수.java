package com.day19;
/*
 * < Sniper VS Tank >
 * - 저격수, 탱크 두 캐릭터 중 아무거나 랜덤하게 2개 생성
 *   (탱크 vs 탱크, 저 vs 탱, 저 vs 저)
 * - 두 객체가 서로 죽을 때까지 서로 공격을 반복
 * - 첫번째, 혹은 두번째 플레이어가 이겼는지 마지막 승자 출력! 
 *  e.g. 플레이어1(탱크)의 승리!
 */

class Unit { // 부모 클래스
	String name;
	int hp, att; // 체력, 공격력
	boolean alive;

	public void attack(Unit enemy) {

	}

	Unit(String name, int hp, int att) {
		this.name = name;
		this.hp = hp;
		this.att = att;
		alive = true;
	}
}

class Sniper extends Unit { // 자식 클래스
	// 객체 생성되면, 자동으로 name은 "저격수", hp는 400, att는 100
	Sniper() {
		super("저격수", 400, 100);
	}

	// attack 오버라이드
	public void attack(Unit enemy) {
		// 1. 10% 확률로 헤드샷 (상대 즉사)
		// 2. 나머지 확률로 평타(일반 공격, 상대 hp를 100만큼 깎는다.)
		if (Math.random() < 0.1) {
			System.out.println(this.name + "헤드샷 !");
			enemy.hp = 0;
		} else {
			System.out.println(this.name + "일반공격 ! 상대편 hp -100");
			enemy.hp -= this.att;
		}
		enemy.alive = enemy.hp > 0;

		if (enemy.alive) {
			System.out.println("상대의 남은 체력 : " + enemy.hp);
		} else {
			System.out.println("상대를 쓰러뜨렸다!");
		}

	}
}

class Tank extends Unit {
	// 객체 생성되면, 자동으로 name은 "탱크", hp는 4000, att는 50
	Tank() {
		super("탱크", 4000, 50);
	}

	// attack 오버라이드
	// 1. 30% 확률로 상대의 hp 30% 감소
	// 2. 나머지 확률로 평타(일반 공격, 상대 hp를 50만큼 깎는다.)
	public void attack(Unit enemy) {
		if (Math.random() < 0.3) {
			System.out.println(this.name + "치명타 ! 상대의 hp 30% 감소");
			enemy.hp *= 0.7;
		} else {
			System.out.println(this.name + "일반 공격! 상대의 hp -50");
			enemy.hp -= this.att;
		}

		enemy.alive = enemy.hp > 0;
		if (enemy.alive) {
			System.out.println("상대의 남은 체력 : " + enemy.hp);
		} else {
			System.out.println("상대를 쓰러뜨렸다!");
		}

	}
}

public class RemindHomework01 {
	public static void main(String[] args) {
		// 두 타입의 객체를 랜덤하게 2개 생성
		// 무한 반복문을 사용하여 둘 중 하나가 죽을 때까지 서로를 공격
		// 단, 죽은 객체가 공격하면 안됨
		// 첫번째, 혹은 두번째 플레이어가 이겼는지 마지막 승자 출력!
		// e.g. 플레이어1(탱크)의 승리!
		Unit p1 = Math.random() > 0.5 ? new Sniper() : new Tank();
		Unit p2 = Math.random() > 0.5 ? new Sniper() : new Tank();
		System.out.println("플레이어 1 : " + p1.name);
		System.out.println("플레이어 2 : " + p2.name);

		while (p1.alive && p2.alive) {
			System.out.println("===플레이어1의 공격====");
			p1.attack(p2);
			if (!p2.alive) {
				break;
			}
			System.out.println("===플레이어2의 공격====");
			p2.attack(p1);

		}

		if (p1.alive) {
			System.out.println("플레이어1의 승리!");
		} else {
			System.out.println("플레이어2의 승리!");
		}

	}
}
