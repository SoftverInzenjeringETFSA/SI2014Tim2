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

public class MainFormZaposlenik extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_7;
	private JPasswordField passwordField_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFormZaposlenik frame = new MainFormZaposlenik();
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
	public MainFormZaposlenik() {
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
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDatum.setBounds(68, 294, 35, 14);
		panel_4.add(lblDatum);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(135, 291, 210, 20);
		panel_4.add(spinner);
		
		
		
		
		
		
		
		
		
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
		
		JLabel label = new JLabel("Projekat:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(10, 28, 78, 20);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 321, 272);
		panel.add(scrollPane);
		
		JLabel label_1 = new JLabel("Timesheet historija:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 59, 200, 20);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Prikaz historije za odre\u0111eni vremenski interval", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(392, 22, 341, 370);
		historijaPanel.add(panel_1);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(SystemColor.controlHighlight);
		canvas.setBounds(10, 88, 321, 272);
		panel_1.add(canvas);
		
		JLabel label_2 = new JLabel("Od");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(10, 30, 46, 20);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Do");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(178, 30, 46, 20);
		panel_1.add(label_3);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(35, 30, 131, 20);
		panel_1.add(spinner_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(200, 30, 131, 20);
		panel_1.add(spinner_3);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Moj profil", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Moji podaci", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(30, 22, 341, 370);
		panel_2.add(panel_3);
		
		JLabel label_4 = new JLabel("Ime:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(93, 40, 82, 14);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Prezime:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(77, 65, 82, 14);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("Adresa:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(77, 90, 82, 14);
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("Broj Telefona:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(47, 115, 97, 14);
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("Email:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(87, 140, 46, 14);
		panel_3.add(label_8);
		
		JLabel label_9 = new JLabel("Datum zapošljavanja:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(10, 165, 113, 14);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("Odjeli:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(83, 190, 40, 14);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("Korisničko ime:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(47, 218, 82, 14);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("Lozinka:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_12.setBounds(77, 243, 46, 14);
		panel_3.add(label_12);
		
		JLabel label_13 = new JLabel("Ponovi lozinku:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_13.setBounds(47, 268, 92, 14);
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("Vrsta korisnika:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_14.setBounds(47, 293, 82, 14);
		panel_3.add(label_14);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 37, 141, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 60, 141, 20);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 85, 141, 20);
		panel_3.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(159, 113, 141, 20);
		panel_3.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(159, 138, 141, 20);
		panel_3.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(159, 215, 141, 20);
		panel_3.add(textField_6);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(159, 240, 141, 20);
		panel_3.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(159, 265, 141, 20);
		panel_3.add(passwordField_1);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_4.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_4.setBounds(159, 162, 141, 20);
		panel_3.add(spinner_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(159, 187, 141, 20);
		panel_3.add(textField_7);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(159, 290, 141, 20);
		panel_3.add(passwordField_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Promjena lozinke", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(392, 22, 341, 370);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Trenutna lozinka:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(48, 38, 83, 14);
		panel_5.add(lblNewLabel_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(162, 35, 141, 20);
		panel_5.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(162, 63, 141, 20);
		panel_5.add(textField_9);
		
		JLabel lblNovaLozinka = new JLabel("Nova lozinka:");
		lblNovaLozinka.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovaLozinka.setBounds(67, 63, 64, 14);
		panel_5.add(lblNovaLozinka);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(162, 91, 141, 20);
		panel_5.add(textField_10);
		
		JLabel lblNovaLozinkaponovo = new JLabel("Nova lozinka(ponovo):");
		lblNovaLozinkaponovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovaLozinkaponovo.setBounds(23, 94, 108, 14);
		panel_5.add(lblNovaLozinkaponovo);
		
		JButton btnSpasi = new JButton("Spasi promjenu");
		btnSpasi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSpasi.setBounds(77, 138, 110, 23);
		panel_5.add(btnSpasi);
		
		JButton btnOtkai = new JButton("Otkaži");
		btnOtkai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnOtkai.setBounds(193, 138, 110, 23);
		panel_5.add(btnOtkai);
		
	}

	private void JTable(Object rowData, TableColumnModel columnNames) {
		// TODO Auto-generated method stub
		
	}
}
