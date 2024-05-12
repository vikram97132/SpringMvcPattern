package com.vik.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost3306/mvc_design","root","mp07mq6100");
		} 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}
}


