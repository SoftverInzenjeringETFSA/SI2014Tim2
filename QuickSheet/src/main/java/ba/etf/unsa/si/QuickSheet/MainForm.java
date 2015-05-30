package ba.etf.unsa.si.QuickSheet;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableColumnModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import ba.etf.unsa.si.KlaseHibernate.AdministratorHibernate;
import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.Lozinka;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Zaposlenik;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.OdjelZaposlenikHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class MainForm extends JFrame {
	private JTextField textField;
	private JPanel panel;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	protected static final Logger LOGGER = Logger.getLogger("MainForm");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm(new AdministratorHibernate());
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public MainForm(AdministratorHibernate admin) {
		final AdministratorHibernate Admin = admin;
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("QuickSheet - Administrator");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 765, 476);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.setBounds(0, 0, 764, 447);
		getContentPane().add(tabbedPane);
		setLocationRelativeTo(null);
		
		JPanel odjeliPanel = new JPanel();
		odjeliPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.addTab("Odjeli", null, odjeliPanel, null);
		odjeliPanel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodaj novi odjel", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_2.setLayout(null);
		panel_2.setBounds(30, 22, 341, 370);
		odjeliPanel.add(panel_2);
		
		lblNaziv = new JLabel("Naziv odjela:");
		lblNaziv.setForeground(UIManager.getColor("TextField.highlight"));
		lblNaziv.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNaziv.setBounds(78, 33, 102, 14);
		panel_2.add(lblNaziv);
		
		textField_43 = new JTextField();
		textField_43.setColumns(10);
		textField_43.setBounds(190, 30, 141, 20);
		panel_2.add(textField_43);
		
		JLabel lblNewLabel_7 = new JLabel("Dodaj zaposlenika:");
		lblNewLabel_7.setForeground(UIManager.getColor("TextField.highlight"));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(50, 58, 102, 29);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblMaksimalniBroj = new JLabel("Maksimalni broj zaposlenika:");
		lblMaksimalniBroj.setForeground(UIManager.getColor("TextField.highlight"));
		lblMaksimalniBroj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaksimalniBroj.setBounds(10, 210, 152, 14);
		panel_2.add(lblMaksimalniBroj);
		
		textField_44 = new JTextField();
		textField_44.setBounds(190, 207, 141, 20);
		panel_2.add(textField_44);
		textField_44.setColumns(10);
		
		final JList list_3 = new JList();
		final DefaultListModel listaZaposlenika = new DefaultListModel();
		list_3.setModel(listaZaposlenika);
		ArrayList<ZaposlenikHibernate> zaposlenici=DalDao.VratiSveZaposlenike();

		for (int i=0;i<zaposlenici.size();i++)
			{
			    String tempString = zaposlenici.get(i).getId() + " " + zaposlenici.get(i).getIme() + " " + zaposlenici.get(i).getPrezime()
			    		+ " " + zaposlenici.get(i).getAdresa() + " " + zaposlenici.get(i).getSatnica();
				listaZaposlenika.addElement(tempString);
			}
		
		list_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list_3.setBounds(190, 61, 141, 135);
		panel_2.add(list_3);
		
		final JLabel label_error = new JLabel("");
		label_error.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_error.setForeground(Color.RED);
		label_error.setBounds(0, 405, 764, 14);
		odjeliPanel.add(label_error);
		label_error.setVisible(false);
		
		JButton btnDodaj_1 = new JButton("Dodaj");
		btnDodaj_1.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnDodaj_1.setForeground(UIManager.getColor("Button.foreground"));
		btnDodaj_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true; 
				
				if(textField_43.getText().equals("")){
					label_error.setText("Unesite naziv odjela!");
					greska = false;}
				else if(list_3.isSelectionEmpty()){
					label_error.setText("Morate označiti zaposlenike koje želite da dodate u odjel!");
					greska = false;}
				
				else if(textField_44.getText().equals("") ){
					label_error.setText("Unesite maksimalan broj zaposlenika!");
					greska = false;}
				else if(Integer.parseInt(textField_44.getText()) > 12){
					label_error.setText("Broj zaposlenika mora biti manji od 12!");
					greska = false;}
				
				else greska = true;
				
				if(greska == false){
					label_error.setVisible(true);	
				}
				
				else{
					label_error.setVisible(false);
					OdjelHibernate odjelh = new OdjelHibernate();
					odjelh.setNaziv(textField_43.getText());
					odjelh.setMaksimalanBrojRadnika(Integer.parseInt(textField_44.getText()));
					DalDao.DodajObjekat(odjelh);
					
					int[] indeksi=list_3.getSelectedIndices();
					for(int i=0;i<indeksi.length;i++){
						String selektovano=listaZaposlenika.getElementAt(indeksi[i]).toString();
						String[] rijeciPr=selektovano.split(" ");
						long idPr=Long.parseLong(rijeciPr[0]);
						ZaposlenikHibernate zPr=DalDao.VratiZaposlenika(idPr);
						OdjelZaposlenikHibernate ozh=new OdjelZaposlenikHibernate();
						ozh.setOdjel(odjelh);
						ozh.setZaposlenikOdjela(zPr);
						DalDao.DodajObjekat(ozh);
					}
					JOptionPane.showMessageDialog(null, "Odjel je dodan.", "Uredu", JOptionPane.INFORMATION_MESSAGE);
					textField_43.setText("");
					textField_44.setText("");
					list_3.clearSelection();
				}
				
				
			}
		});
		
		btnDodaj_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDodaj_1.setBounds(147, 309, 89, 23);
		panel_2.add(btnDodaj_1);
		
		JButton btnOtkai = new JButton("Otkaži");
		btnOtkai.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnOtkai.setForeground(UIManager.getColor("Button.foreground"));
		btnOtkai.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOtkai.setBounds(242, 309, 89, 23);
		panel_2.add(btnOtkai);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga odjela", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_3.setBounds(392, 22, 341, 370);
		odjeliPanel.add(panel_3);
		panel_3.setLayout(null);
		
		textField_45 = new JTextField();
		textField_45.setBounds(131, 56, 124, 23);
		panel_3.add(textField_45);
		textField_45.setColumns(10);
		
		final JComboBox comboBox_16 = new JComboBox();
		comboBox_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_16.setModel(new DefaultComboBoxModel(new String[] {"Naziv"}));
		comboBox_16.setBounds(22, 56, 99, 23);
		panel_3.add(comboBox_16);
		
		final JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Prikaži arhivirane odjele");
		chckbxNewCheckBox_1.setForeground(UIManager.getColor("TextField.highlight"));
		chckbxNewCheckBox_1.setBackground(UIManager.getColor("TextField.darkShadow"));
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox_1.setBounds(22, 86, 149, 23);
		panel_3.add(chckbxNewCheckBox_1);
		
		final JList list_4 = new JList();
		list_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list_4.setBounds(22, 114, 309, 209);
		panel_3.add(list_4);
		
		JButton btnPretrai = new JButton("Pretraži");
		btnPretrai.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnPretrai.setForeground(UIManager.getColor("Button.foreground"));
		btnPretrai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				
				if (textField_45.getText().equalsIgnoreCase("") && chckbxNewCheckBox_1.isSelected()){
					DefaultListModel listaArhOdjela = new DefaultListModel();
					list_4.setModel(listaArhOdjela);
					ArrayList<OdjelHibernate> arhiviraniOdjeli=DalDao.VratiSveArhiviraneOdjele();

					for (int i=0;i<arhiviraniOdjeli.size();i++)
						{
						    String tempString = arhiviraniOdjeli.get(i).getId() + " " + arhiviraniOdjeli.get(i).getNaziv();
							listaArhOdjela.addElement(tempString);
						}
				} else 
					if (textField_45.getText().equalsIgnoreCase("") && chckbxNewCheckBox_1.isSelected()==false){
						DefaultListModel listaArhOdjela = new DefaultListModel();
						list_4.setModel(listaArhOdjela);
						ArrayList<OdjelHibernate> arhiviraniOdjeli=DalDao.VratiSveNearhiviraneOdjele();

						for (int i=0;i<arhiviraniOdjeli.size();i++)
							{
							    String tempString = arhiviraniOdjeli.get(i).getId() + " " + arhiviraniOdjeli.get(i).getNaziv();
								listaArhOdjela.addElement(tempString);
							}
					} else
						if (chckbxNewCheckBox_1.isSelected()){
							DefaultListModel listaArhOdjela = new DefaultListModel();
							list_4.setModel(listaArhOdjela);
							ArrayList<OdjelHibernate> arhiviraniOdjeli=DalDao.PretraziArhiviraneOdjele(textField_45.getText());

							for (int i=0;i<arhiviraniOdjeli.size();i++)
								{
								    String tempString = arhiviraniOdjeli.get(i).getId() + " " + arhiviraniOdjeli.get(i).getNaziv();
									listaArhOdjela.addElement(tempString);
								}
						} else
							if (chckbxNewCheckBox_1.isSelected()==false){
								DefaultListModel listaArhOdjela = new DefaultListModel();
								list_4.setModel(listaArhOdjela);
								ArrayList<OdjelHibernate> arhiviraniOdjeli=DalDao.PretraziNearhiviraneOdjele(textField_45.getText());

								for (int i=0;i<arhiviraniOdjeli.size();i++)
									{
									    String tempString = arhiviraniOdjeli.get(i).getId() + " " + arhiviraniOdjeli.get(i).getNaziv();
										listaArhOdjela.addElement(tempString);
									}
							} 		
			}
		});
		
		btnPretrai.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPretrai.setBounds(262, 56, 69, 23);
		panel_3.add(btnPretrai);
		
		JButton btnIzmjeni = new JButton("Prikaži odjel");
		btnIzmjeni.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnIzmjeni.setForeground(UIManager.getColor("Button.foreground"));
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				
				if(list_4.isSelectionEmpty()){
					greska = false;
					
				}
				
				if(greska == false){
					
					label_error.setText("Morate označiti odjel!");
					label_error.setVisible(true);
				}
				else{
					label_error.setVisible(false);
					String Odjel=list_4.getSelectedValue().toString();
					new OdjelForm(Odjel).setVisible(true);
				}
				
			}
		});
		
		btnIzmjeni.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnIzmjeni.setBounds(83, 334, 119, 23);
		panel_3.add(btnIzmjeni);
		
		JButton btnObrisi = new JButton("Obriši odjel");
		btnObrisi.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnObrisi.setForeground(UIManager.getColor("Button.foreground"));
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(list_4.isSelectionEmpty()){
					greska = false;
					
				}
				if(greska == false){
					
					label_error.setText("Morate selektovati odjel da bi ga izbrisali!");
					label_error.setVisible(true);
				}
				else{
					label_error.setVisible(false);
					
					String selektovanaVrijednost = list_4.getSelectedValue().toString();
					String[] rijeci = selektovanaVrijednost.split(" ");
					long id = Long.parseLong(rijeci[0]);
					OdjelHibernate o=DalDao.VratiOdjel(id);
					o.setArhiviran(true);
					DalDao.ModifikujObjekat(o);
					JOptionPane.showMessageDialog(null, "Odjel je arhiviran.", "Uredu", JOptionPane.INFORMATION_MESSAGE);
					
					DefaultListModel listaArhOdjela = new DefaultListModel();
					list_4.setModel(listaArhOdjela);
					ArrayList<OdjelHibernate> arhiviraniOdjeli=DalDao.VratiSveNearhiviraneOdjele();

					for (int i=0;i<arhiviraniOdjeli.size();i++)
						{
						    String tempString = arhiviraniOdjeli.get(i).getId() + " " + arhiviraniOdjeli.get(i).getNaziv();
							listaArhOdjela.addElement(tempString);
						}
					textField_45.setText("");
				}
			}
		});
		
		btnObrisi.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnObrisi.setBounds(212, 334, 119, 23);
		panel_3.add(btnObrisi);
		
		JLabel label_5 = new JLabel("Izaberite parametar pretrage:");
		label_5.setForeground(UIManager.getColor("TextField.highlight"));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(22, 29, 170, 14);
		panel_3.add(label_5);
		
		JPanel projektiPanel = new JPanel();
		projektiPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.addTab("Projekti", null, projektiPanel, null);
		projektiPanel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodaj novi projekat", TitledBorder.LEFT, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_5.setLayout(null);
		panel_5.setBounds(30, 22, 341, 370);
		projektiPanel.add(panel_5);
		
		JLabel lblNazivProjekta = new JLabel("Naziv projekta:");
		lblNazivProjekta.setForeground(UIManager.getColor("TextField.highlight"));
		lblNazivProjekta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNazivProjekta.setBounds(62, 36, 73, 14);
		panel_5.add(lblNazivProjekta);
		
		textField_47 = new JTextField();
		textField_47.setColumns(10);
		textField_47.setBounds(190, 30, 141, 20);
		panel_5.add(textField_47);
		
		JLabel label_3 = new JLabel("Dodaj zaposlenika:");
		label_3.setForeground(UIManager.getColor("TextField.highlight"));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(45, 120, 90, 14);
		panel_5.add(label_3);
		
		JLabel lblDodajNadreenog = new JLabel("Dodaj nadređenog:");
		lblDodajNadreenog.setForeground(UIManager.getColor("TextField.highlight"));
		lblDodajNadreenog.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDodajNadreenog.setBounds(42, 254, 93, 14);
		panel_5.add(lblDodajNadreenog);
		
		final JComboBox comboBox_19 = new JComboBox();
		comboBox_19.removeAllItems();
		ArrayList<ZaposlenikHibernate> zh=DalDao.VratiSveZaposlenikeKoordinatore();
		for(ZaposlenikHibernate zap:zh){
			comboBox_19.addItem(zh);
		}
		comboBox_19.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_19.setBounds(190, 248, 141, 20);
		panel_5.add(comboBox_19);
		
		final JList list = new JList();
		final DefaultListModel listaZaposlenikaPr = new DefaultListModel();
		list.setModel(listaZaposlenikaPr);
		ArrayList<ZaposlenikHibernate> zaposleniciPr=DalDao.VratiSveZaposlenike();

		for (int i=0;i<zaposleniciPr.size();i++)
			{
			    String tempString = zaposleniciPr.get(i).getId() + " " + zaposleniciPr.get(i).getIme() + " " + zaposleniciPr.get(i).getPrezime()
			    		+ " " + zaposleniciPr.get(i).getAdresa() + " " + zaposleniciPr.get(i).getSatnica();
				listaZaposlenikaPr.addElement(tempString);
			}
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list.setBounds(190, 117, 141, 121);
		panel_5.add(list);
		
		final JLabel label_error1 = new JLabel("");
		label_error1.setForeground(Color.RED);
		label_error1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_error1.setVisible(false);
		label_error1.setBounds(0, 403, 759, 14);
		projektiPanel.add(label_error1);
		
		JButton button_7 = new JButton("Dodaj");
		button_7.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button_7.setForeground(UIManager.getColor("Button.foreground"));
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				if(textField_47.getText().equals("")){
					greska = false;
					label_error1.setText("Morate unijeti naziv projekta!");
				}
				else if(textField_48.getText().equals("")){
					greska = false;
					label_error1.setText("Morate unijeti naziv klijenta!");
				}
				else if(list.isSelectionEmpty()){
					greska = false;
					label_error1.setText("Morate označiti zaposlenike!");
				}
				else if(comboBox_19.getSelectedItem() == null){
					greska = false;
					label_error1.setText("Morate označiti nadređenog!");
				}
				else greska = true;
				
				if(greska == false){
					label_error1.setVisible(true);
				}
				else  {
					label_error1.setVisible(false);
					ProjekatHibernate projekath = new ProjekatHibernate();
					projekath.setNaziv(textField_47.getText());
					projekath.setNazivKlijenta(textField_48.getText());
					
					String selekt=comboBox_19.getSelectedItem().toString();
					String[] rijecis=selekt.split(" ");
					long ids=Long.parseLong(rijecis[0]);
					ZaposlenikHibernate zs=DalDao.VratiZaposlenika(ids);
					
					projekath.setKoordinator(zs);
					DalDao.DodajObjekat(projekath);
					int[] indeksi=list.getSelectedIndices();
					for(int i=0;i<indeksi.length;i++){
						String selektovano=listaZaposlenikaPr.getElementAt(indeksi[i]).toString();
						String[] rijeciPr=selektovano.split(" ");
						long idPr=Long.parseLong(rijeciPr[0]);
						ZaposlenikHibernate zPr=DalDao.VratiZaposlenika(idPr);
						TaskHibernate tPr=new TaskHibernate();
						tPr.setProjekat(projekath);
						tPr.setZaposlenik(zPr);
						DalDao.DodajObjekat(tPr);
					}
					
					JOptionPane.showMessageDialog(null, "Projekat je dodan.", "OK", JOptionPane.INFORMATION_MESSAGE);
					textField_47.setText("");
					textField_48.setText("");
					list.clearSelection();
				}
			}
		});
		
		button_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_7.setBounds(147, 308, 89, 23);
		panel_5.add(button_7);
		
		JLabel lblNazivKlijenta = new JLabel("Naziv klijenta:");
		lblNazivKlijenta.setForeground(UIManager.getColor("TextField.highlight"));
		lblNazivKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNazivKlijenta.setBounds(68, 81, 67, 14);
		panel_5.add(lblNazivKlijenta);
		
		textField_48 = new JTextField();
		textField_48.setColumns(10);
		textField_48.setBounds(190, 75, 141, 20);
		panel_5.add(textField_48);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(149, 215, 82, -66);
		panel_5.add(verticalBox);
		
		JButton btnOtkai_1 = new JButton("Otkaži");
		btnOtkai_1.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnOtkai_1.setForeground(UIManager.getColor("Button.foreground"));
		btnOtkai_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_47.setText("");
				textField_48.setText("");
				list.clearSelection();
				comboBox_19.setSelectedIndex(-1);
				label_error1.setVisible(false);
			}
		});
		
		btnOtkai_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOtkai_1.setBounds(242, 308, 89, 23);
		panel_5.add(btnOtkai_1);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_11.setLayout(null);
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga projekta", TitledBorder.LEFT, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_11.setBounds(392, 22, 341, 370);
		projektiPanel.add(panel_11);
		
		final JCheckBox chckbxPrikaziArhiviraneProjekte = new JCheckBox("Prikazi arhivirane projekte");
		chckbxPrikaziArhiviraneProjekte.setBackground(UIManager.getColor("TextField.darkShadow"));
		chckbxPrikaziArhiviraneProjekte.setForeground(UIManager.getColor("TextField.highlight"));
		chckbxPrikaziArhiviraneProjekte.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxPrikaziArhiviraneProjekte.setBounds(22, 86, 149, 23);
		panel_11.add(chckbxPrikaziArhiviraneProjekte);
		
		final JComboBox comboBox_17 = new JComboBox();
		comboBox_17.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_17.setModel(new DefaultComboBoxModel(new String[] {"Naziv projekta", "Naziv klijenta"}));
		comboBox_17.setBounds(22, 56, 99, 23);
		panel_11.add(comboBox_17);
		
		final JList list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list_1.setBounds(22, 114, 309, 209);
		panel_11.add(list_1);
		
		JButton btnPretrai_1 = new JButton("Pretraži");
		btnPretrai_1.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnPretrai_1.setForeground(UIManager.getColor("Button.foreground"));
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
				if (comboBox_17.getSelectedItem().toString().equals("Naziv projekta") && textField_46.getText().equalsIgnoreCase("") && chckbxPrikaziArhiviraneProjekte.isSelected()){
					DefaultListModel listaArhProjekata = new DefaultListModel();
					list_1.setModel(listaArhProjekata);
					ArrayList<ProjekatHibernate> arhiviraniProjekti=DalDao.VratiSveArhiviraneProjekte();

					for (int i=0;i<arhiviraniProjekti.size();i++)
						{
						    String tempString = arhiviraniProjekti.get(i).getId() + " " + arhiviraniProjekti.get(i).getNaziv() + " " + arhiviraniProjekti.get(i).getNazivKlijenta();
						    listaArhProjekata.addElement(tempString);
						}
				} else
					if (comboBox_17.getSelectedItem().toString().equals("Naziv projekta") && textField_46.getText().equalsIgnoreCase("") && chckbxPrikaziArhiviraneProjekte.isSelected()==false){
						DefaultListModel listaArhProjekata = new DefaultListModel();
						list_1.setModel(listaArhProjekata);
						ArrayList<ProjekatHibernate> arhiviraniProjekti=DalDao.VratiSveNearhiviraneProjekte();

						for (int i=0;i<arhiviraniProjekti.size();i++)
							{
							    String tempString = arhiviraniProjekti.get(i).getId() + " " + arhiviraniProjekti.get(i).getNaziv() + " " + arhiviraniProjekti.get(i).getNazivKlijenta();
							    listaArhProjekata.addElement(tempString);
							}
					} else
						if (comboBox_17.getSelectedItem().toString().equals("Naziv klijenta") && textField_46.getText().equalsIgnoreCase("") && chckbxPrikaziArhiviraneProjekte.isSelected()){
							DefaultListModel listaArhProjekata = new DefaultListModel();
							list_1.setModel(listaArhProjekata);
							ArrayList<ProjekatHibernate> arhiviraniProjekti=DalDao.VratiSveArhiviraneProjekte();

							for (int i=0;i<arhiviraniProjekti.size();i++)
								{
								    String tempString = arhiviraniProjekti.get(i).getId() + " " + arhiviraniProjekti.get(i).getNaziv() + " " + arhiviraniProjekti.get(i).getNazivKlijenta();
								    listaArhProjekata.addElement(tempString);
								}
						} else
							if (comboBox_17.getSelectedItem().toString().equals("Naziv klijenta") && textField_46.getText().equalsIgnoreCase("") && chckbxPrikaziArhiviraneProjekte.isSelected()==false){
								DefaultListModel listaArhProjekata = new DefaultListModel();
								list_1.setModel(listaArhProjekata);
								ArrayList<ProjekatHibernate> arhiviraniProjekti=DalDao.VratiSveNearhiviraneProjekte();

								for (int i=0;i<arhiviraniProjekti.size();i++)
									{
									    String tempString = arhiviraniProjekti.get(i).getId() + " " + arhiviraniProjekti.get(i).getNaziv() + " " + arhiviraniProjekti.get(i).getNazivKlijenta();
									    listaArhProjekata.addElement(tempString);
									}
							} else
								if (comboBox_17.getSelectedItem().toString().equals("Naziv projekta") && textField_46.getText().equalsIgnoreCase("")==false && chckbxPrikaziArhiviraneProjekte.isSelected()){
									DefaultListModel listaArhProjekata = new DefaultListModel();
									list_1.setModel(listaArhProjekata);
									ArrayList<ProjekatHibernate> arhiviraniProjekti=DalDao.VratiArhiviraneProjektePoNazivu(textField_46.getText());

									for (int i=0;i<arhiviraniProjekti.size();i++)
										{
										    String tempString = arhiviraniProjekti.get(i).getId() + " " + arhiviraniProjekti.get(i).getNaziv() + " " + arhiviraniProjekti.get(i).getNazivKlijenta();
										    listaArhProjekata.addElement(tempString);
										}
								} else
									if (comboBox_17.getSelectedItem().toString().equals("Naziv projekta") && textField_46.getText().equalsIgnoreCase("")==false && chckbxPrikaziArhiviraneProjekte.isSelected()==false){
										DefaultListModel listaArhProjekata = new DefaultListModel();
										list_1.setModel(listaArhProjekata);
										ArrayList<ProjekatHibernate> arhiviraniProjekti=DalDao.VratiNearhiviraneProjektePoNazivu(textField_46.getText());

										for (int i=0;i<arhiviraniProjekti.size();i++)
											{
											    String tempString = arhiviraniProjekti.get(i).getId() + " " + arhiviraniProjekti.get(i).getNaziv() + " " + arhiviraniProjekti.get(i).getNazivKlijenta();
											    listaArhProjekata.addElement(tempString);
											}
									} else
										if (comboBox_17.getSelectedItem().toString().equals("Naziv klijenta") && textField_46.getText().equalsIgnoreCase("")==false && chckbxPrikaziArhiviraneProjekte.isSelected()){
											DefaultListModel listaArhProjekata = new DefaultListModel();
											list_1.setModel(listaArhProjekata);
											ArrayList<ProjekatHibernate> arhiviraniProjekti=DalDao.VratiArhiviraneProjektePoNazivuKlijenta(textField_46.getText());

											for (int i=0;i<arhiviraniProjekti.size();i++)
												{
												    String tempString = arhiviraniProjekti.get(i).getId() + " " + arhiviraniProjekti.get(i).getNaziv() + " " + arhiviraniProjekti.get(i).getNazivKlijenta();
												    listaArhProjekata.addElement(tempString);
												}
										} else
											if (comboBox_17.getSelectedItem().toString().equals("Naziv klijenta") && textField_46.getText().equalsIgnoreCase("")==false && chckbxPrikaziArhiviraneProjekte.isSelected()==false){
												DefaultListModel listaArhProjekata = new DefaultListModel();
												list_1.setModel(listaArhProjekata);
												ArrayList<ProjekatHibernate> arhiviraniProjekti=DalDao.VratiNearhiviraneProjektePoNazivuKlijenta(textField_46.getText());

												for (int i=0;i<arhiviraniProjekti.size();i++)
													{
													    String tempString = arhiviraniProjekti.get(i).getId() + " " + arhiviraniProjekti.get(i).getNaziv() + " " + arhiviraniProjekti.get(i).getNazivKlijenta();
													    listaArhProjekata.addElement(tempString);
													}
											}	
			}
		});
		
		btnPretrai_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPretrai_1.setBounds(265, 56, 69, 23);
		panel_11.add(btnPretrai_1);
		
		textField_46 = new JTextField();
		textField_46.setBounds(131, 56, 124, 23);
		panel_11.add(textField_46);
		textField_46.setColumns(10);
		
		JButton btnSauvajPromjene = new JButton("Prikaži projekat");
		btnSauvajPromjene.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnSauvajPromjene.setForeground(UIManager.getColor("Button.foreground"));
		btnSauvajPromjene.addActionListener(new ActionListener() {
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
					String Projekat=list_1.getSelectedValue().toString();
					new ProjekatForm(Projekat).setVisible(true);
					
				}
				
			}
		});
		btnSauvajPromjene.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSauvajPromjene.setBounds(83, 334, 119, 23);
		panel_11.add(btnSauvajPromjene);
		
		JButton btnObriiProjekat = new JButton("Obriši projekat");
		btnObriiProjekat.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnObriiProjekat.setForeground(UIManager.getColor("Button.foreground"));
		btnObriiProjekat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				if(list_1.isSelectionEmpty()){
					greska = false;
					label_error1.setText("Morate označiti projekat da bi ga obrisali!");
					
				}
				if(greska == false){
					label_error1.setVisible(true);
				}
				else{
					label_error1.setVisible(false);
					String selektovanaVrijednost = list_1.getSelectedValue().toString();
					String[] rijeci = selektovanaVrijednost.split(" ");
					long id = Long.parseLong(rijeci[0]);
					ProjekatHibernate o=DalDao.VratiProjekat(id);
					o.setArhiviran(true);
					DalDao.ModifikujObjekat(o);
					JOptionPane.showMessageDialog(null, "Projekat je arhiviran.", "Uredu", JOptionPane.INFORMATION_MESSAGE);
					
					DefaultListModel listaArhProjekata = new DefaultListModel();
					list_1.setModel(listaArhProjekata);
					ArrayList<ProjekatHibernate> nearhiviraniProjekti=DalDao.VratiSveNearhiviraneProjekte();

					for (int i=0;i<nearhiviraniProjekti.size();i++)
						{
						    String tempString = nearhiviraniProjekti.get(i).getId() + " " + nearhiviraniProjekti.get(i).getNaziv() + " " + nearhiviraniProjekti.get(i).getNazivKlijenta();
							listaArhProjekata.addElement(tempString);
						}
					textField_46.setText("");
					
				}
			}
		});
		
		btnObriiProjekat.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnObriiProjekat.setBounds(212, 334, 119, 23);
		panel_11.add(btnObriiProjekat);
		
		JLabel label_7 = new JLabel("Izaberite parametar pretrage:");
		label_7.setForeground(UIManager.getColor("TextField.highlight"));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(22, 29, 170, 14);
		panel_11.add(label_7);
		
		JPanel korisniciPanel = new JPanel();
		korisniciPanel.setBackground(UIManager.getColor("TextField.darkShadow"));
		
		tabbedPane.addTab("Korisnici", null, korisniciPanel, null);
		korisniciPanel.setLayout(null);
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o korisniku", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel.setBounds(30, 22, 341, 370);
		korisniciPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setForeground(UIManager.getColor("TextField.highlight"));
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIme.setBounds(98, 24, 82, 14);
		panel.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setForeground(UIManager.getColor("TextField.highlight"));
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrezime.setBounds(82, 49, 82, 14);
		panel.add(lblPrezime);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setForeground(UIManager.getColor("TextField.highlight"));
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAdresa.setBounds(82, 74, 82, 14);
		panel.add(lblAdresa);
		
		JLabel lblNewLabel_8 = new JLabel("Datum zapošljavanja:");
		lblNewLabel_8.setForeground(UIManager.getColor("TextField.highlight"));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(10, 102, 104, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblOdjel = new JLabel("Odjel:");
		lblOdjel.setForeground(UIManager.getColor("TextField.highlight"));
		lblOdjel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOdjel.setBounds(82, 127, 46, 14);
		panel.add(lblOdjel);
		
		JLabel lblKorisnickoIme = new JLabel("Korisničko ime:");
		lblKorisnickoIme.setForeground(UIManager.getColor("TextField.highlight"));
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKorisnickoIme.setBounds(52, 211, 82, 14);
		panel.add(lblKorisnickoIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setForeground(UIManager.getColor("TextField.highlight"));
		lblLozinka.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLozinka.setBounds(82, 236, 46, 14);
		panel.add(lblLozinka);
		
		JLabel lblPonoviLozinku = new JLabel("Ponovi lozinku:");
		lblPonoviLozinku.setForeground(UIManager.getColor("TextField.highlight"));
		lblPonoviLozinku.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPonoviLozinku.setBounds(52, 261, 92, 14);
		panel.add(lblPonoviLozinku);
		
		JLabel lblVrstaKorisnika = new JLabel("Koordinator:");
		lblVrstaKorisnika.setForeground(UIManager.getColor("TextField.highlight"));
		lblVrstaKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVrstaKorisnika.setBounds(62, 286, 82, 14);
		panel.add(lblVrstaKorisnika);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 258, 141, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(190, 233, 141, 20);
		panel.add(passwordField_1);
		
		textField_36 = new JTextField();
		textField_36.setBounds(190, 21, 141, 20);
		panel.add(textField_36);
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(190, 44, 141, 20);
		panel.add(textField_37);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(190, 69, 141, 20);
		panel.add(textField_38);
		
		textField_41 = new JTextField();
		textField_41.setColumns(10);
		textField_41.setBounds(190, 208, 141, 20);
		panel.add(textField_41);
		
		final JLabel label_error2 = new JLabel("");
		label_error2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_error2.setForeground(Color.RED);
		label_error2.setBounds(0, 403, 759, 14);
		korisniciPanel.add(label_error2);
		
		final JCheckBox chckbxDa = new JCheckBox("Da");
		chckbxDa.setBackground(UIManager.getColor("TextField.darkShadow"));
		chckbxDa.setForeground(UIManager.getColor("TextField.highlight"));
		chckbxDa.setBounds(190, 282, 97, 23);
		panel.add(chckbxDa);
		
		final JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerDateModel(new Date(1432332000000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(190, 99, 141, 20);
		panel.add(spinner);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spinner_1.setBounds(190, 182, 141, 20);
		panel.add(spinner_1);
		
		DefaultListModel lista2 = new DefaultListModel();
		final JList list_5 = new JList();
		JScrollPane scrollPane = new JScrollPane(list_5, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(190, 126, 141, 50);
		list_5.setBounds(190, 126, 141, 50);
		list_5.setModel(lista2);
		ArrayList<OdjelHibernate> sviOdjeli = DalDao.VratiSveNearhiviraneOdjele();
		
		for (int i = 0; i < sviOdjeli.size(); i++)
		{
			String podatak = sviOdjeli.get(i).getId() + " " + sviOdjeli.get(i).getNaziv();
			lista2.addElement(podatak);
		}
		
		panel.add(scrollPane);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBackground(UIManager.getColor("Tree.selectionBackground"));
		btnDodaj.setForeground(UIManager.getColor("Button.foreground"));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true; 
				String p1 = new String(passwordField_1.getPassword());
				String p2 = new String(passwordField.getPassword());
				String ime = textField_36.getText();
				String prezime = textField_37.getText();
				String adresa = textField_38.getText();
				
				Zaposlenik z;
				if (chckbxDa.isSelected())
					z = new Koordinator();
				else 
					z = new ProjekatRadnik();
				
				try{
					z.setIme(ime);
				}
				catch (Exception es){
					LOGGER.log(Level.SEVERE,"context",es);
					label_error2.setText("Unesite ispravno ime!");
					greska = false;
				}
				
				try{
					z.setPrezime(prezime);
				}
				catch (Exception es){
					LOGGER.log(Level.SEVERE,"context",es);
					label_error2.setText("Unesite ispravno prezime!");
					greska = false;
				}
				
				try{
					z.setAdresa(adresa);
				}
				catch (Exception es){
					LOGGER.log(Level.SEVERE,"context",es);
					label_error2.setText("Unesite ispravnu adresu!");
					greska = false;
				}
				
				try
				{
					Date d = (Date)spinner.getValue();
					Calendar c = Calendar.getInstance();
					c.setTime(d);
					LocalDate ld = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
					z.setDatumZaposlenja(ld);
				}
				catch (Exception es)
				{
					LOGGER.log(Level.SEVERE,"context",es);
					label_error2.setText("Unesite ispravan datum!");
					greska = false;
				}
				
				if(list_5.isSelectionEmpty())
				{
					label_error2.setText("Odaberite odjel u kojem radi zaposlenik!");
					greska = false;
				}
				
				try
				{
					Double satnica = (Double)spinner_1.getValue();
					z.setSatnica(satnica);
				}
				catch (Exception es)
				{
					LOGGER.log(Level.SEVERE,"context",es);
					label_error2.setText("Izaberite ispravan unos za satnicu!");
					greska = false;
				}
				
				try
				{
					z.setUsername(textField_41.getText());
					if (!DalDao.ValidirajUsername(z.getUsername()))
					{
						label_error2.setText("Unesite ispravno korisničko ime!");
						greska = false;
					}
				}
				catch(Exception es)
				{
					LOGGER.log(Level.SEVERE,"context",es);
					label_error2.setText("Unesite ispravno korisničko ime!");
					greska = false;
				}
				
				
				if(p1.length() >=0 && p1.length() < 7){
					label_error2.setText("Unesite ispravnu lozinku (minimalno 7 karaktera)!");
					greska = false;}
				if(p2.length() >= 0 && p2.length() < 7 && p2.trim().isEmpty() && p2 == null){
					label_error2.setText("Unesite ispravnu lozinku (minimalno 7 karaktera)!");
					greska = false;} 
				if (!p1.equals(p2)) {
					label_error2.setText("Lozinke se ne podudaraju!");
					greska = false;
					} else
					try {
						z.setLozinka(p1);
					} catch (NoSuchAlgorithmException es) {
						LOGGER.log(Level.SEVERE,"context",es);
						label_error2.setText("Lozinke se ne podudaraju!");
					} catch (InvalidKeySpecException es) {
						LOGGER.log(Level.SEVERE,"context",es);
						label_error2.setText("Lozinke se ne podudaraju!");
					}
				
				if(greska == false){
					label_error2.setVisible(true);	
				}
				
				else{
					label_error2.setVisible(false);
					ZaposlenikHibernate zh = new ZaposlenikHibernate();
					zh.setIme(z.getIme());
					zh.setPrezime(z.getPrezime());
					zh.setAdresa(z.getAdresa());
					zh.setArhiviran(false);
					zh.setKoordinator(chckbxDa.isSelected());
					zh.setDatumZaposlenja(z.getDatumZaposlenja());
					if (p1.length() > 7)
					{
						zh.setLozinka(z.getLozinka());
					}
					zh.setSatnica(z.getSatnica());
					zh.setUsername(z.getUsername());
					DalDao.DodajObjekat(zh);
					ArrayList<String> izabrane = (ArrayList<String>) list_5.getSelectedValuesList();
					for (int i = 0; i < izabrane.size(); i++)
					{
						String podatak = izabrane.get(i);
						String[] rijeci = podatak.split(" ");
						long id = Long.parseLong(rijeci[0]);
						OdjelZaposlenikHibernate ozh = new OdjelZaposlenikHibernate();
						ozh.setOdjel(DalDao.VratiOdjel(id));
						ozh.setZaposlenikOdjela(zh);
						DalDao.DodajObjekat(ozh);
					}
					JOptionPane.showMessageDialog(null, "Uspjesno ste kreirali zaposlenika", "Zaposlenik kreiran", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnDodaj.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDodaj.setBounds(147, 336, 89, 23);
		panel.add(btnDodaj);
		
		final JSpinner spinner1 = new JSpinner();
		spinner1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner1.setModel(new SpinnerDateModel(new Date(1432332000000L), null, null, Calendar.DAY_OF_YEAR));
		spinner1.setBounds(190, 99, 141, 20);
		panel.add(spinner1);
		
		JButton btnOtkai_2 = new JButton("Otkaži");
		btnOtkai_2.setBackground(UIManager.getColor("Tree.selectionBackground"));
		btnOtkai_2.setForeground(UIManager.getColor("Button.foreground"));
		btnOtkai_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_36.setText("");
				textField_37.setText("");
				textField_38.setText("");
				textField_41.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				list .clearSelection();
				label_error2.setVisible(false);
			}
		});
		
		btnOtkai_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOtkai_2.setBounds(242, 336, 89, 23);
		panel.add(btnOtkai_2);
		
		JLabel lblSatnica = new JLabel("Satnica:");
		lblSatnica.setForeground(UIManager.getColor("TextField.highlight"));
		lblSatnica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSatnica.setBounds(82, 185, 46, 14);
		panel.add(lblSatnica);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretraga korisnika", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_1.setBounds(392, 22, 341, 370);
		korisniciPanel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_42 = new JTextField();
		textField_42.setBounds(131, 56, 124, 23);
		panel_1.add(textField_42);
		textField_42.setColumns(10);
		
		final JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_13.setModel(new DefaultComboBoxModel(new String[] {"Ime", "Prezime", "Username"}));
		comboBox_13.setBounds(22, 56, 99, 23);
		panel_1.add(comboBox_13);
		
		final JList list_2 = new JList();
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		list_2.setBounds(22, 114, 309, 209);
		panel_1.add(list_2);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Prikaži arhivirane korisnike");
		chckbxNewCheckBox.setForeground(UIManager.getColor("TextField.highlight"));
		chckbxNewCheckBox.setBackground(UIManager.getColor("TextField.darkShadow"));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBounds(22, 86, 170, 23);
		panel_1.add(chckbxNewCheckBox);
		final DefaultListModel lista = new DefaultListModel();
		JButton btnPretraga = new JButton("Pretraži");
		btnPretraga.setBackground(UIManager.getColor("TextArea.selectionBackground"));
		btnPretraga.setForeground(UIManager.getColor("Button.foreground"));
		btnPretraga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!textField_42.getText().isEmpty())
				{
					lista.removeAllElements();
				    list_2.setModel(lista);
					ArrayList<ZaposlenikHibernate> zaposlenici = new ArrayList<ZaposlenikHibernate>();
					String vrijednost = comboBox_13.getSelectedItem().toString();
					if (chckbxNewCheckBox.isSelected())
					{
						if (vrijednost.equals("Ime"))
						{
							zaposlenici = DalDao.VratiArhiviraneZaposlenikePoImenu(textField_42.getText());
						}
						else if (vrijednost.equalsIgnoreCase("Prezime"))
						{
							zaposlenici = DalDao.VratiArhiviraneZaposlenikePoPrezimenu(textField_42.getText());
						}
						else
						{
							zaposlenici.add(DalDao.VratiArhiviraneZaposlenikePoUsername(textField_42.getText()));
						}
					}
					else
					{
						if (vrijednost.equals("Ime"))
						{
							zaposlenici = DalDao.VratiNearhiviraneZaposlenikePoImenu(textField_42.getText());
						}
						else if (vrijednost.equalsIgnoreCase("Prezime"))
						{
							zaposlenici = DalDao.VratiNearhiviraneZaposlenikePoPrezimenu(textField_42.getText());
						}
						else
						{
							zaposlenici.add(DalDao.VratiNearhiviraneZaposlenikePoUsername(textField_42.getText()));
						}
					}
					for (int i = 0; i < zaposlenici.size(); i++)
					{
						if (zaposlenici.get(i) != null)
						{
							String podatak = zaposlenici.get(i).getId() + " " + zaposlenici.get(i).getIme() + " " + zaposlenici.get(i).getPrezime();
							lista.addElement(podatak);
						}
					}

				}
				
			}
		});
		
		btnPretraga.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPretraga.setBounds(262, 56, 69, 23);
		panel_1.add(btnPretraga);
		
		btnOtkai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_43.setText("");
				textField_44.setText("");
				list_3.clearSelection();
				spinner1.setValue(new Double(0d));
				label_error.setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Prikaži profil");
		btnNewButton_1.setBackground(UIManager.getColor("Tree.selectionBackground"));
		btnNewButton_1.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				if(list_2.isSelectionEmpty()){
					greska = false;
					label_error1.setText("Morate označiti korisnika!");
					
				}
				if(greska == false){
					label_error1.setVisible(true);
				}
				else{
					label_error1.setVisible(false);
					String selektovanaVrijednost = list_2.getSelectedValue().toString();
					String[] rijeci = selektovanaVrijednost.split(" ");
					long id = Long.parseLong(rijeci[0]);
					new KorisnikForm(id).setVisible(true);
				}
				
			}
		});
		
		btnNewButton_1.setBounds(83, 334, 119, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnObriiKorisnika = new JButton("Obriši korisnika");
		btnObriiKorisnika.setBackground(UIManager.getColor("Tree.selectionBackground"));
		btnObriiKorisnika.setForeground(UIManager.getColor("Button.foreground"));
		btnObriiKorisnika.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnObriiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(list_2.isSelectionEmpty()){
					greska = false;
					label_error2.setText("Morate označiti korisnika da bi ga obrisali!");
					
				}
				if(greska == false){
					label_error2.setVisible(true);
				}
				else{
					label_error2.setVisible(false);
					String selektovanaVrijednost = list_2.getSelectedValue().toString();
					String[] rijeci = selektovanaVrijednost.split(" ");
					long id = Long.parseLong(rijeci[0]);
					ZaposlenikHibernate zh = DalDao.VratiZaposlenika(id);
					if (!zh.getArhiviran())
					{
						zh.setArhiviran(true);
						DalDao.ModifikujObjekat(zh);
						lista.removeAllElements();
						JOptionPane.showMessageDialog(null, "Uspjesno ste izbrisali zaposlenika", "Zaposlenik izbrisan", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Zaposlenik je već arhiviran", "Greška brisanja", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		btnObriiKorisnika.setBounds(212, 334, 119, 23);
		panel_1.add(btnObriiKorisnika);
		
		JLabel label_6 = new JLabel("Izaberite parametar pretrage:");
		label_6.setForeground(UIManager.getColor("TextField.highlight"));
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(22, 29, 170, 14);
		panel_1.add(label_6);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(UIManager.getColor("TextField.darkShadow"));
		tabbedPane.addTab("Moj profil", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Promjena lozinke", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		panel_6.setBounds(30, 22, 341, 370);
		panel_4.add(panel_6);
		
		JLabel label = new JLabel("Trenutna lozinka:");
		label.setForeground(UIManager.getColor("TextField.highlight"));
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(48, 38, 83, 14);
		panel_6.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 35, 141, 20);
		panel_6.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(162, 63, 141, 20);
		panel_6.add(textField_2);
		
		JLabel label_1 = new JLabel("Nova lozinka:");
		label_1.setForeground(UIManager.getColor("TextField.highlight"));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(67, 66, 64, 14);
		panel_6.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(162, 91, 141, 20);
		panel_6.add(textField_3);
		
		JLabel label_4 = new JLabel("Nova lozinka(ponovo):");
		label_4.setForeground(UIManager.getColor("TextField.highlight"));
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(23, 94, 108, 14);
		panel_6.add(label_4);
		
		final JLabel label_error3 = new JLabel("");
		label_error3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_error3.setForeground(Color.RED);
		label_error3.setVisible(false);
		label_error3.setBounds(0, 405, 749, 14);
		panel_4.add(label_error3);
		
		JButton button = new JButton("Spasi promjenu");
		button.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button.setForeground(UIManager.getColor("Button.foreground"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean greska = true;
				try {
					if(Lozinka.validatePassword(textField_1.getText(), Admin.getLozinka()) && 
							!textField_1.getText().equals("") && !textField_2.getText().equals("") && 
							!textField_3.getText().equals("") && textField_2.getText().equals(textField_3.getText())){
								Admin.setLozinka(Lozinka.generateStorngPasswordHash(textField_3.getText()));
								DalDao.ModifikujObjekat(Admin);
								JOptionPane.showMessageDialog(null, "Uspjesno ste promjenili lozinku!", "Info", JOptionPane.INFORMATION_MESSAGE );
					}
					else if(textField_1.getText().equals("")) {
						greska = false;
						label_error3.setText("Unesite trenutnu lozinku!");
					}
					else if(textField_2.getText().equals("")){
						greska = false;
						label_error3.setText("Unesite novu lozinku!");
					}
					else if(textField_3.getText().equals("")){
						greska = false;
						label_error3.setText("Unesite ponovo novu lozinku!");
					}
					else if(!textField_2.getText().equals(textField_3.getText())) {
						greska = false;
						label_error3.setText("Lozinke se ne poklapaju!");
					}
					else if(!Lozinka.validatePassword(textField_1.getText(), Admin.getLozinka())) {
						greska = false;
						label_error3.setText("Pogresna lozinka!");
					}
					else { 
						greska = true;
					}
					if(greska == false){
						label_error3.setVisible(true);
					}
					else label_error3.setVisible(false);
				}
				catch(Exception ex) {
					LOGGER.log(Level.SEVERE,"context",ex);
				}
			}
		});
		
		button.setFont(new Font("Tahoma", Font.BOLD, 10));
		button.setBounds(67, 138, 120, 23);
		panel_6.add(button);
		
		JButton button_1 = new JButton("Otkaži");
		button_1.setBackground(UIManager.getColor("TextField.selectionBackground"));
		button_1.setForeground(UIManager.getColor("Button.foreground"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				label_error3.setVisible(false);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		button_1.setBounds(193, 138, 110, 23);
		panel_6.add(button_1);		
	}

	private void JTable(Object rowData, TableColumnModel columnNames) {
		// TODO Auto-generated method stub
		
	}
}
