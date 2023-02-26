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

public class SwitchingUserUi {
	static int i=3;
	static int j=3;
	public static void applicationMain() throws SomeThingWentWrong {
	AdminDao ad=new AdminDaoImpl();
	FacultyDao fd=new FacultyDaoImpl();
	int Choice=0;
	Scanner sc=new Scanner(System.in);
//	

	int S=0;
	int S1=0;
	

	
	System.out.println(Color.BOXING+Color.PURPLE_UNDERLINED+Color.RED_BACKGROUND+Color.WHITE_BOLD_BRIGHT+"=-==-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-WELCOME TO COURSE MANAGEMENT SYSTEM=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-==-="+Color.RESET);

	System.out.println(Color.LIGHT_PINK +"Press 1 to" + " logIn as Admin." + Color.RESET);
	System.out.println(Color.GREEN_BOLD +"Press 2 to" + " logIn as Faculty."+ Color.RESET);
	System.out.println(Color.CYAN_BOLD +"Press 0 to"  + " System for exit "+ Color.RESET);
	Choice=sc.nextInt();		
	switch(Choice) {
	case 1:
		
		System.out.println(Color.BOXING+Color.GREEN_ITALIC+Color.PURPLE_BACKGROUND_BRIGHT+Color.WHITE_BOLD_BRIGHT+"=-==-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-WELCOME ADMIN=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-==-="+Color.RESET);
		System.out.println(Color.BANANA_YELLOW+"Enter Your UserName ");
		
		String un=sc.next();
		System.out.println("Enter Your Password");
		String p=sc.next();
		System.out.print( Color.RESET);
		if(un.equalsIgnoreCase("MrVivek")&&p.equalsIgnoreCase("Vivek123")) {
			do {
				System.out.println(Color.GREEN_BOLD+"1. Create Course \n2. Update Course \n3. View All Course \n4. Create Batch\n5. Update batch\n6. View All Batch\n7. Create Faculty"
						+ " \n8. Update Faculty\n9. View All Faculty\n10. Create Course Plan\n11. Update Course plan\n12. View All Course Plan\n13. Allocate Faculty To a Batch"
						+ "\n14. View DayWiseUpdate For Batch\n15. Generate Report For Batch\n0.Press 0 For Exit"+ Color.RESET);
				System.out.print(Color.BANANA_YELLOW);
				
				S=sc.nextInt();
				System.out.print(Color.RESET);
				if(S==1) {
					System.out.println(Color.CYAN_BOLD+"Enter Courseid");
					int id=sc.nextInt();
					System.out.println("Enter courseName ");
					String name=sc.next();
					System.out.println("Enter Course Fee");
					int fee=sc.nextInt();
					System.out.println("Enter Course Description" );
					String desc=sc.next();
					System.out.print(Color.RESET);
				//System.out.println(ad.createCourse(new CourseImpl(id,name,fee,desc)));	
					System.out.println(	Color.BANANA_YELLOW+ad.createCourse(new CourseImpl(id,name,fee,desc))+Color.RESET);
					
				}
				else if(S==2) {
					System.out.println(Color.PURPLE_BOLD+"Enter Courseid");
					int id=sc.nextInt();
					
					System.out.println("Enter courseName ");
					String name=sc.next();
					System.out.println("Enter Course Fee");
					int fee=sc.nextInt();
					System.out.println("Enter Course Description");
					String desc=sc.next();
					System.out.print(Color.RESET);
					System.out.println(	Color.BANANA_YELLOW+ad.updateCourse(new CourseImpl(id,name,fee,desc))+Color.RESET);
				}else if(S==3) {
					System.out.print(Color.RED_BOLD_BRIGHT);
					List<Course>list=ad.viewCourse();
					list.forEach(System.out::println);
					System.out.print(Color.RESET);
				}else if(S==4) {
					System.out.println(Color.BANANA_YELLOW+"Enter batchId");
					int id=sc.nextInt();
					System.out.println("Enter courseId");
					int cid=sc.nextInt();
					System.out.println("Enter Faculty id");
					int fid=sc.nextInt();
					System.out.println("Enter number of student");
					int nos=sc.nextInt();
					System.out.println("Enter Batch Start Date");
					String date=sc.next();
					System.out.println("Enter Duration of course");
					double cou=sc.nextDouble();
					System.out.print(Color.RESET);
					System.out.println(	Color.BANANA_YELLOW+ad.createBatch(new BatchImpl(id,cid,fid,nos,LocalDate.parse(date),cou))+Color.RESET);
					
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
					System.out.println(	Color.BANANA_YELLOW+ad.updateBatch(new BatchImpl(id,cid,fid,nos,LocalDate.parse(date),cou))+Color.RESET);
				}else if(S==6) {
					System.out.print(Color.RED_BOLD_BRIGHT);
					List<Batch>list=ad.viewBatch();
					list.forEach(System.out::println);
					System.out.print(Color.RESET);
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
				System.out.println(	Color.BANANA_YELLOW+ad.createFaculty(new FacultyImpl(fid,name,fad,mob,e,pss,username))+Color.RESET);
				
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
				System.out.println(	Color.BANANA_YELLOW+ad.updateFaculty(new FacultyImpl(fid,name,fad,mob,e,pss,username))+Color.RESET);
				
				}else if(S==9) {
					System.out.print(Color.RED_BOLD_BRIGHT);
					List<Faculty>list=ad.viewFaculty();
					list.forEach(System.out::println);
					System.out.print(Color.RESET);
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
					System.out.println(	Color.BANANA_YELLOW+ad.createCoursePlan(new CoursePlanImpl(pid,bid,dn,topic,status))+Color.RESET);
				
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
					System.out.println(	Color.BANANA_YELLOW+ad.updateCoursePlan(new CoursePlanImpl(pid,bid,dn,topic,status))+Color.RESET);
				
				}else if(S==12) {
					System.out.print(Color.RED_BOLD_BRIGHT);
					List<CoursePlan>list=ad.viewCoursePlan();
					list.forEach(System.out::println);
					System.out.print(Color.RESET);
				}else if(S==13) {
					System.out.println(Color.ORANGE+"Enter Faculty Id");
					int fid=sc.nextInt();
					System.out.println("Enter BatchId"+ Color.RESET);
					int bid=sc.nextInt();
					System.out.println(	Color.BANANA_YELLOW+	ad.allocateFacultyToBatch(fid, bid)+Color.RESET);
				}else if(S==14) {
					System.out.print(Color.RED_BOLD_BRIGHT);
					List<ReportForBatch>list=ad.DayWiseUpdateForBatch();
					list.forEach(System.out::println);
					System.out.print(Color.RESET);
				}else if(S==15) {
					System.out.print(Color.RED_BOLD_BRIGHT);
					System.out.println("Enter batch id which you want to generate Report");
					int bacid=sc.nextInt();
					
					List<ReportForBatch>list=ad.generateReport(bacid);
					list.forEach(System.out::println);
					System.out.print(Color.RESET);
				}else {
					System.out.println(Color.RED_BOLD_BRIGHT+"Wrong Attempt,Try Again"+Color.RESET);
				}
				
			}while(S!=0);
			
			applicationMain();
			
		}else {
			
			
			
//			for(int i=3;i>=0;i--) {
//			int i=3;
			
			if(i>0) {
				System.out.println(Color.BANANA_YELLOW+"Access Denied, Try Again"+Color.RESET);
				System.out.println(Color.RED_BOLD_BRIGHT+"You have Left "+i+" Attempts only"+Color.RESET);
				i--;
				applicationMain();
				
			}else if(i==0) {
				System.out.println(Color.CYAN_BOLD_BRIGHT+"Your Account Blocked Try After 24 hours or Contact with Engineer"+Color.RESET);
				System.exit(1);
				
			}
//			}
			
			
		}
		break;
	case 2:
		System.out.println(Color.BOXING+Color.YELLOW_ITALIC+Color.BROWN_BACKGROUND+Color.WHITE_BOLD_BRIGHT+"=-==-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-WELCOME FACULTY=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-==-="+Color.RESET);
		System.out.println(Color.BANANA_YELLOW+"Enter Username ");
		String Facultyusername=sc.next();
		System.out.println("Enter Password");
		String Fpss=sc.next();
		System.out.print(Color.RESET);
		if(fd.FacultyLogin(Facultyusername, Fpss)) {
			do {
				System.out.println(Color.CYAN_BOLD+"1.View Course Plan\n2.Update Password\n0.Press 0 For Exit"+ Color.RESET);
				S1=sc.nextInt();
				if(S1==1) {
					System.out.println(Color.RED_BOLD_BRIGHT+"Enter UsreName");
					String users=sc.next();
					List<CoursePlan>list=fd.viewCoursePlan(users);
					list.forEach(System.out::println);
					System.out.print(Color.RESET);
				}else if(S1==2) {
					System.out.println(Color.BANANA_YELLOW+"Enter Username");
					String u1=sc.next();
					System.out.println("Enter Password");
					String p1=sc.next();
					System.out.print(Color.RESET);
					System.out.println(Color.RED_BOLD_BRIGHT+fd.updatePassword(u1, p1)+Color.RESET);
				}else {
					System.out.println(Color.RED_BOLD_BRIGHT+"Wrong Attempt,Try Again"+Color.RESET);
				}
				
			}while(S1!=0);
			applicationMain();
		}else {

			if(j>0) {
				System.out.println(Color.BANANA_YELLOW+"Access Denied, Try Again"+Color.RESET);
				System.out.println(Color.RED_BOLD_BRIGHT+"You have Left "+j+" Attempts only"+Color.RESET);
				j--;
				applicationMain();
				
			}else if(j==0) {
				System.out.println(Color.CYAN_BOLD_BRIGHT+"Your Account Blocked Try After 24 hours or Contact with Engineer"+Color.RESET);
				System.exit(1);
				
			}
		}
		break;
	case 0:
		System.out.println(Color.CYAN_BOLD_BRIGHT+ "APPLICATION CLOSED" + Color.RESET);
		System.out.println(Color.RED_BOLD_BRIGHT+  "Thank You, Visit Again" + Color.RESET);
		System.exit(1);
		break;
		default :
			System.out.println(Color.RED_BOLD_BRIGHT+"Wrong Attempt,Try Again"+Color.RESET);
			applicationMain();
			break;
	}
sc.close();
	
}
}
