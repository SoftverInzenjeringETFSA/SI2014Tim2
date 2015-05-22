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
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Toolkit;

public class KorisnikFormKoordinator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KorisnikFormKoordinator frame = new KorisnikFormKoordinator();
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
	public KorisnikFormKoordinator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setResizable(false);
		setTitle("Profil zaposlenika");
		setBounds(100, 100, 389, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 11, 341, 298);
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
		
		JLabel label_10 = new JLabel("Vrsta korisnika:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(52, 258, 82, 14);
		panel.add(label_10);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBackground(Color.WHITE);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(164, 21, 167, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(164, 46, 167, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(164, 71, 167, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(164, 96, 167, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(164, 121, 167, 20);
		panel.add(textField_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setBackground(Color.WHITE);
		spinner.setEnabled(false);
		spinner.setBorder(null);
		spinner.setModel(new SpinnerDateModel(new Date(1432159200000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setBounds(164, 146, 167, 20);
		panel.add(spinner);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setEnabled(false);
		list.setBounds(164, 173, 167, 51);
		panel.add(list);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(164, 230, 167, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBorder(null);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(164, 255, 167, 20);
		panel.add(textField_6);
	}
}
