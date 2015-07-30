package com.byteslounge.jsf.war;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection{
	private static Connection connection = null;
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/permissions";
	private static final String password = "haslo";
	private static final String username = "radek";
	private DBConnection(){
		
	}
	private static void createConnection () throws SQLException,
			ClassNotFoundException 		
	{
		Class.forName("org.postgresql.Driver");
		System.err.println("PostgreSQL JDBC Driver Registered!");
		connection = DriverManager.getConnection(url, username, password);
		
	}
	public static Connection getConnection() throws SQLException, 
					ClassNotFoundException
	{
		if (connection == null){
			createConnection();
		}
		System.err.println ("OK DB");
		return connection;
	}
	
}