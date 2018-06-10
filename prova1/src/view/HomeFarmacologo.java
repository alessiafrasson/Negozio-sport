package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Farmaco;
import model.Paziente;
import model.Utente;
import net.miginfocom.swing.MigLayout;

public class HomeFarmacologo extends JFrame implements Observer{
	
	
	private JLabel farmLbl = new JLabel("");
	Utente utente;
	private JPanel contentPane;
	private String userFarm;
	private String nomeFarm;
	private String cognomeFarm;
	private int idFarm;
	
	
	private ArrayList<Farmaco> farmaciFarmacologo = new ArrayList<>();
	
	public HomeFarmacologo(Utente utente) {
		setResizable(false);
		
		this.utente = utente;
		utente.addObserver(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][221.00][][73.00,grow]", "[][27.00][42.00][][][][][][][][][][][17.00,grow]"));
		
		contentPane.add(farmLbl, "flowx,cell 0 1 6 1");
		
		
		
	}
	
	
	public void update(Observable arg0, Object arg1) {

		/*if(arg0.getClass().getName().equals("model.Utente")){
			userFarm = utente.getUsername();
			nomeFarm = utente.getNome();
			cognomeFarm = utente.getCognome();
			idFarm = utente.getId();
			setDottLbl();
		}
		
		if(arg0.getClass().getName().equals("model.Paziente")){
			pazientiMedico = paziente.getPazienti();
		} */


	}
	
}