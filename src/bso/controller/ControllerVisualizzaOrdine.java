package bso.controller;

import java.sql.SQLException;

import bso.entity.factoryBook.Raccolta;
import bso.entity.pagamento.Pagamento;
import bso.database.*;
import javafx.collections.ObservableList;


public class ControllerVisualizzaOrdine {
	
	private PagamentoDao pD;
	
	public ObservableList<Pagamento> getDati() throws SQLException {
		
		return pD.getPagamenti();
		}
	
	
	
	public ControllerVisualizzaOrdine()
	{
		pD=new PagamentoDao();
		
	}

}
