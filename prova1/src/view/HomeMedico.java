package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Paziente;
import model.Utente;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Color;

public class HomeMedico extends JFrame implements Observer {

	private Utente utente;
	private Paziente paziente;

	
	private JLabel dottLbl = new JLabel("");
	private JPanel contentPane;
	private JTextField pazienteField;
	private JButton btnCerca;
	private JComboBox<String> PazienticomboBox;
	private JLabel pazientiTrovatiLbl;
	private JButton nuovoPazBtn;
	private JButton nuovaSegnBtn;
	private JButton nuovaTerapiaBtn;

	
	private String userDott = "";
	private String nomeDott = "";
	private String cognomeDott = "";
	private int idDott = 0;
	private JLabel lblAttenzione_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private ArrayList<Paziente> pazientiMedico = new ArrayList<>();


	public HomeMedico(Utente utente, Paziente paziente) {
		setResizable(false);

		this.utente = utente;
		utente.addObserver(this);

		this.paziente = paziente;
		paziente.addObserver(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][221.00][][73.00,grow]", "[][27.00][42.00][][][][][][][][][][][17.00,grow]"));


		contentPane.add(dottLbl, "flowx,cell 0 1 6 1");

		pazienteField = new JTextField();
		contentPane.add(pazienteField, "flowx,cell 5 2,growx,aligny center");
		pazienteField.setColumns(10);

		pazientiTrovatiLbl = new JLabel("");
		contentPane.add(pazientiTrovatiLbl, "cell 5 3");

		JLabel lblRicercaCognomeE = new JLabel("Ricerca cognome e nome del paziente:");
		contentPane.add(lblRicercaCognomeE, "cell 5 1,alignx center");

		PazienticomboBox = new JComboBox<>();
		PazienticomboBox.setVisible(false);
		contentPane.add(PazienticomboBox, "cell 5 4,growx");

		nuovoPazBtn = new JButton("Nuovo paziente");
		nuovoPazBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(nuovoPazBtn, "flowx,cell 5 6");

		nuovaSegnBtn = new JButton("Nuova segnalazione");
		nuovaSegnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(nuovaSegnBtn, "cell 5 6");

		nuovaTerapiaBtn = new JButton("Nuova terapia");
		nuovaTerapiaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		nuovaTerapiaBtn.setVisible(false);
		contentPane.add(nuovaTerapiaBtn, "cell 5 6");

		btnCerca = new JButton("Cerca");
		contentPane.add(btnCerca, "cell 5 2,aligny center");
		
		lblAttenzione_1 = new JLabel("ATTENZIONE: \u00C8 possibile inserire nuove segnalazioni solo per pazienti ");
		lblAttenzione_1.setForeground(Color.RED);
		contentPane.add(lblAttenzione_1, "cell 5 10,alignx left");
		
		lblNewLabel = new JLabel("gi\u00E0 presenti nel sistema e le terapie in atto alla data della reazione avversa");
		lblNewLabel.setForeground(Color.RED);
		contentPane.add(lblNewLabel, "cell 5 11,growx");
		
		lblNewLabel_1 = new JLabel("devono essere indicate prima dell'inserimento della segnalazione.");
		lblNewLabel_1.setForeground(Color.RED);
		contentPane.add(lblNewLabel_1, "cell 5 12,growx");
	}


	@Override
	public void update(Observable arg0, Object arg1) {

		if(arg0.getClass().getName().equals("model.Utente")){
			userDott = utente.getUsername();
			nomeDott = utente.getNome();
			cognomeDott = utente.getCognome();
			idDott = utente.getId();
			setDottLbl();
		}
		
		if(arg0.getClass().getName().equals("model.Paziente")){
			pazientiMedico = paziente.getPazienti();
		}


	}

	private void setDottLbl(){
		dottLbl.setText("Dott. "+ cognomeDott + " " + nomeDott + "- id " + idDott);
	}

	public void addCercaListener(ActionListener a) {
		btnCerca.addActionListener(a);
	}
	
	public void addNuovoPazListener(ActionListener a) {
		nuovoPazBtn.addActionListener(a);
	}
	
	public void addNuovaSegnListener(ActionListener a) {
		nuovaSegnBtn.addActionListener(a);
	}
	
	public void addNuovaTerapiaListener(ActionListener a) {
		nuovaTerapiaBtn.addActionListener(a);
	}

	public String getCognomeCercato(){
		return pazienteField.getText();
	}

	public void addPazientiCombo(){
		int contaPaz = 0;
		ArrayList<Paziente> listaPaz = pazientiMedico;

		PazienticomboBox.removeAllItems();

		for(Paziente paz: listaPaz){
			if(paz.getCognome().equals(getCognomeCercato())){
				PazienticomboBox.addItem(
						paz.getId() + " -- " + paz.getNome() + " " + paz.getCognome() + " " + paz.getDataNascita() + " " + paz.getProvincia()
						);

				contaPaz++;

			}
		}

		if(listaPaz.size() == 0 || contaPaz == 0){
		
			pazientiTrovatiLbl.setText("Nessun paziente trovato");
			PazienticomboBox.setVisible(false);
			nuovaTerapiaBtn.setVisible(false);
			nuovaSegnBtn.setVisible(false);

		} else {
			
			PazienticomboBox.setVisible(true);
			nuovaTerapiaBtn.setVisible(true);
			nuovaSegnBtn.setVisible(true);
			pazientiTrovatiLbl.setText("Pazienti trovati:");
		}
	}
}


