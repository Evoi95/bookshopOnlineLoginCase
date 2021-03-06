package bso.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import bso.entity.users.singelton.TempUser;
import bso.database.UsersDao;

public class ControllerModifUserPage {
	private UsersDao ud;
	private static TempUser uT=TempUser.getInstance();
	
	
	
	public ControllerModifUserPage()
	{
		ud=new UsersDao();
		
	}



	public TempUser prendiLista(int id) throws SQLException {
		bso.log.Log.logger.info("id in controllerMUP :"+ id);
		
		uT.setIdU(id);
		
		return ud.getTempUserSingolo(uT);
		
		
	}
	
	public int  prendiIdMax() throws SQLException
	{
		return ud.maxIdUSer();
	}



	public void aggiornaUtenteByAdmin(String n, String c, String e, String p, String d, LocalDate data, String r) throws NullPointerException {
		
		uT.setNome(n);
		uT.setCognome(c);
		uT.setEmail(e);
		uT.setPassword(p);
		uT.setDescrizione(d);
		uT.setDataDiNascita(data);
		uT.setIdRuolo(r);
		
		UsersDao.aggiornaUtenteTemp(uT);
		
		
	}
	
	
}
