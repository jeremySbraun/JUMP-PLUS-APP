package com.dollarsbank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;



public class ConnectionMaker {

	
	// Connection String URL for the SQL database
	static final String URL = "jdbc:mysql://localhost:3306/";
	static final String USERNAME_STRING = "root";
	static final String PASSWORD_STRING = "root";
	
	static final String CREATE_SCHEMA = "CREATE SCHEMA bankapp";
	
	static final String INITIAL_TABLE = "CREATE TABLE ACCOUNTS(id INT not NULL, PRIMARY KEY(id));";
	
	static final String USE_DATABASE = "USE bankapp;";
	
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
			executeUpdate(conn, CREATE_SCHEMA);
			executeUpdate(conn, USE_DATABASE);
			executeUpdate(conn, INITIAL_TABLE);
		}catch (SQLException e) {
			System.out.println("No connection Made!");
		}
		
		return conn;
	}
	
	
	public static void executeUpdate(Connection conn, String sqlString) {
		int count = 0;
		try {
			Statement statement = conn.createStatement();
			
			 count = statement.executeUpdate(sqlString);
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			count++;
		}
	}

}
