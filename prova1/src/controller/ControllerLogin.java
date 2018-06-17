package controller;

import view.HomeFarmacologo;
import view.HomeMedico;
import view.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.WindowConstants;

import model.Utente;

public class ControllerLogin {

	Utente modelUtente;
	
	Login viewLogin;
	HomeMedico viewMedico;
	HomeFarmacologo viewFarmacologo;
	
	public ControllerLogin(Utente modelUtente, Login viewLogin, HomeMedico viewMedico, HomeFarmacologo viewFarmacologo){
		this.modelUtente = modelUtente;
		this.viewLogin = viewLogin;
		this.viewMedico = viewMedico;
		this.viewFarmacologo = viewFarmacologo;
		
		viewLogin.addLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String user = viewLogin.getUser();
            	String pass = viewLogin.getPass();
            	
                if(modelUtente.login(user, pass)){
                	System.out.println("OK LOGIN " + modelUtente.getUsername());    	
                	
                	viewLogin.setMsgLabel("");
                	viewLogin.setPasswordField("");
                	viewLogin.dispatchEvent(new WindowEvent(viewLogin, WindowEvent.WINDOW_CLOSING));
                	if(modelUtente.getTipo().equals("D")) {
                		viewMedico.setVisible(true);
                	} else if(modelUtente.getTipo().equals("D")) {
                		viewFarmacologo.setVisible(true);
                	}
                } else {
                	viewLogin.setMsgLabel("Username o password errati");
                	viewLogin.setPasswordField("");
                }
                
            }
        });
        
        
	}
	
}
