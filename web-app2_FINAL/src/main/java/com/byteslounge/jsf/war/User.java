package com.byteslounge.jsf.war;

public class User{
	public User(int id, String name, String pass){
			this.userId = id;
			this.userName = name;
			this.userPassword = pass;
	}
	
	private int userId;
	private String userName;
	private String userPassword;

	public String getUserName(){
		return this.userName;
	}
	public int getUserId(){
		return this.userId;
	}
	/* Gettery, settery, etc */

	}