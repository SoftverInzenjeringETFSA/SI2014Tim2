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

public class MainFormKoordinator extends JFrame {
	private JTextField textField;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_42;

	
	

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
		spinner_2.setModel(new SpinnerNumberModel(0.0, 0.0, 12.0, 1.0));
		spinner_2.setBounds(136, 245, 210, 20);
		panel_4.add(spinner_2);
		
		
		
		
		
		
		
		
		
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Pretraga odjela", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(30, 22, 355, 370);
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
		list_4.setBounds(22, 87, 309, 272);
		panel_3.add(list_4);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Prikaži arhivirane odjele");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox_1.setBounds(22, 57, 149, 23);
		panel_3.add(chckbxNewCheckBox_1);
		
		JPanel korisniciPanel = new JPanel();
		tabbedPane.addTab("Korisnici", null, korisniciPanel, null);
		korisniciPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pretraga korisnika", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(30, 22, 355, 370);
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
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga projekta", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_11.setBounds(30, 22, 355, 370);
		projektiPanel.add(panel_11);
		
		JCheckBox chckbxPrikaziArhiviraneProjekte = new JCheckBox("Prikazi arhivirane projekte");
		chckbxPrikaziArhiviraneProjekte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxPrikaziArhiviraneProjekte.setBounds(22, 57, 149, 23);
		panel_11.add(chckbxPrikaziArhiviraneProjekte);
		
		JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setBounds(165, 30, 85, 23);
		panel_11.add(comboBox_17);
		
		JButton btnPretrai_1 = new JButton("Pretraži");
		btnPretrai_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPretrai_1.setBounds(265, 30, 69, 23);
		panel_11.add(btnPretrai_1);
		
		textField_46 = new JTextField();
		textField_46.setBounds(22, 30, 133, 23);
		panel_11.add(textField_46);
		textField_46.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setBounds(22, 87, 309, 243);
		panel_11.add(list_1);
		
		JButton button = new JButton("Sačuvaj promjene");
		button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button.setBounds(215, 336, 119, 23);
		panel_11.add(button);
		
		JPanel izvjestajiPanel = new JPanel();
		tabbedPane.addTab("Izvještaji", null, izvjestajiPanel, null);
		izvjestajiPanel.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Izvje\u0161taj", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(408, 22, 341, 370);
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
		lblNewLabel_11.setBounds(75, 33, 57, 14);
		panel_7.add(lblNewLabel_11);
		
		JComboBox comboBox_20 = new JComboBox();
		comboBox_20.setBounds(75, 58, 197, 20);
		panel_7.add(comboBox_20);
		
		JLabel lblZaposlenik = new JLabel("Zaposlenik:");
		lblZaposlenik.setBounds(75, 89, 57, 14);
		panel_7.add(lblZaposlenik);
		
		JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setBounds(75, 114, 197, 20);
		panel_7.add(comboBox_21);
		
		JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setBounds(75, 170, 197, 20);
		panel_7.add(comboBox_22);
		
		JLabel lblProjekat_1 = new JLabel("Projekat:");
		lblProjekat_1.setBounds(75, 145, 57, 14);
		panel_7.add(lblProjekat_1);
		
		JComboBox comboBox_23 = new JComboBox();
		comboBox_23.setBounds(75, 226, 197, 20);
		panel_7.add(comboBox_23);
		
		JLabel lblMjesevc = new JLabel("Izvjestaj za mjesec:");
		lblMjesevc.setBounds(75, 201, 116, 14);
		panel_7.add(lblMjesevc);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(203, 229, 46, 14);
		panel_7.add(label_15);
		
		JLabel lblIliIzvjestajZa = new JLabel("Ili, izvjestaj za vremenski period:");
		lblIliIzvjestajZa.setBounds(75, 264, 197, 14);
		panel_7.add(lblIliIzvjestajZa);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(76, 289, 46, 14);
		panel_7.add(lblOd);
		
		JLabel lblDo_1 = new JLabel("Do:");
		lblDo_1.setBounds(177, 289, 46, 14);
		panel_7.add(lblDo_1);
		
		JButton btnNewButton_3 = new JButton("Generisi izvjestaj");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_3.setBounds(75, 336, 197, 23);
		panel_7.add(btnNewButton_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1431986400000L), new Date(1431986400000L), null, Calendar.YEAR));
		spinner.setBounds(106, 286, 61, 20);
		panel_7.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1431986400000L), new Date(1431986400000L), null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(203, 286, 61, 20);
		panel_7.add(spinner_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 380, 309, -349);
		izvjestajiPanel.add(scrollPane_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Timesheet validacija", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(30, 22, 355, 370);
		izvjestajiPanel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblImenkoPrezimenkovic = new JLabel("Zahtjevi za reviziju i odobravanje timesheeta:");
		lblImenkoPrezimenkovic.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImenkoPrezimenkovic.setBounds(24, 41, 240, 14);
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
		list_6.setBounds(24, 76, 305, 249);
		panel_6.add(list_6);
		
	}

	private void JTable(Object rowData, TableColumnModel columnNames) {
		// TODO Auto-generated method stub
		
	}
}
