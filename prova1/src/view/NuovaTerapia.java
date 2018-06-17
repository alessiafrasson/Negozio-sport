package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class NuovaTerapia extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public NuovaTerapia() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[][29.00][32.00][grow]", "[21px][][][][][][][][][][][][]"));
		
		JLabel lblNuovaTerapia = new JLabel("NUOVA TERAPIA:");
		getContentPane().add(lblNuovaTerapia, "cell 0 0 4 2");
		
		JLabel lblFarmaco = new JLabel("Farmaco:");
		getContentPane().add(lblFarmaco, "cell 1 2");
		
		JComboBox comboBox = new JComboBox();
		getContentPane().add(comboBox, "cell 3 2,growx");
		
		JLabel lblDose = new JLabel("Dose:");
		getContentPane().add(lblDose, "cell 1 4");
		
		textField = new JTextField();
		getContentPane().add(textField, "cell 3 4,growx");
		textField.setColumns(10);
		
		JLabel lblFrequenza = new JLabel("Frequenza:");
		getContentPane().add(lblFrequenza, "cell 1 6");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "cell 3 6,growx");
		textField_1.setColumns(10);
		
		JButton button = new JButton("Conferma dati");
		getContentPane().add(button, "cell 3 10,alignx right,aligny top");
	}

}
