package sist.exam01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import db.ConnectionProvider;

public class Test02 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int custid;
			String name, addr, phone;
			System.out.print("고객번호==>");
			custid = sc.nextInt();
			System.out.print("이름==>");
			name = sc.next();
			System.out.print("주소==>");
			addr = sc.next();
			System.out.print("전화==>");
			phone = sc.next();
			Connection conn = 
			ConnectionProvider.getConnection();
			CallableStatement cstmt 
			= conn.prepareCall("{call addCustomer(?,?,?,?)}");
			cstmt.setInt(1, custid);
			cstmt.setString(2, name);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
			int re = cstmt.executeUpdate();
			System.out.println("re:"+re);
			ConnectionProvider.close(cstmt, conn);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}









