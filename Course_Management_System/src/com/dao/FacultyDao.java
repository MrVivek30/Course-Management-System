package com.dao;

import java.util.List;

import com.dto.CoursePlan;

import com.exception.SomeThingWentWrong;

public interface FacultyDao {

	public boolean FacultyLogin(String username,String password) throws SomeThingWentWrong ;
	
	public List<CoursePlan> viewCoursePlan(String username) throws SomeThingWentWrong;
	
	public String updatePassword(String username,String password);
}
