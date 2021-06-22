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
