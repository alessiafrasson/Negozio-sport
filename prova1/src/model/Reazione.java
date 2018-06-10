package model;

import java.util.Observable;

public class Reazione extends Observable{
	
	int id;
	String nome;
	int livGravita;
	String descrizione;
	
	public Reazione(int id, String nome, int livGravita, String descrizione) {
		
		this.id =  id;
		this.nome = nome;
		this.livGravita = livGravita;
		this.descrizione = descrizione;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		setChanged();
		notifyObservers();
	}
	
	
	public void setGravita(int livGravita) {
		this.livGravita = livGravita;
		setChanged();
		notifyObservers();
	}
	
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		setChanged();
		notifyObservers();
	}
	
	
	public int getId() {
		return this.id;
		
	}
	
	
	
}