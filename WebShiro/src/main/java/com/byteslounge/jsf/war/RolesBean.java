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

public class RolesBean implements Serializable {
	public RolesBean(){}
	
	public LinkedList<Role> getRolesByUserId(int id) throws SQLException, ClassNotFoundException{
		Connection conn = DBConnection.getConnection();
		String q = new String("SELECT * FROM users t1 JOIN users_roles t2 ON t1.user_id = t2.user_id JOIN roles t3 ON t2.role_id = t3.role_id WHERE t1.user_id = ?");
		PreparedStatement ps = conn.prepareStatement(q);
		ps.setInt(1, id);
		LinkedList<Role> list = new LinkedList<Role>();
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			list.add(new Role(rs.getInt(7), rs.getString(8)));
		}
			ps.close();
			conn.close();
		return list;
	}

}