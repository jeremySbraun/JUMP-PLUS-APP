package com.dollarsbank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMaker {

	
	// Connection String URL for the SQL database
	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String USERNAME_STRING = "root";
	static final String PASSWORD_STRING = "root";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Connection conn = getConnection();
		
		if(conn != null) {
			System.out.println("Connection Made!");
		}
	}
	
	
	
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USERNAME_STRING, PASSWORD_STRING);
		}catch (SQLException e) {
			System.out.println("No connection Made!");
		}
		
		return conn;
	}

}
