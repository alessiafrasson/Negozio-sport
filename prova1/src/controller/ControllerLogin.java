package controller;

import view.HomeMedico;
import view.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Utente;

public class ControllerLogin {

	Utente modelUtente;
	
	Login viewLogin;
	HomeMedico viewMedico;
	
	public ControllerLogin(Utente modelUtente, Login viewLogin, HomeMedico viewMedico){
		this.modelUtente = modelUtente;
		this.viewLogin = viewLogin;
		this.viewMedico = viewMedico;

	
		viewLogin.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String user = viewLogin.getUserMedico();
            	String pass = viewLogin.getPassMedico();
            	
                if(modelUtente.login(user, pass)){
                	System.out.println("OK LOGIN " + modelUtente.getUsername());    	
                	
                	viewLogin.setMsgLabel("");
                	viewLogin.setPasswordField("");
                	viewMedico.setVisible(true);
                } else {
                	viewLogin.setMsgLabel("Username o password errati");
                	viewLogin.setPasswordField("");
                }
                
            }
        });
        
        
	}
	
}
