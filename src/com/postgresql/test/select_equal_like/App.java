package com.postgresql.test.select_equal_like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.postgresql.test.Actor;

public class App {
	
	private static Scanner in = new Scanner(System.in);
	private static List<Actor> actors = new ArrayList<>();
	
	public static void findActorBySelect(String input) {
		
	
		Connection cnt = null;
		PreparedStatement stm = null;
		ResultSet res = null;
		
		try {
			StringBuilder sql = new StringBuilder("SELECT * FROM actor");
			StringBuilder sql_like = new StringBuilder("SELECT * FROM actor");
			sql.append("WHERE first_name LIKE ?");
			cnt = DatabaseConnection.getConnection();
			stm = cnt.prepareStatement(sql.toString());
			stm.setString(1, input);
			res = stm.executeQuery();
			while(res.next()) {
				Actor actor = new Actor();
				actor.setActorID(res.getInt("actor_id"));
				actor.setFirstName(res.getString("fisrt_name"));
				actor.setLastName(res.getString("fisrt_name"));
				actor.setLastUpdate(res.getTimestamp("last_update").toString());
				actors.add(actor);
			}
		}catch(SQLException e){
			return;
		} finally {
			try {
				if(cnt != null) {
					cnt.close();
				}
				if(stm != null) {
					stm.close();
				}
				if(res != null) {
					res.close();
				}
			}catch(Exception e) {
				System.out.print(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.print("Enter search input: ");
		String input = in.nextLine();
		findActorBySelect(input +"%");
		for(Actor actor : actors) {
			System.out.println(actor.toString());
		}
	}

}
