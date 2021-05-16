package com.day18;

class Shape { // 부모클래스
	Shape() {
	}

	public double getArea() {
		return 0.0;
	}

	public String getInfo() {
		return null;
	}
}

class Circle extends Shape {
	private int radius;

	Circle(int radius) {
		setRadius(radius);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getArea() {
		return Math.pow(radius, 2) * Math.PI;
	}

	public String getInfo() {
		return "원 [ 반지름 : " + getRadius() + " ]";
	}
}

class Triangle extends Shape {
	private int base;
	private int height;

	Triangle(int base, int height) {
		setBase(base);
		setHeight(height);
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getArea() {
		return (base * height) / 2.0;
	}

	public String getInfo() {
		return "삼각형 [ 밑변 : " + getBase() + " / 높이 : " + getHeight() + " ]";
	}
}

class Rectangle extends Triangle {

	Rectangle(int base, int height) {
		super(base, height);
		setBase(base);
		setHeight(height);
	}

	public double getArea() {
		return getBase() * getHeight();
	}

	public String getInfo() {
		return "사각형 [ 밑변 : " + getBase() + " / 높이 : " + getHeight() + " ]";
	}
}

public class Quiz01 {
	private static final int CIRCLE = 0;
	private static final int TRIANGLE = 1;
	private static final int RECTANGLE = 2;

	private Shape getRandomShape() {
		int rand = (int) (Math.random() * 3); // 0,1,2
		switch (rand) {
		case CIRCLE:
			return new Circle((int) (Math.random() * 100) + 1);
		case TRIANGLE:
			return new Triangle((int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1);
		case RECTANGLE:
			return new Rectangle((int) (Math.random() * 100) + 1, (int) (Math.random() * 100) + 1);
		}
		return null;
	}

	Quiz01() {
		Shape[] sh = new Shape[50];
		for (int i = 0; i < sh.length; ++i) {
			sh[i] = getRandomShape();
		}
		for (Shape s : sh) {
			System.out.println(s.getInfo());
			System.out.println("넓이 : " + s.getArea());
		}

	}

	public static void main(String[] args) {

		/*
		 * Quiz01 Shape, Circle, Rectangle, Triangle 복붙해오기 메인메서드 - Circle, Rectangle,
		 * Triangle 중 랜덤하게 50개의 도형을 생성 (필드도 랜덤) - 50개 도형의 모든 넓이 출력
		 * 
		 */
		new Quiz01();

	}
}
