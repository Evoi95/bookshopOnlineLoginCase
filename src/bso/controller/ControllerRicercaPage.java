package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.*;
import bso.database.*;
import javafx.collections.ObservableList;

public class ControllerRicercaPage {
	
	private LibroDao lD;
	private GiornaleDao gD;
	private RivistaDao rD;
	public ControllerRicercaPage()
	{
		lD = new LibroDao();
		gD = new GiornaleDao();
		rD =new RivistaDao();
		//singeltonSystemState.getIstance();
		SingeltonSystemState.getIstance().setIsSearch(true);
		bso.log.Log.logger.info("vis nel costruttore"+SingeltonSystemState.getIstance());
		
	}
	
	public ObservableList<Raccolta> cercaPerTipo (String S) throws SQLException
	{
		//3 if per i tipi 
		bso.log.Log.logger.info("Tipo e confronto :"+SingeltonSystemState.getIstance().getType().equals("libro"));
		if(SingeltonSystemState.getIstance().getType().equals("libro"))
		{
			//serach in libro dao
			return lD.getLibriByName(S);
		}
		else if(SingeltonSystemState.getIstance().getType().equals("giornale"))
		{
			//search in giornale dao
			return gD.getGiornaliByName(S);
		}
		else if(SingeltonSystemState.getIstance().getType().equals("rivista"))
		{
			//search in rivista dao
			return rD.getRivisteByName(S);
		}
		
		return null;
		
	}
	
	public String returnType()
	{
		return SingeltonSystemState.getIstance().getType();
	}
	
	
}
