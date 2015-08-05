package com.byteslounge.jsf.war;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



public class UsersBean{
		public UsersBean(){}
		public LinkedList<User> getUsers() throws SQLException,	ClassNotFoundException {
			Connection con =  DBConnection.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT * FROM users");
			LinkedList<User> list =  new LinkedList<User>();
		
			ResultSet rs =  ps.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}		
			ps.close();
			con.close();
			
			return list;
			}
			
		public User getUserByName(String name) throws SQLException,	ClassNotFoundException {
			Connection con =  DBConnection.getConnection();
			PreparedStatement ps= con.prepareStatement("SELECT * FROM users WHERE user_name=?");
			ps.setString(1,name);
			ResultSet rs =  ps.executeQuery();
			ps.close();
			con.close();
			
			if(rs.next()){
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}		
			return null;
		}

}