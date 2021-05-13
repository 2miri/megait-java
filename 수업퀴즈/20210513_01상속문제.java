package com.day17;
// * 부모클래스 : Book 
// *   필드 : 책이름, 저자, 가격

class Book {
	private String book;
	private String writer;
	private int price;
	
	Book(){
		
	}
	Book(String book, String writer, int price) {
		setBook(book);
		setWriter(writer);
		setPrice(price);
		getData();
	}
	
	public String getBook() {
		return book;
	}
	
	public void setBook(String book) {
		this.book = book;
	}
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	// *   메소드 : 	print() 메서드를 만들고 오버라이드 활용
	// *           setData() - 인자값 3개(책이름, 저자, 가격)를 받아서 
	// *                       각 필드에 저장해주는
	public void print() {
		System.out.println(getData());
	}
	
	public String getData() {
		return "책 이름 : " + book + " / 저자 : " 
				+ writer + " / 가격 : " + price + "원";
	}
	
	public void setData(String book, String writer, int price) {
		setBook(book);
		setWriter(writer);
		setPrice(price);
	}
}
// * 자식클래스 : 
// *  1) Novel 
// *   필드 : 책이름, 저자, 가격, 장르
class Novel extends Book {
	private String genre;

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void print() {
		System.out.println(getNovelData());
	}
	
	public String getNovelData() {
		return getData()+" / 장르 : "+genre;
	}
	
	public void setData(String book, String writer, int price, String genre) {
		setBook(book);
		setWriter(writer);
		setPrice(price);
		setGenre(genre);
	}
}
// *  2) Comic 
// *   필드 : 책이름, 저자, 가격, 장르, 주인공 이름
class Comic extends Novel {
	private String hero;

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}
	
	public void print() {
		System.out.println(getComicData());
	}
	
	public String getComicData() {
		return getNovelData()+" / 주인공이름 : "+hero;
	}
	
	public void setData(String book, String writer, int price, String genre, String hero) {
		setBook(book);
		setWriter(writer);
		setPrice(price);
		setGenre(genre);
		setHero(hero);
	}
	
}
// *  3) Textbook  
// *   필드 : 책이름, 저자, 가격, 출판사, 과목 
class Textbook extends Book {
	private String company;
	private String subject;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void print() {
		System.out.println(getData());
	}
	
	public String getTextbookData() {
		return getData()+" / 출판사 : "+ company + " / 과목 : " + subject;
	}
	
	public void setData(String book, String writer, int price, String company, String subject) {
		setBook(book);
		setWriter(writer);
		setPrice(price);
		setCompany(company);
		setSubject(subject);
	}
	
	
}


public class Quiz01 {
	public static void main(String[] args) {
		// * 메인메소드에서.. 
		// * 자식클래스 3개를 모두 객체 생성 1개씩 하고 
		// * 각 필드에 값 저장, 출력해서 확인 (입력 필요 X)
		//Quiz01 번의 클래스에 print() 메서드를 만들고 오버라이드 활용
		Novel book1 = new Novel();
		Comic book2 = new Comic();
		Textbook book3 = new Textbook();
		
		book1.setData("책이름1", "저자1", 1000, "스릴러");
		book2.setData("책이름2", "저자2", 2000, "액션", "재건");
		book3.setData("책이름3", "저자3", 3000, "동아출판사", "수학");
		
		book1.print();
		book2.print();
		book3.print();
		
		
	}

}
