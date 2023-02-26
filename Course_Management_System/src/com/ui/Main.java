package com.ui;

import com.exception.SomeThingWentWrong;

public class Main {

	
	
	public static void main(String[] args) {
		
	try {
		
		SwitchingUserUi.applicationMain();
		
	} catch (SomeThingWentWrong e) {
		
		e.printStackTrace();
	} 
	}
}
