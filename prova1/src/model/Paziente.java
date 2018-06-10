package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

public class Paziente extends Observable{

	private int id = 0;
	private String nome = "";
	private String cognome = "";
	private String dataNascita = "";
	private String provincia = "";
	private String professione = "";
	private ArrayList<Paziente> pazientimedico = new ArrayList<>();

	public Paziente(int id, String dataNascita, String provincia, String professione, String nome, String cognome) {

		this.id = id;
		this.dataNascita = dataNascita;
		this.provincia = provincia;
		this.professione = professione;
		this.nome = nome;
		this.cognome = cognome;

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

	public void setCognome(String cognome){
		this.cognome = cognome;
		setChanged();
		notifyObservers();
	}

	public void setProvincia(String provincia){
		this.provincia = provincia;
		setChanged();
		notifyObservers();
	}

	public void setDataNascita(String dataNascita){
		this.dataNascita = dataNascita;
		setChanged();
		notifyObservers();
	}
	

	public void setProfessione(String professione){
		this.professione = professione;
		setChanged();
		notifyObservers();
	}
	

	
	//RICERCA TUTTI I PAZIENTI DI UN DETERMINATO MEDICO
	public void setPazientiMedico(int idMedico){
		ArrayList<Paziente> lista = new ArrayList<Paziente>();

		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
			Statement stat = conn.createStatement();

			ResultSet res = stat.executeQuery("SELECT Paziente.* from"
						+ " Paziente JOIN MedicoPaziente"
						+ " ON Paziente.intIdPaziente = MedicoPaziente.intIdPaziente"
						+ " AND MedicoPaziente.intIdMedico = " + idMedico );
			while (res.next()) {

				lista.add(new Paziente(res.getInt("intIdPaziente"),
						res.getString("dtaDataNascita"),
						res.getString("strProvincia"),
						res.getString("strProfessione"),
						res.getString("strNome"),
						res.getString("strCognome")
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
		
		pazientimedico = lista;
		
		setChanged();
		notifyObservers();
	}

	
	public int getId(){
		return this.id;
	}

	public String getNome(){
		return this.nome;
	}

	public String getCognome(){
		return this.cognome;
	}

	public String getDataNascita(){
		return this.dataNascita;
	}

	public String getProfessione(){
		return this.professione;
	}
	

	public String getProvincia(){
		return this.provincia;
	}
	
	public ArrayList<Paziente> getPazientiMedico(){
		return pazientimedico;
	}
	
	//INSERISCE NUOVO PAZIENTE NEL DB
	public void addPaziente(){
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
			Statement stat = conn.createStatement();

			//id inserito automaticamente, è autoincrement
			stat.executeUpdate("Insert INTO Paziente(dtaDataNascita,strProvincia,strProfessione,strNome,strCognome) "
					+ "VALUES('" + dataNascita + "','" + provincia + "','" + professione + "','" + nome + "',' "+ cognome + "')");
			
			
			//recupero id massimo tra tutti che sarà quello appena inserito
			ResultSet res = stat.executeQuery("SELECT max(intIdPaziente) AS id FROM Paziente");
			int idPaz = res.getInt("id");
			setId(idPaz);
			
			
			res.close();
			conn.close();
		} catch (SQLException SQLexc) {
			SQLexc.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	//MAI USATO, RESTITUISCE TUTTI I PAZIENTI PRESENTI NEL DB
	public ArrayList<Paziente> getPazienti(){

		ArrayList<Paziente> lista = new ArrayList<Paziente>();

		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
			Statement stat = conn.createStatement();

			ResultSet res = stat.executeQuery("SELECT * FROM Paziente");
			while (res.next()) {

				lista.add(new Paziente(res.getInt("intIdPaziente"),
						res.getString("dtaDataNascita"),
						res.getString("strProvincia"),
						res.getString("strProfessione"),
						res.getString("strNome"),
						res.getString("strCognome")
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

		return lista;
	}


}
