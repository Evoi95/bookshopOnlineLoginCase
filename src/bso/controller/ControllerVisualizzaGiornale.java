package bso.controller;


import bso.entity.factoryBook.Giornale;
import bso.database.GiornaleDao;



public class ControllerVisualizzaGiornale {
	
	private GiornaleDao gD;
	private Giornale g;
	
	public ControllerVisualizzaGiornale()
	{
		gD = new GiornaleDao();
	}
	
	public void setID(String i)
	{		
		SingeltonSystemState.getIstance().setId(Integer.parseInt(i));
	}
	public int getID()
	{
		return SingeltonSystemState.getIstance().getId();
	}
	public Giornale getData(int i)
	{
		SingeltonSystemState.getIstance().setTypeAsDaily();
		return  gD.getGiornale(g,i);
	}

}
