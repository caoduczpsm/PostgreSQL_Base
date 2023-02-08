package com.postgresql.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	//private static List<String> firstNames = new ArrayList<>();
	private static List<Actor> actors = new ArrayList<>();
	
	public static void getAllFirstName() {
		Connection cnt = null;
		PreparedStatement stm = null;
		ResultSet res = null;
		
		try {
//			String sql = "SELECT first_name FROM actor";
			String sql = "SELECT * FROM actor";
			cnt = MainClass.getConnection();
			stm = cnt.prepareStatement(sql);
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
	
	public static void main(String []args) {
		getAllFirstName();
		
//		for(String firstName : firstNames) {
//			System.out.println(firstName);
//		}
		
		for(Actor actor : actors) {
			System.out.println(actor.toString());
		}
		
	}

}
