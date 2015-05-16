package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {
	private JTextField txtIme;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblDobrodosliUQuicksheet = new JLabel("Dobrodosli u QuickSheet - Jednostavnu aplikaciju za evidentiranje radnih sati.");
		lblDobrodosliUQuicksheet.setBounds(10, 0, 414, 33);
		getContentPane().add(lblDobrodosliUQuicksheet);
		
		txtIme = new JTextField();
		txtIme.setBounds(61, 60, 311, 20);
		getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Vaša lozinka:");
		lblNewLabel.setBounds(61, 99, 200, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblVaeKorisnikoIme = new JLabel("Vaše korisničko ime:");
		lblVaeKorisnikoIme.setLabelFor(txtIme);
		lblVaeKorisnikoIme.setBounds(61, 44, 200, 20);
		getContentPane().add(lblVaeKorisnikoIme);
		
		txtPassword = new JPasswordField();
		lblNewLabel.setLabelFor(txtPassword);
		txtPassword.setBounds(61, 117, 311, 20);
		getContentPane().add(txtPassword);
		
		JLabel lblUkolikoSteZaboravili = new JLabel("Ukoliko ste zaboravili svoju lozinku, molimo da se obratite Vašem Administratoru.");
		lblUkolikoSteZaboravili.setBounds(20, 140, 404, 20);
		getContentPane().add(lblUkolikoSteZaboravili);
		
		JButton btnNewButton = new JButton("Prijava");
		btnNewButton.setBounds(283, 194, 89, 23);
		getContentPane().add(btnNewButton);

	}
}
