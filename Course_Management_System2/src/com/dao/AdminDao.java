package com.dao;

import java.util.List;

import com.dto.Batch;
import com.dto.Course;
import com.dto.CoursePlan;
import com.dto.Faculty;
import com.dto.ReportForBatch;
import com.exception.SomeThingWentWrong;

public interface AdminDao {
	
	public String AdminLogin(String username,String password) throws SomeThingWentWrong ;

	public String createCourse(Course course);
	
	public String updateCourse(Course c) ;
	
	public List<Course> viewCourse() throws SomeThingWentWrong;
	
	public String createBatch(Batch b);
	
	public String updateBatch(Batch b);
	
	public List<Batch> viewBatch() throws SomeThingWentWrong;
	
	public String createFaculty(Faculty f);
	
	public String updateFaculty(Faculty f);
	
	public List<Faculty> viewFaculty() throws SomeThingWentWrong;
	
	public String createCoursePlan(CoursePlan cp);
	
	public String updateCoursePlan(CoursePlan cp);
	
	public List<CoursePlan> viewCoursePlan() throws SomeThingWentWrong;
	
	public String allocateFacultyToBatch(int facultyid,int batchid);
	
	public List<ReportForBatch>DayWiseUpdateForBatch() throws SomeThingWentWrong;
	
	public List<ReportForBatch>generateReport(int batchid) throws SomeThingWentWrong;
	
}
