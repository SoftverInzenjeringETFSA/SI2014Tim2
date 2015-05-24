package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ListModel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class MainFormKoordinator extends JFrame {
	private JTextField textField;
	private JTextField textField_46;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFormKoordinator frame = new MainFormKoordinator(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFormKoordinator(final ZaposlenikHibernate zh) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("QuickSheet - Koordinator");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 458);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 764, 450);
		getContentPane().add(tabbedPane);
		setLocationRelativeTo(null);
		JPanel timeSheetPanel = new JPanel();
		tabbedPane.addTab("Moj Timesheet", null, timeSheetPanel, null);
		timeSheetPanel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Timesheet podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(30, 22, 703, 348);
		timeSheetPanel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Projekat:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(80, 69, 46, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_4.add(lblNewLabel);
		
		final JLabel label_8 = new JLabel("");
		label_8.setVisible(false);
		label_8.setBounds(0, 389, 759, 14);
		timeSheetPanel.add(label_8);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"projekat1", "projekat2"}));
		comboBox.setBounds(136, 69, 201, 20);
		panel_4.add(comboBox);
		
		final JSpinner spinner_3 = new JSpinner();
		spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_3.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_3.setBounds(135, 294, 210, 20);
		panel_4.add(spinner_3);
		
		JButton btnNewButton = new JButton("Pošalji na reviziju");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(comboBox.getSelectedIndex()==-1){
					greska = false;
					label_8.setText("Morate označiti parametar pretrage!");
					
				}
				else if(table.getModel().getValueAt(0,0) == null || table.getModel().getValueAt(0,1) == null || table.getModel().getValueAt(0,2) == null){
					greska = false;
					label_8.setText("Morate popuniti barem jedan task da bi poslali timesheet na reviziju!");
				}
				
				else greska = true;
					
				if(greska == false){ 
					label_8.setVisible(true);
					}
				
				else{
					label_8.setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(531, 291, 124, 29);
		panel_4.add(btnNewButton);
		
	
		
		JLabel lblTaskovi = new JLabel("Taskovi:");
		lblTaskovi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTaskovi.setBounds(80, 117, 46, 14);
		panel_4.add(lblTaskovi);
		
		JLabel lblBrojSati = new JLabel("Ukupan broj radnih sati:");
		lblBrojSati.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBrojSati.setBounds(10, 248, 116, 14);
		panel_4.add(lblBrojSati);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		spinner_2.setBounds(136, 245, 210, 20);
		panel_4.add(spinner_2);
		
		
		
		
		JLabel label = new JLabel("Datum:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(91, 297, 35, 14);
		panel_4.add(label);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(136, 120, 519, 106);
		panel_4.add(scrollPane_2);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(true);
		
		scrollPane_2.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Naziv taska", "Procenat zavr\u0161enosti", "Broj radnih sati"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(123);
		table.getColumnModel().getColumn(1).setPreferredWidth(126);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		
		JPanel historijaPanel = new JPanel();
		tabbedPane.addTab("Moja Historija", null, historijaPanel, null);
		historijaPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prikaz historije timesheet - ova za odre\u0111eni projekat", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(30, 22, 341, 370);
		historijaPanel.add(panel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_1.setBounds(155, 28, 141, 20);
		panel.add(comboBox_1);
		
		JLabel label_1 = new JLabel("Projekat:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 28, 78, 20);
		panel.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 321, 272);
		panel.add(scrollPane);
		
		JLabel label_2 = new JLabel("Timesheet historija:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(10, 59, 200, 20);
		panel.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Prikaz historije za odre\u0111eni vremenski interval", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(392, 22, 341, 370);
		historijaPanel.add(panel_2);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(SystemColor.controlHighlight);
		canvas.setBounds(10, 88, 321, 272);
		panel_2.add(canvas);
		
		JLabel label_3 = new JLabel("Od");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 30, 46, 20);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Do");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(178, 30, 46, 20);
		panel_2.add(label_4);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerDateModel(new Date(1432159200000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_4.setBounds(35, 30, 131, 20);
		panel_2.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_5.setModel(new SpinnerDateModel(new Date(1432159200000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_5.setBounds(200, 30, 131, 20);
		panel_2.add(spinner_5);
		
		JLabel label_5 = new JLabel("Ili, prikaz za određeni mjesec:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(10, 61, 156, 14);
		panel_2.add(label_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_2.setBounds(200, 61, 131, 20);
		panel_2.add(comboBox_2);
		
		JPanel odjeliPanel = new JPanel();
		tabbedPane.addTab("Odjeli", null, odjeliPanel, null);
		odjeliPanel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Pretraga odjela", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(30, 22, 355, 370);
		odjeliPanel.add(panel_3);
		panel_3.setLayout(null);
		
		JList list_4 = new JList();
		list_4.setBounds(22, 116, 309, 243);
		panel_3.add(list_4);
		
		JLabel label_16 = new JLabel("Izaberite parametar pretrage:");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_16.setBounds(22, 29, 170, 14);
		panel_3.add(label_16);
		
		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(comboBox_5.getSelectedItem() == null)){
					textField_7.setText((String) comboBox_5.getSelectedItem());
				}
			}
		});
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"naziv"}));
		comboBox_5.setBounds(22, 56, 99, 23);
		panel_3.add(comboBox_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(128, 56, 124, 23);
		panel_3.add(textField_7);
		
		final JLabel label_error = new JLabel("");
		label_error.setVisible(false);
		label_error.setBounds(0, 408, 759, 14);
		odjeliPanel.add(label_error);
		
		JButton button_2 = new JButton("Pretraži");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				
				if(comboBox_5.getSelectedItem() == null){
					greska = false;
					label_error.setText("Morate označiti parametar pretrage!");
				}
				if(greska == false){
					label_error.setVisible(true);
				}
				else label_error.setVisible(false);
			}
			
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_2.setBounds(262, 56, 69, 23);
		panel_3.add(button_2);
		
		JCheckBox checkBox = new JCheckBox("Prikaži arhivirane korisnike");
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		checkBox.setBounds(22, 86, 170, 23);
		panel_3.add(checkBox);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o odjelu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(392, 22, 341, 370);
		odjeliPanel.add(panel_5);
		
		JLabel label_6 = new JLabel("Naziv odjela:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(78, 33, 62, 14);
		panel_5.add(label_6);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(190, 30, 141, 20);
		panel_5.add(textField_1);
		
		JLabel lblZaposlenici = new JLabel("Zaposlenici:");
		lblZaposlenici.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici.setBounds(85, 58, 66, 29);
		panel_5.add(lblZaposlenici);
		
		JLabel label_9 = new JLabel("Maksimalni broj zaposlenika:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(10, 207, 152, 14);
		panel_5.add(label_9);
		
		JList list = new JList();
		list.setEnabled(false);
		list.setBounds(190, 61, 141, 135);
		panel_5.add(list);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(190, 207, 141, 20);
		panel_5.add(textField_2);
		
		
		
		
		
		JPanel projektiPanel = new JPanel();
		tabbedPane.addTab("Projekti", null, projektiPanel, null);
		projektiPanel.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga projekta", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_11.setBounds(30, 22, 355, 201);
		projektiPanel.add(panel_11);
		
		JCheckBox chckbxPrikaziArhiviraneProjekte = new JCheckBox("Prikaži arhivirane projekte");
		chckbxPrikaziArhiviraneProjekte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxPrikaziArhiviraneProjekte.setBounds(22, 75, 149, 23);
		panel_11.add(chckbxPrikaziArhiviraneProjekte);
		
		final JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(comboBox_17.getSelectedItem() == null)){
					textField_46.setText((String) comboBox_17.getSelectedItem());
				}
			}
		});
		comboBox_17.setModel(new DefaultComboBoxModel(new String[] {"naziv projekta"}));
		comboBox_17.setBounds(22, 45, 99, 23);
		panel_11.add(comboBox_17);
		
		final JLabel label_error1 = new JLabel("");
		label_error1.setVisible(false);
		label_error1.setBounds(0, 403, 759, 14);
		projektiPanel.add(label_error1);
		
		JButton btnPretrai_1 = new JButton("Pretraži");
		btnPretrai_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(comboBox_17.getSelectedItem() == null){
					greska = false;
					label_error1.setText("Morate označiti parametar pretrage!");
				}
				if(greska == false){
					label_error1.setVisible(true);
				}
				else label_error1.setVisible(false);
			}
		});
		btnPretrai_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPretrai_1.setBounds(262, 45, 69, 23);
		panel_11.add(btnPretrai_1);
		
		textField_46 = new JTextField();
		textField_46.setBounds(128, 45, 124, 23);
		panel_11.add(textField_46);
		textField_46.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setBounds(22, 105, 309, 85);
		panel_11.add(list_1);
		
		JLabel lblIzaberiteParametarPretrage = new JLabel("Izaberite parametar pretrage:");
		lblIzaberiteParametarPretrage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIzaberiteParametarPretrage.setBounds(22, 22, 170, 14);
		panel_11.add(lblIzaberiteParametarPretrage);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o projektu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.setBounds(392, 22, 341, 370);
		projektiPanel.add(panel_8);
		panel_8.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBounds(166, 25, 165, 20);
		panel_8.add(textField_4);
		
		JLabel label_7 = new JLabel("Naziv:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(86, 28, 82, 14);
		panel_8.add(label_7);
		
		JLabel label_10 = new JLabel("Naziv klijenta:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(51, 53, 102, 14);
		panel_8.add(label_10);
		
		JLabel lblZaposlenici_1 = new JLabel("Zaposlenici:");
		lblZaposlenici_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici_1.setBounds(62, 78, 56, 14);
		panel_8.add(lblZaposlenici_1);
		
		
		
		
		JLabel lblNadreeni = new JLabel("Nadređeni:");
		lblNadreeni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNadreeni.setBounds(66, 271, 102, 14);
		panel_8.add(lblNadreeni);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(166, 50, 165, 20);
		panel_8.add(textField_5);
		
		JLabel lblArhivirajProjekat = new JLabel("Arhiviraj projekat:");
		lblArhivirajProjekat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblArhivirajProjekat.setBounds(30, 306, 102, 14);
		panel_8.add(lblArhivirajProjekat);
		
		JCheckBox chckbxArhiviraj = new JCheckBox("");
		chckbxArhiviraj.setBounds(162, 302, 97, 23);
		panel_8.add(chckbxArhiviraj);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(166, 268, 165, 20);
		panel_8.add(comboBox_3);
		
		final JList list_3 = new JList();
		list_3.setBackground(Color.WHITE);
		list_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_3.setBounds(166, 78, 165, 148);
		panel_8.add(list_3);
		
		JButton button = new JButton("Sačuvaj promjene");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(textField_4.getText().equals("")){
					greska = false;
					label_error1.setText("Unesite naziv projekta!");
				}
				else if(textField_5.getText().equals("")){
					greska = false;
					label_error1.setText("Unesite naziv klijenta!");
				}
				else if(list_3.getModel().getSize() == 0){
					greska = false;
					label_error1.setText("Dodajte zaposlenike na projekat!");
				}
			
				
				else if(comboBox_3.getSelectedItem() == null){
					greska = false;
					label_error1.setText("Morate označiti nadređenog!");
				}
				else greska = true;
				if(greska == false){
					label_error1.setVisible(true);
				}
				else label_error1.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBounds(212, 336, 119, 23);
		panel_8.add(button);
		
		JButton btnUkloni = new JButton("Dodaj");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DodajKorisnika().setVisible(true);
			}
		});
		btnUkloni.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUkloni.setBounds(166, 237, 82, 23);
		panel_8.add(btnUkloni);
		
		
		
		
		JButton button_3 = new JButton("Ukloni");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(list_3.isSelectionEmpty()){
					greska = false;
					label_error1.setText("Morate označiti korisnika da bi ga uklonili!");
				}
				if(greska == false){
					label_error1.setVisible(true);
				}
				else label_error1.setVisible(false);
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_3.setBounds(249, 237, 82, 23);
		panel_8.add(button_3);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Taskovi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(30, 226, 355, 166);
		projektiPanel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblPrikazTaskova = new JLabel("Prikaz taskova:");
		lblPrikazTaskova.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrikazTaskova.setBounds(21, 22, 82, 14);
		panel_9.add(lblPrikazTaskova);
		
		JList list_7 = new JList();
		list_7.setBounds(21, 37, 309, 85);
		panel_9.add(list_7);
		
		JButton btnDodajTask = new JButton("Dodaj task");
		btnDodajTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TaskForm().setVisible(true);
			}
		});
		btnDodajTask.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDodajTask.setBounds(211, 133, 119, 23);
		panel_9.add(btnDodajTask);
		
		
		
		
		JPanel korisniciPanel = new JPanel();
		tabbedPane.addTab("Korisnici", null, korisniciPanel, null);
		korisniciPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pretraga korisnika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(30, 22, 355, 370);
		korisniciPanel.add(panel_1);
		panel_1.setLayout(null);
		
	    final JList list_2 = new JList();
	    list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setBounds(22, 116, 309, 209);
		panel_1.add(list_2);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Prikaži arhivirane korisnike");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBounds(22, 86, 170, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("Prikaži profil");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!list_2.isSelectionEmpty())
				{
					String selektovaniModel = list_2.getSelectedValue().toString();
					new KorisnikFormKoordinator(selektovaniModel).setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(212, 336, 119, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel label_11 = new JLabel("Izaberite parametar pretrage:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(22, 29, 170, 14);
		panel_1.add(label_11);
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(comboBox_4.getSelectedItem() == null)){
					textField_6.setText((String) comboBox_4.getSelectedItem());
				}
			}
		});
		comboBox_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Ime", "Prezime", "Username"}));
		comboBox_4.setBounds(22, 56, 99, 23);
		panel_1.add(comboBox_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(128, 56, 124, 23);
		panel_1.add(textField_6);
		
		final JLabel label_error2 = new JLabel("");
		label_error2.setVisible(false);
		label_error2.setBounds(0, 408, 759, 14);
		korisniciPanel.add(label_error2);
		
		JButton button_1 = new JButton("Pretraži");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				
				if(comboBox_4.getSelectedItem() == null){
					greska = false;
					label_error2.setText("Morate označiti parametar pretrage!");
				}
				if(greska == false){
					label_error2.setVisible(true);
				}
				else {
					label_error2.setVisible(false);
				if (!textField_6.getText().isEmpty())
				{
			    DefaultListModel lista = new DefaultListModel();
			    list_2.setModel(lista);
			    ArrayList<ProjekatHibernate> projekti = DalDao.VratiSveKoordinatorskeProjekte(zh.getId());
				ArrayList<ZaposlenikHibernate> zaposlenici = new ArrayList<ZaposlenikHibernate>();
				for (int i = 0; i < projekti.size(); i++)
				{
					
					ArrayList<ZaposlenikHibernate> zaps = DalDao.VratiZaposlenikeNaProjektu(projekti.get(i).getId());
					for (int j = 0; j < zaps.size(); j++)
					{
						if (!zaposlenici.contains(zaps.get(j)))
							zaposlenici.add(zaps.get(j));
					}
				}
				ArrayList<ZaposlenikHibernate> filterZaposlenici = new ArrayList<ZaposlenikHibernate>();
				String vrijednost = comboBox_4.getSelectedItem().toString();
				if (chckbxNewCheckBox.isSelected())
				{
					if (vrijednost.equals("Ime"))
					{
						for (int i = 0; i < zaposlenici.size(); i++)
						{
							if (zaposlenici.get(i).getIme().equals(textField_6.getText()))
							{
								filterZaposlenici.add(zaposlenici.get(i));
							}
						}
					}
					else if (vrijednost.equalsIgnoreCase("Prezime"))
					{
						for (int i = 0; i < zaposlenici.size(); i++)
						{
							if (zaposlenici.get(i).getPrezime().equals(textField_6.getText()))
							{
								filterZaposlenici.add(zaposlenici.get(i));
							}
						}
					}
					else
					{
						for (int i = 0; i < zaposlenici.size(); i++)
						{
							if (zaposlenici.get(i).getUsername().equals(textField_6.getText()))
							{
								filterZaposlenici.add(zaposlenici.get(i));
							}
						}
					}
				}
				else
				{
					if (vrijednost.equals("Ime"))
					{
						for (int i = 0; i < zaposlenici.size(); i++)
						{
							if (zaposlenici.get(i).getIme().equals(textField_6.getText()) && !zaposlenici.get(i).getArhiviran())
							{
								filterZaposlenici.add(zaposlenici.get(i));
							}
						}
					}
					else if (vrijednost.equalsIgnoreCase("Prezime"))
					{
						for (int i = 0; i < zaposlenici.size(); i++)
						{
							if (zaposlenici.get(i).getPrezime().equals(textField_6.getText()) && !zaposlenici.get(i).getArhiviran())
							{
								filterZaposlenici.add(zaposlenici.get(i));
							}
						}
					}
					else
					{
						for (int i = 0; i < zaposlenici.size(); i++)
						{
							if (zaposlenici.get(i).getUsername().equals(textField_6.getText()) && !zaposlenici.get(i).getArhiviran())
							{
								filterZaposlenici.add(zaposlenici.get(i));
							}
						}					
					}
				}
				for (int i = 0; i < filterZaposlenici.size(); i++)
				{
					String podatak = filterZaposlenici.get(i).getId() + " " + filterZaposlenici.get(i).getIme() + " " + filterZaposlenici.get(i).getPrezime();
					lista.addElement(podatak);
				}
				}
			}}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.setBounds(262, 56, 69, 23);
		panel_1.add(button_1);
		
		
		
		
		JPanel izvjestajiPanel = new JPanel();
		tabbedPane.addTab("Izvještaji", null, izvjestajiPanel, null);
		izvjestajiPanel.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Izvje\u0161taj", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(392, 22, 341, 370);
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
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_11.setBounds(75, 33, 57, 14);
		panel_7.add(lblNewLabel_11);
		
		JComboBox comboBox_20 = new JComboBox();
		comboBox_20.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_20.setBounds(75, 58, 197, 20);
		ArrayList<OdjelHibernate> odjeli = DalDao.VratiSveNearhiviraneOdjele();
		for (int i = 0; i < odjeli.size(); i++)
		{
			String komponenta = odjeli.get(i).getId() + " " + odjeli.get(i).getNaziv();
			comboBox_20.addItem(komponenta);
		}
		panel_7.add(comboBox_20);
		
		JLabel lblZaposlenik = new JLabel("Zaposlenik:");
		lblZaposlenik.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenik.setBounds(75, 89, 57, 14);
		panel_7.add(lblZaposlenik);
		
		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_21.setBounds(75, 114, 197, 20);		
		String vrijednost1 = comboBox_20.getSelectedItem().toString();
		String[] rijeci = vrijednost1.split(" ");
		long odjelId = Long.parseLong(rijeci[0]);
		ArrayList<ZaposlenikHibernate> zaposleniciOdjela = DalDao.VratiZaposlenikeUOdjelu(odjelId);
		for (int i = 0; i < zaposleniciOdjela.size(); i++)
		{
			String komponenta = zaposleniciOdjela.get(i).getId() + " " + zaposleniciOdjela.get(i).getIme() + " " + zaposleniciOdjela.get(i).getPrezime();
		}
		panel_7.add(comboBox_21);
		
		JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_22.setBounds(75, 170, 197, 20);
		panel_7.add(comboBox_22);
		
		JLabel lblProjekat_1 = new JLabel("Projekat:");
		lblProjekat_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProjekat_1.setBounds(75, 145, 57, 14);
		panel_7.add(lblProjekat_1);
		
		JComboBox comboBox_23 = new JComboBox();
		comboBox_23.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_23.setBounds(75, 226, 197, 20);
		panel_7.add(comboBox_23);
		
		JLabel lblMjesevc = new JLabel("Izvještaj za mjesec:");
		lblMjesevc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMjesevc.setBounds(75, 201, 116, 14);
		panel_7.add(lblMjesevc);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(203, 229, 46, 14);
		panel_7.add(label_15);
		
		JLabel lblIliIzvjestajZa = new JLabel("Ili, izvještaj za vremenski period:");
		lblIliIzvjestajZa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIliIzvjestajZa.setBounds(75, 264, 197, 14);
		panel_7.add(lblIliIzvjestajZa);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOd.setBounds(76, 289, 46, 14);
		panel_7.add(lblOd);
		
		JLabel lblDo_1 = new JLabel("Do:");
		lblDo_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDo_1.setBounds(177, 289, 46, 14);
		panel_7.add(lblDo_1);
		
		JButton btnNewButton_3 = new JButton("Generiši izvještaj");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_3.setBounds(75, 336, 197, 23);
		panel_7.add(btnNewButton_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerDateModel(new Date(1431986400000L), new Date(1431986400000L), null, Calendar.YEAR));
		spinner.setBounds(106, 286, 61, 20);
		panel_7.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_1.setModel(new SpinnerDateModel(new Date(1431986400000L), new Date(1431986400000L), null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(203, 286, 61, 20);
		panel_7.add(spinner_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 380, 309, -349);
		izvjestajiPanel.add(scrollPane_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Timesheet validacija", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(30, 22, 341, 370);
		izvjestajiPanel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblImenkoPrezimenkovic = new JLabel("Zahtjevi za reviziju i odobravanje timesheeta:");
		lblImenkoPrezimenkovic.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImenkoPrezimenkovic.setBounds(15, 41, 240, 14);
		panel_6.add(lblImenkoPrezimenkovic);
		final JLabel label_17 = new JLabel("");
		label_17.setVisible(false);
		label_17.setBounds(0, 408, 759, 14);
		izvjestajiPanel.add(label_17);
		
		
		JButton btnPrikazi = new JButton("Prikaži");
		btnPrikazi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(list_3.isSelectionEmpty()){
					greska = false;
					label_17.setText("Morate označiti timesheet da bi ga uklonili!");
				}
				if(greska == false){
					label_17.setVisible(true);
				}
				else {
					label_17.setVisible(false);
					new PrikazTimesheeta().setVisible(true);
				}
				
			}			
		});
		btnPrikazi.setBounds(88, 336, 74, 23);
		panel_6.add(btnPrikazi);
		
		JButton btnOdobri = new JButton("Odobri");
		btnOdobri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				
				if(list_3.isSelectionEmpty()){
					greska = false;
					label_17.setText("Morate označiti timesheet da bi ga odobrili!");
				}
				if(greska == false){
					label_17.setVisible(true);
				}
				else {
					label_17.setVisible(false);
					
				}
			}
		});
		btnOdobri.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnOdobri.setBounds(172, 336, 74, 23);
		panel_6.add(btnOdobri);
		
		JButton btnNewButton_2 = new JButton("Odbij");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(list_3.isSelectionEmpty()){
					greska = false;
					label_17.setText("Morate označiti timesheet da bi ga odbili!");
				}
				if(greska == false){
					label_17.setVisible(true);
				}
				else {
					label_17.setVisible(false);
					
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_2.setBounds(256, 336, 74, 23);
		panel_6.add(btnNewButton_2);
		
		JList list_6 = new JList();
		list_6.setBounds(12, 76, 315, 249);
		panel_6.add(list_6);
		
		
		
	}

	private void JTable(Object rowData, TableColumnModel columnNames) {
		// TODO Auto-generated method stub
		
	}
}
