package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import bso.controller.ControllerLogin;

class TestControllerLogin {
	
	private boolean state;
	private String ruolo;
	private ControllerLogin cL;
	String email;
	String pass;

	@Test
	void testControlla() {
		cL=new ControllerLogin();	
		email="Admin@Admin.com";/*"pippo@pippo.com"; 10.9*/
		pass="Admin871";/*"pippo871";10.9*/
		try {
			state=cL.controlla(email,pass);
		} catch (SQLException e) {
		 
			
		}	
		System.out.println("Sate :"+ state);
		assertEquals(true,state);
	}

	@Test
	void testGetRuoloTempUSer() {
		cL=new ControllerLogin();
		email="baoPublishing@gmail.com";
		ruolo=cL.getRuoloTempUSer(email);
		assertEquals("E",ruolo);
		
	}

}
