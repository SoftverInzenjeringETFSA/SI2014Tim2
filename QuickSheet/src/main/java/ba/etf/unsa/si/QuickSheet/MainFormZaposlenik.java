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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import java.awt.Rectangle;
import javax.swing.DefaultComboBoxModel;

public class MainFormZaposlenik extends JFrame {
	private JTextField textField;
	private JTextField txtGftfg;
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
	private JTable table;

	
	

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
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("QuickSheet - Zaposlenik");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 478);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 764, 453);
		getContentPane().add(tabbedPane);
		setLocationRelativeTo(null);
		JPanel timeSheetPanel = new JPanel();
		tabbedPane.addTab("Moj Timesheet", null, timeSheetPanel, null);
		timeSheetPanel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Timesheet podaci", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(30, 22, 703, 354);
		timeSheetPanel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Projekat:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(80, 69, 46, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_4.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"projekat 1", "projekat 2"}));
		comboBox.setBounds(136, 69, 201, 20);
		panel_4.add(comboBox);
		
		final JLabel label_15 = new JLabel("");
		label_15.setVisible(false);
		label_15.setBounds(0, 387, 759, 14);
		timeSheetPanel.add(label_15);
		
		
		JButton btnNewButton = new JButton("Pošalji na reviziju");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(comboBox.getSelectedIndex() == -1){
					greska = false;
					label_15.setText("Morate označiti parametar pretrage!");
					
				}
				else if(table.getModel().getValueAt(0,0) == null || table.getModel().getValueAt(0,1) == null || table.getModel().getValueAt(0,2) == null){
					greska = false;
					label_15.setText("Morate popuniti barem jedan task da bi poslali timesheet na reviziju!");
				}
				
				else greska = true;
					
				if(greska == false){ 
					label_15.setVisible(true);
					}
				
				else{
					label_15.setVisible(false);
				}
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		spinner_2.setBounds(136, 245, 210, 20);
		panel_4.add(spinner_2);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDatum.setBounds(91, 298, 35, 14);
		panel_4.add(lblDatum);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(135, 291, 210, 20);
		panel_4.add(spinner);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(new Rectangle(0, 0, 100, 100));
		scrollPane_1.setBounds(136, 120, 519, 106);
		panel_4.add(scrollPane_1);
		
		table = new JTable();
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
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(119);
		table.getColumnModel().getColumn(1).setPreferredWidth(140);
		table.setBounds(new Rectangle(10, 10, 100, 1000));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setRowSelectionAllowed(true);
		scrollPane_1.setViewportView(table);
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel historijaPanel = new JPanel();
		tabbedPane.addTab("Moja Historija", null, historijaPanel, null);
		historijaPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prikaz historije timesheet - ova za odre\u0111eni projekat", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(30, 22, 341, 370);
		historijaPanel.add(panel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
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
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_1.setModel(new SpinnerDateModel(new Date(1432159200000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(35, 30, 131, 20);
		panel_1.add(spinner_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_3.setModel(new SpinnerDateModel(new Date(1432159200000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_3.setBounds(200, 30, 131, 20);
		panel_1.add(spinner_3);
		
		JLabel lblIliPrikazZa = new JLabel("Ili, prikaz za određeni mjesec:");
		lblIliPrikazZa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIliPrikazZa.setBounds(10, 61, 156, 14);
		panel_1.add(lblIliPrikazZa);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(200, 61, 131, 20);
		panel_1.add(comboBox_2);
		
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
		
		txtGftfg = new JTextField();
		txtGftfg.setBorder(null);
		txtGftfg.setEditable(false);
		txtGftfg.setBackground(Color.WHITE);
		txtGftfg.setEnabled(false);
		txtGftfg.setDisabledTextColor(new Color(109, 109, 109));
		txtGftfg.setColumns(10);
		txtGftfg.setBounds(159, 37, 141, 20);
		panel_3.add(txtGftfg);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setDisabledTextColor(Color.LIGHT_GRAY);
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(159, 62, 141, 20);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(159, 87, 141, 20);
		panel_3.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(159, 113, 141, 20);
		panel_3.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(159, 138, 141, 20);
		panel_3.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBorder(null);
		textField_6.setBackground(Color.WHITE);
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(159, 215, 141, 20);
		panel_3.add(textField_6);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setBackground(Color.WHITE);
		passwordField.setEnabled(false);
		passwordField.setEditable(false);
		passwordField.setBounds(159, 240, 141, 20);
		panel_3.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(Color.WHITE);
		passwordField_1.setEnabled(false);
		passwordField_1.setEditable(false);
		passwordField_1.setBounds(159, 265, 141, 20);
		panel_3.add(passwordField_1);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBorder(new CompoundBorder());
		spinner_4.setBackground(Color.WHITE);
		spinner_4.setEnabled(false);
		spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_4.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_4.setBounds(159, 162, 141, 20);
		panel_3.add(spinner_4);
		
		textField_7 = new JTextField();
		textField_7.setBorder(null);
		textField_7.setBackground(Color.WHITE);
		textField_7.setEnabled(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(159, 189, 141, 20);
		panel_3.add(textField_7);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBorder(null);
		passwordField_2.setBackground(Color.WHITE);
		passwordField_2.setEnabled(false);
		passwordField_2.setEditable(false);
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
		
		final JLabel label_16 = new JLabel("");
		label_16.setVisible(false);
		label_16.setBounds(0, 411, 759, 14);
		panel_2.add(label_16);

		
		JButton btnSpasi = new JButton("Spasi promjenu");
		btnSpasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				if(textField_8.getText().equals("")){
					greska = false;
					label_16.setText("Unesite trenutnu lozinku!");
				}
				else if(textField_9.getText().equals("")){
					greska = false;
					label_16.setText("Unesite novu lozinku!");
				}
				else if(textField_10.getText().equals("")){
					greska = false;
					label_16.setText("Unesite ponovo novu lozinku!");
				}
				else if(!textField_9.getText().equals(textField_10.getText())){
					greska = false;
					label_16.setText("Lozinke se ne podudaraju!");
				}
				else greska = true;
				if(greska == false){
					label_16.setVisible(true);
				}
				else label_16.setVisible(false);
			}
		});
		btnSpasi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSpasi.setBounds(77, 138, 110, 23);
		panel_5.add(btnSpasi);
		
		JButton btnOtkai = new JButton("Otkaži");
		btnOtkai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				label_16.setVisible(false);
			}
		});
		btnOtkai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnOtkai.setBounds(193, 138, 110, 23);
		panel_5.add(btnOtkai);
		
		
		
		
	}

	private void JTable(Object rowData, TableColumnModel columnNames) {
		// TODO Auto-generated method stub
		
	}
}
