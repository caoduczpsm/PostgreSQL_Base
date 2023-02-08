package com.postgresql.test.select_equal_like;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.postgresql.test.MainClass;

public class DatabaseConnection {

	private static final String url = "jdbc:postgresql://localhost:5432/ncaoduc";
	private static final String username = "postgres";
	private static final String password = "ncaoduc";
	
	static Connection getConnection() {
		Connection cnt = null;
		try {
			cnt = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return cnt;
	}

	public static void main(String[] args) {
		
		DatabaseConnection dbc = new DatabaseConnection();
		DatabaseConnection.getConnection();

	}
}
