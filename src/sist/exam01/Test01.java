package sist.exam01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import db.ConnectionProvider;

public class Test01 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int custid, itemid, cnt;
			System.out.print("고객번호==>");
			custid = sc.nextInt();
			System.out.print("상품번호==>");
			itemid = sc.nextInt();
			System.out.print("수량==>");
			cnt = sc.nextInt();
			
			Connection conn 
			= ConnectionProvider.getConnection();
			CallableStatement cstmt 
			= conn.prepareCall("{call addCart(?,?,?)}");
			cstmt.setInt(1, custid);
			cstmt.setInt(2, itemid);
			cstmt.setInt(3, cnt);
			int re = cstmt.executeUpdate();
			System.out.println("re:"+re);
			ConnectionProvider.close(cstmt, conn);
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}

}






