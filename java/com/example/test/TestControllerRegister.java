package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import bso.controller.ControllerBsoRegister;
import bso.entity.users.singelton.User;

class TestControllerRegister {
	private static User u=User.getInstance();
	private ControllerBsoRegister bReg;
	private boolean state=false;

	@Test
	void testRegistra() throws SQLException {
		bReg=new ControllerBsoRegister();
		u.setNome("pippo");
		u.setCognome("pluto");
		u.setEmail("pluto10@gmail.com");
		u.setPassword("pluto723");
		u.setDataDiNascita(LocalDate.of(1995,10,31));
		
		System.out.println("Data in testControllerReg :"+u.getDataDiNascita());
		
		state=bReg.registra(u.getNome(), u.getCognome(),u.getEmail(), u.getPassword(), u.getPassword(),u.getDataDiNascita());
		
		System.out.println("State in bsroREg:"+state);
		assertEquals(false,state);
		
	}

	@Test
	void testCheckData() {
		bReg=new ControllerBsoRegister();
		boolean state=false;
		state=bReg.checkData( u.getNome(),u.getCognome(),u.getEmail(), "pippo745", u.getPassword());
		assertEquals(false,state);
		//fail("Not yet implemented");
	}

	@Test
	void testCheckEmail() {
		bReg=new ControllerBsoRegister();
		
		u.setEmail("pluto10@gmail.com");
		state=bReg.checkEmail(u.getEmail());
		assertNotEquals(false,state);
		
	}

	@Test
	void testCheckPassword() {
		bReg=new ControllerBsoRegister();
		
		String pwd="pluto723";
		state=bReg.checkPassword(pwd,u.getPassword());
		
		assertEquals(true,state);
		
		//fail("Not yet implemented");
	}

	@Test
	void testCheckNomeCognome() {
		bReg=new ControllerBsoRegister();
		state=bReg.checkNomeCognome(u.getNome(),u.getCognome() );
		assertEquals(true,state);
		//fail("Not yet implemented");
	}

}
