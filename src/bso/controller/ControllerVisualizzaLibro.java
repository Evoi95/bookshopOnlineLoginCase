package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Libro;
import bso.database.LibroDao;

public class ControllerVisualizzaLibro {
	
	private LibroDao ld;
	private Libro b;
	private SingeltonSystemState vis = SingeltonSystemState.getIstance() ;
	
	public ControllerVisualizzaLibro()
	{
		ld = new LibroDao();
	}
	public void setID(String i)
	{		
		vis.setId(Integer.parseInt(i));
	}
	public int getID()
	{
		;
		return vis.getId();
	}
	public Libro getData(int i) throws SQLException
	{
		vis.setTypeAsBook();
		return  ld.getLibro(b,i);
	}
}