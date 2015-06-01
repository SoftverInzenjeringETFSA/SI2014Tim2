package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;

import javax.naming.directory.InvalidAttributeValueException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JScrollPane;

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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.IzvjestajOdjela;
import ba.etf.unsa.si.Klase.IzvjestajZaposlenika;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Lozinka;
import ba.etf.unsa.si.Klase.Odjel;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Task;
import ba.etf.unsa.si.Klase.Timesheet;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

import javax.swing.border.CompoundBorder;

import java.time.Month;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPasswordField;

import java.awt.Component;

import javax.swing.ScrollPaneConstants;

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
	private JTextField textField_3;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_12;
	private JTextField textField_10;
	protected static final Logger LOGGER = Logger.getLogger("MainFormKoordinator");
	private JTextField textField_11;
	private JTextField textField_13;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_14;
	private JTextField textField_15;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFormKoordinator frame = new MainFormKoordinator(DalDao.VratiZaposlenika(10));
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public MainFormKoordinator(final ZaposlenikHibernate zh) {
		final ZaposlenikHibernate Zaposlenik = zh;
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("QuickSheet - Koordinator");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 541);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 764, 512);
		getContentPane().add(tabbedPane);
		setLocationRelativeTo(null);
		JPanel timeSheetPanel = new JPanel();
		timeSheetPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.addTab("Moj Timesheet", null, timeSheetPanel, null);
		timeSheetPanel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Timesheet podaci", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_4.setBounds(30, 22, 703, 348);
		timeSheetPanel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Projekat:");
		lblNewLabel.setForeground(UIManager.getColor("TextField.highlight"));
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
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(comboBox.getSelectedItem()==null){
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
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(501, 291, 154, 29);
		panel_4.add(btnNewButton);
		
		JLabel lblTaskovi = new JLabel("Taskovi:");
		lblTaskovi.setForeground(UIManager.getColor("TextField.highlight"));
		lblTaskovi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTaskovi.setBounds(80, 117, 46, 14);
		panel_4.add(lblTaskovi);
		
		JLabel lblBrojSati = new JLabel("Ukupan broj radnih sati:");
		lblBrojSati.setForeground(UIManager.getColor("TextField.highlight"));
		lblBrojSati.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBrojSati.setBounds(10, 248, 116, 14);
		panel_4.add(lblBrojSati);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 24, 1));
		spinner_2.setBounds(136, 245, 210, 20);
		panel_4.add(spinner_2);
		
		JLabel label = new JLabel("Datum:");
		label.setForeground(UIManager.getColor("TextField.highlight"));
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
		
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_1.setBounds(155, 28, 141, 20);
		panel.add(comboBox_1);
		
		JLabel label_1 = new JLabel("Projekat:");
		label_1.setForeground(UIManager.getColor("TextField.highlight"));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(10, 28, 78, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Timesheet historija:");
		label_2.setForeground(UIManager.getColor("TextField.highlight"));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(10, 59, 200, 20);
		panel.add(label_2);
		
		final DefaultListModel DefaultListModel1 = new DefaultListModel(); 
		JList list_8 = new JList();
		list_8.setModel(DefaultListModel1);
		JScrollPane scrollPane9 = new JScrollPane(list_8, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane9.setBounds(20, 90, 297, 269);
		list_8.setBounds(20, 90, 297, 269);
		panel.add(scrollPane9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prikaz historije za odre\u0111eni vremenski interval", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_2.setBounds(392, 22, 341, 370);
		historijaPanel.add(panel_2);
		
		JLabel lblPrikazZaOdreeni = new JLabel("Prikaz za određeni mjesec:");
		lblPrikazZaOdreeni.setForeground(UIManager.getColor("TextField.highlight"));
		lblPrikazZaOdreeni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrikazZaOdreeni.setBounds(10, 68, 156, 14);
		panel_2.add(lblPrikazZaOdreeni);
		
		final JComboBox comboBox_2 = new JComboBox();
		
		comboBox_2.setModel(new DefaultComboBoxModel(Month.values()));
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_2.setBounds(200, 62, 131, 20);
		panel_2.add(comboBox_2);
		
		final DefaultListModel DefaultListModel2 = new DefaultListModel();
		JList list_9 = new JList();
		list_9.setModel(DefaultListModel2);
		JScrollPane scrollPane8 = new JScrollPane(list_9, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane8.setBounds(20, 93, 311, 266);
		list_9.setBounds(20, 93, 311, 266);
		panel_2.add(scrollPane8);
		
		JPanel odjeliPanel = new JPanel();
		odjeliPanel.setForeground(UIManager.getColor("TextField.highlight"));
		odjeliPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.addTab("Odjeli", null, odjeliPanel, null);
		odjeliPanel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(UIManager.getColor("TextField.highlight"));
		panel_3.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga odjela", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_3.setBounds(30, 22, 355, 426);
		odjeliPanel.add(panel_3);
		panel_3.setLayout(null);
		
		final JList list_4 = new JList();
		JScrollPane scrollPane7 = new JScrollPane(list_4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane7.setBounds(22, 116, 309, 260);
		final DefaultListModel dlm_1 = new DefaultListModel();
		list_4.setModel(dlm_1);
		list_4.setBounds(22, 116, 309, 243);
		panel_3.add(scrollPane7);
		
		JLabel label_16 = new JLabel("Izaberite parametar pretrage:");
		label_16.setForeground(UIManager.getColor("TextField.highlight"));
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_16.setBounds(22, 29, 170, 14);
		panel_3.add(label_16);
		
		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(comboBox_5.getSelectedItem() == null)){
					textField_7.setText((String) comboBox_5.getSelectedItem());
				}
			}
		});
		
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Naziv", "Max br. zaposlenika"}));
		comboBox_5.setBounds(22, 56, 99, 23);
		panel_3.add(comboBox_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(128, 56, 124, 23);
		panel_3.add(textField_7);
		
		final JLabel label_error = new JLabel("");
		label_error.setForeground(Color.RED);
		label_error.setVisible(false);
		label_error.setBounds(0, 459, 759, 25);
		odjeliPanel.add(label_error);
		
		final JCheckBox checkBox = new JCheckBox("Prikaži arhivirane korisnike");
		checkBox.setBackground(UIManager.getColor("TextField.darkShadow"));
		checkBox.setForeground(UIManager.getColor("TextField.highlight"));
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		checkBox.setBounds(22, 86, 170, 23);
		panel_3.add(checkBox);
		
		JButton button_2 = new JButton("Pretraži");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<OdjelHibernate> odjeli = new ArrayList<OdjelHibernate>();
				dlm_1.removeAllElements();
				if (comboBox_5.getSelectedItem().toString().equals("Naziv"))
				{
					if (checkBox.isSelected())
					{
						odjeli = DalDao.PretraziArhiviraneOdjelePoNazivu(textField_7.getText());
					}
					else 
					{
						odjeli = DalDao.PretraziNearhiviraneOdjelePoNazivu(textField_7.getText());
					}
				}
				else
				{
					if (textField_7.getText().matches("^[0-9]*$"))
					{
						if (checkBox.isSelected())
						{
							odjeli = DalDao.PretraziArhiviraneOdjelePoKapacitetu(Integer.parseInt(textField_7.getText()));
						}
						else 
						{
							odjeli = DalDao.PretraziNearhiviraneOdjelePoKapacitetu(Integer.parseInt(textField_7.getText()));
						}
					}
				}
				for (int i=0; i < odjeli.size(); i++)
				{
				    String tempString = odjeli.get(i).getId() + " " + odjeli.get(i).getNaziv();
				    dlm_1.addElement(tempString);
				}
				
			}
		});
		
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_2.setBounds(262, 56, 69, 23);
		panel_3.add(button_2);
		
		JButton btnPrikaiOdjel = new JButton("Prikaži odjel");
		btnPrikaiOdjel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrikaiOdjel.setBounds(230, 387, 101, 23);
		panel_3.add(btnPrikaiOdjel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(UIManager.getColor("TextField.highlight"));
		panel_5.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o odjelu", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_5.setBounds(392, 22, 341, 426);
		odjeliPanel.add(panel_5);
		
		JLabel label_6 = new JLabel("Naziv odjela:");
		label_6.setForeground(UIManager.getColor("TextField.highlight"));
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(78, 33, 62, 14);
		panel_5.add(label_6);
		
		textField_1 = new JTextField();
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(190, 30, 141, 20);
		panel_5.add(textField_1);
		
		JLabel lblZaposlenici = new JLabel("Zaposlenici:");
		lblZaposlenici.setForeground(UIManager.getColor("TextField.highlight"));
		lblZaposlenici.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici.setBounds(85, 58, 66, 29);
		panel_5.add(lblZaposlenici);
		
		JLabel label_9 = new JLabel("Maksimalni broj zaposlenika:");
		label_9.setForeground(UIManager.getColor("TextField.highlight"));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(10, 298, 152, 14);
		panel_5.add(label_9);
		
		final JList list = new JList();
		final DefaultListModel listaZaposlenikaOdjela = new DefaultListModel();
		list.setModel(listaZaposlenikaOdjela);
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list.setEnabled(false);
		JScrollPane scrollPane6 = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane6.setBounds(190, 61, 141, 226);
		list.setBounds(190, 61, 141, 135);
		panel_5.add(scrollPane6);
		
		btnPrikaiOdjel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listaZaposlenikaOdjela.removeAllElements();
				boolean greska = true;
				if(list_4.isSelectionEmpty())
				{
					label_error.setText("Morate označiti odjel!");
					label_error.setVisible(true);
				}
				else
				{
					label_error.setVisible(false);
					String Odjel=list_4.getSelectedValue().toString();
					String[] temp = Odjel.split(" ");
					final long id = Long.parseLong(temp[0]);
					final OdjelHibernate prikaz = DalDao.VratiOdjel(id); 
					ArrayList<ZaposlenikHibernate> zaposleniciOdjela=DalDao.VratiZaposlenikeUOdjelu(id);
					for (int i=0;i<zaposleniciOdjela.size();i++)
					{
					    String tempString = zaposleniciOdjela.get(i).toString();
						listaZaposlenikaOdjela.addElement(tempString);
					}
					textField_1.setText(prikaz.getNaziv());
					textField_2.setText(prikaz.getMaksimalanBrojRadnika().toString());
				}
			}
		});
		
		textField_2 = new JTextField();
		textField_2.setDisabledTextColor(Color.BLACK);
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(190, 298, 141, 20);
		panel_5.add(textField_2);
		
		JPanel projektiPanel = new JPanel();
		projektiPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.addTab("Projekti", null, projektiPanel, null);
		projektiPanel.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga projekta", TitledBorder.LEFT, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_11.setBounds(30, 22, 355, 249);
		projektiPanel.add(panel_11);
		
		final JCheckBox chckbxPrikaziArhiviraneProjekte = new JCheckBox("Prikaži arhivirane projekte");
		chckbxPrikaziArhiviraneProjekte.setBackground(UIManager.getColor("TextField.darkShadow"));
		chckbxPrikaziArhiviraneProjekte.setForeground(UIManager.getColor("TextField.highlight"));
		chckbxPrikaziArhiviraneProjekte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxPrikaziArhiviraneProjekte.setBounds(22, 75, 149, 23);
		panel_11.add(chckbxPrikaziArhiviraneProjekte);
		
		final JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(comboBox_17.getSelectedItem() == null)){
					textField_46.setText((String) comboBox_17.getSelectedItem());
				}
			}
		});
		
		comboBox_17.setModel(new DefaultComboBoxModel(new String[] {"Naziv projekta", "Naziv klijenta"}));
		comboBox_17.setBounds(22, 45, 99, 23);
		panel_11.add(comboBox_17);
		
		final JLabel label_error1 = new JLabel("");
		label_error1.setForeground(Color.RED);
		label_error1.setVisible(false);
		label_error1.setBounds(0, 459, 759, 25);
		projektiPanel.add(label_error1);
		
		JButton btnPretrai_1 = new JButton("Pretraži");
		btnPretrai_1.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnPretrai_1.setForeground(UIManager.getColor("Button.foreground"));
		btnPretrai_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPretrai_1.setBounds(262, 45, 69, 23);
		panel_11.add(btnPretrai_1);
		
		textField_46 = new JTextField();
		textField_46.setBounds(128, 45, 124, 23);
		panel_11.add(textField_46);
		textField_46.setColumns(10);
		
		final JList list_1 = new JList();
		JScrollPane scrollPane4 = new JScrollPane(list_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane4.setBounds(22, 105, 309, 85);
		list_1.setBounds(22, 105, 309, 85);
		final DefaultListModel dlm2 = new DefaultListModel();
		list_1.setModel(dlm2);
		panel_11.add(scrollPane4);
		
		JLabel lblIzaberiteParametarPretrage = new JLabel("Izaberite parametar pretrage:");
		lblIzaberiteParametarPretrage.setForeground(UIManager.getColor("TextField.highlight"));
		lblIzaberiteParametarPretrage.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIzaberiteParametarPretrage.setBounds(22, 22, 170, 14);
		panel_11.add(lblIzaberiteParametarPretrage);
		
		JButton btnPrikaiProjekat = new JButton("Prikaži projekat");
		btnPrikaiProjekat.setForeground(Color.BLACK);
		btnPrikaiProjekat.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPrikaiProjekat.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnPrikaiProjekat.setBounds(215, 215, 116, 23);
		panel_11.add(btnPrikaiProjekat);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o projektu", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_8.setBounds(392, 22, 341, 426);
		projektiPanel.add(panel_8);
		panel_8.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setColumns(10);
		textField_4.setBounds(166, 25, 165, 20);
		panel_8.add(textField_4);
		
		JLabel label_7 = new JLabel("Naziv:");
		label_7.setForeground(UIManager.getColor("TextField.highlight"));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(86, 28, 82, 14);
		panel_8.add(label_7);
		
		JLabel label_10 = new JLabel("Naziv klijenta:");
		label_10.setForeground(UIManager.getColor("TextField.highlight"));
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(51, 53, 102, 14);
		panel_8.add(label_10);
		
		JLabel lblZaposlenici_1 = new JLabel("Zaposlenici:");
		lblZaposlenici_1.setForeground(UIManager.getColor("TextField.highlight"));
		lblZaposlenici_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici_1.setBounds(62, 78, 56, 14);
		panel_8.add(lblZaposlenici_1);
		
		JLabel lblNadreeni = new JLabel("Nadređeni:");
		lblNadreeni.setForeground(UIManager.getColor("TextField.highlight"));
		lblNadreeni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNadreeni.setBounds(66, 339, 102, 14);
		panel_8.add(lblNadreeni);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(166, 50, 165, 20);
		panel_8.add(textField_5);
		
		JLabel lblArhivirajProjekat = new JLabel("Arhiviraj projekat:");
		lblArhivirajProjekat.setForeground(UIManager.getColor("TextField.highlight"));
		lblArhivirajProjekat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblArhivirajProjekat.setBounds(30, 367, 102, 14);
		panel_8.add(lblArhivirajProjekat);
		
		final JCheckBox chckbxArhiviraj = new JCheckBox("Da");
		chckbxArhiviraj.setBackground(UIManager.getColor("Button.darkShadow"));
		chckbxArhiviraj.setForeground(Color.WHITE);
		chckbxArhiviraj.setBounds(166, 363, 97, 23);
		panel_8.add(chckbxArhiviraj);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(166, 336, 165, 20);
		panel_8.add(comboBox_3);
		
		final JList list_3 = new JList();
		list_3.setBackground(Color.WHITE);
		list_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JScrollPane scrollPane3 = new JScrollPane(list_3, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane3.setBounds(166, 78, 165, 88);
		list_3.setBounds(166, 78, 165, 148);
		final DefaultListModel listaZaposlenikaProjekta = new DefaultListModel();
		list_3.setModel(listaZaposlenikaProjekta);
		panel_8.add(scrollPane3);
		
		JButton button = new JButton("Sačuvaj promjene");
		button.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button.setForeground(UIManager.getColor("Button.foreground"));
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
		
		button.setFont(new Font("Tahoma", Font.BOLD, 10));
		button.setBounds(202, 392, 129, 23);
		panel_8.add(button);
		
		JButton btnUkloni = new JButton("Dodaj");
		btnUkloni.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnUkloni.setForeground(UIManager.getColor("Button.foreground"));
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DodajKorisnika().setVisible(true);
			}
		});
		btnUkloni.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUkloni.setBounds(249, 306, 82, 23);
		panel_8.add(btnUkloni);
		
		JButton button_3 = new JButton("Ukloni");
		button_3.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button_3.setForeground(UIManager.getColor("Button.foreground"));
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
		
		button_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_3.setBounds(249, 175, 82, 23);
		panel_8.add(button_3);
		
		JList list_10 = new JList();
		list_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_10.setBackground(Color.WHITE);
		JScrollPane scrollPaneX = new JScrollPane(list_10, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneX.setBounds(166, 209, 165, 86);
		list_10.setBounds(166, 209, 146, 86);
		final DefaultListModel listaZaposlenika = new DefaultListModel();
		list_10.setModel(listaZaposlenika);
		panel_8.add(scrollPaneX);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Taskovi", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_9.setBounds(30, 282, 355, 166);
		projektiPanel.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblPrikazTaskova = new JLabel("Prikaz taskova:");
		lblPrikazTaskova.setForeground(UIManager.getColor("TextField.highlight"));
		lblPrikazTaskova.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrikazTaskova.setBounds(21, 22, 82, 14);
		panel_9.add(lblPrikazTaskova);
		
		final JList list_7 = new JList();
		list_7.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane5 = new JScrollPane(list_7, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane5.setBounds(21, 37, 309, 85);
		list_7.setBounds(21, 37, 309, 85);
		final DefaultListModel dll = new DefaultListModel();
		list_7.setModel(dll);
		panel_9.add(scrollPane5);
		
		btnPrikaiProjekat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean greska = true;
				if(list_1.isSelectionEmpty()){
					greska = false;
					label_error1.setText("Morate označiti projekat!");
				}
				if(greska == false){
					label_error1.setVisible(true);
				}
				else{
					label_error1.setVisible(false);
					String Projekat = list_1.getSelectedValue().toString();
					textField_46.setText("");
					dlm2.removeAllElements();
					dll.removeAllElements();
					String[] temp = Projekat.split(" ");
					final long id = Long.parseLong(temp[0]);
					ProjekatHibernate prikaz = DalDao.VratiProjekat(id);
					ArrayList<ZaposlenikHibernate> zaposleniciProjekta=DalDao.VratiZaposlenikeNaProjektu(id);
					for (int i=0;i<zaposleniciProjekta.size();i++)
					{
					    String tempString = zaposleniciProjekta.get(i).toString();
						listaZaposlenikaProjekta.addElement(tempString);
					}
					ArrayList<ZaposlenikHibernate> zaposlenici=DalDao.VratiSveZaposlenike();
					for (int i=0;i<zaposlenici.size();i++)
					{
					    String tempString = zaposlenici.get(i).toString();
					    listaZaposlenika.addElement(tempString);
					}
					textField_4.setText(prikaz.getNaziv());
					textField_5.setText(prikaz.getNazivKlijenta());
					ArrayList<ZaposlenikHibernate> koo = DalDao.VratiSveZaposlenikeKoordinatore();
					for (int i = 0; i < koo.size(); i++)
						comboBox_3.addItem(koo.get(i).toString());
					comboBox_3.setSelectedItem(Zaposlenik.toString());
					chckbxArhiviraj.setSelected(prikaz.getArhiviran());
					ArrayList<TaskHibernate> taskovi = DalDao.VratiSveTaskoveProjekta(id);
					for (int i = 0; i < taskovi.size(); i++)
					{
						String komponenta = taskovi.get(i).getId() + " Naziv: " + taskovi.get(i).getNaziv() + ", Zaposlenik: " + taskovi.get(i).getZaposlenik().toString() + ", Procenat: " + taskovi.get(i).getProcenatZavrsenosti() + "%";
						dll.addElement(komponenta);
					}
				}
			}
		});
		
		JButton btnDodajTask = new JButton("Dodaj task");
		btnDodajTask.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnDodajTask.setForeground(UIManager.getColor("Button.foreground"));
		btnDodajTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_4.getText() == null || textField_4.getText().isEmpty() || textField_4.getText() == "")
				{
					label_error1.setVisible(true);
					label_error1.setText("Morate izabrati projekat!");
				}
				else 
				{
					label_error1.setVisible(false);
					ArrayList<ProjekatHibernate> pj = DalDao.VratiArhiviraneProjektePoNazivu(textField_4.getText());
					new TaskForm(pj.get(0), dll).setVisible(true);
				}
			}
		});
		
		btnDodajTask.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDodajTask.setBounds(82, 132, 119, 23);
		panel_9.add(btnDodajTask);
		
		JButton btnIzbriiTask = new JButton("Izbriši task");
		btnIzbriiTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_error1.setVisible(false);
				boolean postojiGreska = false;
				TaskHibernate th = new TaskHibernate();
				if (list_7.isSelectionEmpty())
				{
					postojiGreska = true;
					label_error1.setText("Morate izabrati task!");
				}
				else
				{
					String izabraniTask = list_7.getSelectedValue().toString();
					String[] rijeci = izabraniTask.split(" ");
					long ide = Long.parseLong(rijeci[0]);
					th = DalDao.VratiTask(ide);
					if (th.getProcenatZavrsenosti().equals(100))
					{
						postojiGreska = true;
						label_error1.setText("Ne možete izbrisati urađen task!");
					}
				}
				if (postojiGreska)
					label_error1.setVisible(true);
				else
				{
					DalDao.ObrisiObjekat(th);
					String komponenta = th.getId() + " Naziv: " + th.getNaziv() + ", Zaposlenik: " + th.getZaposlenik().toString() + ", Procenat: " + th.getProcenatZavrsenosti() + "%";
					dll.removeElement(komponenta);
					JOptionPane.showMessageDialog(null, "Uspjesno ste obrisali task", "Task obrisan", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnIzbriiTask.setForeground(Color.BLACK);
		btnIzbriiTask.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnIzbriiTask.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnIzbriiTask.setBounds(211, 132, 119, 23);
		panel_9.add(btnIzbriiTask);
		
		JPanel korisniciPanel = new JPanel();
		korisniciPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.addTab("Korisnici", null, korisniciPanel, null);
		korisniciPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga korisnika", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_1.setBounds(30, 22, 355, 426);
		korisniciPanel.add(panel_1);
		panel_1.setLayout(null);
		
	    final JList list_2 = new JList();
	    list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    JScrollPane scrollPane2 = new JScrollPane(list_2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane2.setBounds(22, 116, 309, 265);
		list_2.setBounds(22, 116, 309, 209);
		final DefaultListModel lista = new DefaultListModel();
	    list_2.setModel(lista);
		panel_1.add(scrollPane2);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Prikaži arhivirane korisnike");
		chckbxNewCheckBox.setForeground(UIManager.getColor("TextField.highlight"));
		chckbxNewCheckBox.setBackground(UIManager.getColor("TextField.darkShadow"));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBounds(22, 86, 170, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("Prikaži profil");
		btnNewButton_1.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_1.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!list_2.isSelectionEmpty())
				{
					String selektovaniModel = list_2.getSelectedValue().toString();
					new KorisnikFormKoordinator(selektovaniModel).setVisible(true);
				}
			}
		});
		
		btnNewButton_1.setBounds(212, 392, 119, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel label_11 = new JLabel("Izaberite parametar pretrage:");
		label_11.setForeground(UIManager.getColor("TextField.highlight"));
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(22, 29, 170, 14);
		panel_1.add(label_11);
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Ime", "Prezime", "Username"}));
		comboBox_4.setBounds(22, 56, 99, 23);
		panel_1.add(comboBox_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(128, 56, 124, 23);
		panel_1.add(textField_6);
		
		final JLabel label_error2 = new JLabel("");
		label_error2.setVisible(false);
		label_error2.setBounds(0, 459, 759, 25);
		korisniciPanel.add(label_error2);
		
		JButton button_1 = new JButton("Pretraži");
		button_1.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button_1.setForeground(new Color(0, 0, 0));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!textField_6.getText().isEmpty())
				{
					lista.removeAllElements();
					ArrayList<ZaposlenikHibernate> zaposlenici = new ArrayList<ZaposlenikHibernate>();
					String vrijednost = comboBox_4.getSelectedItem().toString();
					if (chckbxNewCheckBox.isSelected())
					{
						if (vrijednost.equals("Ime"))
						{
							zaposlenici = DalDao.VratiArhiviraneZaposlenikePoImenu(textField_6.getText());
						}
						else if (vrijednost.equalsIgnoreCase("Prezime"))
						{
							zaposlenici = DalDao.VratiArhiviraneZaposlenikePoPrezimenu(textField_6.getText());
						}
						else
						{
							zaposlenici.add(DalDao.VratiArhiviraneZaposlenikePoUsername(textField_6.getText()));
						}
					}
					else
					{
						if (vrijednost.equals("Ime"))
						{
							zaposlenici = DalDao.VratiNearhiviraneZaposlenikePoImenu(textField_6.getText());
						}
						else if (vrijednost.equalsIgnoreCase("Prezime"))
						{
							zaposlenici = DalDao.VratiNearhiviraneZaposlenikePoPrezimenu(textField_6.getText());
						}
						else
						{
							zaposlenici.add(DalDao.VratiNearhiviraneZaposlenikePoUsername(textField_6.getText()));
						}
					}
					ArrayList<ProjekatHibernate> projekti = DalDao.VratiSveKoordinatorskeProjekte(Zaposlenik.getId());
					ArrayList<String> dopusteniZaposlenici = new ArrayList<String>();
					for (int index = 0; index < projekti.size(); index++)
					{
						ArrayList<ZaposlenikHibernate> zata = DalDao.VratiZaposlenikeNaProjektu(projekti.get(index).getId());
						for (ZaposlenikHibernate zz: zata)
						{
							if (!dopusteniZaposlenici.contains(zz))
								dopusteniZaposlenici.add(zz.toString());
						}
					}
					for (int i = 0; i < zaposlenici.size(); i++)
					{
						if (zaposlenici.get(i) != null)
						{
							String podatak = zaposlenici.get(i).toString();
							if (dopusteniZaposlenici.contains(podatak))
								lista.addElement(podatak);
						}
					}

				}
			}
		});
		
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		button_1.setBounds(262, 56, 69, 23);
		panel_1.add(button_1);
		
		JPanel izvjestajiPanel = new JPanel();
		izvjestajiPanel.setBackground(UIManager.getColor("Button.darkShadow"));
		tabbedPane.addTab("Izvještaji", null, izvjestajiPanel, null);
		izvjestajiPanel.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(UIManager.getColor("TextField.highlight"));
		panel_7.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Izvje\u0161taj", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
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
		lblNewLabel_11.setForeground(UIManager.getColor("TextField.highlight"));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_11.setBounds(75, 33, 57, 14);
		panel_7.add(lblNewLabel_11);
		
		final ArrayList<OdjelHibernate> odjeli = DalDao.VratiSveNearhiviraneOdjele();
		final JComboBox comboBox_20 = new JComboBox();
		comboBox_20.setBackground(Color.WHITE);
		comboBox_20.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_20.setBounds(75, 58, 197, 20);
		for (int i = 0; i < odjeli.size(); i++)
		{
			String komponenta = odjeli.get(i).getId() + " " + odjeli.get(i).getNaziv();
			comboBox_20.addItem(komponenta);
		}
		panel_7.add(comboBox_20);
		
		JLabel lblZaposlenik = new JLabel("Zaposlenik:");
		lblZaposlenik.setForeground(UIManager.getColor("TextField.highlight"));
		lblZaposlenik.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenik.setBounds(75, 89, 57, 14);
		panel_7.add(lblZaposlenik);
		
		final JComboBox comboBox_21 = new JComboBox();
		comboBox_21.setBackground(Color.WHITE);
		comboBox_21.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_21.setBounds(75, 114, 197, 20);
		String vrijednost1 = comboBox_20.getSelectedItem().toString();
		String[] rijeci = vrijednost1.split(" ");
		long odjelId = Long.parseLong(rijeci[0]);
		ArrayList<ZaposlenikHibernate> zaposleniciOdjela = DalDao.VratiZaposlenikeUOdjelu(odjelId);
		comboBox_21.removeAllItems();
		for (int i = 0; i < zaposleniciOdjela.size(); i++)
		{
			String komponenta = zaposleniciOdjela.get(i).getId() + " " + zaposleniciOdjela.get(i).getIme() + " " + zaposleniciOdjela.get(i).getPrezime();
			comboBox_21.addItem(komponenta);
		}
		panel_7.add(comboBox_21);
		
		comboBox_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String vrijednost1 = comboBox_20.getSelectedItem().toString();
				String[] rijeci = vrijednost1.split(" ");
				long odjelId = Long.parseLong(rijeci[0]);
				ArrayList<ZaposlenikHibernate> zaposleniciOdjela = DalDao.VratiZaposlenikeUOdjelu(odjelId);
				comboBox_21.removeAllItems();
				for (int i = 0; i < zaposleniciOdjela.size(); i++)
				{
					String komponenta = zaposleniciOdjela.get(i).getId() + " " + zaposleniciOdjela.get(i).getIme() + " " + zaposleniciOdjela.get(i).getPrezime();
					comboBox_21.addItem(komponenta);
				}
			}
		});
		
		final JComboBox comboBox_22 = new JComboBox();
		comboBox_22.setBackground(Color.WHITE);
		comboBox_22.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_22.setBounds(75, 170, 197, 20);
		String vrijednost12 = comboBox_21.getSelectedItem().toString();
		String[] rijeci1 = vrijednost12.split(" ");
		long zaposlenikID = Long.parseLong(rijeci1[0]);
		ArrayList<ProjekatHibernate> projekti = DalDao.VratiZaposlenikoveProjekte(zaposlenikID);
		comboBox_22.removeAllItems();
		
		for (int i = 0; i < projekti.size(); i++)
		{
			String komponenta = projekti.get(i).getId() + " " + projekti.get(i).getNaziv();
			comboBox_22.addItem(komponenta);
		}
		
		panel_7.add(comboBox_22);
		comboBox_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox_21.getSelectedIndex() != -1)
				{
					String vrijednost1 = comboBox_21.getSelectedItem().toString();
					String[] rijeci = vrijednost1.split(" ");
					long zaposlenikID = Long.parseLong(rijeci[0]);
					ArrayList<ProjekatHibernate> projekti = DalDao.VratiZaposlenikoveProjekte(zaposlenikID);
					comboBox_22.removeAllItems();
					for (int i = 0; i < projekti.size(); i++)
					{
						String komponenta = projekti.get(i).getId() + " " + projekti.get(i).getNaziv();
						comboBox_22.addItem(komponenta);
					}
				}
				else
				{
					comboBox_22.removeAllItems();
				}
			}
		});
		
		JLabel lblProjekat_1 = new JLabel("Projekat:");
		lblProjekat_1.setForeground(UIManager.getColor("TextField.highlight"));
		lblProjekat_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProjekat_1.setBounds(75, 145, 57, 14);
		panel_7.add(lblProjekat_1);
		
		JComboBox comboBox_23 = new JComboBox();
		comboBox_23.setBackground(Color.WHITE);
		comboBox_23.setModel(new DefaultComboBoxModel(Month.values()));
		comboBox_23.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		comboBox_23.setBounds(75, 226, 197, 20);
		panel_7.add(comboBox_23);
		
		JLabel lblMjesevc = new JLabel("Izvještaj za mjesec:");
		lblMjesevc.setForeground(UIManager.getColor("TextField.highlight"));
		lblMjesevc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMjesevc.setBounds(75, 201, 116, 14);
		panel_7.add(lblMjesevc);
		
		JLabel label_15 = new JLabel("");
		label_15.setBounds(203, 229, 46, 14);
		panel_7.add(label_15);
		JLabel lblIliIzvjestajZa = new JLabel("Ili, izvještaj za vremenski period:");
		lblIliIzvjestajZa.setForeground(UIManager.getColor("TextField.highlight"));
		lblIliIzvjestajZa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIliIzvjestajZa.setBounds(75, 264, 197, 14);
		panel_7.add(lblIliIzvjestajZa);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setForeground(UIManager.getColor("TextField.highlight"));
		lblOd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOd.setBounds(76, 289, 46, 14);
		panel_7.add(lblOd);
		
		JLabel lblDo_1 = new JLabel("Do:");
		lblDo_1.setForeground(UIManager.getColor("TextField.highlight"));
		lblDo_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDo_1.setBounds(177, 289, 46, 14);
		panel_7.add(lblDo_1);
		
		JButton btnNewButton_3 = new JButton("Generiši izvještaj");
		btnNewButton_3.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnNewButton_3.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 10));
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
		panel_6.setBackground(UIManager.getColor("Button.darkShadow"));
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Timesheet validacija", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_6.setBounds(30, 22, 341, 370);
		izvjestajiPanel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblImenkoPrezimenkovic = new JLabel("Zahtjevi za reviziju i odobravanje timesheeta:");
		lblImenkoPrezimenkovic.setForeground(UIManager.getColor("TextField.highlight"));
		lblImenkoPrezimenkovic.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImenkoPrezimenkovic.setBounds(15, 41, 240, 14);
		panel_6.add(lblImenkoPrezimenkovic);
		final JLabel label_17 = new JLabel("");
		label_17.setVisible(false);
		label_17.setBounds(0, 408, 759, 14);
		izvjestajiPanel.add(label_17);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (comboBox_20.getSelectedIndex() == -1 || comboBox_21.getSelectedIndex() == -1 || comboBox_22.getSelectedIndex() == -1) 
				{
					label_17.setVisible(true);
					label_17.setText("Morate izabrati parametre za kreiranje izvještaja");
				}
				else
				{
					String odjel = comboBox_20.getSelectedItem().toString();
					String[] rijeci = odjel.split(" ");
					long OdjelID = Long.parseLong(rijeci[0]);
					
					String zaposlenik = comboBox_21.getSelectedItem().toString();
					String[] rijeci1 = zaposlenik.split(" ");
					long ZaposlenikID = Long.parseLong(rijeci1[0]);
					
					String projekat = comboBox_22.getSelectedItem().toString();
					String[] rijeci2 = projekat.split(" ");
					long ProjekatID = Long.parseLong(rijeci2[0]);
					
					OdjelHibernate oh = DalDao.VratiOdjel(OdjelID);
					ZaposlenikHibernate zh = DalDao.VratiZaposlenika(ZaposlenikID);
					ProjekatHibernate ph = DalDao.VratiProjekat(ProjekatID);
					
					ZaposlenikHibernate koordinatorH = ph.getKoordinator();
					Koordinator kkk = null;
					try {
						kkk = new Koordinator(koordinatorH.getUsername(), koordinatorH.getIme(), koordinatorH.getPrezime(), koordinatorH.getAdresa(), koordinatorH.getDatumZaposlenja(), koordinatorH.getSatnica());
					} catch (InvalidAttributeValueException e2) {
						LOGGER.log(Level.SEVERE,"context",e2);
					}
					Projekat PROJEKAT = null;
					try {
						PROJEKAT = new Projekat(ph.getNaziv(), ph.getNazivKlijenta(), kkk);
					} catch (InvalidAttributeValueException e2) {
						LOGGER.log(Level.SEVERE,"context",e2);
					}
					
					ArrayList<TaskHibernate> taskoviH = DalDao.VratiSveTaskoveProjekta(ProjekatID);
					LinkedList<Task> taskovi = new LinkedList<Task>();
					for (int i = 0; i < taskoviH.size(); i++)
					{
						ZaposlenikHibernate zzz = taskoviH.get(i).getZaposlenik();
						ProjekatRadnik _zaposlenik = null;
						try {
							_zaposlenik = new ProjekatRadnik(zzz.getUsername(), zzz.getIme(), zzz.getPrezime(), zzz.getAdresa(), zzz.getDatumZaposlenja(), zzz.getSatnica());
						} catch (InvalidAttributeValueException e1) {
							LOGGER.log(Level.SEVERE,"context",e1);
						}
						Task novi = null;
						try {
							novi = new Task(taskoviH.get(i).getNaziv(), taskoviH.get(i).getOpis(), taskoviH.get(i).getPrioritet(), _zaposlenik, taskoviH.get(i).getRok());
						} catch (javax.management.InvalidAttributeValueException e1) {
							LOGGER.log(Level.SEVERE,"context",e1);
						}
						taskovi.add(novi);
					}
					
					try {
						PROJEKAT.setTaskovi(taskovi);
					} catch (InvalidAttributeValueException e1) {
						LOGGER.log(Level.SEVERE,"context",e1);
					}
					
					ArrayList<ZaposlenikHibernate> zaposh = DalDao.VratiZaposlenikeNaProjektu(ProjekatID);
					LinkedList<ProjekatRadnik> zaposlenici = new LinkedList<ProjekatRadnik>();
					for (int i = 0; i < zaposh.size(); i++)
					{
						ProjekatRadnik pa = null;
						try {
							pa = new ProjekatRadnik(zaposh.get(i).getUsername(), zaposh.get(i).getIme(), zaposh.get(i).getPrezime(), zaposh.get(i).getAdresa(), zaposh.get(i).getDatumZaposlenja(), zaposh.get(i).getSatnica());
						} catch (InvalidAttributeValueException e1) {
							LOGGER.log(Level.SEVERE,"context",e1);
						}
						zaposlenici.add(pa);
					}
					
					try {
						PROJEKAT.setZaposlenici(zaposlenici);
					} catch (InvalidAttributeValueException e1) {
						LOGGER.log(Level.SEVERE,"context",e1);
					}
					
					
					ArrayList<TimesheetHibernate> tss = DalDao.VratiTimesheetoveProjekta(ProjekatID);
					LinkedList<Timesheet> tim = new LinkedList<Timesheet>();
					for (int i = 0; i < tss.size(); i++)
					{
						ArrayList<TaskHibernate> Taskovi = DalDao.VratiTimesheetTaskoveZaposlenika(tss.get(i).getId());
						LinkedList<Task> kom = new LinkedList<Task>();
						for (int j = 0; j < Taskovi.size(); j++)
						{
							ZaposlenikHibernate zaaa = Taskovi.get(j).getZaposlenik();
							ProjekatRadnik aaa = null;
							try {
								aaa = new ProjekatRadnik(zaaa.getUsername(), zaaa.getIme(), zaaa.getPrezime(), zaaa.getAdresa(), zaaa.getDatumZaposlenja(), zaaa.getSatnica());
							} catch (InvalidAttributeValueException e1) {
								LOGGER.log(Level.SEVERE,"context",e1);
							}
							Task nono = null;
							try {
								nono = new Task(Taskovi.get(j).getNaziv(), Taskovi.get(j).getOpis(), Taskovi.get(j).getPrioritet(), aaa, Taskovi.get(j).getRok());
							} catch (javax.management.InvalidAttributeValueException e1) {
								LOGGER.log(Level.SEVERE,"context",e1);
							}
							kom.add(nono);
						}
						ProjekatHibernate pp = tss.get(i).getProjekat();
						ZaposlenikHibernate imm = pp.getKoordinator();
						Koordinator koko = null;
						try {
							koko = new Koordinator(imm.getUsername(), imm.getIme(), imm.getPrezime(), imm.getAdresa(), imm.getDatumZaposlenja(), imm.getSatnica());
						} catch (InvalidAttributeValueException e1) {
							LOGGER.log(Level.SEVERE,"context",e1);
						}
						Projekat ll = null;
						try {
							ll = new Projekat(pp.getNaziv(), pp.getNazivKlijenta(), koko);
						} catch (InvalidAttributeValueException e1) {
							LOGGER.log(Level.SEVERE,"context",e1);
						}
						try {
							Timesheet toto = new Timesheet(kom, tss.get(i).getBrojRadnihSati(), ll, tss.get(i).getDatumSlanja());
						} catch (javax.management.InvalidAttributeValueException e1) {
							LOGGER.log(Level.SEVERE,"context",e1);
						}
					}
					
					ProjekatRadnik ZAPOSLENIK = new ProjekatRadnik();
					try {
						ZAPOSLENIK = new ProjekatRadnik(zh.getUsername(), zh.getIme(), zh.getPrezime(), zh.getAdresa(), zh.getDatumZaposlenja(), zh.getSatnica());
					} catch (InvalidAttributeValueException e1) {
						LOGGER.log(Level.SEVERE,"context",e1);
					}
					IzvjestajZaposlenika iz = null;
					try {
						iz = new IzvjestajZaposlenika(PROJEKAT, ZAPOSLENIK);
					} catch (InvalidAttributeValueException e1) {
						LOGGER.log(Level.SEVERE,"context",e1);
					}
					
					
					Odjel ODJEL = null;
					try {
						ODJEL = new Odjel(oh.getNaziv(), oh.getMaksimalanBrojRadnika());
					} catch (javax.management.InvalidAttributeValueException e1) {
						LOGGER.log(Level.SEVERE,"context",e1);
					}
					ODJEL.setArhiviran(false);
					ArrayList<ZaposlenikHibernate> odjelZap = DalDao.VratiZaposlenikeUOdjelu(OdjelID);
					LinkedList<ProjekatRadnik> zaki = new LinkedList<ProjekatRadnik>();
					
					for (int i = 0; i < odjelZap.size(); i++)
					{
						try {
							ProjekatRadnik prNovi = new ProjekatRadnik(zaki.get(i).getUsername(), zaki.get(i).getIme(), zaki.get(i).getPrezime(), zaki.get(i).getAdresa(), zaki.get(i).getDatumZaposlenja(), zaki.get(i).getSatnica());
							zaki.add(prNovi);
						} catch (InvalidAttributeValueException e1) {
							LOGGER.log(Level.SEVERE,"context",e1);
						}
					
					}
					
					ODJEL.setZaposlenici(zaki);
					IzvjestajOdjela oz = null;
					try {
						oz = new IzvjestajOdjela(PROJEKAT, ODJEL);
					} catch (InvalidAttributeValueException e1) {
						LOGGER.log(Level.SEVERE,"context",e1);
					}
					new IzvjestajForm(iz, oz).setVisible(true);
				}
				
			}
		});
		
		JButton btnPrikazi = new JButton("Prikaži");
		btnPrikazi.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnPrikazi.setForeground(UIManager.getColor("Button.foreground"));
		btnPrikazi.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrikazi.setBounds(88, 336, 74, 23);
		panel_6.add(btnPrikazi);
		
		JButton btnOdobri = new JButton("Odobri");
		btnOdobri.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnOdobri.setForeground(UIManager.getColor("Button.foreground"));
		btnOdobri.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOdobri.setBounds(172, 336, 74, 23);
		panel_6.add(btnOdobri);
		
		JButton btnNewButton_2 = new JButton("Odbij");
		btnNewButton_2.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnNewButton_2.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setBounds(256, 336, 74, 23);
		panel_6.add(btnNewButton_2);
		
		ArrayList<TimesheetHibernate> timesheets = DalDao.VratiTimesheetoveZaValidaciju(zh.getId());
		DefaultListModel dlm = new DefaultListModel();
		final JList list_6 = new JList();
		list_6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane1 = new JScrollPane(list_6, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setBounds(12, 76, 315, 249);
		list_6.setBounds(12, 76, 315, 249);
		list_6.setModel(dlm);
		panel_6.add(scrollPane1);
		
		btnPretrai_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm2.removeAllElements();
				ArrayList<ProjekatHibernate> phovci = new ArrayList<ProjekatHibernate>();
				if (comboBox_17.getSelectedItem().toString().equals("Naziv projekta"))
				{
					if (chckbxPrikaziArhiviraneProjekte.isSelected())
						phovci = DalDao.VratiSveArhiviraneProjekte();
					else 
						phovci = DalDao.VratiSveNearhiviraneProjekte();
					for (int i=0;i<phovci.size();i++)
					{
						if (phovci.get(i).getNaziv().equals(textField_46.getText()))
						{
							if (phovci.get(i).getKoordinator().toString().equals(Zaposlenik.toString()))
							{
							    String tempString = phovci.get(i).getId() + " Projekat: " + phovci.get(i).getNaziv() + ", Klijent: " + phovci.get(i).getNazivKlijenta();
							    dlm2.addElement(tempString);
							}
						}
					}
				} 
				else
				{
					if (chckbxPrikaziArhiviraneProjekte.isSelected())
						phovci = DalDao.VratiSveArhiviraneProjekte();
					else 
						phovci = DalDao.VratiSveNearhiviraneProjekte();
					for (int i=0;i<phovci.size();i++)
					{
						if (phovci.get(i).getNazivKlijenta().equals(textField_46.getText()))
						{
							if (phovci.get(i).getKoordinator().toString().equals(Zaposlenik.toString()))
							{
							    String tempString = phovci.get(i).getId() + " Projekat: " + phovci.get(i).getNaziv() + ", Klijent: " + phovci.get(i).getNazivKlijenta();
							    dlm2.addElement(tempString);
							}
						}
					}
				}
			}
		});
		
		for(int i = 0; i < timesheets.size(); i++)
		{
			if (!timesheets.get(i).getValidiran())
			{
				ArrayList<TaskHibernate> taskovi = DalDao.VratiTimesheetTaskoveZaposlenika(timesheets.get(i).getId());
				if (taskovi != null && taskovi.size() > 0 && taskovi.get(0).getKomentar() != null)
				{
					String ime = taskovi.get(0).getZaposlenik().getIme() + " " + taskovi.get(0).getZaposlenik().getPrezime();
					String komponenta = timesheets.get(i).getId() + " " + "Projekat: " + timesheets.get(i).getProjekat().getNaziv() + ", Zaposlenik: " + ime + ", " + timesheets.get(i).getDatumSlanja().toString();
					dlm.addElement(komponenta); 
				}
			}
		}
		
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(list_6.isSelectionEmpty()){
					greska = false;
					label_17.setText("Morate označiti timesheet da bi ga prikazali!");
				}
				if(greska == false){
					label_17.setVisible(true);
				}
				else {
					label_17.setVisible(false);
					String selektovatniTimesheet = list_6.getSelectedValue().toString();
					new PrikazTimesheeta(selektovatniTimesheet).setVisible(true);
				}
				
			}			
		});
		
		btnOdobri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				
				if(list_6.isSelectionEmpty()){
					greska = false;
					label_17.setText("Morate označiti timesheet da bi ga odobrili!");
				}
				if(greska == false){
					label_17.setVisible(true);
				}
				else {
					label_17.setVisible(false);
					String vrijednost = list_6.getSelectedValue().toString();
					String[] rijeci = vrijednost.split(" ");
					long id = Long.parseLong(rijeci[0]);
					TimesheetHibernate timesheet = DalDao.VratiTimesheet(id);
					timesheet.setValidiran(true);
					DalDao.ModifikujObjekat(timesheet);
					ArrayList<TaskHibernate> taskovi = DalDao.VratiTimesheetTaskoveZaposlenika(id);
					for (int i = 0; i < taskovi.size(); i++)
					{
						taskovi.get(i).setKomentar("Odobren:" + " " + taskovi.get(i).getKomentar());
						DalDao.ModifikujObjekat(taskovi.get(i));
					}
					JOptionPane.showMessageDialog(null, "Uspjesno ste odobrili timesheet", "Timesheet odobren", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if(list_6.isSelectionEmpty()){
					greska = false;
					label_17.setText("Morate označiti timesheet da bi ga odbili!");
				}
				if(greska == false){
					label_17.setVisible(true);
				}
				else {
					label_17.setVisible(false);
					String vrijednost = list_6.getSelectedValue().toString();
					String[] rijeci = vrijednost.split(" ");
					long id = Long.parseLong(rijeci[0]);
					TimesheetHibernate timesheet = DalDao.VratiTimesheet(id);
					timesheet.setValidiran(true);
					DalDao.ModifikujObjekat(timesheet);
					ArrayList<TaskHibernate> taskovi = DalDao.VratiTimesheetTaskoveZaposlenika(id);
					for (int i = 0; i < taskovi.size(); i++)
					{
						taskovi.get(i).setKomentar("Odbijen:" + " " + taskovi.get(i).getKomentar());
						DalDao.ModifikujObjekat(taskovi.get(i));
					}
					JOptionPane.showMessageDialog(null, "Uspjesno ste odbili timesheet", "Timesheet odbijen", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(UIManager.getColor("TextField.darkShadow"));
		
		tabbedPane.addTab("Moj profil", null, panel_12, null);
		panel_12.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setForeground(UIManager.getColor("TextField.highlight"));
		panel_13.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_13.setLayout(null);
		panel_13.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Moji podaci", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_13.setBounds(30, 22, 341, 426);
		panel_12.add(panel_13);
		
		JLabel label_18 = new JLabel("Ime:");
		label_18.setForeground(UIManager.getColor("TextField.highlight"));
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_18.setBounds(93, 40, 82, 14);
		panel_13.add(label_18);
		
		JLabel label_19 = new JLabel("Prezime:");
		label_19.setForeground(UIManager.getColor("TextField.highlight"));
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_19.setBounds(77, 65, 82, 14);
		panel_13.add(label_19);
		
		JLabel label_20 = new JLabel("Adresa:");
		label_20.setForeground(UIManager.getColor("TextField.highlight"));
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_20.setBounds(77, 90, 82, 14);
		panel_13.add(label_20);
		
		JLabel label_23 = new JLabel("Datum zapošljavanja:");
		label_23.setForeground(UIManager.getColor("TextField.highlight"));
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_23.setBounds(10, 201, 113, 14);
		panel_13.add(label_23);
		
		JLabel label_24 = new JLabel("Odjeli:");
		label_24.setForeground(UIManager.getColor("TextField.highlight"));
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_24.setBounds(83, 229, 40, 14);
		panel_13.add(label_24);
		
		JLabel label_25 = new JLabel("Korisničko ime:");
		label_25.setForeground(UIManager.getColor("TextField.highlight"));
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_25.setBounds(47, 340, 82, 14);
		panel_13.add(label_25);
		
		JLabel label_28 = new JLabel("Vrsta korisnika:");
		label_28.setForeground(UIManager.getColor("TextField.highlight"));
		label_28.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_28.setBounds(47, 368, 82, 14);
		panel_13.add(label_28);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.BLACK);
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setDisabledTextColor(UIManager.getColor("Button.foreground"));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(159, 37, 141, 20);
		panel_13.add(textField_3);
		
		textField_8 = new JTextField();
		textField_8.setForeground(Color.BLACK);
		textField_8.setEnabled(false);
		textField_8.setEditable(false);
		textField_8.setDisabledTextColor(UIManager.getColor("Button.foreground"));
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(159, 62, 141, 20);
		panel_13.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setDisabledTextColor(UIManager.getColor("Button.foreground"));
		textField_9.setEnabled(false);
		textField_9.setForeground(UIManager.getColor("Button.darkShadow"));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBorder(null);
		textField_9.setBackground(Color.WHITE);
		textField_9.setBounds(159, 87, 141, 20);
		panel_13.add(textField_9);
		
		textField_12 = new JTextField();
		textField_12.setDisabledTextColor(UIManager.getColor("Button.foreground"));
		textField_12.setForeground(Color.BLACK);
		textField_12.setEnabled(false);
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBorder(null);
		textField_12.setBackground(Color.WHITE);
		textField_12.setBounds(159, 337, 141, 20);
		panel_13.add(textField_12);
		
		JLabel lblSatnica = new JLabel("Satnica:");
		lblSatnica.setForeground(UIManager.getColor("TextField.highlight"));
		lblSatnica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSatnica.setBounds(77, 176, 40, 14);
		panel_13.add(lblSatnica);
		
		final DefaultListModel defaultListModel = new DefaultListModel();
		JList list_5 = new JList();
		list_5.setForeground(Color.BLACK);
		list_5.setModel(defaultListModel);
		list_5.setEnabled(false);
		list_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_5.setBackground(Color.WHITE);
		JScrollPane scrollPane_3 = new JScrollPane(list_5, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_3.setBounds(159, 229, 141, 97);
		list_5.setBounds(159, 229, 141, 97);
		panel_13.add(scrollPane_3);
		
		textField_10 = new JTextField();
		textField_10.setDisabledTextColor(UIManager.getColor("Button.foreground"));
		textField_10.setForeground(Color.BLACK);
		textField_10.setEnabled(false);
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBorder(null);
		textField_10.setBackground(Color.WHITE);
		textField_10.setBounds(159, 365, 141, 20);
		panel_13.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setForeground(SystemColor.controlDkShadow);
		textField_11.setEnabled(false);
		textField_11.setEditable(false);
		textField_11.setDisabledTextColor(Color.BLACK);
		textField_11.setColumns(10);
		textField_11.setBorder(null);
		textField_11.setBackground(Color.WHITE);
		textField_11.setBounds(159, 170, 141, 20);
		panel_13.add(textField_11);
		
		textField_13 = new JTextField();
		textField_13.setForeground(SystemColor.controlDkShadow);
		textField_13.setEnabled(false);
		textField_13.setEditable(false);
		textField_13.setDisabledTextColor(Color.BLACK);
		textField_13.setColumns(10);
		textField_13.setBorder(null);
		textField_13.setBackground(Color.WHITE);
		textField_13.setBounds(159, 198, 141, 20);
		panel_13.add(textField_13);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(87, 117, 58, 14);
		panel_13.add(lblEmail);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefon.setBounds(77, 145, 82, 14);
		panel_13.add(lblTelefon);
		
		textField_14 = new JTextField();
		textField_14.setForeground(SystemColor.controlDkShadow);
		textField_14.setEnabled(false);
		textField_14.setEditable(false);
		textField_14.setDisabledTextColor(Color.BLACK);
		textField_14.setColumns(10);
		textField_14.setBorder(null);
		textField_14.setBackground(Color.WHITE);
		textField_14.setBounds(159, 114, 141, 20);
		panel_13.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setForeground(SystemColor.controlDkShadow);
		textField_15.setEnabled(false);
		textField_15.setEditable(false);
		textField_15.setDisabledTextColor(Color.BLACK);
		textField_15.setColumns(10);
		textField_15.setBorder(null);
		textField_15.setBackground(Color.WHITE);
		textField_15.setBounds(159, 142, 141, 20);
		panel_13.add(textField_15);
		
		JPanel panel_14 = new JPanel();
		panel_14.setForeground(UIManager.getColor("TextField.highlight"));
		panel_14.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_14.setLayout(null);
		panel_14.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Promjena lozinke", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_14.setBounds(392, 22, 341, 426);
		panel_12.add(panel_14);
		
		JLabel label_29 = new JLabel("Trenutna lozinka:");
		label_29.setForeground(UIManager.getColor("TextField.highlight"));
		label_29.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_29.setBounds(48, 38, 83, 14);
		panel_14.add(label_29);
		
		JLabel label_30 = new JLabel("Nova lozinka:");
		label_30.setForeground(UIManager.getColor("TextField.highlight"));
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_30.setBounds(67, 66, 64, 14);
		panel_14.add(label_30);
		
		JLabel label_31 = new JLabel("Nova lozinka(ponovo):");
		label_31.setForeground(UIManager.getColor("TextField.highlight"));
		label_31.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_31.setBounds(23, 94, 108, 14);
		panel_14.add(label_31);
		
		final JLabel label_32 = new JLabel("");
		label_32.setForeground(Color.RED);
		label_32.setVisible(false);
		label_32.setBounds(0, 459, 759, 25);
		panel_12.add(label_32); 
		
		JButton button_4 = new JButton("Spasi promjenu");
		button_4.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		button_4.setForeground(UIManager.getColor("Button.foreground"));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				try {
					String staraLozinka = new String(passwordField.getPassword());
					String novaLozinka = new String(passwordField_1.getPassword());
					String novaLozinkaRepeat = new String(passwordField_2.getPassword());
					
					if(staraLozinka.length() < 7) {
						greska = false;
						label_32.setText("Unesite trenutnu lozinku!");
					}
					if (!Lozinka.validatePassword(staraLozinka, zh.getLozinka()))
					{
						greska = false;
						label_32.setText("Neispravan unos trenutne lozinke!");
					}
					if(novaLozinka.length() < 7 || novaLozinkaRepeat.length() < 7){
						greska = false;
						label_32.setText("Lozinka mora imati najmanje 7 karaktera!");
					}
					if(!novaLozinka.equals(novaLozinkaRepeat)) {
						greska = false;
						label_32.setText("Lozinke se ne poklapaju!");
					}
					if(!novaLozinka.matches("^[a-zA-Z0-9]*$")) {
						greska = false;
						label_32.setText("Neispravan format lozinke (koristite samo slova engleskog alfabeta i brojeve)!");
					}
					if(greska == false){
						label_32.setVisible(true);
					}
					else 
					{
						label_32.setVisible(false);
						zh.setLozinka(Lozinka.generateStorngPasswordHash(novaLozinka));
						DalDao.ModifikujObjekat(zh);
						JOptionPane.showMessageDialog(null, "Uspjesno ste promjenili lozinku!", "Lozinka promjenjena", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
		});
		
		button_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_4.setBounds(67, 138, 120, 23);
		panel_14.add(button_4);
		
		JButton button_5 = new JButton("Otkaži");
		button_5.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		button_5.setForeground(UIManager.getColor("Button.foreground"));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
				passwordField_1.setText("");
				passwordField_2.setText("");
				label_32.setVisible(false);
			}
		});
		
		button_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_5.setBounds(193, 138, 110, 23);
		panel_14.add(button_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(156, 35, 147, 20);
		panel_14.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(156, 63, 147, 20);
		panel_14.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(156, 91, 147, 20);
		panel_14.add(passwordField_2);
		
		panel_12.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				textField_3.setText(Zaposlenik.getIme());
				textField_8.setText(Zaposlenik.getPrezime());
				textField_9.setText(Zaposlenik.getAdresa());
				Double satnica = Zaposlenik.getSatnica();
				textField_11.setText(satnica.toString());
				Calendar calendar = Calendar.getInstance();
				calendar.set(Zaposlenik.getDatumZaposlenja().getYear(), Zaposlenik.getDatumZaposlenja().getMonthValue(), Zaposlenik.getDatumZaposlenja().getDayOfMonth());
				textField_1.setText(calendar.toString());
				ArrayList<OdjelHibernate> listaOdjela = DalDao.VratiZaposlenikoveOdjele(Zaposlenik.getId());
				for(OdjelHibernate odjel : listaOdjela) {
					defaultListModel.addElement(odjel);
				}
				textField_13.setText(Zaposlenik.getDatumZaposlenja().toString());
				textField_12.setText(Zaposlenik.getUsername());
				textField_10.setText("Koordinator");
				textField_14.setText(Zaposlenik.getEmail());
				textField_15.setText(Zaposlenik.getTelefon());
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
				
	}
	
	private void JTable(Object rowData, TableColumnModel columnNames) {
		// TODO Auto-generated method stub
		
	}
}
