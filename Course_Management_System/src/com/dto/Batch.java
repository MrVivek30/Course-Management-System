package com.dto;

import java.time.LocalDate;

public interface Batch {
	
	public int getBatchid() ;

	public void setBatchid(int batchid);

	public int getCourseid() ;

	public void setCourseid(int courseid);

	public int getFacultyid() ;

	public void setFacultyid(int facultyid) ;

	public int getNumberofStudents() ;

	public void setNumberofStudents(int numberofStudents) ;
	
	public LocalDate getBatchstartDate() ;

	public void setBatchstartDate(LocalDate batchstartDate) ;

	public double getDuration() ;

	public void setDuration(double duration) ;

	
}
