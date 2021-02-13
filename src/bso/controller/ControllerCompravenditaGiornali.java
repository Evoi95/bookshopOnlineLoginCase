package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Giornale;
import bso.entity.factoryBook.Raccolta;
import bso.entity.users.singelton.User;
import bso.database.GiornaleDao;
import javafx.collections.ObservableList;

public class ControllerCompravenditaGiornali {
	private GiornaleDao gD;
	private Giornale g;
	private User u=User.getInstance();

	public ControllerCompravenditaGiornali() {
		gD = new GiornaleDao();
		g = new Giornale();
	}

	public ObservableList<Raccolta> getGiornali() throws SQLException {
		
		
		return gD.getGiornali();

	}

	public boolean disponibilitaGiornale(String i ) throws SQLException {
		
		int id = Integer.parseInt(i);
		
		return gD.checkDisp(g,id);
	}
	public String tipoUtente()
	{
		u.setIdRuolo("a");
		return u.getIdRuolo();
	}

}
