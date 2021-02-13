package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Libro;
import bso.entity.factoryBook.Raccolta;
import bso.entity.users.singelton.User;
import bso.database.LibroDao;
import javafx.collections.ObservableList;

public class ControllerCompravenditaLibri {
	private LibroDao lD;
	private Libro l;
	private static User u=User.getInstance();



	public boolean disponibilitaLibro(String i ) throws SQLException {
	
		int id = Integer.parseInt(i);
		
		return lD.checkDisp(l,id);
	}

	public ControllerCompravenditaLibri() {
		lD = new LibroDao();
	}

	public ObservableList<Raccolta> getLibri() throws SQLException {
		return lD.getLibri();
	}
	
	public String retTipoUser()
	{
		
		// usato per torare tipo utente e 
		//switchare schermata opportuna
		
		//provo a forzare
		u.setIdRuolo("u");
		return u.getIdRuolo();
	}


	
}
