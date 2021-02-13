package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Raccolta;
import bso.entity.factoryBook.Rivista;
import bso.entity.users.singelton.User;
import bso.database.RivistaDao;
import javafx.collections.ObservableList;

public class ControllerCompravenditaRiviste {
	private RivistaDao rD;
	private Rivista r;
	private static User u=User.getInstance();

	public ControllerCompravenditaRiviste() {
		rD = new RivistaDao();
		r = new Rivista();
	}

	public ObservableList<Raccolta> getRiviste() throws SQLException {
		return rD.getRiviste();
	}
	

	public boolean disponibilitaRiviste(String i ) throws SQLException {
		
		int id = Integer.parseInt(i);
		
		return rD.checkDisp(r,id);
	}

	public String tipoUtente()
	{
		u.setIdRuolo("e");
		return u.getIdRuolo();
	}

}
