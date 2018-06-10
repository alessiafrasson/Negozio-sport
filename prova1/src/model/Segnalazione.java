package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

public class Segnalazione extends Observable{
	
	private int id = 0;
	private Paziente paziente;
	private Utente utente;
	private Reazione reazione;
	public Segnalazione(int id, Paziente paziente, Utente utente, Reazione reazione) {
		
		this.id = id;
		this.paziente = paziente;
		this.utente = utente;
		this.reazione = reazione;
	}
	 
	
	public void setId(int id) {
		this.id = id;
		setChanged();
		notifyObservers();
		
	}
	//INSERISCE UNA NUOVA SEGNALAZIONE
	public void addSegnalazione(){
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
			Statement stat = conn.createStatement();

			stat.executeUpdate("INSERT INTO Segnalazione(intIdPaziente, intIdReazione, intIdMedico) VALUES (" + this.paziente.getId() + ", " + this.reazione.getId() + ", " + this.utente.getId() +")");
			
			ResultSet res = stat.executeQuery("SELECT max(intIdSegnalazione) AS id FROM Segnalazione");
			setId(res.getInt("id"));
			
			res.close();
			conn.close();
			
		} catch (SQLException SQLexc) {
			SQLexc.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}