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
import java.awt.Toolkit;

public class MainFormKoordinator extends JFrame {
	private JTextField textField;
	private JTextField textField_46;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFormKoordinator frame = new MainFormKoordinator();
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
	public MainFormKoordinator() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("QuickSheet");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 459);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 764, 431);
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
		lblNewLabel.setBounds(56, 72, 46, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_4.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Pošalji na reviziju");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_2.setModel(new SpinnerNumberModel(0.0, 0.0, 12.0, 1.0));
		spinner_2.setBounds(136, 245, 210, 20);
		panel_4.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_3.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_3.setBounds(135, 294, 210, 20);
		panel_4.add(spinner_3);
		
		JLabel label = new JLabel("Datum:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(68, 294, 35, 14);
		panel_4.add(label);
		
		
		
		
		
		
		
		
		
		JPanel historijaPanel = new JPanel();
		tabbedPane.addTab("Moja Historija", null, historijaPanel, null);
		historijaPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prikaz historije timesheet - ova za odre\u0111eni projekat", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(30, 22, 341, 370);
		historijaPanel.add(panel);
		
		JComboBox comboBox_1 = new JComboBox();
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
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(22, 56, 99, 23);
		panel_3.add(comboBox_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(128, 56, 124, 23);
		panel_3.add(textField_7);
		
		JButton button_2 = new JButton("Pretraži");
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
		
		JLabel label_8 = new JLabel("Rukovodilac odjela:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(50, 215, 102, 14);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("Maksimalni broj zaposlenika:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(10, 243, 152, 14);
		panel_5.add(label_9);
		
		JList list = new JList();
		list.setEnabled(false);
		list.setBounds(190, 61, 141, 135);
		panel_5.add(list);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(190, 212, 141, 20);
		panel_5.add(textField_3);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(190, 243, 141, 20);
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
		
		JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setBounds(22, 45, 99, 23);
		panel_11.add(comboBox_17);
		
		JButton btnPretrai_1 = new JButton("Pretraži");
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
		textField_4.setBounds(166, 36, 165, 20);
		panel_8.add(textField_4);
		
		JLabel label_7 = new JLabel("Naziv:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(86, 39, 82, 14);
		panel_8.add(label_7);
		
		JLabel label_10 = new JLabel("Naziv klijenta:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(51, 70, 102, 14);
		panel_8.add(label_10);
		
		JLabel lblZaposlenici_1 = new JLabel("Zaposlenici:");
		lblZaposlenici_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici_1.setBounds(62, 95, 56, 14);
		panel_8.add(lblZaposlenici_1);
		
		JList list_3 = new JList();
		list_3.setBackground(Color.WHITE);
		list_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_3.setBounds(166, 95, 165, 63);
		panel_8.add(list_3);
		
		JLabel lblNadreeni = new JLabel("Nadređeni:");
		lblNadreeni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNadreeni.setBounds(66, 254, 102, 14);
		panel_8.add(lblNadreeni);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(166, 67, 165, 20);
		panel_8.add(textField_5);
		
		JButton btnUkloniZaposlenikaSa = new JButton("Ukloni zaposlenika sa projekta");
		btnUkloniZaposlenikaSa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUkloniZaposlenikaSa.setBounds(21, 336, 178, 23);
		panel_8.add(btnUkloniZaposlenikaSa);
		
		JLabel lblArhivirajProjekat = new JLabel("Arhiviraj projekat:");
		lblArhivirajProjekat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblArhivirajProjekat.setBounds(30, 289, 102, 14);
		panel_8.add(lblArhivirajProjekat);
		
		JCheckBox chckbxArhiviraj = new JCheckBox("");
		chckbxArhiviraj.setBounds(162, 285, 97, 23);
		panel_8.add(chckbxArhiviraj);
		
		JList list_5 = new JList();
		list_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_5.setBackground(Color.WHITE);
		list_5.setBounds(166, 169, 165, 63);
		panel_8.add(list_5);
		
		JLabel lblDodajZaposelenike = new JLabel("Dodaj zaposlenike:");
		lblDodajZaposelenike.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDodajZaposelenike.setBounds(28, 169, 90, 14);
		panel_8.add(lblDodajZaposelenike);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(166, 251, 165, 20);
		panel_8.add(comboBox_3);
		
		JButton button = new JButton("Sačuvaj promjene");
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBounds(212, 336, 119, 23);
		panel_8.add(button);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(null, "Taskovi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBounds(30, 226, 355, 166);
		projektiPanel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblPrikazTaskova = new JLabel("Prikaz taskova:");
		lblPrikazTaskova.setBounds(21, 22, 82, 14);
		panel_9.add(lblPrikazTaskova);
		
		JList list_7 = new JList();
		list_7.setBounds(21, 37, 309, 85);
		panel_9.add(list_7);
		
		JButton btnDodajTask = new JButton("Dodaj task");
		btnDodajTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		JList list_2 = new JList();
		list_2.setBounds(22, 116, 309, 209);
		panel_1.add(list_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Prikaži arhivirane korisnike");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBounds(22, 86, 170, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("Prikaži profil");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new KorisnikFormKoordinator().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(212, 336, 119, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel label_11 = new JLabel("Izaberite parametar pretrage:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(22, 29, 170, 14);
		panel_1.add(label_11);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(22, 56, 99, 23);
		panel_1.add(comboBox_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(128, 56, 124, 23);
		panel_1.add(textField_6);
		
		JButton button_1 = new JButton("Pretraži");
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
		comboBox_20.setBounds(75, 58, 197, 20);
		panel_7.add(comboBox_20);
		
		JLabel lblZaposlenik = new JLabel("Zaposlenik:");
		lblZaposlenik.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenik.setBounds(75, 89, 57, 14);
		panel_7.add(lblZaposlenik);
		
		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setBounds(75, 114, 197, 20);
		panel_7.add(comboBox_21);
		
		JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setBounds(75, 170, 197, 20);
		panel_7.add(comboBox_22);
		
		JLabel lblProjekat_1 = new JLabel("Projekat:");
		lblProjekat_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProjekat_1.setBounds(75, 145, 57, 14);
		panel_7.add(lblProjekat_1);
		
		JComboBox comboBox_23 = new JComboBox();
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
		
		JButton btnPrikazi = new JButton("Prikaži");
		btnPrikazi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrikazTimesheeta().setVisible(true);
			}			
		});
		btnPrikazi.setBounds(88, 336, 74, 23);
		panel_6.add(btnPrikazi);
		
		JButton btnOdobri = new JButton("Odobri");
		btnOdobri.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnOdobri.setBounds(172, 336, 74, 23);
		panel_6.add(btnOdobri);
		
		JButton btnNewButton_2 = new JButton("Odbij");
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
