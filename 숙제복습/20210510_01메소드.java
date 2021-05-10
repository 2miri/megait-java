package com.day14;

import javax.swing.JOptionPane;

class Rectangle {
	// * 클래스 : Rectangle
	// * - 필드(멤버변수) : base, height
	// * - 메소드
	// * 1) setData() : 두 정수를 인자값으로 받아, 객체의 base, height에 각각 저장
	int base;
	int height;

	void setData(int base, int height) {
		this.base = base;
		this.height = height;
	}

	// * 2) getArea() : 넓이를 리턴
	int getArea() {
		return base * height;
	}

	// * 3) getCircum() : 둘레를 리턴
	int getCircum() {
		return (base + height) * 2;
	}
}

public class RemindHomework01 {
	public static void main(String[] args) {
		// * 메인 클래스 : Quiz01
		// * - Rectangle 객체 1개 생성
		Rectangle re = new Rectangle();

		// * - JOptionPane을 사용하여 밑변, 높이를 입력 받고,
		// * Rectangle 객체에 저장 (setData() 사용)

		re.setData(Integer.parseInt(JOptionPane.showInputDialog("밑변을 입력하세요")),
				Integer.parseInt(JOptionPane.showInputDialog("높이를 입력하세요")));

		// * - 이 사각형 객체의 넓이와 둘레를 메소드를 사용하여 출력 (getArea(), getCircum())
		JOptionPane.showMessageDialog(null, "넓이 : " + re.getArea() + "\n 둘레 : " + re.getCircum());

	}

}
