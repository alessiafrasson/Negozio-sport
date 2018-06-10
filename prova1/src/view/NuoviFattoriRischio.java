package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import model.FattoreRischio;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NuoviFattoriRischio extends JFrame implements Observer{

	private FattoreRischio fattoreRischio;
	
	private JPanel contentPane;
	private JTextField fattTextField3;
	private JTextField fattTextField2;
	private JTextField fattTextField1;
	JComboBox<String> fattCombo1;
	JComboBox<String> fattCombo2;
	JComboBox<String> fattCombo3;
	JComboBox<String> fattCombo4;
	private JButton btnConferma;
	private JButton btnAnnulla;
	
	private ArrayList<FattoreRischio> fattori = new ArrayList<>();

	public NuoviFattoriRischio(FattoreRischio fattoreRischio) {
		this.fattoreRischio = fattoreRischio;
		fattoreRischio.addObserver(this);
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[33.00][][][][][][][][20.00][20.00][]"));
		
		JLabel lblFattoriDiRischio = new JLabel("FATTORI DI RISCHIO PAZIENTE: ");
		contentPane.add(lblFattoriDiRischio, "cell 0 0 3 1");
		
		JLabel lblFattore = new JLabel("Fattore 1:");
		contentPane.add(lblFattore, "cell 0 1");
		
		fattCombo1 = new JComboBox<>();
		contentPane.add(fattCombo1, "cell 2 1,growx");
		
		JLabel lblFattore_1 = new JLabel("Fattore 2:");
		contentPane.add(lblFattore_1, "cell 0 2");
		
		fattCombo2 = new JComboBox<>();
		contentPane.add(fattCombo2, "cell 2 2,growx");
		
		JLabel lblFattore_2 = new JLabel("Fattore 3:");
		contentPane.add(lblFattore_2, "cell 0 3");
		
		fattCombo3 = new JComboBox<>();
		contentPane.add(fattCombo3, "cell 2 3,growx");
		
		JLabel lblFattore_3 = new JLabel("Fattore 4:");
		contentPane.add(lblFattore_3, "cell 0 4");
		
		fattCombo4 = new JComboBox<>();
		contentPane.add(fattCombo4, "cell 2 4,growx");
		
		JLabel lblNuovoFattore = new JLabel("Nuovo fattore");
		contentPane.add(lblNuovoFattore, "cell 0 6");
		
		fattTextField1 = new JTextField();
		contentPane.add(fattTextField1, "flowx,cell 2 6,growx");
		fattTextField1.setColumns(10);
		
		JLabel lblNuovoFattore_1 = new JLabel("Nuovo fattore");
		contentPane.add(lblNuovoFattore_1, "cell 0 7");
		
		fattTextField2 = new JTextField();
		contentPane.add(fattTextField2, "flowx,cell 2 7,growx");
		fattTextField2.setColumns(10);
		
		JLabel lblNuovo = new JLabel("Nuovo fattore");
		contentPane.add(lblNuovo, "cell 0 8");
		
		fattTextField3 = new JTextField();
		contentPane.add(fattTextField3, "flowx,cell 2 8,growx");
		fattTextField3.setColumns(10);
		
		JLabel lblGravit_1 = new JLabel("Gravit\u00E0");
		contentPane.add(lblGravit_1, "cell 2 6");
		
		JComboBox<String> grav1 = new JComboBox<>();
		grav1.addItem("");
		for(int i=1; i<6;i++){
			grav1.addItem(i+"");
		}
		contentPane.add(grav1, "cell 2 6");
		
		JLabel lblGravit_2 = new JLabel("Gravit\u00E0");
		contentPane.add(lblGravit_2, "cell 2 7");
		
		JComboBox<String> grav2 = new JComboBox<>();
		grav2.addItem("");
		for(int i=1; i<6;i++){
			grav2.addItem(i+"");
		}
		contentPane.add(grav2, "cell 2 7");
		
		JLabel lblGravit = new JLabel("Gravit\u00E0");
		contentPane.add(lblGravit, "cell 2 8");
		
		JComboBox<String> grav3 = new JComboBox<>();
		grav3.addItem("");
		for(int i=1; i<6;i++){
			grav3.addItem(i+"");
		}
		contentPane.add(grav3, "cell 2 8");
		
		JButton helpBtn = new JButton("?");
		helpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Nel caso in cui fosse necessario aggiungere ulteriori fattori di rischio sarà possibile farlo nella "
						+ " pagina di modifica dei dati del paziente. ");
			}
		});
		contentPane.add(helpBtn, "cell 0 10");
		
		btnAnnulla = new JButton("Annulla");
		contentPane.add(btnAnnulla, "flowx,cell 2 10,alignx right");
		
		btnConferma = new JButton("Conferma");
		contentPane.add(btnConferma, "cell 2 10,alignx right");
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		fattori = fattoreRischio.getFattori();
		setCombo();
	}
	
	private void setCombo(){
		
		fattCombo1.removeAllItems();
		fattCombo2.removeAllItems();
		fattCombo3.removeAllItems();
		fattCombo4.removeAllItems();
		fattCombo1.addItem("");
		fattCombo2.addItem("");
		fattCombo3.addItem("");
		fattCombo4.addItem("");
		
		for(FattoreRischio fattore:fattori){
			fattCombo1.addItem(fattore.getDescrizione() + " \t cod:"+fattore.getId());
			fattCombo2.addItem(fattore.getDescrizione() + " \t cod:"+fattore.getId());
			fattCombo3.addItem(fattore.getDescrizione() + " \t cod:"+fattore.getId());
			fattCombo4.addItem(fattore.getDescrizione() + " \t cod:"+fattore.getId());
		}
	}

	public void addConfermaListener(ActionListener a) {
		btnConferma.addActionListener(a);
	}
	
	public void addAnnullaListener(ActionListener a) {
		btnAnnulla.addActionListener(a);
	}
	
	public String[] getFattoriSelezionati(){
		String fattoriSel[] = new String[4];
		
		fattoriSel[0] = fattCombo1.getSelectedItem().toString();
		fattoriSel[1] = fattCombo2.getSelectedItem().toString();
		fattoriSel[2] = fattCombo3.getSelectedItem().toString();
		fattoriSel[3] = fattCombo4.getSelectedItem().toString();
		
		return fattoriSel;
		
		
	}
	
}
