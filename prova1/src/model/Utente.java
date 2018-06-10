package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;


//Classe Utente con annidato l'UtenteBuilder (Builder pattern)
public class Utente extends Observable{

	private int id = 0;
	private String nome = "";
	private String cognome = "";
	private String username = "";
	private String password = "";
	private String tipo = "";

	public Utente(int id, String nome, String cognome, String username, String password, String tipo) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.tipo = tipo;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}

	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getTipo() {
		return tipo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public ArrayList<Utente> getUtenti(){

		ArrayList<Utente> lista = new ArrayList<Utente>();
		
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
			Statement stat = conn.createStatement();

			ResultSet res = stat.executeQuery("SELECT intIdUtente, strNome, strCognome, strUsername, strPassword, strTipo FROM Utente");
			while (res.next()) {

				lista.add(new Utente(res.getInt("intIdUtente"),
						res.getString("strNome"),
						res.getString("strCognome"),
						res.getString("strUsername"),
						res.getString("strPassword"),
						res.getString("strTipo")));
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
	
	
	public boolean login(String username, String password){
		
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:DBSorveglianza.db");
			Statement stat = conn.createStatement();

			ResultSet res = stat.executeQuery("SELECT * FROM Utente WHERE strUsername = '" + username + "' AND strPassword = '" + password + "'");
			
			while(res.next()){
				setId(res.getInt("intIdUtente"));
				setUsername(username);
				setNome(res.getString("strNome"));
				setCognome(res.getString("strCognome"));
				setTipo(res.getString("strTipo"));
			}

		
			res.close();
			conn.close();
			
		} catch (SQLException SQLexc) {
			SQLexc.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (getId()!=0);
	}
	
	
	
	public static class UtenteBuilder{
		private int id = 0;
		private String nome = "";
		private String cognome = "";
		private String username = "";
		private String password = "";
		private String tipo = "";
		
		
		public UtenteBuilder(String username, String password){
			this.username = username;
			this.password = password;
		}
		
		public UtenteBuilder setNome(String nome){
			this.nome = nome;
			return this;
		}
		public UtenteBuilder setId(int id){
			this.id = id;
			return this;
		}

		public UtenteBuilder setCognome(String cognome){
			this.cognome = cognome;
			return this;
		}

		public UtenteBuilder setUsername(String username){
			this.username = username;
			return this;
		}
		
		public UtenteBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
		public UtenteBuilder setTipo(String tipo){
			this.tipo = tipo;
			return this;
		}

		
		public Utente build(){
			return new Utente(id, nome, cognome, username, password, tipo);
		}

	}


}
