package com.postgresql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass {
	
	private static final String url = "jdbc:postgresql://localhost:5432/ncaoduc";
	private static final String username = "postgres";
	private static final String password = "ncaoduc";
	
	static Connection getConnection() {
		Connection cnt = null;
		try {
			cnt = DriverManager.getConnection(url, username, password);
			System.out.println("Connect Successful To PostgreSQL");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return cnt;
	}

	public static void main(String[] args) {
		
		MainClass main = new MainClass();
		main.getConnection();

	}

}
