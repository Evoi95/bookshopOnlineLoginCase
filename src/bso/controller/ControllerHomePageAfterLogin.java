package bso.controller;


import bso.entity.users.singelton.User;


public class ControllerHomePageAfterLogin {
	
	private static User U = User.getInstance();
	private static SingeltonSystemState vis = SingeltonSystemState.getIstance() ;

	// qui ci va la funzione di logout
	
	public static boolean logout() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{	
		
		String n = U.getNome();
		bso.log.Log.logger.info("Stai sloggando con il nome di : "+ n );
		U.setNull();
		
		if(U.getEmail() == null && U.getIdRuolo() == null)
		{
			bso.log.Log.logger.info("Logout  utente" + U.getEmail());
			vis.setIsLogged(false);
			return true;
		}
		
		return false;
		
	}
}
