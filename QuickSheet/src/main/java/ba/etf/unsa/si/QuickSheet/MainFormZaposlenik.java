package ba.etf.unsa.si.QuickSheet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.Lozinka;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

import java.time.Month;

public class MainFormZaposlenik extends JFrame {
	private JTextField textField;
	private JTextField txtGftfg;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table;
	private JTextField textField_7;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFormZaposlenik frame = new MainFormZaposlenik(new ZaposlenikHibernate());
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
		
		tabbedPane.addTab("Moj Timesheet", null, timeSheetPanel, null);
		timeSheetPanel.setLayout(null);
		
		final ZaposlenikHibernate Zaposlenik = zaposlenik;
		
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
		historijaPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
		tabbedPane.addTab("Moja Historija", null, historijaPanel, null);
		historijaPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prikaz historije timesheet - ova za odre\u0111eni projekat", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(30, 22, 341, 370);
		historijaPanel.add(panel);
		
		final JComboBox comboBox_1 = new JComboBox();
		
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(155, 28, 141, 20);
		panel.add(comboBox_1);
		
		JLabel label = new JLabel("Projekat:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(10, 28, 78, 20);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Timesheet historija:");
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
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Prikaz historije za odre\u0111eni vremenski interval", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(392, 22, 341, 370);
		historijaPanel.add(panel_1);
		
		JLabel lblIliPrikazZa = new JLabel("Prikaz za određeni mjesec:");
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
		list_2.setBounds(10, 53, 321, 306);
		panel_1.add(list_2);
		
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
		
		JLabel label_9 = new JLabel("Datum zapošljavanja:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(10, 140, 113, 14);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("Odjeli:");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(83, 166, 40, 14);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("Korisničko ime:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(47, 272, 82, 14);
		panel_3.add(label_11);
		
		JLabel label_14 = new JLabel("Vrsta korisnika:");
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
					
				}
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
				ArrayList<TaskHibernate> taskovi = DalDao.VratiSveTaskoveProjekta(Long.parseUnsignedLong(comboBox.getSelectedItem().toString().split(" ")[0]));
				for(TaskHibernate task : taskovi) {
					
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
					
				}
			}
		});
	}

	private void JTable(Object rowData, TableColumnModel columnNames) {
		// TODO Auto-generated method stub
		
	}
}
