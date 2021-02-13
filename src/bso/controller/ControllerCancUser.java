package bso.controller;

import bso.entity.users.singelton.TempUser;
import bso.database.UsersDao;

public class ControllerCancUser {
	private static TempUser u=TempUser.getInstance();
	

	public void cancellaUtente(int id)
	{
		u.setIdU(id);
		UsersDao.deleteTempUser(u);
	}
	
	public ControllerCancUser()
	{
		
	}
}
