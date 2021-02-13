package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Giornale;
import bso.database.GiornaleDao;
import javafx.collections.ObservableList;

public class ControllerGiornalePage {

	private GiornaleDao gD;
	
	public ObservableList<Giornale> getGiornaliS() throws SQLException {
		return gD.getLibriSingolo();
	}
	
	
	public ControllerGiornalePage() {
		gD=new GiornaleDao();
	}
}
