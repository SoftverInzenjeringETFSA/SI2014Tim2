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

public class MainFormZaposlenik extends JFrame {
	private JTextField textField;
	private JTextField txtGftfg;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_7;
	protected static final Logger LOGGER = Logger.getLogger("MainFormZaposlenik");

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

	public MainFormZaposlenik(ZaposlenikHibernate zaposlenik) {
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
		label_15.setBounds(0, 387, 759, 14);
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
		list_3.setBounds(12, 122, 198, 114);
		panel_4.add(list_3);
		
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
		
		textArea.setBounds(216, 123, 224, 114);
		panel_4.add(textArea);
		
		final JTextArea textArea_1 = new JTextArea();
		
		textArea_1.setBounds(450, 124, 224, 114);
		panel_4.add(textArea_1);
		
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
		list_1.setBounds(10, 78, 321, 281);
		panel.add(list_1);
		
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
		list_2.setBounds(10, 79, 321, 280);
		panel_1.add(list_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("TextField.darkShadow"));
		
		tabbedPane.addTab("Moj profil", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Moji podaci", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_3.setBounds(30, 22, 341, 370);
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
		label_9.setBounds(10, 140, 113, 14);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("Odjeli:");
		label_10.setForeground(UIManager.getColor("TextField.highlight"));
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(83, 166, 40, 14);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("Korisničko ime:");
		label_11.setForeground(UIManager.getColor("TextField.highlight"));
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(47, 272, 82, 14);
		panel_3.add(label_11);
		
		JLabel label_14 = new JLabel("Vrsta korisnika:");
		label_14.setForeground(UIManager.getColor("TextField.highlight"));
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_14.setBounds(47, 302, 82, 14);
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
		
		textField_6 = new JTextField();
		textField_6.setBorder(null);
		textField_6.setBackground(Color.WHITE);
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(159, 269, 141, 20);
		panel_3.add(textField_6);
		
		final JSpinner spinner_4 = new JSpinner();
		spinner_4.setBorder(new CompoundBorder());
		spinner_4.setBackground(Color.WHITE);
		spinner_4.setEnabled(false);
		spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_4.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_4.setBounds(159, 137, 141, 20);
		panel_3.add(spinner_4);
		
		final JSpinner spinner_5 = new JSpinner();
		spinner_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_5.setEnabled(false);
		spinner_5.setBorder(new CompoundBorder());
		spinner_5.setBackground(Color.WHITE);
		spinner_5.setBounds(159, 114, 141, 20);
		panel_3.add(spinner_5);
		
		JLabel lblSatnica = new JLabel("Satnica:");
		lblSatnica.setForeground(UIManager.getColor("TextField.highlight"));
		lblSatnica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSatnica.setBounds(77, 117, 40, 14);
		panel_3.add(lblSatnica);
		
		final DefaultListModel defaultListModel = new DefaultListModel();
		JList list = new JList();
		list.setModel(defaultListModel);
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setEnabled(false);
		list.setBackground(Color.WHITE);
		list.setBounds(159, 165, 141, 97);
		panel_3.add(list);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(159, 299, 141, 20);
		panel_3.add(textField_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Promjena lozinke", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_5.setBounds(392, 22, 341, 370);
		panel_2.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Trenutna lozinka:");
		lblNewLabel_1.setForeground(UIManager.getColor("TextField.highlight"));
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
		lblNovaLozinka.setForeground(UIManager.getColor("TextField.highlight"));
		lblNovaLozinka.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovaLozinka.setBounds(67, 63, 64, 14);
		panel_5.add(lblNovaLozinka);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(162, 91, 141, 20);
		panel_5.add(textField_10);
		
		JLabel lblNovaLozinkaponovo = new JLabel("Nova lozinka(ponovo):");
		lblNovaLozinkaponovo.setForeground(UIManager.getColor("TextField.highlight"));
		lblNovaLozinkaponovo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNovaLozinkaponovo.setBounds(23, 94, 108, 14);
		panel_5.add(lblNovaLozinkaponovo);
		
		final JLabel label_16 = new JLabel("");
		label_16.setVisible(false);
		label_16.setBounds(0, 411, 759, 14);
		panel_2.add(label_16);

		JButton btnSpasi = new JButton("Spasi promjenu");
		btnSpasi.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnSpasi.setForeground(UIManager.getColor("Button.foreground"));
		btnSpasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				try {
					if(Lozinka.validatePassword(textField_8.getText(), Zaposlenik.getLozinka()) && 
							!textField_8.getText().equals("") && !textField_9.getText().equals("") && 
							!textField_10.getText().equals("") && textField_9.getText().equals(textField_10.getText())){
								Zaposlenik.setLozinka(Lozinka.generateStorngPasswordHash(textField_10.getText()));
								DalDao.ModifikujObjekat(Zaposlenik);
								JOptionPane.showMessageDialog(null, "Uspjesno ste promjenili lozinku!", "Info", JOptionPane.INFORMATION_MESSAGE );
					}
					else if(textField_8.getText().equals("")) {
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
					else if(!textField_9.getText().equals(textField_10.getText())) {
						greska = false;
						label_16.setText("Lozinke se ne poklapaju!");
					}
					else if(!Lozinka.validatePassword(textField_8.getText(), Zaposlenik.getLozinka())) {
						greska = false;
						label_16.setText("Pogresna lozinka!");
					}
					else { 
						greska = true;
					}
					if(greska == false){
						label_16.setVisible(true);
					}
					else label_16.setVisible(false);
				}
				catch(Exception ex) {
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
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				label_16.setVisible(false);
			}
		});
		
		btnOtkai.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOtkai.setBounds(193, 138, 110, 23);
		panel_5.add(btnOtkai);
		
		panel_2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				txtGftfg.setText(Zaposlenik.getIme());
				textField_2.setText(Zaposlenik.getPrezime());
				textField_3.setText(Zaposlenik.getAdresa());
				spinner_5.setValue(Zaposlenik.getSatnica());
				Calendar calendar = Calendar.getInstance();
				calendar.set(Zaposlenik.getDatumZaposlenja().getYear(), Zaposlenik.getDatumZaposlenja().getMonthValue(), Zaposlenik.getDatumZaposlenja().getDayOfMonth());
				Date temp = calendar.getTime();
				spinner_4.setValue(temp);
				ArrayList<OdjelHibernate> listaOdjela = DalDao.VratiZaposlenikoveOdjele(Zaposlenik.getId());
				for(OdjelHibernate odjel : listaOdjela) {
					defaultListModel.addElement(odjel);
				}
				textField_6.setText(Zaposlenik.getUsername());
				textField_7.setText("Zaposlenik");
			}
		});
		
		timeSheetPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				comboBox.removeAllItems();
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
				ArrayList<TaskHibernate> taskovi = DalDao.VratiSveTaskoveProjekta(ph.getId());
				String temp = "";
				for(TaskHibernate task : taskovi) {
					DefaultListModel4.addElement(task);
					temp += "0\n";
				}
				textArea.setText(temp);
				textArea_1.setText(temp);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				spinner_2.setValue(0.0);
				String[] sati = textArea_1.getText().split("\n");
				spinner_2.setValue(0.0);
				for(String sat: sati) {
					Double temp = Double.parseDouble(sat);
					spinner_2.setValue((Double)spinner_2.getValue() + temp);
			}
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
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)|| (c == KeyEvent.VK_PERIOD))) {
					e.consume();
				}
				
			}
		});
		
		textArea_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_PERIOD))) {
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
					String[] procenti = textArea_1.getText().split("\n");
					
					for(int i = 0; i < list_3.getModel().getSize(); i++) {
						TaskHibernate task = (TaskHibernate)list_3.getModel().getElementAt(i);
						task.setProcenatZavrsenosti(Integer.getInteger(procenti[i]));
						DalDao.ModifikujObjekat(task);
						TimesheetTaskHibernate tt = new TimesheetTaskHibernate();
						tt.setTask(task);
						tt.setTimesheet(timesheet);
						DalDao.DodajObjekat(tt);
					}
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
			
		});
	}
}
