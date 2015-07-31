package com.byteslounge.jsf.war;

public class Permission {
	private int permissionId;
	private String permissionName;
	
	public Permission (int id, String name){
		this.permissionId = id;
		this.permissionName = name;
		
	}
	public int getPermissionId(){
		return this.permissionId;
	}
	public void setPermissionId(int id){
		this.permissionId = id;
	}
	public String getPermissionName(){
		return this.permissionName;
	}
	public void setPermissionName(String name){
		this.permissionName = name;
	}
}