package com.dto;

import java.time.LocalDate;

public class BatchImpl implements Batch{
	
	private int batchid;
	
	private int courseid;
	
	private int facultyid;
	
	private int numberofStudents;
	
	private LocalDate batchstartDate;
	
	private double duration;
	
	public BatchImpl() {
		
	}

	public BatchImpl(int batchid, int courseid, int facultyid, int numberofStudents, LocalDate batchstartDate,
			double duration) {
		super();
		this.batchid = batchid;
		this.courseid = courseid;
		this.facultyid = facultyid;
		this.numberofStudents = numberofStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public int getNumberofStudents() {
		return numberofStudents;
	}

	public void setNumberofStudents(int numberofStudents) {
		this.numberofStudents = numberofStudents;
	}

	public LocalDate getBatchstartDate() {
		return batchstartDate;
	}

	public void setBatchstartDate(LocalDate batchstartDate) {
		this.batchstartDate = batchstartDate;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "    batchid=" + batchid + ", courseid=" + courseid + ", facultyid=" + facultyid
				+ ", numberofStudents=" + numberofStudents + ", batchstartDate=" + batchstartDate + ", duration="
				+ duration + "";
	}
	
	
	
}
