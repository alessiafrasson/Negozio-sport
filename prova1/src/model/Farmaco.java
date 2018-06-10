package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

public class Farmaco extends Observable{
	
	private int id;
	private String nome;
	
	public Farmaco(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	
	public void setNome(String nome){
		this.nome = nome;
		setChanged();
		notifyObservers();
	}
	
	
	public void setId(int id){
		this.id = id;
		setChanged();
		notifyObservers();
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	
	//CERCA SEGNALAZIONI USANDO L'ID DEL FARMACO
	public int getNumeroSegnalazioni() {
		int segnalazioni = 0;
		
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
			Statement stat = conn.createStatement();

			ResultSet res = stat.executeQuery("SELECT COUNT(*) AS numero FROM Segnalazione WHERE intIdFarmaco =" + this.getId());
			
			segnalazioni = res.getInt("numero");

			res.close();
			conn.close();
		} catch (SQLException SQLexc) {
			SQLexc.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return segnalazioni;
	}
	
}
