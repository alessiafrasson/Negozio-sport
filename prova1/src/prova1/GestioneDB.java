package prova1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestioneDB{

 
/*
 * 
 *  
 *  
 *   MAI USATA, SPESSO MI SERVONO TIPI DI DATO DIVERSI DALLE QUERY ED ERA UN CASINO, 
	POI HO LETTO CHE è MEGLIO APRIRE E CHIUDERE LA CONNESSIONE PERCHè TENERLA APERTA è UNO SPRECO DI RISORSE 
*
*
*
*	
*/
  
	protected Connection getConnection(){
    	try{
        	Connection connessione = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
        	return connessione;
    	} catch (Exception e) {
    		System.err.println(e.getClass().getName() + ": " + e.getMessage());
    		System.exit(0);
    	}
    	 	return null;
    }
     
    public ResultSet selectQuery(String query){
    	
    	try{
        	Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");

        	Statement stat = conn.createStatement();
        	ResultSet result = stat.executeQuery(query);
        	ResultSet res2 = result;
        	
        	result.close();
        	conn.close();
        	
            return res2;
            
            
    	} catch (Exception e) {
    		System.err.println(e.getClass().getName() + ": " + e.getMessage());
    		System.exit(0);
    	}
    	
    	return null;
    	
    }
    
}
