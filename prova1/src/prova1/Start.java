package prova1;

import controller.ControllerLogin;
import controller.ControllerMedico;
import model.FattoreRischio;
import model.Paziente;
import model.Utente;
import view.NuoviFattoriRischio;
import view.HomeMedico;
import view.Login;
import view.NuovaSegnalazione;
import view.NuovaTerapia;
import view.NuovoPaziente;

public class Start {
	
	/*
	 * 
	 * 
	 * CREO TUTTE LE CLASSI, LE VIEW SONO CREATE ALL'INIZIO MA NON SONO VISIBILI
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		
		Utente utente = new Utente(0,"","","","", "");
		Paziente paziente = new Paziente(0,"","","","","");
		FattoreRischio fattore = new FattoreRischio(0, "", 0);
		
		Login loginView = new Login();
		HomeMedico viewMedico = new HomeMedico(utente,paziente);
		NuovoPaziente nuovoPaz = new NuovoPaziente();
		NuovaTerapia nuovaTer = new NuovaTerapia();
		NuovaSegnalazione nuovaSegn = new NuovaSegnalazione();
		NuoviFattoriRischio fattoriRischio = new NuoviFattoriRischio(fattore);
		
		ControllerLogin controllerLog = new ControllerLogin(utente, loginView,viewMedico);
		ControllerMedico controllerMed = new ControllerMedico(utente, paziente, fattore,
				viewMedico, nuovoPaz, nuovaTer, nuovaSegn,fattoriRischio);
		loginView.setVisible(true);
		
		
		/*utente.setId(1);
		utente.setCognome("rossi");
		utente.setNome("luca");
		utente.setTipo("D");
		viewMedico.setVisible(true);
		fattoriRischio.setVisible(true);*/
	}
}