package com.dto;

public class ReportForBatch {
	
	//batch
	private int BatchId;
	
	
	//Course
	private int CourseId;
	private String CourseName;
	
	//courseplan
	
	private int DayNumber;
	private String Status;
	private int fee;
	
	//Faculty
	
	private int FacultyId;
	private String FacultyName;
	
	
	public ReportForBatch() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReportForBatch(int batchId,int courseId, String courseName, int dayNumber, String status,
			int fee, int facultyId, String facultyName) {
		super();
		BatchId = batchId;
	
		CourseId = courseId;
		CourseName = courseName;
		DayNumber = dayNumber;
		Status = status;
		this.fee = fee;
		FacultyId = facultyId;
		FacultyName = facultyName;
	}


	public int getBatchId() {
		return BatchId;
	}


	public void setBatchId(int batchId) {
		BatchId = batchId;
	}





	public int getCourseId() {
		return CourseId;
	}


	public void setCourseId(int courseId) {
		CourseId = courseId;
	}


	public String getCourseName() {
		return CourseName;
	}


	public void setCourseName(String courseName) {
		CourseName = courseName;
	}


	public int getDayNumber() {
		return DayNumber;
	}


	public void setDayNumber(int dayNumber) {
		DayNumber = dayNumber;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}


	public int getFacultyId() {
		return FacultyId;
	}


	public void setFacultyId(int facultyId) {
		FacultyId = facultyId;
	}


	public String getFacultyName() {
		return FacultyName;
	}


	public void setFacultyName(String facultyName) {
		FacultyName = facultyName;
	}


	@Override
	public String toString() {
		return "    BatchId=" + BatchId + ", CourseId=" + CourseId
				+ ", CourseName=" + CourseName + ", DayNumber=" + DayNumber + ", Status=" + Status + ", fee=" + fee
				+ ", FacultyId=" + FacultyId + ", FacultyName=" + FacultyName + "";
	}


	
	
	
	
}
