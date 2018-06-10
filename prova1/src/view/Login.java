package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passField;
	private JButton btnLogin;
	private JLabel msgLabel;
	private JLabel lblUsernameLucarossiPassword;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[117.00][-128.00][115.00,grow][14.00][100.00,grow][][115.00,grow]", "[5.00][29.00,fill][20.00][20.00][][][][][]"));

		JLabel lblNewLabel_6 = new JLabel("");
		contentPane.add(lblNewLabel_6, "flowx,cell 0 0");
		
		lblUsernameLucarossiPassword = new JLabel("USERNAME lucarossi PASSWORD aaa");
		lblUsernameLucarossiPassword.setForeground(Color.BLUE);
		contentPane.add(lblUsernameLucarossiPassword, "flowx,cell 0 1");
		
		msgLabel = new JLabel("");
		msgLabel.setForeground(Color.RED);
		contentPane.add(msgLabel, "cell 0 1 7 1,alignx center,aligny center");
		
				JLabel lblNewLabel_4 = new JLabel("LOGIN");
				lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 12));
				contentPane.add(lblNewLabel_4, "cell 1 2 5 1,alignx center");

		JLabel lblNewLabel = new JLabel("username:");
		contentPane.add(lblNewLabel, "cell 0 4,alignx center");
		
				userField = new JTextField();
				contentPane.add(userField, "cell 2 4 4 1,growx");
				userField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("password:");
		contentPane.add(lblNewLabel_1, "cell 0 5,alignx center");

		passField = new JPasswordField();
		contentPane.add(passField, "cell 2 5 4 1,growx");
		
		btnLogin = new JButton("Conferma");
		contentPane.add(btnLogin, "cell 4 7,alignx center");
	}

	public void addLoginListener(ActionListener a) {
		btnLogin.addActionListener(a);
	}

	public String getUserMedico() {
		return userField.getText();
	}

	@SuppressWarnings("deprecation")
	public String getPassMedico() {
		return passField.getText();
	}
	
	public void setMsgLabel(String text){
		msgLabel.setText(text);
	}
	
	public void setPasswordField(String text){
		passField.setText(text);
	}

}
