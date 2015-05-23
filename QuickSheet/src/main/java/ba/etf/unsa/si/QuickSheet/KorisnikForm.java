

package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KorisnikForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KorisnikForm frame = new KorisnikForm();
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
	public KorisnikForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dzenana\\git\\SI2014Tim2\\QuickSheet\\qs.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setResizable(false);
		setTitle("Profil zaposlenika");
		setBounds(100, 100, 392, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 11, 341, 370);
		panel.setBorder(new TitledBorder(null, "Podaci o korisniku", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Ime:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(98, 24, 82, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Prezime:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(82, 49, 82, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Adresa:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(82, 74, 82, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Broj Telefona:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(52, 99, 97, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Email:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(92, 124, 46, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Datum zapošljavanja:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(15, 149, 113, 14);
		panel.add(label_5);
		
		JLabel lblOdjeli = new JLabel("Odjeli:");
		lblOdjeli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOdjeli.setBounds(88, 174, 40, 14);
		panel.add(lblOdjeli);
		
		JLabel label_7 = new JLabel("Korisničko ime:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(52, 233, 82, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Lozinka:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(82, 258, 46, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Ponovi lozinku:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(52, 283, 92, 14);
		panel.add(label_9);
		
		JLabel lblKoordinator = new JLabel("Koordinator:");
		lblKoordinator.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKoordinator.setBounds(62, 308, 60, 14);
		panel.add(lblKoordinator);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(164, 21, 167, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 44, 167, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 69, 167, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(164, 97, 167, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(164, 122, 167, 20);
		panel.add(textField_4);
		
		final JList list = new JList();
		list.setBounds(164, 174, 167, 51);
		panel.add(list);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(164, 230, 167, 20);
		panel.add(textField_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 255, 167, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(164, 280, 167, 20);
		panel.add(passwordField_1);
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(164, 304, 97, 23);
		panel.add(checkBox);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1432332000000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(164, 146, 167, 20);
		panel.add(spinner);
		
		final JLabel label_error = new JLabel("");
		label_error.setVisible(false);
		label_error.setBounds(0, 386, 386, 14);
		contentPane.add(label_error);
		
		JButton btnSpasiIzmjene = new JButton("Spremi izmjene");
		btnSpasiIzmjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true; 
				
				if(textField.getText().equals("")){
					label_error.setText("Unesite ime!");
					greska = false;}
				else if(textField_1.getText().equals("")){
					label_error.setText("Unesite prezime!");
					greska = false;}
				else if(textField_2.getText().equals("")){
					label_error.setText("Unesite adresu!");
					greska = false;}
				else if(textField_3.getText().equals("")){
					label_error.setText("Unesite broj telefona!");
					greska = false;}
				else if(textField_4.getText().equals("")){
					label_error.setText("Unesite email!");
					greska = false;}
				else if(textField_5.getText().equals("")){
					label_error.setText("Unesite korisničko ime!");
					greska = false;}
				else if(list.getSelectedValue().equals("")){ 
					  label_error.setText("Odaberite odjel u kojem radi zaposlenik!");
					  greska = false;}
				else greska = true;
				
				if(greska == false){
					label_error.setVisible(true);	
				}
				
				else{
					label_error.setVisible(false);
				}
				
			}
		});
		btnSpasiIzmjene.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSpasiIzmjene.setBounds(190, 336, 141, 23);
		panel.add(btnSpasiIzmjene);
		
		
	}
}