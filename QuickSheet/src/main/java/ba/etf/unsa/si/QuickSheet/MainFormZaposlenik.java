package ba.etf.unsa.si.QuickSheet;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.Lozinka;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetTaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

import java.time.LocalDate;
import java.time.Month;

import javax.swing.JTextArea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class MainFormZaposlenik extends JFrame {
	private JTextField textField;
	private JTextField txtGftfg;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_7;
	protected static final Logger LOGGER = Logger.getLogger("MainFormZaposlenik");
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_11;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFormZaposlenik frame = new MainFormZaposlenik(new ZaposlenikHibernate());
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public MainFormZaposlenik(final ZaposlenikHibernate zaposlenik) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("QuickSheet - Zaposlenik");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 548);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 764, 519);
		getContentPane().add(tabbedPane);
		setLocationRelativeTo(null);
		JPanel timeSheetPanel = new JPanel();
		timeSheetPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		
		tabbedPane.addTab("Moj Timesheet", null, timeSheetPanel, null);
		timeSheetPanel.setLayout(null);
		
		final ZaposlenikHibernate Zaposlenik = zaposlenik;
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Timesheet podaci", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_4.setBounds(30, 22, 703, 354);
		timeSheetPanel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Projekat:");
		lblNewLabel.setForeground(UIManager.getColor("TextField.highlight"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(80, 69, 46, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel_4.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		ArrayList<ProjekatHibernate> projekti = DalDao.VratiZaposlenikoveProjekte(zaposlenik.getId());
		for (int i = 0; i < projekti.size(); i++)
		comboBox.addItem(projekti.get(i));
		comboBox.setBounds(136, 69, 201, 20);
		panel_4.add(comboBox);
		
		final JLabel label_15 = new JLabel("");
		label_15.setVisible(false);
		label_15.setBounds(9, 414, 759, 14);
		timeSheetPanel.add(label_15);
		
		JButton btnNewButton = new JButton("Pošalji na reviziju");
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(531, 291, 124, 29);
		panel_4.add(btnNewButton);
		
		JLabel lblTaskovi = new JLabel("Taskovi:");
		lblTaskovi.setForeground(UIManager.getColor("TextField.highlight"));
		lblTaskovi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTaskovi.setBounds(10, 104, 46, 14);
		panel_4.add(lblTaskovi);
		
		JLabel lblBrojSati = new JLabel("Ukupan broj radnih sati:");
		lblBrojSati.setForeground(UIManager.getColor("TextField.highlight"));
		lblBrojSati.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBrojSati.setBounds(10, 248, 116, 14);
		panel_4.add(lblBrojSati);
		
		final JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		spinner_2.setBounds(136, 245, 210, 20);
		panel_4.add(spinner_2);
		
		final DefaultListModel DefaultListModel4 = new DefaultListModel();
		final JList list_3 = new JList();
		list_3.setModel(DefaultListModel4);
		JScrollPane scrollPane4 = new JScrollPane(list_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane4.setBounds(12, 122, 198, 114);
		list_3.setBounds(12, 122, 198, 114);
		panel_4.add(scrollPane4);
		
		JLabel lblProcenatZavrsenosti = new JLabel("Procenat zavrsenosti:");
		lblProcenatZavrsenosti.setForeground(UIManager.getColor("TextField.highlight"));
		lblProcenatZavrsenosti.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProcenatZavrsenosti.setBounds(216, 104, 114, 14);
		panel_4.add(lblProcenatZavrsenosti);
		
		JLabel lblBrojSati_1 = new JLabel("Broj sati:");
		lblBrojSati_1.setForeground(UIManager.getColor("TextField.highlight"));
		lblBrojSati_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBrojSati_1.setBounds(450, 104, 114, 14);
		panel_4.add(lblBrojSati_1);
		
		final JTextArea textArea = new JTextArea();
		JScrollPane scrollPane5 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane5.setBounds(216, 123, 224, 114);
		textArea.setBounds(216, 123, 224, 114);
		panel_4.add(scrollPane5);
		
		final JTextArea textArea_1 = new JTextArea();
		JScrollPane scrollPane6 = new JScrollPane(textArea_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane6.setBounds(450, 124, 224, 114);
		textArea_1.setBounds(450, 124, 224, 114);
		panel_4.add(scrollPane6);
		
		JButton button = new JButton("Odjava");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.Window win[] = java.awt.Window.getWindows();
				for (int i = 0; i < win.length; i++) {
					win[i].dispose();
				}
				Login loginW = new Login();
				loginW.setVisible(true);
			}
		});
		button.setForeground(UIManager.getColor("Button.foreground"));
		button.setFont(new Font("Tahoma", Font.BOLD, 10));
		button.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button.setBounds(613, 384, 89, 23);
		timeSheetPanel.add(button);
		
		JPanel historijaPanel = new JPanel();
		historijaPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.addTab("Moja Historija", null, historijaPanel, null);
		historijaPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prikaz historije timesheet - ova za odre\u0111eni projekat", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel.setBounds(30, 22, 341, 370);
		historijaPanel.add(panel);
		
		final JComboBox comboBox_1 = new JComboBox();
		
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(155, 28, 141, 20);
		panel.add(comboBox_1);
		
		JLabel label = new JLabel("Projekat:");
		label.setForeground(UIManager.getColor("TextField.highlight"));
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(10, 28, 78, 20);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Timesheet historija:");
		label_1.setForeground(UIManager.getColor("TextField.highlight"));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 59, 200, 20);
		panel.add(label_1);
		
		final DefaultListModel DefaultListModel1 = new DefaultListModel();
		JList list_1 = new JList();
		list_1.setModel(DefaultListModel1);
		list_1.setEnabled(false);
		JScrollPane scrollPane3 = new JScrollPane(list_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane3.setBounds(10, 78, 321, 281);
		list_1.setBounds(10, 78, 321, 281);
		panel.add(scrollPane3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prikaz historije za odre\u0111eni vremenski interval", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_1.setBounds(392, 22, 341, 370);
		historijaPanel.add(panel_1);
		
		JLabel lblIliPrikazZa = new JLabel("Prikaz za određeni mjesec:");
		lblIliPrikazZa.setForeground(UIManager.getColor("TextField.highlight"));
		lblIliPrikazZa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIliPrikazZa.setBounds(10, 28, 156, 14);
		panel_1.add(lblIliPrikazZa);
		
		final JComboBox comboBox_2 = new JComboBox();
		
		comboBox_2.setModel(new DefaultComboBoxModel(Month.values()));
		comboBox_2.setBounds(200, 25, 131, 20);
		panel_1.add(comboBox_2);
		
		final DefaultListModel DefaultListModel2 = new DefaultListModel();
		JList list_2 = new JList();
		list_2.setModel(DefaultListModel2);
		list_2.setEnabled(false);
		JScrollPane scrollPane2 = new JScrollPane(list_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setBounds(10, 79, 321, 280);
		list_2.setBounds(10, 79, 321, 280);
		panel_1.add(scrollPane2);
		
		JButton button_1 = new JButton("Odjava");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.Window win[] = java.awt.Window.getWindows();
				for (int i = 0; i < win.length; i++) {
					win[i].dispose();
				}
				Login loginW = new Login();
				loginW.setVisible(true);
			}
		});
		button_1.setForeground(UIManager.getColor("Button.foreground"));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_1.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button_1.setBounds(622, 398, 89, 23);
		historijaPanel.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("TextField.darkShadow"));
		
		tabbedPane.addTab("Moj profil", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Moji podaci", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_3.setBounds(30, 22, 341, 412);
		panel_2.add(panel_3);
		
		JLabel label_4 = new JLabel("Ime:");
		label_4.setForeground(UIManager.getColor("TextField.highlight"));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(93, 40, 82, 14);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Prezime:");
		label_5.setForeground(UIManager.getColor("TextField.highlight"));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(77, 65, 82, 14);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("Adresa:");
		label_6.setForeground(UIManager.getColor("TextField.highlight"));
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(77, 90, 82, 14);
		panel_3.add(label_6);
		
		JLabel label_9 = new JLabel("Datum zapošljavanja:");
		label_9.setForeground(UIManager.getColor("TextField.highlight"));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(10, 194, 113, 14);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("Odjeli:");
		label_10.setForeground(UIManager.getColor("TextField.highlight"));
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(83, 220, 40, 14);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("Korisničko ime:");
		label_11.setForeground(UIManager.getColor("TextField.highlight"));
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(47, 326, 82, 14);
		panel_3.add(label_11);
		
		JLabel label_14 = new JLabel("Vrsta korisnika:");
		label_14.setForeground(UIManager.getColor("TextField.highlight"));
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_14.setBounds(47, 356, 82, 14);
		panel_3.add(label_14);
		
		txtGftfg = new JTextField();
		txtGftfg.setBorder(null);
		txtGftfg.setEditable(false);
		txtGftfg.setBackground(Color.WHITE);
		txtGftfg.setEnabled(false);
		txtGftfg.setDisabledTextColor(Color.BLACK);
		txtGftfg.setColumns(10);
		txtGftfg.setBounds(159, 37, 141, 20);
		panel_3.add(txtGftfg);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setDisabledTextColor(Color.BLACK);
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(159, 62, 141, 20);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setDisabledTextColor(Color.BLACK);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(159, 87, 141, 20);
		panel_3.add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setDisabledTextColor(Color.BLACK);
		textField_6.setBorder(null);
		textField_6.setBackground(Color.WHITE);
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(159, 323, 141, 20);
		panel_3.add(textField_6);
		
		JLabel lblSatnica = new JLabel("Satnica:");
		lblSatnica.setForeground(UIManager.getColor("TextField.highlight"));
		lblSatnica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSatnica.setBounds(77, 166, 40, 14);
		panel_3.add(lblSatnica);
		
		final DefaultListModel defaultListModel = new DefaultListModel();
		JList list = new JList();
		list.setModel(defaultListModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setEnabled(false);
		list.setBackground(Color.WHITE);
		JScrollPane scrollPane1 = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setBounds(159, 219, 141, 97);
		list.setBounds(159, 165, 141, 97);
		panel_3.add(scrollPane1);
		
		textField_7 = new JTextField();
		textField_7.setDisabledTextColor(Color.BLACK);
		textField_7.setEnabled(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(159, 353, 141, 20);
		panel_3.add(textField_7);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(87, 115, 59, 14);
		panel_3.add(lblEmail);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefon.setBounds(77, 143, 59, 14);
		panel_3.add(lblTelefon);
		
		textField_1 = new JTextField();
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(159, 112, 141, 20);
		panel_3.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setDisabledTextColor(Color.BLACK);
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(159, 140, 141, 20);
		panel_3.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setDisabledTextColor(Color.BLACK);
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(159, 163, 141, 20);
		panel_3.add(textField_5);
		
		textField_11 = new JTextField();
		textField_11.setDisabledTextColor(Color.BLACK);
		textField_11.setEnabled(false);
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBorder(null);
		textField_11.setBackground(Color.WHITE);
		textField_11.setBounds(159, 191, 141, 20);
		panel_3.add(textField_11);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Promjena lozinke", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_5.setBounds(392, 22, 341, 412);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Trenutna lozinka:");
		lblNewLabel_1.setForeground(UIManager.getColor("TextField.highlight"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(48, 38, 83, 14);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNovaLozinka = new JLabel("Nova lozinka:");
		lblNovaLozinka.setForeground(UIManager.getColor("TextField.highlight"));
		lblNovaLozinka.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovaLozinka.setBounds(67, 63, 64, 14);
		panel_5.add(lblNovaLozinka);
		
		JLabel lblNovaLozinkaponovo = new JLabel("Nova lozinka(ponovo):");
		lblNovaLozinkaponovo.setForeground(UIManager.getColor("TextField.highlight"));
		lblNovaLozinkaponovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovaLozinkaponovo.setBounds(23, 88, 108, 14);
		panel_5.add(lblNovaLozinkaponovo);
		
		final JLabel label_16 = new JLabel("");
		label_16.setForeground(Color.RED);
		label_16.setVisible(false);
		label_16.setBounds(0, 469, 759, 22);
		panel_2.add(label_16);

		JButton btnSpasi = new JButton("Spasi promjenu");
		btnSpasi.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnSpasi.setForeground(UIManager.getColor("Button.foreground"));
		btnSpasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				try {
					String staraLozinka = new String(passwordField.getPassword());
					String novaLozinka = new String(passwordField_1.getPassword());
					String novaLozinkaRepeat = new String(passwordField_2.getPassword());
					
					if(staraLozinka.length() < 7) {
						greska = false;
						label_16.setText("Unesite trenutnu lozinku!");
					}
					if (!Lozinka.validatePassword(staraLozinka, Zaposlenik.getLozinka()))
					{
						greska = false;
						label_16.setText("Neispravan unos trenutne lozinke!");
					}
					if(novaLozinka.length() < 7 || novaLozinkaRepeat.length() < 7){
						greska = false;
						label_16.setText("Lozinka mora imati najmanje 7 karaktera!");
					}
					if(!novaLozinka.equals(novaLozinkaRepeat)) {
						greska = false;
						label_16.setText("Lozinke se ne poklapaju!");
					}
					if(!novaLozinka.matches("^[a-zA-Z0-9]*$")) {
						greska = false;
						label_16.setText("Neispravan format lozinke (koristite samo slova engleskog alfabeta i brojeve)!");
					}
					if(greska == false){
						label_16.setVisible(true);
					}
					else 
					{
						label_16.setVisible(false);
						Zaposlenik.setLozinka(Lozinka.generateStorngPasswordHash(novaLozinka));
						DalDao.ModifikujObjekat(Zaposlenik);
						JOptionPane.showMessageDialog(null, "Uspjesno ste promjenili lozinku!", "Lozinka promjenjena", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception ex) {
					label_16.setVisible(true);
					label_16.setText("Neispravan unos lozinke!");
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
		});
		
		btnSpasi.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSpasi.setBounds(67, 138, 120, 23);
		panel_5.add(btnSpasi);
		
		JButton btnOtkai = new JButton("Otkaži");
		btnOtkai.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnOtkai.setForeground(UIManager.getColor("Button.foreground"));
		btnOtkai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
				passwordField_1.setText("");
				passwordField_2.setText("");
				label_16.setVisible(false);
			}
		});
		
		btnOtkai.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOtkai.setBounds(193, 138, 110, 23);
		panel_5.add(btnOtkai);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 35, 139, 20);
		panel_5.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(164, 60, 139, 20);
		panel_5.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(164, 85, 139, 20);
		panel_5.add(passwordField_2);
		
		JButton button_2 = new JButton("Odjava");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.Window win[] = java.awt.Window.getWindows();
				for (int i = 0; i < win.length; i++) {
					win[i].dispose();
				}
				Login loginW = new Login();
				loginW.setVisible(true);
			}
		});
		button_2.setForeground(UIManager.getColor("Button.foreground"));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_2.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button_2.setBounds(626, 438, 89, 23);
		panel_2.add(button_2);
		
		panel_2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				txtGftfg.setText(Zaposlenik.getIme());
				textField_2.setText(Zaposlenik.getPrezime());
				textField_3.setText(Zaposlenik.getAdresa());
				
				ArrayList<OdjelHibernate> listaOdjela = DalDao.VratiZaposlenikoveOdjele(Zaposlenik.getId());
				for(OdjelHibernate odjel : listaOdjela) {
					defaultListModel.addElement(odjel);
				}
				textField_6.setText(Zaposlenik.getUsername());
				textField_1.setText(Zaposlenik.getEmail());
				textField_4.setText(Zaposlenik.getTelefon());
				textField_7.setText("Zaposlenik");
				Double satnica = Zaposlenik.getSatnica();
				textField_5.setText(satnica.toString());
				textField_11.setText(Zaposlenik.getDatumZaposlenja().toString());
			}
		});
		
		timeSheetPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				textArea.setText("");
				textArea_1.setText("");
				DefaultListModel4.removeAllElements();
				comboBox.removeAllItems();
				list_3.removeAll();
				ArrayList<ProjekatHibernate> projekti = DalDao.VratiZaposlenikoveProjekte(Zaposlenik.getId());
				for(ProjekatHibernate projekat: projekti) {
					comboBox.addItem(projekat);
				}
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//promjeniti 
				DefaultListModel4.removeAllElements();
				ProjekatHibernate ph = (ProjekatHibernate)comboBox.getSelectedItem();
				ArrayList<TaskHibernate> taskovi = DalDao.VratiTaskoveZaposlenikaNaProjektu(ph.getId(), zaposlenik.getId());
				String temp1 = "";
				String temp2 = "";
				for(TaskHibernate task : taskovi) {
					if(task.getProcenatZavrsenosti().equals(100)) continue;
					DefaultListModel4.addElement(task);
					temp1 += task.getProcenatZavrsenosti().toString() + "\n";
					temp2 += "0\n";
				}
				textArea.setText(temp1);
				textArea_1.setText(temp2);
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultListModel1.removeAllElements();
					ProjekatHibernate selectedProjec = (ProjekatHibernate)comboBox_1.getSelectedItem();
					if(selectedProjec != null) {
						ArrayList<TimesheetHibernate> timesheets = DalDao.VratiTimesheetoveZaposlenikaNaProjektu(selectedProjec.getId(), Zaposlenik.getId());
						for(TimesheetHibernate timesheet : timesheets) {
							DefaultListModel1.addElement(timesheet);
						}
					}
					
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
 			}
		});
		
		historijaPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					comboBox_1.removeAllItems();
					ArrayList<ProjekatHibernate> projekti = DalDao.VratiZaposlenikoveProjekte(Zaposlenik.getId());
					for(ProjekatHibernate projekat: projekti) {
						comboBox_1.addItem(projekat);
					}
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
		});
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultListModel2.removeAllElements();
					Month mjesec = (Month)comboBox_2.getSelectedItem();
					ArrayList<TimesheetHibernate> timesheets = DalDao.VratiTimesheetoveZaposlenikaZaMjesec(Zaposlenik.getId(), mjesec);
					for(TimesheetHibernate item : timesheets) {
						DefaultListModel2.addElement(item);
					}
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
		});
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_UP) || (c == KeyEvent.VK_LEFT) || (c == KeyEvent.VK_DOWN)  || (c == KeyEvent.VK_ENTER)|| (c == KeyEvent.VK_PERIOD))) {
					e.consume();
				}
				
			}
		});
		
		textArea_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)|| (c == KeyEvent.VK_UP) || (c == KeyEvent.VK_LEFT) || (c == KeyEvent.VK_DOWN) || (c == KeyEvent.VK_PERIOD))) {
					e.consume();
				}
			}
		});
		
		textArea_1.addInputMethodListener(new InputMethodListener() {
			public void inputMethodTextChanged(InputMethodEvent event) {
				try {
					String[] sati = textArea_1.getText().split("\n");
					spinner_2.setValue(new Double(0.0));
					for(String sat: sati) {
						Double temp = Double.parseDouble(sat);
						Double vrijednost = new Double ((Double)spinner_2.getValue() + temp);
						spinner_2.setValue(vrijednost);
					}
					
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
			
			public void caretPositionChanged(InputMethodEvent event) {
				try {
					String[] sati = textArea_1.getText().split("\n");
					spinner_2.setValue(0.0);
					for(String sat: sati) {
						Double temp = Double.parseDouble(sat);
						spinner_2.setValue((Double)spinner_2.getValue() + temp);
					}
					
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TimesheetHibernate timesheet = new TimesheetHibernate();
					timesheet.setBrojRadnihSati((Integer)spinner_2.getValue());
					timesheet.setDatumSlanja(LocalDate.now());
					timesheet.setProjekat((ProjekatHibernate)comboBox.getSelectedItem());
					timesheet.setValidiran(false);
					DalDao.DodajObjekat(timesheet);
					String[] sati = textArea_1.getText().split("\n");
					String[] procenti = textArea.getText().split("\n");
					spinner_2.setValue(0.0);
					for(String sat: sati) {
						Double temp = Double.parseDouble(sat);
						spinner_2.setValue((Double)spinner_2.getValue() + temp);
					}
					
					for(int i = 0; i < list_3.getModel().getSize(); i++) {
						TaskHibernate task = (TaskHibernate)list_3.getModel().getElementAt(i);
						task.setProcenatZavrsenosti(Integer.parseInt(procenti[i]));
						DalDao.ModifikujObjekat(task);
						TimesheetTaskHibernate tt = new TimesheetTaskHibernate();
						tt.setTask(task);
						tt.setTimesheet(timesheet);
						DalDao.DodajObjekat(tt);
					}
					JOptionPane.showMessageDialog(null, "Uspjesno ste poslali timesheet na reviziju!", "Timesheet poslat", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
			
		});
	}
}
