package sist.exam01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import db.ConnectionProvider;


public class Test03 {

	public static void main(String[] args) {
		try {
			int eno;
			String ename, dname, manager;
			Scanner sc = new Scanner(System.in);
			System.out.print("사원번호:");
			eno = sc.nextInt();
			Connection conn = ConnectionProvider.getConnection();
			CallableStatement cstmt =
				conn.prepareCall("{call getEmp(?,?,?,?)}");
			
			cstmt.setInt(1, eno);
			
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			cstmt.execute();
			
			ename = cstmt.getString(2);
			dname = cstmt.getString(3);
			manager = cstmt.getString(4);
			
			System.out.println("사원명:"+ename);
			System.out.println("관리자명:"+manager);
			System.out.println("부서명:"+dname);
			
			ConnectionProvider.close(cstmt, conn);
			
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
}




