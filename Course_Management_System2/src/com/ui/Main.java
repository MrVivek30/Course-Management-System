package com.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.colour.Color;
import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.dao.FacultyDao;
import com.dao.FacultyDaoImpl;
import com.dto.Batch;
import com.dto.BatchImpl;
import com.dto.Course;
import com.dto.CourseImpl;
import com.dto.CoursePlan;
import com.dto.CoursePlanImpl;
import com.dto.Faculty;
import com.dto.FacultyImpl;
import com.dto.ReportForBatch;
import com.exception.SomeThingWentWrong;

public class Main {

	public static void main(String[] args) throws SomeThingWentWrong {
		
		AdminDao ad=new AdminDaoImpl();
		FacultyDao fd=new FacultyDaoImpl();
		int Choice=0;
		Scanner sc=new Scanner(System.in);
//		
		
		int S=0;
		int S1=0;
		

		
		System.out.println(Color.BOXING+Color.PURPLE_UNDERLINED+Color.RED_BACKGROUND+Color.WHITE_BOLD_BRIGHT+"******************************************WELCOME TO COURSE MANAGEMENT SYSTEM*************************************************** "+Color.RESET);

		System.out.println(Color.LIGHT_PINK +"Press 1 to" + " logIn as Admin." + Color.RESET);
		System.out.println(Color.GREEN_BOLD +"Press 2 to" + " logIn as Faculty."+ Color.RESET);
		System.out.println(Color.CYAN_BOLD +"Press 0 to"  + " System for exit "+ Color.RESET);
		Choice=sc.nextInt();		
		switch(Choice) {
		case 1:
			System.out.println(Color.BANANA_YELLOW+"Enter Username "+ Color.RESET);
			String un=sc.next();
			System.out.println(Color.BANANA_YELLOW+"Enter Password"+ Color.RESET);
			String p=sc.next();
			if(un.equalsIgnoreCase("MrVivek")&&p.equalsIgnoreCase("Vivek123")) {
				do {
					System.out.println(Color.GREEN_BOLD+"1.Create Course \n2.Update Course \n3.View Course \n4.Create Batch\n5.Update batch\n6.View Batch\n7.Create Faculty"
							+ " \n8. Update Faculty\n9.View Faculty\n10.Create Course Plan\n11.Update Course plan\n12.View Course Plan\n13.AllocateFaculty"
							+ "\n14.DayWiseUpdateFor Batch\n15.GenerateReport For Batch"+ Color.RESET);
					
					
					S=sc.nextInt();
					if(S==1) {
						System.out.println(Color.CYAN_BOLD+"Enter Courseid");
						int id=sc.nextInt();
						System.out.println("Enter courseName ");
						String name=sc.next();
						System.out.println("Enter Course Fee");
						int fee=sc.nextInt();
						System.out.println("Enter Course Description"+ Color.RESET);
						String desc=sc.next();
					//System.out.println(ad.createCourse(new CourseImpl(id,name,fee,desc)));	
					ad.createCourse(new CourseImpl(id,name,fee,desc));
						
					}
					else if(S==2) {
						System.out.println(Color.PURPLE_BOLD+"Enter Courseid");
						int id=sc.nextInt();
						
						System.out.println("Enter courseName ");
						String name=sc.next();
						System.out.println("Enter Course Fee");
						int fee=sc.nextInt();
						System.out.println("Enter Course Description"+ Color.RESET);
						String desc=sc.next();
						
						ad.updateCourse(new CourseImpl(id,name,fee,desc));
					}else if(S==3) {
						List<Course>list=ad.viewCourse();
						list.forEach(System.out::println);
					}else if(S==4) {
						System.out.println(Color.YELLOW_BOLD+"Enter batchId");
						int id=sc.nextInt();
						System.out.println("Enter courseId");
						int cid=sc.nextInt();
						System.out.println("Enter Faculty id");
						int fid=sc.nextInt();
						System.out.println("Enter number of student");
						int nos=sc.nextInt();
						System.out.println("Enter Batch Start Date");
						String date=sc.next();
						System.out.println("Enter Duration of course"+ Color.RESET);
						double cou=sc.nextDouble();
						ad.createBatch(new BatchImpl(id,cid,fid,nos,LocalDate.parse(date),cou));
						
					}else if(S==5) {
						System.out.println(Color.CYAN_BOLD+"Enter batchId");
						int id=sc.nextInt();
						System.out.println("Enter courseId");
						int cid=sc.nextInt();
						System.out.println("Enter Faculty id");
						int fid=sc.nextInt();
						System.out.println("Enter number of student");
						int nos=sc.nextInt();
						System.out.println("Enter Batch Start Date");
						String date=sc.next();
						System.out.println("Enter Duration of course"+ Color.RESET);
						double cou=sc.nextDouble();
						ad.updateBatch(new BatchImpl(id,cid,fid,nos,LocalDate.parse(date),cou));
					}else if(S==6) {
						List<Batch>list=ad.viewBatch();
						list.forEach(System.out::println);
					}else if (S==7) {
						System.out.println( Color.BANANA_YELLOW+"Enter faculty id");
						int fid=sc.nextInt();
						System.out.println("Enter faculty Name");
						String name=sc.next();
					System.out.println("Enter faculty Address");
					String fad=sc.next();
					System.out.println("Enter Mobile Number");
					String mob=sc.next();
					System.out.println("Enter Email");
					String e=sc.next();
					System.out.println("Enter Password");
					String pss=sc.next();
					System.out.println("Enter usrename"+ Color.RESET);
					String username=sc.next();
					ad.createFaculty(new FacultyImpl(fid,name,fad,mob,e,pss,username));
					
					}else if(S==8) {
						System.out.println(Color.GREEN_BOLD+"Enter faculty id");
						int fid=sc.nextInt();
						System.out.println("Enter faculty Name");
						String name=sc.next();
					System.out.println("Enter faculty Address");
					String fad=sc.next();
					System.out.println("Enter Mobile Number");
					String mob=sc.next();
					System.out.println("Enter Email");
					String e=sc.next();
					System.out.println("Enter Password");
					String pss=sc.next();
					System.out.println("Enter usrename"+ Color.RESET);
					String username=sc.next();
					ad.updateFaculty(new FacultyImpl(fid,name,fad,mob,e,pss,username));
					
					}else if(S==9) {
						List<Faculty>list=ad.viewFaculty();
						list.forEach(System.out::println);
						
					}else if(S==10) {
						System.out.println(Color.CYAN_BOLD+"Enter Course Plan id");
						int pid=sc.nextInt();
						System.out.println("Enter Batch id");
						int bid=sc.nextInt();
						System.out.println("Enter Day Number");
						int dn=sc.nextInt();
						System.out.println("Enter Topic");
						String topic=sc.next();
						System.out.println("Enter Status"+ Color.RESET);
						String status=sc.next();
					ad.createCoursePlan(new CoursePlanImpl(pid,bid,dn,topic,status));
					
					}else if(S==11) {
						System.out.println(Color.BANANA_YELLOW+"Enter Course Plan id");
						int pid=sc.nextInt();
						System.out.println("Enter Batch id");
						int bid=sc.nextInt();
						System.out.println("Enter Day Number");
						int dn=sc.nextInt();
						System.out.println("Enter Topic");
						String topic=sc.next();
						System.out.println("Enter Status"+ Color.RESET);
						String status=sc.next();
						ad.updateCoursePlan(new CoursePlanImpl(pid,bid,dn,topic,status));
					
					}else if(S==12) {
						List<CoursePlan>list=ad.viewCoursePlan();
						list.forEach(System.out::println);
					}else if(S==13) {
						System.out.println(Color.ORANGE+"Enter Faculty Id");
						int fid=sc.nextInt();
						System.out.println("Enter BatchId"+ Color.RESET);
						int bid=sc.nextInt();
						ad.allocateFacultyToBatch(fid, bid);
					}else if(S==14) {
						List<ReportForBatch>list=ad.DayWiseUpdateForBatch();
						list.forEach(System.out::println);
					}else if(S==15) {
						System.out.println(Color.BROWN_BACKGROUND+"enter batch id");
						int bacid=sc.nextInt();
						List<ReportForBatch>list=ad.generateReport(bacid);
						list.forEach(System.out::println);
					}
					
				}while(S!=0);
			}
			break;
		case 2:
			System.out.println(Color.BANANA_YELLOW+"Enter Username ");
			String Facultyusername=sc.next();
			System.out.println("Enter Password"+ Color.RESET);
			String Fpss=sc.next();
			if(fd.FacultyLogin(Facultyusername, Fpss)) {
				do {
					System.out.println(Color.CYAN_BOLD+"1.View Course Plan\n2.Update Password"+ Color.RESET);
					S1=sc.nextInt();
					if(S1==1) {
						System.out.println(Color.BROWN+"Enter UsreName");
						String users=sc.next();
						List<CoursePlan>list=fd.viewCoursePlan(users);
						list.forEach(System.out::println);
					}else if(S1==2) {
						System.out.println(Color.BLUE_BOLD+"Enter Username");
						String u1=sc.next();
						System.out.println("Enter Password"+ Color.RESET);
						String p1=sc.next();
						fd.updatePassword(u1, p1);
					}
					
				}while(S1!=0);
			}
			break;
		}
	sc.close();
	}
}
