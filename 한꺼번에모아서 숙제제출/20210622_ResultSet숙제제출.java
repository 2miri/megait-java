# QUIZ 04

```java
package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import util.MyConnection;

/*
Quiz04 
 - 사용자에게 회원 번호를 입력 받고 
   장바구니에 해당 회원이 어떤 상품을 담았는지 (상품번호 조회) 출력
  회원번호 : 2
  결과 : 1 4 2 6 6 5
+-------+--------+-------+
| ct_no | mem_no | pd_no |
+-------+--------+-------+
|     1 |      2 |     1 |
|     2 |      2 |     4 |
|     3 |      3 |     1 |
|     4 |      2 |     2 |
|     6 |      2 |     6 |
|     7 |      2 |     6 |
|     8 |      2 |     5 |
+-------+--------+-------+
 */
public class Homework01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int memNo;
		String sql;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		boolean unique = true;

		try {
			System.out.println("회원번호를 입력하세용");
			memNo = sc.nextInt();

			conn = MyConnection.getConnection();

			sql = "SELECT * FROM cart";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			StringBuilder sb = new StringBuilder("회원번호 : " + memNo + "\n장바구니에 담은 상품 :");

			while (rs.next()) {
				int pdNo = rs.getInt("pd_no");
				int sqlMemNo = rs.getInt("mem_no");
				if (sqlMemNo == memNo) {
					sb.append(" " + pdNo);
					unique = false;
				}

			} // while문 끝

			if (unique) {
				sb.append(" 없음");
			}

			System.out.println(sb);

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(conn, ps, rs);
		}

	}

}

```



# QUIZ05

```java
package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import util.MyConnection;

/*
  메뉴) 
	1. 회원 가입
	2. 로그인 (username 만 입력 받아서 로그인)
	3. 상품 보기 (상품명, 가격, 상품번호 출력) 
	4. 장바구니 담기 (상품명, 가격, 상품번호 출력하고 상품번호를 입력 받아 cart에 저장)
	5. 내 장바구니 보기 (내가 담아둔 상품들의 번호 출력. 가능하다면, 상품명까지 출력.) 
	-> 상품명까지 출력하는건 mysql join찾아보기
	0. 종료
	
 */
public class Homework02 {
	String menu = "1. 회원가입\n2. 로그인\n3. 상품보기\n4. 장바구니 담기\n5. 내 장바구니 보기\n0. 종료";
	String select;
	String sql;
	boolean unique;

	String username;
	String sqlUserName;
	int sqlUserNo;
	StringBuilder sb = new StringBuilder();

	int sqlPdNo;
	String sqlPdName;
	int sqlPdPrice;

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	Homework02() {

		try {
			conn = MyConnection.getConnection();

			loop: while (true) {
				select = JOptionPane.showInputDialog(menu);

				switch (select) {
				case "1": // 회원가입
					username = JOptionPane.showInputDialog("가입할 아이디를 입력하세요");

					sql = "SELECT username FROM member";
					ResultSetExecuteQuery();

					unique = true;

					while (rs.next()) {
						sqlUserName = rs.getString("username");
						if (username.equalsIgnoreCase(sqlUserName)) {
							JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다");
							unique = false;
							break;
						}
					} // while문 끝
					if (unique) {
						sql = "INSERT INTO member (username) VALUES ( ? )";
						ps = conn.prepareStatement(sql);
						ps.setString(1, username);
						ps.execute();
						JOptionPane.showMessageDialog(null, "회원가입 완료!");
					}

					break;

				case "2": // 로그인 (username 만 입력 받아서 로그인)

					sb.setLength(0); // 스프링빌더 초기화
					username = JOptionPane.showInputDialog("아이디를 입력해주세요");
					sql = "SELECT * FROM member";
					ResultSetExecuteQuery();

					unique = true;

					while (rs.next()) {
						// username, point, type, email, regdate
						sqlUserNo = rs.getInt("no");
						sqlUserName = rs.getString("username");
						int point = rs.getInt("point");
						String type = rs.getInt("type") == 0 ? "일반회원" : "관리자";
						String email = rs.getString("email");
						String regdate = rs.getString("regdate");

						if (sqlUserName.equalsIgnoreCase(username)) {
							sb.append("회원 번호 : " + sqlUserNo + "\n")
							.append("아이디 : " + sqlUserName + "\n")
							.append("포인트 : " + point + "\n")
							.append("회원 유형 : " + type + "\n")
							.append("email : " + email + "\n")
							.append("가입일자 : " + regdate);
							JOptionPane.showMessageDialog(null, sb);
							unique = false;
							break;
						}

					} // while문 끝

					if (unique) {
						JOptionPane.showMessageDialog(null, "가입되지 않은 아이디입니다");
						sqlUserNo = 0;
					}

					break;

				case "3": // 상품 보기 (상품명, 가격, 상품번호 출력)

					JOptionPane.showMessageDialog(null, setProductView());

					break;

				case "4": // 장바구니 담기 (상품명, 가격, 상품번호 출력하고 상품번호를 입력 받아 cart에 저장)

					int pdNo = Integer.parseInt(JOptionPane.showInputDialog(null, setProductView()));

					unique = true;

					sql = "SELECT pd_no FROM product";
					ResultSetExecuteQuery();
					while (rs.next()) {
						sqlPdNo = rs.getInt("pd_no");
						if (sqlPdNo == pdNo) { // 상품번호를 맞게 입력했을 때
							switch (sqlUserNo) {

							case 0: // 로그인 안했을 때
								unique = false;
								JOptionPane.showMessageDialog(null, "로그인이 필요합니다");
								break;

							default: // 로그인 했을때

								unique = false;
								sql = "INSERT INTO cart (mem_no, pd_no) VALUES ( ? , ? )";
								ps = conn.prepareStatement(sql);
								ps.setInt(1, sqlUserNo);
								ps.setInt(2, sqlPdNo);
								ps.execute();
								JOptionPane.showMessageDialog(null, "선택하신 상품이 장바구니에 추가되었습니다");
								break;

							}

						}
					} // while문 끝

					if (unique) {
						JOptionPane.showMessageDialog(null, "잘못된 상품 번호입니다");
					}

					break;

				case "5":
					// 내 장바구니 보기 (내가 담아둔 상품들의 번호 출력. 가능하다면, 상품명까지 출력.)
					// -> 상품명까지 출력하는건 mysql join찾아보기
					sb.setLength(0);
					sql = "SELECT * FROM cart LEFT OUTER JOIN product ON cart.pd_no = product.pd_no";
					ResultSetExecuteQuery();
					
					unique = true;
					
					while(rs.next()) {
						int sqlMemNo = rs.getInt("mem_no");
						sqlPdNo = rs.getInt("pd_no");
						sqlPdName = rs.getString("pd_name");
						
						if(sqlMemNo == sqlUserNo) {
							sb.append("상품번호 : " + sqlPdNo)
							.append(" / 상품명 : " + sqlPdName + "\n")
							.append("============================\n");
							unique = false;
						}
					}
					
					if(unique) {
						JOptionPane.showMessageDialog(null, "로그인이 필요합니다");
					} else {
						JOptionPane.showMessageDialog(null, sb);
					}
					
					break;

				case "0": // 프로그램 종료
					JOptionPane.showMessageDialog(null, "프로그램이 종료됩니다");
					break loop;

				default:
					JOptionPane.showMessageDialog(null, "잘못된 메뉴 입니다");
					break;

				}
			}

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(conn, ps, rs);
		}

	} // 생성자 끝

	public StringBuilder setProductView() throws SQLException {
		// 상품번호 / 상품명 / 상품가격 sb에 저장하기
		sb.setLength(0);
		sql = "SELECT * FROM product";
		ResultSetExecuteQuery();
		while (rs.next()) {
			// pd_no, pd_name, pd_price
			sqlPdNo = rs.getInt("pd_no");
			sqlPdName = rs.getString("pd_name");
			sqlPdPrice = rs.getInt("pd_price");
			sb.append("상품번호 : " + sqlPdNo + "\n")
			.append("상품명 : " + sqlPdName + "\n")
			.append("상품 가격 : " + sqlPdPrice + "\n")
			.append("========================" + "\n");
		}

		return sb;

	}

	public void ResultSetExecuteQuery() throws SQLException {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	}

	public static void main(String[] args) {
		new Homework02();

	}

}

```

