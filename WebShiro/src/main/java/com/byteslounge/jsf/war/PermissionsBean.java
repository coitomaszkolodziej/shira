package com.byteslounge.jsf.war;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import java.util.*;

public class PermissionsBean implements Serializable {
	public PermissionsBean(){}
							
	public LinkedList<Permission> getPermissionsByRoleId(int id) throws SQLException, ClassNotFoundException{
		Connection conn = DBConnection.getConnection();
		String q = new String("SELECT * FROM roles_permissions JOIN permissions ON roles_permissions.permission_id = permissions.permission_id WHERE role_id = ?");
		PreparedStatement ps = conn.prepareStatement(q);
		ps.setInt(1, id);

		LinkedList<Permission> list = new LinkedList<Permission>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			list.add(new Permission(rs.getInt(4), rs.getString(5)));
		}
		return list;
	}
	public LinkedList<Permission> 	getPermissionsByUserId(int id) throws SQLException, ClassNotFoundException{
		Connection conn = DBConnection.getConnection();
		String q = new String("SELECT t3.permission_id, permission_name FROM roles_permissions t1 JOIN users_roles t2 ON t1.role_id = t2.role_id JOIN permissions t3 ON t1.permission_id = t3.permission_id WHERE t2.user_id = ?");
		PreparedStatement ps = conn.prepareStatement(q);
		ps.setInt(1, id);

		LinkedList<Permission> list = new LinkedList<Permission>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			list.add(new Permission(rs.getInt(1), rs.getString(2)));
		}
		return list;
	}

}