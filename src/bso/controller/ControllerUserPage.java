package bso.controller;

import bso.database.UsersDao;

public class ControllerUserPage {
	private UsersDao ud;
	
	public void getUtenti()  {
		 ud.getListaUtenti();
	}
	
	public ControllerUserPage()
	{
		ud=new UsersDao();
	}
	

}
