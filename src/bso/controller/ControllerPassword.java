package bso.controller;

import java.sql.SQLException;

import bso.entity.users.singelton.User;
import bso.database.UsersDao;

public class ControllerPassword {
	private User u = User.getInstance();
	private boolean status;


	public boolean aggiornaPass(String email,String vecchiaP,String nuovaP) throws SQLException
	{
		
		if(nuovaP.length()>=8 || !email.equals(""))
		{
			u.setEmail(email);
			u.setPassword(vecchiaP);
			if(UsersDao.checkUser(u) == 1)
			{
				UsersDao.checkResetpass(u, nuovaP,email);
				status=true;
			}
			else if  (UsersDao.checkUser(u) == 0 || UsersDao.checkUser(u) == -1 )
			{
				status=false;
			}
			
		}
		else {
			status=false;
		}
		return status;
	}
}
