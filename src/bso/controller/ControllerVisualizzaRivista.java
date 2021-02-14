package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Rivista;
import bso.database.RivistaDao;

public class ControllerVisualizzaRivista {
	
	private RivistaDao rD;
	private Rivista r;
	private static SingeltonSystemState vis = SingeltonSystemState.getIstance() ;
	
	public ControllerVisualizzaRivista()
	{
		rD = new RivistaDao();
	}
	public void setID(String i)
	{		
		vis.setId(Integer.parseInt(i));
	}
	public int getID()
	{
		return vis.getId();
	}
	public Rivista getData(int i) 
	{
		vis.setTypeAsMagazine();
		try {
			return  rD.getRivista(r,i);
		} catch (SQLException e) {
			
			return null;
		}
		
	}
}
