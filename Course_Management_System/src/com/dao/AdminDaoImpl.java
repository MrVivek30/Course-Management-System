package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.SomeThingWentWrong;

public class AdminDaoImpl {
	
	//---------------------Helper Method----------------------
	
		private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
			return (!rs.isBeforeFirst()&&rs.getRow()==0)?true:false;
		}
		
		
		
		
		// ----------------------FacultyLogin--------------------
		
		public String AdminLogin(String username,String password) throws SomeThingWentWrong {
			
		String str="Admin login ";
		try (Connection con=Dbutils.conToDatabase()){
			
			String log="Select * from Admin where username=?&&password=?";
			PreparedStatement ps=con.prepareStatement(log);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(isResultSetEmpty(rs)) {
				
			throw new SomeThingWentWrong("Invalid Username or Password");
						
			}else {
				
				str="Welcome"+rs.getString("username");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
			return str;
		}	
	
}
