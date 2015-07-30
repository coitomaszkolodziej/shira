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

@ManagedBean
@SessionScoped
public class RolesBean implements Serializable {

   public List<Role> getRoles(int userId){
      ResultSet rs = null;
      PreparedStatement pst = null;
		Connection con = DBConnection.getConnection();
      
		String query = "Select * from roles";
      
     /* try {   
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            Author author = new Author();
            author.setId(rs.getInt(1));
            author.setName(rs.getString(2));
            records.add(author);				
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }*/
      return roles;
   }

}