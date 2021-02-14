package bso.controller;

import bso.entity.users.singelton.User;
import bso.database.UsersDao;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControllerVisualizzaProfilo {
	private UsersDao ud;
	private boolean status=false;

	public User getCredenziali() {
		
		return UsersDao.pickData(User.getInstance());
		
	}
	
	public ControllerVisualizzaProfilo()
	{
		ud=new UsersDao();
	}

	public boolean cancellaUtente() {
		if(UsersDao.deleteUser(User.getInstance())==true )
		{
			User.getInstance().setNull();
			status=true;
			//bso.log.Log.logger.info("USer @"+u.getInstance());
		}
		return status;

		}
}
		
		
		
		
	


