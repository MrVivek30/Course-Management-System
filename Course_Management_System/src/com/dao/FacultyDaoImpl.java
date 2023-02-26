package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.CoursePlan;
import com.dto.CoursePlanImpl;
import com.exception.SomeThingWentWrong;

public class FacultyDaoImpl implements FacultyDao {

	//---------------------Helper Method----------------------
	
	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst()&&rs.getRow()==0)?true:false;
	}
	
	private List<CoursePlan> getCoursePlanListFromResultSet(ResultSet rs) throws SQLException{
		List<CoursePlan> list = new ArrayList<>();
		
		while(rs.next()) {
			//Create an object of Employee
			CoursePlan cp=new CoursePlanImpl();
			cp.setPlanid(rs.getInt("planid"));
			cp.setBatchid(rs.getInt("batchid"));
			cp.setDaynumber(rs.getInt("daynumber"));
			cp.setTopic(rs.getString("topic"));
			cp.setStatus(rs.getString("status"));
	
			
		
		list.add(cp);
		}
		return list;
	}
	
	
	
	
	// ----------------------FacultyLogin--------------------
	
	
	
	public boolean FacultyLogin(String username,String password)  {
		
//	String str="Faculty login ";
		boolean flag=false;
		
	try (Connection con=Dbutils.conToDatabase()){
		
		String log="Select * from faculty where username=? and password=?";
		PreparedStatement ps=con.prepareStatement(log);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		if(isResultSetEmpty(rs)) {
			
//		throw new SomeThingWentWrong("Invalid Username or Password");
					
		}else {
			
//			str="Welcome"+rs.getString("username");
			
			flag=true;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
		return flag;
	}
	
	
	
	//-------------------------------ViewCoursePlan-------------------------------------
	
	
	public List<CoursePlan> viewCoursePlan(String username) throws SomeThingWentWrong {
		
		List<CoursePlan>list=null;
		try(Connection con=Dbutils.conToDatabase()) {
			
		String s="Select * from courseplan";
		PreparedStatement ps=con.prepareStatement(s);
		
		ResultSet r=ps.executeQuery();
		
		if(isResultSetEmpty(r)) {
			throw new SomeThingWentWrong();
		}else {
			list=getCoursePlanListFromResultSet(r);
		}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	
	//-------------------------------updatePassword---------------------------
	
	
	public String updatePassword(String username,String password) {
		
		String msg="Invalid credentials,try again";
		
		try (Connection con=Dbutils.conToDatabase()){
			
			String s="update faculty set password=? where username=?";
			
			PreparedStatement ps=con.prepareStatement(s);
			
			ps.setString(1, password);
			ps.setString(2, username);
			
		if(ps.executeUpdate()>0) {
			msg="Password Updated Successfully";
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return msg;
	}

	//---------------------------daywiseplanner-----------------------
	
	
	
}
