package com.gms.web.test;

import java.sql.*;


public class MariadbConn {
	public String exam() {
		Connection conn;
		Statement stmt;
		String s="";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager .getConnection(
					"jdbc:mariadb://localhost:3306/mariadb", 
					"mariadb", 
					"mariadb");
			stmt = conn.createStatement();
			String sql = String.format(
					"SELECT NAME FROM MEMBER WHERE USERID LIKE 'e1' "
					);
			ResultSet rs = stmt.executeQuery(sql);			
			if(rs.next()) {
				s=rs.getString("NAME");
			}
			else{
				s = "연결실패";
			}
		} catch (Exception e) {
			e.printStackTrace();
	
		}
		return s;
	}


}
