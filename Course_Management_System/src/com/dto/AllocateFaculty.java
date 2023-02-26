package com.dto;

public class AllocateFaculty {

	// faculty
	private int FacultyId;
	private String FacultyName;
	//batch
	private int batchId;
	private int NumberOfStudents;
	
	//course
	private int CourseId;
	private String CourseName;
	
	
	
	public AllocateFaculty() {
		super();
		// TODO Auto-generated constructor stub
	}



	public AllocateFaculty(int facultyId, String facultyName, int batchId, int numberOfStudents, int courseId,
			String courseName) {
		super();
		FacultyId = facultyId;
		FacultyName = facultyName;
		this.batchId = batchId;
		NumberOfStudents = numberOfStudents;
		CourseId = courseId;
		CourseName = courseName;
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



	public int getBatchId() {
		return batchId;
	}



	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}



	public int getNumberOfStudents() {
		return NumberOfStudents;
	}



	public void setNumberOfStudents(int numberOfStudents) {
		NumberOfStudents = numberOfStudents;
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



	@Override
	public String toString() {
		return "   FacultyId=" + FacultyId + ", FacultyName=" + FacultyName + ", batchId=" + batchId
				+ ", NumberOfStudents=" + NumberOfStudents + ", CourseId=" + CourseId + ", CourseName=" + CourseName
				+ "";
	}
	
	
	
	
}
