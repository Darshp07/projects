package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/module_4_Q7";
	private static final String USER = "root";
	private static final String PASS = "3306";
	
	
	public static Connection getConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
		
		return DriverManager.getConnection(DB_URL, USER, PASS);	
	}
	
}
