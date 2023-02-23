	package com.dao;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.ResourceBundle;
	
	public class Dbutils {
	 final static String url;
	 final static String username;
	 static final String password ;
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
		ResourceBundle bundle=ResourceBundle.getBundle("dbdetails");
		url=bundle.getString("url");
		username=bundle.getString("username");
		password=bundle.getString("password");
	}
	
	static Connection conToDatabase() throws SQLException {
		return DriverManager.getConnection(url,username,password);
		
	}
	static void closecon(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	}
