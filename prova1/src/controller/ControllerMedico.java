package controller;

import view.HomeMedico;
import view.Login;
import view.NuovaSegnalazione;
import view.NuovaTerapia;
import view.NuovoPaziente;
import model.FattoreRischio;
import model.Paziente;
import model.FattoreRischio;
import view.NuoviFattoriRischio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.relation.InvalidRelationServiceException;

import model.Utente;

public class ControllerMedico {

	Utente modelUtente;
	
	Paziente modelPaziente;
	
	HomeMedico viewMedico;
	NuovoPaziente nuovoPaz;
	NuovaTerapia nuovaTer;
	NuovaSegnalazione nuovaSegn;
	NuoviFattoriRischio fattoriRischio;
	
	public ControllerMedico(Utente modelUtente,Paziente modelPaziente, FattoreRischio modelFattore, 
			HomeMedico viewMedico, NuovoPaziente nuovoPaz, NuovaTerapia nuovaTer, 
			NuovaSegnalazione nuovaSegn, NuoviFattoriRischio fattoriRischio){
		
		this.modelUtente = modelUtente;
		this.modelPaziente = modelPaziente;
		
		this.viewMedico = viewMedico;
		this.nuovoPaz = nuovoPaz;
		this.nuovaTer = nuovaTer;
		this.nuovaSegn = nuovaSegn;
		this.fattoriRischio = fattoriRischio;
		
		
		viewMedico.addCercaListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("metodo addCercaListener");
            	int idMedico = modelUtente.getId();
            	String cognomePaz = viewMedico.getCognomeCercato();
            	System.out.println("Ricercato "+ cognomePaz);
            	
            	modelPaziente.setPazientiMedico(idMedico);
            	viewMedico.addPazientiCombo();
                
            }
		});	
		
		
		viewMedico.addNuovoPazListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("metodo addNuovoPazListener");
            	nuovoPaz.setVisible(true);
                
            }
		});
		
		viewMedico.addNuovaSegnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("metodo addNuovaSegnListener");
            	nuovaSegn.setVisible(true);
			}
		});
		
		viewMedico.addNuovaTerapiaListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("metodo addNuovaTerapiaListener");
            	nuovaTer.setVisible(true);
            }
        });

		nuovoPaz.addConfermaDatiListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("metodo addConfermaDatiListener");
            	modelFattore.setFattori();
            	fattoriRischio.setVisible(true);
            	
            	modelPaziente.setCognome(nuovoPaz.getCognome());
            	modelPaziente.setNome(nuovoPaz.getNome());
            	modelPaziente.setProvincia(nuovoPaz.getProv());
            	modelPaziente.setDataNascita(nuovoPaz.getAAAANasc()+"/"+nuovoPaz.getMMNasc()+"/"+nuovoPaz.getGGNasc());
            	modelPaziente.setProfessione(nuovoPaz.getProfessione());
        
            	
            	modelPaziente.addPaziente();
            	
            	nuovoPaz.setVisible(false);
                
            }
		});
		
		
		fattoriRischio.addConfermaListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("metodo addConfermaListener");
            	int codFattore = 0;
            	int codPaziente = modelPaziente.getId();
            	
            	for(int i=0; i<fattoriRischio.getFattoriSelezionati().length;i++){
            		if(fattoriRischio.getFattoriSelezionati()[i] != ""){
            			codFattore = Integer.parseInt(fattoriRischio.getFattoriSelezionati()[i].split("cod:")[1]);
            			modelFattore.FattorePaziente(codFattore, codPaziente);
            		}
            	}
                
            }
		});
		
		
		
		fattoriRischio.addAnnullaListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	fattoriRischio.setVisible(false);
                
            }
		});
		
		
		
	}
}
