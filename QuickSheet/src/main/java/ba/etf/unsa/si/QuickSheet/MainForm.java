package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.Box;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

import java.awt.Component;
import java.awt.ScrollPane;

public class MainForm extends JFrame {
	private JTextField textField;
	private JPanel panel;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JPanel panel_2;
	private JLabel lblNaziv;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_42;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setResizable(false);
		setTitle("QuickSheet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 459);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 764, 431);
		getContentPane().add(tabbedPane);
		setLocationRelativeTo(null);
		JPanel timeSheetPanel = new JPanel();
		tabbedPane.addTab("Moj Timesheet", null, timeSheetPanel, null);
		timeSheetPanel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Timesheet podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(22, 28, 711, 354);
		timeSheetPanel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Projekat:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(56, 72, 46, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_4.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Pošalji na reviziju");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(531, 291, 124, 29);
		panel_4.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(136, 69, 201, 20);
		panel_4.add(comboBox);
		
		JLabel lblTaskovi = new JLabel("Taskovi:");
		lblTaskovi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTaskovi.setBounds(56, 120, 46, 14);
		panel_4.add(lblTaskovi);
		
		JLabel lblBrojSati = new JLabel("Broj radnih sati:");
		lblBrojSati.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBrojSati.setBounds(26, 248, 76, 14);
		panel_4.add(lblBrojSati);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0.0, 0.0, 12.0, 1.0));
		spinner_2.setBounds(136, 245, 210, 20);
		panel_4.add(spinner_2);
		
		JLabel label = new JLabel("Datum:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(68, 294, 35, 14);
		panel_4.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(135, 291, 210, 20);
		panel_4.add(spinner);
		
		
		
		
		
		
		
		
		
		JPanel historijaPanel = new JPanel();
		tabbedPane.addTab("Moja Historija", null, historijaPanel, null);
		historijaPanel.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prikaz historije timesheet - ova za odre\u0111eni projekat", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(30, 22, 341, 370);
		historijaPanel.add(panel_6);
		panel_6.setLayout(null);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(155, 28, 141, 20);
		panel_6.add(comboBox_10);
		
		JLabel lblNewLabel_4 = new JLabel("Projekat:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(10, 28, 78, 20);
		panel_6.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 321, 272);
		panel_6.add(scrollPane);
		
		JLabel lblNewLabel_5 = new JLabel("Timesheet historija:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(10, 59, 200, 20);
		panel_6.add(lblNewLabel_5);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Prikaz historije za odre\u0111eni vremenski interval", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(392, 22, 341, 370);
		historijaPanel.add(panel_7);
		panel_7.setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(10, 88, 321, 272);
		panel_7.add(canvas);
		canvas.setBackground(SystemColor.controlHighlight);
		
		JLabel lblNewLabel_6 = new JLabel("Od");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(10, 30, 46, 20);
		panel_7.add(lblNewLabel_6);
		
		JLabel lblDo = new JLabel("Do");
		lblDo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDo.setBounds(178, 30, 46, 20);
		panel_7.add(lblDo);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(35, 30, 131, 20);
		panel_7.add(spinner_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_3.setBounds(200, 30, 131, 20);
		panel_7.add(spinner_3);
		
		JPanel odjeliPanel = new JPanel();
		tabbedPane.addTab("Odjeli", null, odjeliPanel, null);
		odjeliPanel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Podaci o odjelu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		panel_2.setBounds(30, 22, 341, 370);
		odjeliPanel.add(panel_2);
		
		lblNaziv = new JLabel("Naziv odjela:");
		lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNaziv.setBounds(78, 33, 102, 14);
		panel_2.add(lblNaziv);
		
		textField_43 = new JTextField();
		textField_43.setColumns(10);
		textField_43.setBounds(190, 30, 141, 20);
		panel_2.add(textField_43);
		
		JLabel lblNewLabel_7 = new JLabel("Dodaj zaposlenika:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(50, 58, 102, 29);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Rukovodilac odjela:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9.setBounds(50, 207, 102, 14);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblMaksimalniBroj = new JLabel("Maksimalni broj zaposlenika:");
		lblMaksimalniBroj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaksimalniBroj.setBounds(10, 243, 152, 14);
		panel_2.add(lblMaksimalniBroj);
		
		textField_44 = new JTextField();
		textField_44.setBounds(190, 240, 141, 20);
		panel_2.add(textField_44);
		textField_44.setColumns(10);
		
		JButton btnDodaj_1 = new JButton("Dodaj");
		btnDodaj_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDodaj_1.setBounds(242, 308, 89, 23);
		panel_2.add(btnDodaj_1);
		
		JList list_3 = new JList();
		list_3.setBounds(190, 61, 141, 135);
		panel_2.add(list_3);
		
		JComboBox comboBox_14 = new JComboBox();
		comboBox_14.setBounds(190, 207, 141, 20);
		panel_2.add(comboBox_14);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Pretraga odjela", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(392, 22, 341, 370);
		odjeliPanel.add(panel_3);
		panel_3.setLayout(null);
		
		textField_45 = new JTextField();
		textField_45.setBounds(22, 30, 133, 23);
		panel_3.add(textField_45);
		textField_45.setColumns(10);
		
		JComboBox comboBox_16 = new JComboBox();
		comboBox_16.setBounds(165, 30, 85, 23);
		panel_3.add(comboBox_16);
		
		JButton btnPretrai = new JButton("Pretraži");
		btnPretrai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPretrai.setBounds(262, 30, 69, 23);
		panel_3.add(btnPretrai);
		
		JList list_4 = new JList();
		list_4.setBounds(22, 87, 309, 230);
		panel_3.add(list_4);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Prikaži arhivirane odjele");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox_1.setBounds(22, 57, 149, 23);
		panel_3.add(chckbxNewCheckBox_1);
		
		JButton btnIzmjeni = new JButton("Sačuvaj promjene");
		btnIzmjeni.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnIzmjeni.setBounds(83, 328, 119, 23);
		panel_3.add(btnIzmjeni);
		
		JButton btnObrisi = new JButton("Obriši odjel");
		btnObrisi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnObrisi.setBounds(212, 328, 119, 23);
		panel_3.add(btnObrisi);
		
		JPanel korisniciPanel = new JPanel();
		tabbedPane.addTab("Korisnici", null, korisniciPanel, null);
		korisniciPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o korisniku", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 22, 341, 370);
		korisniciPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIme.setBounds(98, 24, 82, 14);
		panel.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrezime.setBounds(82, 49, 82, 14);
		panel.add(lblPrezime);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAdresa.setBounds(82, 74, 82, 14);
		panel.add(lblAdresa);
		
		JLabel lblBrojTelefona = new JLabel("Broj Telefona:");
		lblBrojTelefona.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBrojTelefona.setBounds(52, 99, 97, 14);
		panel.add(lblBrojTelefona);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(92, 124, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblNewLabel_8 = new JLabel("Datum zapošljavanja:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(10, 149, 104, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblOdjel = new JLabel("Odjel:");
		lblOdjel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOdjel.setBounds(82, 174, 46, 14);
		panel.add(lblOdjel);
		
		JLabel lblKorisnickoIme = new JLabel("Korisničko ime:");
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKorisnickoIme.setBounds(52, 233, 82, 14);
		panel.add(lblKorisnickoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLozinka.setBounds(82, 258, 46, 14);
		panel.add(lblLozinka);
		
		JLabel lblPonoviLozinku = new JLabel("Ponovi lozinku:");
		lblPonoviLozinku.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPonoviLozinku.setBounds(52, 283, 92, 14);
		panel.add(lblPonoviLozinku);
		
		JLabel lblVrstaKorisnika = new JLabel("Vrsta korisnika:");
		lblVrstaKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVrstaKorisnika.setBounds(52, 308, 82, 14);
		panel.add(lblVrstaKorisnika);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(190, 305, 141, 20);
		panel.add(comboBox_11);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 280, 141, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(190, 255, 141, 20);
		panel.add(passwordField_1);
		
		textField_36 = new JTextField();
		textField_36.setBounds(190, 21, 141, 20);
		panel.add(textField_36);
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(190, 44, 141, 20);
		panel.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(190, 69, 141, 20);
		panel.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setColumns(10);
		textField_39.setBounds(190, 97, 141, 20);
		panel.add(textField_39);
		
		textField_40 = new JTextField();
		textField_40.setColumns(10);
		textField_40.setBounds(190, 122, 141, 20);
		panel.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setColumns(10);
		textField_41.setBounds(190, 230, 141, 20);
		panel.add(textField_41);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDodaj.setBounds(242, 336, 89, 23);
		panel.add(btnDodaj);
		
		JList list_5 = new JList();
		list_5.setBounds(190, 174, 141, 51);
		panel.add(list_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pretraga korisnika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(392, 22, 341, 370);
		korisniciPanel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_42 = new JTextField();
		textField_42.setBounds(22, 30, 133, 23);
		panel_1.add(textField_42);
		textField_42.setColumns(10);
		
		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setBounds(165, 30, 85, 23);
		panel_1.add(comboBox_13);
		
		JButton btnPretraga = new JButton("Pretraži");
		btnPretraga.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPretraga.setBounds(265, 30, 69, 23);
		panel_1.add(btnPretraga);
		
		JList list_2 = new JList();
		list_2.setBounds(22, 87, 309, 230);
		panel_1.add(list_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Prikaži arhivirane korisnike");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBounds(22, 57, 165, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("Prikaži profil");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KorisnikForm().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(83, 328, 119, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnObriiKorisnika = new JButton("Obriši korisnika");
		btnObriiKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnObriiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnObriiKorisnika.setBounds(212, 328, 119, 23);
		panel_1.add(btnObriiKorisnika);
		
		JPanel projektiPanel = new JPanel();
		tabbedPane.addTab("Projekti", null, projektiPanel, null);
		projektiPanel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o projektu", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setLayout(null);
		panel_5.setBounds(30, 22, 341, 370);
		projektiPanel.add(panel_5);
		
		JLabel label_2 = new JLabel("Naziv:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(79, 36, 82, 14);
		panel_5.add(label_2);
		
		textField_47 = new JTextField();
		textField_47.setColumns(10);
		textField_47.setBounds(159, 33, 165, 20);
		panel_5.add(textField_47);
		
		JLabel label_3 = new JLabel("Dodaj zaposlenika:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(24, 117, 102, 14);
		panel_5.add(label_3);
		
		JLabel lblDodajNadreenog = new JLabel("Dodaj nadređenog:");
		lblDodajNadreenog.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDodajNadreenog.setBounds(24, 251, 102, 14);
		panel_5.add(lblDodajNadreenog);
		
		JComboBox comboBox_19 = new JComboBox();
		comboBox_19.setBounds(159, 248, 165, 20);
		panel_5.add(comboBox_19);
		
		JButton button_7 = new JButton("Dodaj");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button_7.setBounds(242, 308, 89, 23);
		panel_5.add(button_7);
		
		JLabel lblNazivKlijenta = new JLabel("Naziv klijenta:");
		lblNazivKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNazivKlijenta.setBounds(44, 78, 102, 14);
		panel_5.add(lblNazivKlijenta);
		
		textField_48 = new JTextField();
		textField_48.setColumns(10);
		textField_48.setBounds(159, 75, 165, 20);
		panel_5.add(textField_48);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(149, 215, 82, -66);
		panel_5.add(verticalBox);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Radnik1", "Radnik2", "Radnik3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(159, 116, 165, 121);
		panel_5.add(list);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga projekta", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_11.setBounds(392, 22, 341, 370);
		projektiPanel.add(panel_11);
		
		JCheckBox chckbxPrikaziArhiviraneProjekte = new JCheckBox("Prikazi arhivirane projekte");
		chckbxPrikaziArhiviraneProjekte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxPrikaziArhiviraneProjekte.setBounds(22, 57, 149, 23);
		panel_11.add(chckbxPrikaziArhiviraneProjekte);
		
		JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setBounds(165, 30, 85, 23);
		panel_11.add(comboBox_17);
		
		JButton button_4 = new JButton("Pretrazi");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_4.setBounds(265, 30, 69, 23);
		panel_11.add(button_4);
		
		textField_46 = new JTextField();
		textField_46.setBounds(22, 30, 133, 23);
		panel_11.add(textField_46);
		textField_46.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setBounds(22, 87, 309, 230);
		panel_11.add(list_1);
		
		JButton btnSauvajPromjene = new JButton("Sačuvaj promjene");
		btnSauvajPromjene.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSauvajPromjene.setBounds(83, 328, 119, 23);
		panel_11.add(btnSauvajPromjene);
		
		JButton btnObriiProjekat = new JButton("Obriši projekat");
		btnObriiProjekat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnObriiProjekat.setBounds(212, 328, 119, 23);
		panel_11.add(btnObriiProjekat);
		
	}

	private void JTable(Object rowData, TableColumnModel columnNames) {
		// TODO Auto-generated method stub
		
	}
}
