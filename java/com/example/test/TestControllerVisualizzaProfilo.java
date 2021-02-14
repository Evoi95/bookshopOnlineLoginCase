package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bso.controller.ControllerVisualizzaProfilo;
import bso.entity.users.singelton.User;

class TestControllerVisualizzaProfilo {
	private ControllerVisualizzaProfilo cVP=new ControllerVisualizzaProfilo();
	private static User u=User.getInstance();
	

	@Test
	void testGetCredenziali() {
		u.setNull();
		u.setNome("pippo");
		u.setEmail("Admin@Admin.com");
		System.out.println("CVO CREDENZIAL:"+cVP.getCredenziali());
	}

	@Test
	void testCancellaUtente() {
		//boolean state;
		//cVP.cancellaUtente();
		//assertNotEquals(false,state);
	}

}
