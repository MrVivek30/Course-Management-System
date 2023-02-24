package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Batch;
import com.dto.BatchImpl;
import com.dto.Course;
import com.dto.CourseImpl;
import com.dto.CoursePlan;
import com.dto.CoursePlanImpl;
import com.dto.Faculty;
import com.dto.FacultyImpl;
import com.exception.SomeThingWentWrong;

public class AdminDaoImpl implements AdminDao{
	
	//---------------------Helper Method----------------------
	
		private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
			return (!rs.isBeforeFirst()&&rs.getRow()==0)?true:false;
		}
		
		
		// helper for courseplan
		
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
		
		
		// helper for course--------------------------------------
		
		
		private List<Course> getCourseListFromResultSet(ResultSet rs) throws SQLException{
			List<Course> list = new ArrayList<>();
			
			while(rs.next()) {
				//Create an object of Employee
				Course c=new CourseImpl();
				c.setCourseid(rs.getInt("courseid"));
				c.setCoursename(rs.getString("coursename"));
				c.setFee(rs.getInt("fee"));
				c.setCourseDescription(rs.getString("coursedescription"));
				
				list.add(c);
				
			
			list.add(c);
			}
			return list;
		}
		
		
		//*********************************faculty***********************************
		
		// ----------------------FacultyLogin--------------------
		
		public String AdminLogin(String username,String password) throws SomeThingWentWrong {
			
		String str="Admin login ";
		try (Connection con=Dbutils.conToDatabase()){
			
			String log="Select * from Admin where username=? && password=?";
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
	
		
		//----------------------------createcourse------------------------
		
		
		public String createCourse(Course course) {
			
			String msg="Course cannot be created ,please try again";
			
			try (Connection con=Dbutils.conToDatabase()){
				String s="insert into Course values(?,?,?,?)";
				
				PreparedStatement ps=con.prepareStatement(s);
				ps.setInt(1, course.getCourseid());
				ps.setString(2, course.getCoursename());
				ps.setInt(3, course.getFee());
				ps.setString(4,course.getCourseDescription());
				
				if(ps.executeUpdate()>0) {
					msg="Course created successfully";
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return msg;
		}
//---------------------------updateCourse--------------------------------
		
		
		public String updateCourse(Course c) {
			String msg="Course Cannot be updated,please Try again";
			try (Connection con=Dbutils.conToDatabase()){
				String s="update course set coursename=?,fee=?,courseDescription=? where courseid=?";
				
				PreparedStatement ps=con.prepareStatement(s);
			
				ps.setString(1, c.getCoursename());
				ps.setInt(2, c.getFee());
				ps.setString(3,c.getCourseDescription());
				ps.setInt(4, c.getCourseid());
				
				if(ps.executeUpdate()>0) {
					msg="Course updated successfully";
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return msg;
		}

		//------------------------viewCourse---------------------------------
		
		
		public List<Course> viewCourse() throws SomeThingWentWrong{
			
		List<Course>list=null;
		try(Connection con=Dbutils.conToDatabase()) {
			String s="select * from course";
			PreparedStatement ps=con.prepareStatement(s);
			
			ResultSet rs=ps.executeQuery();
			if(isResultSetEmpty(rs)) {
				throw new SomeThingWentWrong();
			}else {
			 list=getCourseListFromResultSet(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		}
		
		
		
		//***************************************BAtCh****************************************
		
		
		
		//----------------------------createbatch------------------------
		
		
				public String createBatch(Batch b) {
					
					String msg="Batch cannot be created ,please try again";
					
					try (Connection con=Dbutils.conToDatabase()){
						String s="insert into Course values(?,?,?,?,?,?)";
						
						PreparedStatement ps=con.prepareStatement(s);
						ps.setInt(1, b.getBatchid());
						ps.setInt(2, b.getCourseid());
						
						ps.setInt(3, b.getFacultyid());
						ps.setInt(4, b.getNumberofStudents());
						ps.setDate(5, Date.valueOf(b.getBatchstartDate()));
						ps.setDouble(6, b.getDuration());
						
						if(ps.executeUpdate()>0) {
							msg="Batch created successfully";
							
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					return msg;
				}
		//---------------------------updateBatch--------------------------------
				
				
				public String updateBatch(Batch b) {
					String msg="Batch Cannot be updated,please Try again";
					try (Connection con=Dbutils.conToDatabase()){
						String s="update batch set courseid=?,facultyid=?,numberofstudents=?,batchstartdate=?duration=? where batchid=?";
						
						
						PreparedStatement ps=con.prepareStatement(s);
					
						ps.setInt(1, b.getCourseid());
						ps.setInt(2, b.getFacultyid());
						ps.setInt(3, b.getNumberofStudents());
						ps.setDate(4,Date.valueOf(b.getBatchstartDate()) );
						ps.setDouble(5, b.getDuration());
						ps.setInt(6, b.getBatchid());
						
						if(ps.executeUpdate()>0) {
							msg="Batch updated successfully";
							
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					return msg;
				}

				//------------------------viewBatch---------------------------------
				

				// helper for BAtch--------------------------------------
				
				
				private List<Batch> getBatchListFromResultSet(ResultSet rs) throws SQLException{
					List<Batch> list = new ArrayList<>();
					
					while(rs.next()) {
						//Create an object of Employee
						Batch b=new BatchImpl();
						b.setBatchid(rs.getInt("batchid"));
						b.setCourseid(rs.getInt("courseid"));
						b.setFacultyid(rs.getInt("facultyid"));
						b.setNumberofStudents(rs.getInt("numberofstudents"));
						b.setBatchstartDate(rs.getDate("batchstartdate").toLocalDate());
						b.setDuration(rs.getDouble("duration"));
						
						
						list.add(b);
						
					}
					return list;
				}
				
			//-----------------------------viewBatch---------------------------
				
				
				
				public List<Batch> viewBatch() throws SomeThingWentWrong{
					
				List<Batch>list=null;
				try(Connection con=Dbutils.conToDatabase()) {
					String s="select * from Batch";
					PreparedStatement ps=con.prepareStatement(s);
					
					ResultSet rs=ps.executeQuery();
					if(isResultSetEmpty(rs)) {
						throw new SomeThingWentWrong();
					}else {
					 list=getBatchListFromResultSet(rs);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
				
				}
				
				
		//-------------------------------

//***************************************Faculty****************************************



//----------------------------createFaculty------------------------


		public String createFaculty(Faculty f) {
			
			String msg="Faculty cannot be created ,please try again";
			
			try (Connection con=Dbutils.conToDatabase()){
				String s="insert into faculty values(?,?,?,?,?,?,?)";
				
				PreparedStatement ps=con.prepareStatement(s);
				ps.setInt(1, f.getFacultyid());
				ps.setString(2, f.getFacultyname());
				ps.setString(3, f.getFacultyaddress());
				ps.setString(4, f.getMobile());
				ps.setString(5, f.getEmail());
				ps.setString(6, f.getPassword());
				ps.setString(7, f.getUsername());
				
				
				if(ps.executeUpdate()>0) {
					msg="Faculty created successfully";
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return msg;
		}
//---------------------------updateFaculty--------------------------------
		
		
		public String updateFaculty(Faculty f) {
			String msg="Faculty Cannot be updated,please Try again";
			try (Connection con=Dbutils.conToDatabase()){
				String s="update Faculty set facultyname=?,facultyaddress=?,mobile=?,email=?,password=?,username=? where facultyid=?";
				
				
				PreparedStatement ps=con.prepareStatement(s);
			
				
				ps.setString(1, f.getFacultyname());
				ps.setString(2, f.getFacultyaddress());
				ps.setString(3, f.getMobile());
				ps.setString(4, f.getEmail());
				ps.setString(5, f.getPassword());
				ps.setString(6, f.getUsername());
				ps.setInt(7, f.getFacultyid());
				
				if(ps.executeUpdate()>0) {
					msg="Faculty updated successfully";
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return msg;
		}

		//------------------------viewFaculty---------------------------------
		

		// helper for Faculty--------------------------------------
		
		
		private List<Faculty> getFacultyListFromResultSet(ResultSet rs) throws SQLException{
			List<Faculty> list = new ArrayList<>();
			
			while(rs.next()) {
				//Create an object of Employee
				Faculty f=new FacultyImpl();
				f.setFacultyid(rs.getInt("facultyid"));
				f.setFacultyname(rs.getString("facultyname"));
				f.setFacultyaddress(rs.getString("facultyaddress"));
				f.setMobile(rs.getString("mobile"));
				f.setEmail(rs.getString("email"));
				f.setPassword(rs.getString("password"));
				f.setUsername(rs.getString("username"));
				
				
				
				list.add(f);
				
			}
			return list;
		}
		
	//-----------------------------viewFaculty---------------------------
		
		
		
		public List<Faculty> viewFaculty() throws SomeThingWentWrong{
			
		List<Faculty>list=null;
		try(Connection con=Dbutils.conToDatabase()) {
			String s="select * from Faculty";
			PreparedStatement ps=con.prepareStatement(s);
			
			ResultSet rs=ps.executeQuery();
			if(isResultSetEmpty(rs)) {
				throw new SomeThingWentWrong();
			}else {
			 list=getFacultyListFromResultSet(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		}
				
}
