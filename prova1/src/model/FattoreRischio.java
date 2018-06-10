package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

public class FattoreRischio extends Observable{

	private int id = 0;
	private String descrizione = "";
	private int livelloGrav = 0;
	private ArrayList<FattoreRischio> fattoriRischio = new ArrayList<>();
	

	public FattoreRischio(int id, String descrizione, int livelloGrav) {
		this.id = id;
		this.descrizione = descrizione;
		this.livelloGrav = livelloGrav;
	}

	public void setDescrizione(String descrizione){
		this.descrizione = descrizione;
		setChanged();
		notifyObservers();
	}

	public void setId(int id){
		this.id = id;
		setChanged();
		notifyObservers();
	}

	public void setLivelloGrav(int livelloGrav){
		this.livelloGrav = livelloGrav;
		setChanged();
		notifyObservers();
	}


	public int getId(){
		return this.id;
	}

	public String getDescrizione(){
		return this.descrizione;
	}

	public int getLivelloGrav(){
		return this.livelloGrav;
	}


	public void setFattori(){

		ArrayList<FattoreRischio> lista = new ArrayList<FattoreRischio>();
		
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
			Statement stat = conn.createStatement();

			ResultSet res = stat.executeQuery("SELECT * FROM FattoreRischio ORDER BY FattoreRischio.strDescrizione");
			while (res.next()) {

				lista.add(new FattoreRischio(res.getInt("intIdFattore"),
						res.getString("strDescrizione"),
						Integer.parseInt(res.getString("intLivelloRischio"))
						)
						);
			}

			res.close();
			conn.close();
		} catch (SQLException SQLexc) {
			SQLexc.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fattoriRischio = lista;
		setChanged();
		notifyObservers();
	}
	
	public ArrayList<FattoreRischio> getFattori(){
		return fattoriRischio;
	}
	
	
	//Inserisce un nuovo fattore di rischio nel db e ritorna l'indice
	public int insertFattore(String descrizione, int livRischio){
		int cod = 0;
		
		return cod;
	}
	
	//Inserisce un nuovo fattore di rischio per un paziente
	public void FattorePaziente(int idFattore, int idPaziente){
		System.out.println(idFattore + " paz: " + idPaziente);
	}

}
