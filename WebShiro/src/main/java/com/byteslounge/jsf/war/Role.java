package com.byteslounge.jsf.war;

public class Role {
	private int roleId;
	private String roleName;
	
	public Role(int id, String name){
		this.roleId = id;
		this.roleName = name;
	}
	public String getRoleName(){
		return this.roleName;
	}
	public int getRoleId(){
		return this.roleId;
	}
}