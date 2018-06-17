package view;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class NuovoPaziente extends JFrame {
	private JTextField cognomePazField;
	private JTextField ggField;
	private JTextField mmField;
	private JTextField aaaaField;
	private JTextField nomePazField;
	private JTextField profField;
	JComboBox provCombo;
	private JButton btnConfermaDati;

	/**
	 * Create the frame.
	 */
	public NuovoPaziente() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[][][][grow]", "[40.00][][][][][][][]"));
		
		JLabel lblNuovoPaziente = new JLabel("NUOVO PAZIENTE");
		getContentPane().add(lblNuovoPaziente, "cell 0 0 4 1");
		
		JLabel lblNome = new JLabel("Nome");
		getContentPane().add(lblNome, "cell 2 1");
		
		nomePazField = new JTextField();
		getContentPane().add(nomePazField, "cell 3 1,growx");
		nomePazField.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		getContentPane().add(lblCognome, "cell 2 2");
		
		cognomePazField = new JTextField();
		getContentPane().add(cognomePazField, "cell 3 2,growx");
		cognomePazField.setColumns(10);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita ( GG/MM/AAAA)");
		getContentPane().add(lblDataDiNascita, "cell 2 3");
		
		ggField = new JTextField();
		getContentPane().add(ggField, "flowx,cell 3 3,growx");
		ggField.setColumns(10);
		
		JLabel label = new JLabel("/");
		getContentPane().add(label, "cell 3 3");
		
		mmField = new JTextField();
		getContentPane().add(mmField, "cell 3 3,growx");
		mmField.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		getContentPane().add(label_1, "cell 3 3");
		
		aaaaField = new JTextField();
		getContentPane().add(aaaaField, "cell 3 3,growx");
		aaaaField.setColumns(10);
		
		JLabel lblProvincia = new JLabel("Provincia");
		getContentPane().add(lblProvincia, "cell 2 4");
		
		provCombo = new JComboBox();
		provCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AG", "AL", "AN", "AO", "AR", "AP", "AT", "AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL", "CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM", "FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "AQ", "LT", "LE", "LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "ME", "MI", "MO", "MB", "NA", "NO", "NU", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE", "PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "RM", "RO", "SA", "VS", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "OG", "TP", "TN", "TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT" }));
		getContentPane().add(provCombo, "cell 3 4,alignx left");
		
		JLabel lblProfessione = new JLabel("Professione");
		getContentPane().add(lblProfessione, "cell 2 5");
		
		profField = new JTextField();
		getContentPane().add(profField, "cell 3 5,growx");
		profField.setColumns(10);
		
		btnConfermaDati = new JButton("Conferma dati");
		getContentPane().add(btnConfermaDati, "cell 3 7,alignx right");
	}

	

	public void addConfermaDatiListener(ActionListener a) {
		btnConfermaDati.addActionListener(a);
	}
	
	public String getNome(){
		return nomePazField.getText();
	}
	
	public String getCognome(){
		return cognomePazField.getText();
	}
	
	public String getGGNasc(){
		return ggField.getText();
	}

	
	public String getMMNasc(){
		return mmField.getText();
	}

	
	public String getAAAANasc(){
		return aaaaField.getText();
	}
	
	public String getProv(){
		return provCombo.getSelectedItem().toString();
	}	

	public String getProfessione(){
		return profField.getText();
	}
	



}
