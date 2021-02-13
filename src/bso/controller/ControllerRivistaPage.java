package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Rivista;
import bso.database.RivistaDao;
import javafx.collections.ObservableList;

public class ControllerRivistaPage {
	private RivistaDao rd;
	
	public ObservableList<Rivista> getRivistaS() throws SQLException {
		return rd.getRivistaSingolo();
	}
	
	
	public ControllerRivistaPage()
	{
		rd=new RivistaDao();
	}
}
