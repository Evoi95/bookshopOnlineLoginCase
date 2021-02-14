package bso.controller;

import java.io.IOException;
import java.sql.SQLException;

import bso.entity.pagamento.Fattura;
import bso.entity.pagamento.Pagamento;
import bso.database.ContrassegnoDao;
import bso.database.PagamentoDao;

public class ControllerPagamentoCash {
	private ContrassegnoDao pD;
	private Fattura f;
	private PagamentoDao pagD;

	public void controlla(String nome, String cognome, String via, String com,float ammontare) throws IOException, SQLException {
		try {
			pD.daiPrivilegi();
			pagD.daiPrivilegi();

			bso.log.Log.logger.info("\n\n");
			f.setNome(nome);
			f.setCognome(cognome);
			f.setVia(via);
			f.setCom(com);
			f.setAmmontare(pD.prendiSpesa());
			pD.inserisciFattura(f);
			
			Pagamento p=new Pagamento(0, "cash", 0, f.getNome(), f.getAmmontare(), null, 0);
			pagD.aggiornaPagamentoCash(p);
					
		} catch (Exception e) {
			e.getCause();
		}

	}

	public ControllerPagamentoCash()  {
		pD = new ContrassegnoDao();
		f = new Fattura();
		pagD=new PagamentoDao();
		
	}

}
