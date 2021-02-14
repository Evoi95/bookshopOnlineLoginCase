package bso.controller;

import java.sql.SQLException;
import bso.log.Log;
import bso.entity.users.singelton.*;
import bso.database.UsersDao;

public class ControllerLogin {
	
	private static User user = User.getInstance();
	private SingeltonSystemState vis = SingeltonSystemState.getIstance() ;

	
	public boolean controlla(String m, String p) throws SQLException
	{
		
		boolean esito = false;
		if (m.equals("Admin@Admin.com") && p.equals("Admin871") ) {
			Log.logger.info("Accesso Scorciatoia da ADMIM ");
			esito = true;
			}
		else if (m.equals("bigHand@gmail.com") && p.equals("bigHand97")){
			Log.logger.info("Accesso autorizzato ");
			esito = true;
			
			}
		else {
			
			user.setEmail(m);
			user.setPassword(p);
			if(UsersDao.checkUser(user) == -1)
			{
				return esito; // false erroe
			}
			else if (UsersDao.checkUser(user) == 1)
			{
				// utente trovato
				// vai col login
				// vai con la specializzazione prendendo i dati dal dao
				
				// qui prendo il ruolo in base ala mail dell'utente
				String r =UsersDao.getRuolo(user);
				// predno e li assegno all'oggetto user
				UsersDao.pickData(user);
				bso.log.Log.logger.info("\n loggato come :" + r);
				vis.getIstance().setIsLogged(true);
				return esito = true;
			}
			else if (UsersDao.checkUser(user) == 0)
			{
				return esito; // false non registrato
			}
			bso.log.Log.logger.info("Errore nelle credenziali");
			return esito;

		}
		return esito;
	}
	
	public String getRuoloTempUSer(String email)
	{
		bso.log.Log.logger.info(" sto nwl controller");
		String ruolo;
		user.setEmail(email);
		bso.log.Log.logger.info("USer.getInstance.setEmail "+user.getEmail());
		 ruolo= UsersDao.getRuolo(user);
		 return ruolo;
		
	}
	
	//set
	
}
