package bso.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.jdbc.RuntimeSqlException;
import org.apache.ibatis.jdbc.ScriptRunner;

public class CreateDefaultDB 
{
	private static boolean status = false;
	private static boolean statusA = false;
	private static Statement st = null ;
	private static String query = "query" ;
	private static String qTrigger = "query per trigger";
	private static PreparedStatement prepQ = null;

	
	public static void createDefaultDB () throws SQLException, ClassNotFoundException, FileNotFoundException
	{
		try 
		{
			status = ConnToDb.InitailConnection() && !ConnToDb.connection();
			statusA = ConnToDb.InitailConnection() && ConnToDb.connection();
			
			if(status) 
			{
 				st = ConnToDb.conn.createStatement();
				query="CREATE DATABASE IF NOT EXISTS ispw ";
				st.execute(query);
				query = "USE ispw ";
				st.execute(query);
				try 
				{
					ScriptRunner sr = new ScriptRunner(ConnToDb.conn);
					sr.setSendFullScript(true);
				    Reader reader = new BufferedReader(new FileReader("FileSql/storedInsCreateDB.sql"));
				    sr.runScript(reader);
					bso.log.Log.logger.info("Tabelle create!");
					if (PopulateDefaultDb.populateDefaultDb()) {
						bso.log.Log.logger.info("Tabella populata con valori di default");
						
					}
					else
					{
						bso.log.Log.logger.warning("Ops..! qualcosa e' andato storto nel populare il database!");
					}
				}
				catch(FileNotFoundException | RuntimeSqlException e1) 
				{
					e1.printStackTrace();
					bso.log.Log.logger.warning("ERRORE DI SQL\n"+e1+"\n");
				
				}
				finally
				{
					bso.log.Log.logger.info("Trigger creati e connesione chiusa col db");
				}
			}
			
			else if (statusA)
			{
				bso.log.Log.logger.info("Trovato database e connesso senza problemi! Buone madonne!");
				ConnToDb.conn.close();		
			}
			// Se qualcosa non va chiudo la connessione e vado nel cacth
			else 
			{
				bso.log.Log.logger.warning("Ops..! qualcosa E' andato storto nella connesione al database!");
				ConnToDb.conn.close();		

			}
		}
		catch(SQLException e1) 
		{
			e1.printStackTrace();
			bso.log.Log.logger.warning("ERRORE DI SQL ");
		}
		finally
		{
			ConnToDb.conn.close();		

		}
		
		
	}
	
	public static boolean createTrigger() throws SQLException 
	{
		try 
		{		st = ConnToDb.conn.createStatement();
				query = "USE ispw ";
				st.execute(query);
				//0 regolare 1 irregolare
				qTrigger= "delimiter //"
						+ "create trigger pagaFattura after insert on fattura "
						+ "for each row "
						+ "begin  "
						+ "insert into  pagamento values(0,'fattura',0,new.nome,new.ammontare); "
						+ "end; //";
				
				prepQ = ConnToDb.conn.prepareStatement(qTrigger);	

				
				bso.log.Log.logger.info("Trigger pagamento triggerato");
				
				qTrigger= "delimiter //"
						+ "create trigger pagaCartaCredito after insert on cartacredito "
						+ "for each row "
						+ "begin "
						+ "insert into  pagamento values(0,'cartac',0,new.nomeP,new.ammontare);"
						+ "end; //";
				prepQ = ConnToDb.conn.prepareStatement(qTrigger);	
				bso.log.Log.logger.info("Trigger cartaDiCredito triggerato");
				return true;
			
		}
		catch(SQLException e1) 
		{
			bso.log.Log.logger.warning("ERRORE DI SQL ");
		}
		
		return false;
	}
}
