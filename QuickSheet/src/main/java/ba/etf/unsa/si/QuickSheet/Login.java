package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;

import javax.naming.directory.InvalidAttributeValueException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.etf.unsa.si.Klase.Administrator;
import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.AdministratorHibernate;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;
import ba.etf.unsa.si.util.HibernateUtil;

import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

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
		setBackground(UIManager.getColor("Button.darkShadow"));
		getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setTitle("QuickSheet - Login");
		setResizable(false);
		setBounds(100, 100, 394, 352);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblDobrodosliUQuicksheet = new JLabel("Dobrodošli u QuickSheet - Jednostavnu aplikaciju za evidentiranje radnih sati.");
		lblDobrodosliUQuicksheet.setForeground(UIManager.getColor("Button.highlight"));
		lblDobrodosliUQuicksheet.setHorizontalAlignment(SwingConstants.CENTER);
		lblDobrodosliUQuicksheet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDobrodosliUQuicksheet.setBounds(0, 11, 385, 32);
		getContentPane().add(lblDobrodosliUQuicksheet);
		
		txtIme = new JTextField();
		txtIme.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtIme.setForeground(UIManager.getColor("Button.foreground"));
		txtIme.setHorizontalAlignment(SwingConstants.CENTER);
		txtIme.setBounds(71, 91, 235, 20);
		getContentPane().add(txtIme);
		txtIme.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Vaša lozinka:");
		lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(155, 134, 71, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblVaeKorisnikoIme = new JLabel("Vaše korisničko ime:");
		lblVaeKorisnikoIme.setForeground(UIManager.getColor("Button.highlight"));
		lblVaeKorisnikoIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVaeKorisnikoIme.setLabelFor(txtIme);
		lblVaeKorisnikoIme.setBounds(142, 72, 101, 20);
		getContentPane().add(lblVaeKorisnikoIme);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Stencil", Font.BOLD, 11));
		txtPassword.setForeground(UIManager.getColor("Button.foreground"));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(txtPassword);
		txtPassword.setBounds(71, 154, 235, 20);
		getContentPane().add(txtPassword);
		
		JLabel lblUkolikoSteZaboravili = new JLabel("Ukoliko ste zaboravili svoju lozinku, molimo da se obratite Vašem Administratoru.");
		lblUkolikoSteZaboravili.setForeground(UIManager.getColor("Button.background"));
		lblUkolikoSteZaboravili.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblUkolikoSteZaboravili.setBounds(27, 176, 351, 20);
		getContentPane().add(lblUkolikoSteZaboravili);
		
		JButton btnNewButton = new JButton("Prijava");
		btnNewButton.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textFieldValue = txtIme.getText();
				if(textFieldValue.equals("administrator")){
					new MainForm().setVisible(true);
				}
				else if(textFieldValue.equals("koordinator")){
					new MainFormKoordinator().setVisible(true);
				}
				else if(textFieldValue.equals("baza")){
					try {
						
						ArrayList<ZaposlenikHibernate> zh = new ArrayList<ZaposlenikHibernate>();
						zh = DalDao.VratiNadredjeneZaposlenike();
						System.out.println(zh.size());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else{
					new MainFormZaposlenik().setVisible(true);
				}
		}
		});
		btnNewButton.setBounds(142, 238, 89, 23);
		getContentPane().add(btnNewButton);

	}
}
