package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Libro;
import bso.database.LibroDao;
import javafx.collections.ObservableList;

public class ControllerBookPage {
	private LibroDao lD;
	
	public ObservableList<Libro> getLibriS() throws SQLException {
		return lD.getLibriSingolo();
	}
	
	public ControllerBookPage()
	{
		lD=new LibroDao();
	}
	

}
