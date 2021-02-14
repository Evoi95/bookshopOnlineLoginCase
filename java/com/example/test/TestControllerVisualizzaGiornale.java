package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import bso.controller.ControllerVisualizzaGiornale;

class TestControllerVisualizzaGiornale {
	private ControllerVisualizzaGiornale cVG=new ControllerVisualizzaGiornale();

	@Test
	void testSetID() {
		String id="1";
		cVG.setID(id);
	}

	
	@Test
	void testGetID() {
		int x=cVG.getID();
		assertNotEquals(-1,x);
		}



}
