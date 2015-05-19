package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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

public class MainForm extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JLabel lblPonedjeljak;
	private JLabel lblUtorak;
	private JLabel lblSrijeda;
	private JLabel lbletvrtak;
	private JLabel lblPetak;
	private JLabel lblSubota;
	private JLabel lblNedjelja;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblDatum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblSati;
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
		setTitle("QuickSheet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 460);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 777, 421);
		getContentPane().add(tabbedPane);
		
		JPanel timeSheetPanel = new JPanel();
		tabbedPane.addTab("Moj Timesheet", null, timeSheetPanel, null);
		timeSheetPanel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(32, 43, 108, 20);
		timeSheetPanel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(149, 43, 108, 20);
		timeSheetPanel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(32, 74, 108, 20);
		timeSheetPanel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(149, 74, 108, 20);
		timeSheetPanel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(32, 105, 108, 20);
		timeSheetPanel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(149, 105, 108, 20);
		timeSheetPanel.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(32, 135, 108, 20);
		timeSheetPanel.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(149, 135, 108, 20);
		timeSheetPanel.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(32, 166, 108, 20);
		timeSheetPanel.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(149, 166, 108, 20);
		timeSheetPanel.add(comboBox_9);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 43, 59, 20);
		timeSheetPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(263, 74, 59, 20);
		timeSheetPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(263, 105, 59, 20);
		timeSheetPanel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(263, 135, 59, 20);
		timeSheetPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(263, 166, 59, 20);
		timeSheetPanel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(335, 43, 59, 20);
		timeSheetPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(335, 105, 59, 20);
		timeSheetPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(335, 74, 59, 20);
		timeSheetPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(335, 135, 59, 20);
		timeSheetPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(335, 166, 59, 20);
		timeSheetPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(404, 43, 59, 20);
		timeSheetPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(404, 105, 59, 20);
		timeSheetPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(404, 135, 59, 20);
		timeSheetPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(404, 166, 59, 20);
		timeSheetPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(404, 74, 59, 20);
		timeSheetPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(473, 43, 59, 20);
		timeSheetPanel.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(473, 74, 59, 20);
		timeSheetPanel.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(473, 105, 59, 20);
		timeSheetPanel.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(473, 135, 59, 20);
		timeSheetPanel.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(473, 166, 59, 20);
		timeSheetPanel.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(542, 43, 59, 20);
		timeSheetPanel.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(611, 43, 59, 20);
		timeSheetPanel.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(676, 43, 59, 20);
		timeSheetPanel.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(542, 74, 59, 20);
		timeSheetPanel.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(542, 105, 59, 20);
		timeSheetPanel.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(542, 135, 59, 20);
		timeSheetPanel.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(542, 166, 59, 20);
		timeSheetPanel.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(611, 74, 59, 20);
		timeSheetPanel.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(611, 105, 59, 20);
		timeSheetPanel.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(611, 135, 59, 20);
		timeSheetPanel.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(611, 166, 59, 20);
		timeSheetPanel.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(676, 74, 59, 20);
		timeSheetPanel.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(676, 105, 59, 20);
		timeSheetPanel.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(676, 135, 59, 20);
		timeSheetPanel.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(676, 166, 59, 20);
		timeSheetPanel.add(textField_35);
		
		lblPonedjeljak = new JLabel("Ponedjeljak");
		lblPonedjeljak.setBounds(263, 21, 59, 20);
		timeSheetPanel.add(lblPonedjeljak);
		
		lblUtorak = new JLabel("Utorak");
		lblUtorak.setBounds(346, 21, 59, 20);
		timeSheetPanel.add(lblUtorak);
		
		lblSrijeda = new JLabel("Srijeda");
		lblSrijeda.setBounds(414, 21, 59, 20);
		timeSheetPanel.add(lblSrijeda);
		
		lbletvrtak = new JLabel("Četvrtak");
		lbletvrtak.setBounds(483, 21, 59, 20);
		timeSheetPanel.add(lbletvrtak);
		
		lblPetak = new JLabel("Petak");
		lblPetak.setBounds(552, 21, 59, 20);
		timeSheetPanel.add(lblPetak);
		
		lblSubota = new JLabel("Subota");
		lblSubota.setBounds(621, 21, 59, 20);
		timeSheetPanel.add(lblSubota);
		
		lblNedjelja = new JLabel("Nedjelja");
		lblNedjelja.setBounds(687, 21, 59, 20);
		timeSheetPanel.add(lblNedjelja);
		
		lblNewLabel = new JLabel("Sedmica od:");
		lblNewLabel.setBounds(119, 0, 71, 20);
		timeSheetPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("datum1");
		lblNewLabel_1.setBounds(189, 3, 91, 14);
		timeSheetPanel.add(lblNewLabel_1);
		
		lblDatum = new JLabel("datum2");
		lblDatum.setBounds(335, 3, 91, 14);
		timeSheetPanel.add(lblDatum);
		
		lblNewLabel_2 = new JLabel("do");
		lblNewLabel_2.setBounds(266, 3, 30, 14);
		timeSheetPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ukupno:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(432, 197, 91, 20);
		timeSheetPanel.add(lblNewLabel_3);
		
		lblSati = new JLabel("sati");
		lblSati.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSati.setBounds(529, 197, 91, 20);
		timeSheetPanel.add(lblSati);
		
		JButton btnNewButton = new JButton("Pošalji na reviziju");
		btnNewButton.setBounds(621, 197, 114, 23);
		timeSheetPanel.add(btnNewButton);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Ponedjeljak"); 
		model.addColumn("Utorak"); 
		model.addColumn("Srijeda"); 
		model.addColumn("Četvrtak"); 
		model.addColumn("Petak"); 
		model.addColumn("Subota"); 
		model.addColumn("Nedjelja");
		
		JPanel historijaPanel = new JPanel();
		tabbedPane.addTab("Moja Historija", null, historijaPanel, null);
		historijaPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Projekat:");
		lblNewLabel_4.setBounds(34, 29, 78, 20);
		historijaPanel.add(lblNewLabel_4);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(91, 29, 135, 20);
		historijaPanel.add(comboBox_10);
		
		JLabel lblNewLabel_5 = new JLabel("Timesheet historija:");
		lblNewLabel_5.setBounds(34, 87, 200, 20);
		historijaPanel.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 107, 265, 252);
		historijaPanel.add(scrollPane);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(SystemColor.controlHighlight);
		canvas.setBounds(382, 107, 327, 252);
		historijaPanel.add(canvas);
		
		JLabel lblNewLabel_6 = new JLabel("Od");
		lblNewLabel_6.setBounds(372, 29, 46, 20);
		historijaPanel.add(lblNewLabel_6);
		
		JLabel lblDo = new JLabel("Do");
		lblDo.setBounds(512, 29, 46, 20);
		historijaPanel.add(lblDo);
		
		JPanel odjeliPanel = new JPanel();
		tabbedPane.addTab("Odjeli", null, odjeliPanel, null);
		odjeliPanel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Podaci o odjelu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		panel_2.setBounds(30, 40, 341, 341);
		odjeliPanel.add(panel_2);
		
		lblNaziv = new JLabel("Naziv:");
		lblNaziv.setBounds(71, 30, 82, 14);
		panel_2.add(lblNaziv);
		
		textField_43 = new JTextField();
		textField_43.setColumns(10);
		textField_43.setBounds(190, 30, 141, 20);
		panel_2.add(textField_43);
		
		JLabel lblNewLabel_7 = new JLabel("Dodaj zaposlenika:");
		lblNewLabel_7.setBounds(42, 60, 90, 29);
		panel_2.add(lblNewLabel_7);
		
		JComboBox comboBox_14 = new JComboBox();
		comboBox_14.setBounds(190, 64, 141, 20);
		panel_2.add(comboBox_14);
		
		JButton btnDodajVise = new JButton("Dodaj vise");
		btnDodajVise.setBounds(242, 95, 89, 23);
		panel_2.add(btnDodajVise);
		
		JLabel lblNewLabel_9 = new JLabel("Dodaj nadredjenog:");
		lblNewLabel_9.setBounds(30, 132, 102, 14);
		panel_2.add(lblNewLabel_9);
		
		JComboBox comboBox_15 = new JComboBox();
		comboBox_15.setBounds(190, 132, 141, 20);
		panel_2.add(comboBox_15);
		
		JButton button_2 = new JButton("Dodaj vise");
		button_2.setBounds(242, 163, 89, 23);
		panel_2.add(button_2);
		
		JLabel lblMaksimalniBroj = new JLabel("Maksimalni broj zaposlenika:");
		lblMaksimalniBroj.setBounds(10, 217, 152, 14);
		panel_2.add(lblMaksimalniBroj);
		
		textField_44 = new JTextField();
		textField_44.setBounds(190, 211, 141, 20);
		panel_2.add(textField_44);
		textField_44.setColumns(10);
		
		JButton btnDodaj_1 = new JButton("Dodaj");
		btnDodaj_1.setBounds(242, 297, 89, 23);
		panel_2.add(btnDodaj_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(378, 51, 373, 331);
		odjeliPanel.add(panel_3);
		
		textField_45 = new JTextField();
		textField_45.setColumns(10);
		textField_45.setBounds(400, 26, 175, 20);
		odjeliPanel.add(textField_45);
		
		JComboBox comboBox_16 = new JComboBox();
		comboBox_16.setBounds(579, 26, 73, 20);
		odjeliPanel.add(comboBox_16);
		
		JButton button_3 = new JButton("Pretrazi");
		button_3.setBounds(662, 23, 89, 23);
		odjeliPanel.add(button_3);
		
		JPanel korisniciPanel = new JPanel();
		tabbedPane.addTab("Korisnici", null, korisniciPanel, null);
		korisniciPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o korisniku", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 40, 341, 342);
		korisniciPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIme.setBounds(98, 33, 82, 14);
		panel.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrezime.setBounds(82, 58, 82, 14);
		panel.add(lblPrezime);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAdresa.setBounds(82, 83, 82, 14);
		panel.add(lblAdresa);
		
		JLabel lblBrojTelefona = new JLabel("Broj Telefona:");
		lblBrojTelefona.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBrojTelefona.setBounds(52, 108, 97, 14);
		panel.add(lblBrojTelefona);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(92, 133, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblNewLabel_8 = new JLabel("Datum zaposljavanja:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(10, 158, 124, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblOdjel = new JLabel("Odjel:");
		lblOdjel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOdjel.setBounds(92, 183, 46, 14);
		panel.add(lblOdjel);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKorisnickoIme.setBounds(52, 205, 82, 14);
		panel.add(lblKorisnickoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLozinka.setBounds(82, 230, 46, 14);
		panel.add(lblLozinka);
		
		JLabel lblPonoviLozinku = new JLabel("Ponovi lozinku:");
		lblPonoviLozinku.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPonoviLozinku.setBounds(52, 255, 92, 14);
		panel.add(lblPonoviLozinku);
		
		JLabel lblVrstaKorisnika = new JLabel("Vrsta korisnika:");
		lblVrstaKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVrstaKorisnika.setBounds(52, 280, 82, 14);
		panel.add(lblVrstaKorisnika);
		
		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setBounds(190, 277, 141, 20);
		panel.add(comboBox_11);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 252, 141, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(190, 227, 141, 20);
		panel.add(passwordField_1);
		
		textField_36 = new JTextField();
		textField_36.setBounds(190, 30, 141, 20);
		panel.add(textField_36);
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(190, 53, 141, 20);
		panel.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(190, 78, 141, 20);
		panel.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setColumns(10);
		textField_39.setBounds(190, 106, 141, 20);
		panel.add(textField_39);
		
		textField_40 = new JTextField();
		textField_40.setColumns(10);
		textField_40.setBounds(190, 131, 141, 20);
		panel.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setColumns(10);
		textField_41.setBounds(190, 202, 141, 20);
		panel.add(textField_41);
		
		JComboBox comboBox_12 = new JComboBox();
		comboBox_12.setBounds(190, 180, 141, 20);
		panel.add(comboBox_12);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(242, 308, 89, 23);
		panel.add(btnDodaj);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pretraga korisnika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(392, 40, 341, 342);
		korisniciPanel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_42 = new JTextField();
		textField_42.setBounds(33, 39, 183, 20);
		panel_1.add(textField_42);
		textField_42.setColumns(10);
		
		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setBounds(226, 39, 85, 20);
		panel_1.add(comboBox_13);
		
		JButton btnPretraga = new JButton("Pretraga");
		btnPretraga.setBounds(127, 70, 89, 23);
		panel_1.add(btnPretraga);
		
		JList list_2 = new JList();
		list_2.setBounds(33, 151, 278, 180);
		panel_1.add(list_2);
		
		JPanel projektiPanel = new JPanel();
		tabbedPane.addTab("Projekti", null, projektiPanel, null);
		projektiPanel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o projektu", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setLayout(null);
		panel_5.setBounds(30, 40, 341, 341);
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
		
		JLabel label_4 = new JLabel("Dodaj nadredjenog:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(24, 251, 102, 14);
		panel_5.add(label_4);
		
		JComboBox comboBox_19 = new JComboBox();
		comboBox_19.setBounds(159, 248, 165, 20);
		panel_5.add(comboBox_19);
		
		JButton button_7 = new JButton("Dodaj");
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
		panel_11.setBounds(392, 40, 341, 342);
		projektiPanel.add(panel_11);
		
		JCheckBox chckbxPrikaziArhiviraneProjekte = new JCheckBox("Prikazi arhivirane projekte");
		chckbxPrikaziArhiviraneProjekte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxPrikaziArhiviraneProjekte.setBounds(22, 110, 149, 23);
		panel_11.add(chckbxPrikaziArhiviraneProjekte);
		
		JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setBounds(226, 39, 85, 20);
		panel_11.add(comboBox_17);
		
		JButton button_4 = new JButton("Pretrazi");
		button_4.setBounds(127, 70, 89, 23);
		panel_11.add(button_4);
		
		textField_46 = new JTextField();
		textField_46.setBounds(33, 39, 183, 20);
		panel_11.add(textField_46);
		textField_46.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setBounds(33, 151, 278, 180);
		panel_11.add(list_1);
		
		JPanel izvjestajiPanel = new JPanel();
		tabbedPane.addTab("Izvjestaji", null, izvjestajiPanel, null);
		izvjestajiPanel.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(343, 29, 406, 353);
		izvjestajiPanel.add(panel_7);
		panel_7.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(202, 5, 1, 1);
		panel_10.setLayout(null);
		panel_7.add(panel_10);
		
		JLabel label_12 = new JLabel("Imenko Prezimenkovic");
		label_12.setBounds(10, 11, 121, 14);
		panel_10.add(label_12);
		
		JLabel label_13 = new JLabel("Projekat1");
		label_13.setBounds(141, 11, 121, 14);
		panel_10.add(label_13);
		
		JLabel label_14 = new JLabel("19.05.2015.");
		label_14.setBounds(10, 36, 121, 14);
		panel_10.add(label_14);
		
		JButton button_15 = new JButton("Prikazi");
		button_15.setBounds(10, 61, 74, 23);
		panel_10.add(button_15);
		
		JButton button_16 = new JButton("Odobri");
		button_16.setBounds(94, 61, 74, 23);
		panel_10.add(button_16);
		
		JButton button_17 = new JButton("Odbij");
		button_17.setBounds(173, 61, 74, 23);
		panel_10.add(button_17);
		
		JLabel lblNewLabel_11 = new JLabel("Odjel:");
		lblNewLabel_11.setBounds(171, 5, 57, 14);
		panel_7.add(lblNewLabel_11);
		
		JComboBox comboBox_20 = new JComboBox();
		comboBox_20.setBounds(111, 30, 197, 20);
		panel_7.add(comboBox_20);
		
		JLabel lblZaposlenik = new JLabel("Zaposlenik:");
		lblZaposlenik.setBounds(171, 61, 57, 14);
		panel_7.add(lblZaposlenik);
		
		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setBounds(111, 86, 197, 20);
		panel_7.add(comboBox_21);
		
		JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setBounds(111, 142, 197, 20);
		panel_7.add(comboBox_22);
		
		JLabel lblProjekat_1 = new JLabel("Projekat:");
		lblProjekat_1.setBounds(171, 117, 57, 14);
		panel_7.add(lblProjekat_1);
		
		JComboBox comboBox_23 = new JComboBox();
		comboBox_23.setBounds(111, 198, 197, 20);
		panel_7.add(comboBox_23);
		
		JLabel lblMjesevc = new JLabel("Izvjestaj za mjesec:");
		lblMjesevc.setBounds(156, 173, 116, 14);
		panel_7.add(lblMjesevc);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(203, 229, 46, 14);
		panel_7.add(label_15);
		
		JLabel lblIliIzvjestajZa = new JLabel("Ili, izvjestaj za vremenski period:");
		lblIliIzvjestajZa.setBounds(142, 229, 197, 14);
		panel_7.add(lblIliIzvjestajZa);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(112, 257, 46, 14);
		panel_7.add(lblOd);
		
		JLabel lblDo_1 = new JLabel("Do:");
		lblDo_1.setBounds(213, 257, 46, 14);
		panel_7.add(lblDo_1);
		
		JButton btnNewButton_3 = new JButton("Generisi izvjestaj");
		btnNewButton_3.setBounds(111, 302, 197, 23);
		panel_7.add(btnNewButton_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1431986400000L), new Date(1431986400000L), null, Calendar.YEAR));
		spinner.setBounds(142, 254, 61, 20);
		panel_7.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1431986400000L), new Date(1431986400000L), null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(239, 254, 61, 20);
		panel_7.add(spinner_1);
		
		JLabel lblTimesheetValidacija = new JLabel("Timesheet validacija:");
		lblTimesheetValidacija.setBounds(24, 11, 129, 14);
		izvjestajiPanel.add(lblTimesheetValidacija);
		
		JLabel lblNewLabel_10 = new JLabel("Izvjestaji:");
		lblNewLabel_10.setBounds(344, 11, 67, 14);
		izvjestajiPanel.add(lblNewLabel_10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 380, 309, -349);
		izvjestajiPanel.add(scrollPane_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(34, 41, 289, 94);
		izvjestajiPanel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblImenkoPrezimenkovic = new JLabel("Imenko Prezimenkovic");
		lblImenkoPrezimenkovic.setBounds(10, 11, 121, 14);
		panel_6.add(lblImenkoPrezimenkovic);
		
		JLabel lblProjekat = new JLabel("Projekat1");
		lblProjekat.setBounds(141, 11, 121, 14);
		panel_6.add(lblProjekat);
		
		JLabel label_5 = new JLabel("19.05.2015.");
		label_5.setBounds(10, 36, 121, 14);
		panel_6.add(label_5);
		
		JButton btnPrikazi = new JButton("Prikazi");
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrikazTimesheeta().setVisible(true);
			}			
		});
		btnPrikazi.setBounds(10, 61, 74, 23);
		panel_6.add(btnPrikazi);
		
		JButton btnOdobri = new JButton("Odobri");
		btnOdobri.setBounds(110, 61, 74, 23);
		panel_6.add(btnOdobri);
		
		JButton btnNewButton_2 = new JButton("Odbij");
		btnNewButton_2.setBounds(205, 61, 74, 23);
		panel_6.add(btnNewButton_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(34, 146, 289, 94);
		izvjestajiPanel.add(panel_8);
		
		JLabel label_6 = new JLabel("Imenko Prezimenkovic");
		label_6.setBounds(10, 11, 121, 14);
		panel_8.add(label_6);
		
		JLabel label_7 = new JLabel("Projekat1");
		label_7.setBounds(141, 11, 121, 14);
		panel_8.add(label_7);
		
		JLabel label_8 = new JLabel("19.05.2015.");
		label_8.setBounds(10, 36, 121, 14);
		panel_8.add(label_8);
		
		JButton button_9 = new JButton("Prikazi");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrikazTimesheeta().setVisible(true);
			}
		});
		button_9.setBounds(10, 61, 74, 23);
		panel_8.add(button_9);
		
		JButton button_10 = new JButton("Odobri");
		button_10.setBounds(109, 61, 74, 23);
		panel_8.add(button_10);
		
		JButton button_11 = new JButton("Odbij");
		button_11.setBounds(205, 61, 74, 23);
		panel_8.add(button_11);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(34, 251, 289, 94);
		izvjestajiPanel.add(panel_9);
		
		JLabel label_9 = new JLabel("Imenko Prezimenkovic");
		label_9.setBounds(10, 11, 121, 14);
		panel_9.add(label_9);
		
		JLabel label_10 = new JLabel("Projekat1");
		label_10.setBounds(141, 11, 121, 14);
		panel_9.add(label_10);
		
		JLabel label_11 = new JLabel("19.05.2015.");
		label_11.setBounds(10, 36, 121, 14);
		panel_9.add(label_11);
		
		JButton button_12 = new JButton("Prikazi");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrikazTimesheeta().setVisible(true);
			}
		});
		button_12.setBounds(10, 61, 74, 23);
		panel_9.add(button_12);
		
		JButton button_13 = new JButton("Odobri");
		button_13.setBounds(110, 61, 74, 23);
		panel_9.add(button_13);
		
		JButton button_14 = new JButton("Odbij");
		button_14.setBounds(205, 61, 74, 23);
		panel_9.add(button_14);
		
	}
}
