package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;

import javax.naming.directory.InvalidAttributeValueException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.Toolkit;

import javax.swing.JCheckBox;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Zaposlenik;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.OdjelZaposlenikHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import java.awt.Color;

public class KorisnikForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	protected static final Logger LOGGER = Logger.getLogger("KorisnikForm");
	private JTextField textField_3;
	private JTextField textField_4;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KorisnikForm frame = new KorisnikForm(1);
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public KorisnikForm(long id) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setResizable(false);
		setTitle("Profil zaposlenika");
		setBounds(100, 100, 392, 503);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		final ZaposlenikHibernate zh = DalDao.VratiZaposlenika(id);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setBounds(22, 11, 341, 436);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o korisniku", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Ime:");
		label.setForeground(UIManager.getColor("TextField.highlight"));
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(98, 24, 82, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Prezime:");
		label_1.setForeground(UIManager.getColor("TextField.highlight"));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(82, 49, 82, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Adresa:");
		label_2.setForeground(UIManager.getColor("TextField.highlight"));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(82, 74, 82, 14);
		panel.add(label_2);
		
		JLabel label_5 = new JLabel("Datum zapošljavanja:");
		label_5.setForeground(UIManager.getColor("TextField.highlight"));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(15, 150, 113, 14);
		panel.add(label_5);
		
		JLabel lblOdjeli = new JLabel("Odjeli:");
		lblOdjeli.setForeground(UIManager.getColor("TextField.highlight"));
		lblOdjeli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOdjeli.setBounds(88, 177, 40, 14);
		panel.add(lblOdjeli);
		
		JLabel label_7 = new JLabel("Korisničko ime:");
		label_7.setForeground(UIManager.getColor("TextField.highlight"));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(52, 259, 82, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Lozinka:");
		label_8.setForeground(UIManager.getColor("TextField.highlight"));
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(82, 284, 46, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Ponovi lozinku:");
		label_9.setForeground(UIManager.getColor("TextField.highlight"));
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(52, 309, 92, 14);
		panel.add(label_9);
		
		JLabel lblKoordinator = new JLabel("Koordinator:");
		lblKoordinator.setForeground(UIManager.getColor("TextField.highlight"));
		lblKoordinator.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKoordinator.setBounds(62, 334, 60, 14);
		panel.add(lblKoordinator);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(164, 21, 167, 20);
		textField.setText(zh.getIme());
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 44, 167, 20);
		textField_1.setText(zh.getPrezime());
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 69, 167, 20);
		textField_2.setText(zh.getAdresa());
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 98, 167, 20);
		panel.add(textField_3);
		textField_3.setText(zh.getEmail());
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(164, 123, 167, 20);
		textField_4.setText(zh.getTelefon());
		panel.add(textField_4);
		
		ArrayList<OdjelHibernate> sviOdjeli = DalDao.VratiSveNearhiviraneOdjele();
		DefaultListModel lista = new DefaultListModel();
		final JList list = new JList();
		JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(164, 175, 167, 51);
		list.setBounds(164, 123, 167, 51);
		list.setModel(lista);
		for (int i = 0; i < sviOdjeli.size(); i++)
		{
			String podatak = sviOdjeli.get(i).getId() + " " + sviOdjeli.get(i).getNaziv();
			lista.addElement(podatak);
		}
		ArrayList<OdjelHibernate> oh = DalDao.VratiZaposlenikoveOdjele(id);
		for (int i = 0; i < oh.size(); i++)
		{
			String podatak = oh.get(i).getId() + " " + oh.get(i).getNaziv();
			list.setSelectedValue(podatak, false);
		}
		panel.add(scrollPane);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(164, 256, 167, 20);
		textField_5.setText(zh.getUsername());
		panel.add(textField_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 281, 167, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(164, 306, 167, 20);
		panel.add(passwordField_1);
		
		final JCheckBox chckbxDa = new JCheckBox("Da");
		chckbxDa.setForeground(UIManager.getColor("Button.highlight"));
		chckbxDa.setBackground(UIManager.getColor("Button.darkShadow"));
		chckbxDa.setBounds(164, 330, 97, 23);
		chckbxDa.setSelected(zh.getKoordinator());
		panel.add(chckbxDa);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, zh.getDatumZaposlenja().getYear());
		cal.set(Calendar.MONTH, zh.getDatumZaposlenja().getMonthValue());
		cal.set(Calendar.DAY_OF_MONTH, zh.getDatumZaposlenja().getDayOfMonth());
		Date d = cal.getTime();
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1432332000000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(164, 147, 167, 20);
		spinner.setValue(d);
		panel.add(spinner);
		
		final JLabel label_error = new JLabel("");
		label_error.setForeground(Color.RED);
		label_error.setVisible(false);
		label_error.setBounds(0, 449, 386, 25);
		contentPane.add(label_error);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		spinner_1.setBounds(164, 231, 167, 20);
		spinner_1.setValue(zh.getSatnica());
		panel.add(spinner_1);
		
		final JCheckBox chckbxDa_1 = new JCheckBox("Da");
		chckbxDa_1.setBackground(UIManager.getColor("Button.darkShadow"));
		chckbxDa_1.setForeground(UIManager.getColor("Button.highlight"));
		chckbxDa_1.setBounds(164, 356, 97, 23);
		chckbxDa_1.setSelected(zh.getArhiviran());
		panel.add(chckbxDa_1);
		
		JButton btnSpasiIzmjene = new JButton("Spremi izmjene");
		btnSpasiIzmjene.setForeground(UIManager.getColor("Button.foreground"));
		btnSpasiIzmjene.setBackground(UIManager.getColor("TextField.selectionBackground"));
		btnSpasiIzmjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				String p1 = new String(passwordField_1.getPassword());
				String p2 = new String(passwordField.getPassword());
				String ime = textField.getText();
				String prezime = textField_1.getText();
				String adresa = textField_2.getText();
				String email = textField_3.getText();
				String telefon = textField_4.getText();
				Zaposlenik z;
				if (chckbxDa.isSelected())
					z = new Koordinator();
				else 
					z = new ProjekatRadnik();
				
				try
				{
					z.setIme(ime);
				}
				catch (Exception e)
				{
					LOGGER.log(Level.SEVERE,"context",e);
					label_error.setText("Unesite ispravno ime!");
					greska = false;
				}
				
				try
				{
					z.setPrezime(prezime);
				}
				catch (Exception e){
					LOGGER.log(Level.SEVERE,"context",e);
					label_error.setText("Unesite ispravno prezime!");
					greska = false;
				}
				
				try
				{
					z.setAdresa(adresa);
				}
				catch (Exception e){
					LOGGER.log(Level.SEVERE,"context",e);
					label_error.setText("Unesite ispravnu adresu!");
					greska = false;
				}
				try
				{
					z.setTelefon(telefon);
				}
				catch (Exception es)
				{
					LOGGER.log(Level.SEVERE,"context",es);
					label_error.setText("Unesite ispravan telefonski broj (minimalno 9 cifara)!");
					greska = false;
				}
				try
				{
					z.setEmail(email);
				}
				catch (Exception es)
				{
					LOGGER.log(Level.SEVERE,"context",es);
					label_error.setText("Unesite validnu mail adresu!");
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
				catch (Exception e)
				{
					LOGGER.log(Level.SEVERE,"context",e);
					label_error.setText("Unesite ispravan datum!");
					greska = false;
				}
				
				try
				{
					Double satnica = (Double)spinner_1.getValue();
					z.setSatnica(satnica);
				}
				catch (Exception e)
				{
					LOGGER.log(Level.SEVERE,"context",e);
					label_error.setText("Izaberite ispravan unos za satnicu!");
					greska = false;
				}
				
				try
				{
					z.setUsername(textField_5.getText());
					if (DalDao.ValidirajUsernameKorisnik(z.getUsername(), zh.getId()) == false || DalDao.ValidirajUsernameAdmin(z.getUsername(), zh.getId()) == false)
					{
						label_error.setText("Korisničko ime koje ste unijeli je već u upotrebi!");
						greska = false;
					}
				}
				catch(Exception e)
				{
					LOGGER.log(Level.SEVERE,"context",e);
					label_error.setText("Unesite ispravno korisničko ime!");
					greska = false;
				}
				
				if(passwordField.getPassword().length > 0 && passwordField.getPassword().length < 7)
				{
					label_error.setText("Unesite ispravnu lozinku (minimalno 7 karaktera)!");
					greska = false;
				}
				if(passwordField.getPassword().length > 0 && passwordField_1.getPassword().length < 7)
				{
					label_error.setText("Unesite ispravnu lozinku (minimalno 7 karaktera)!");
					greska = false;
				}
				if (!p1.equals(p2)) 
				{
					label_error.setText("Lozinke se ne podudaraju!");
					greska = false;
				} 
				else
				{
					try 
					{
						if (passwordField.getPassword().length != 0)
							z.setLozinka(p1);
					} 
					catch (NoSuchAlgorithmException e) 
					{
						label_error.setText("Unesite ispravnu lozinku (minimalno 7 karaktera)!");
						LOGGER.log(Level.SEVERE,"context",e);
					} 
					catch (InvalidKeySpecException e) 
					{
						label_error.setText("Unesite ispravnu lozinku (minimalno 7 karaktera)!");
						LOGGER.log(Level.SEVERE,"context",e);
					} catch (InvalidAttributeValueException e) 
					{
						label_error.setText("Unesite ispravnu lozinku (minimalno 7 karaktera)!");
						LOGGER.log(Level.SEVERE,"context",e);
					}
				}
				if(greska == false)
					label_error.setVisible(true);	
				
				else
				{
					label_error.setVisible(false);
					zh.setIme(z.getIme());
					zh.setPrezime(z.getPrezime());
					zh.setAdresa(z.getAdresa());
					zh.setArhiviran(chckbxDa_1.isSelected());
					zh.setKoordinator(chckbxDa.isSelected());
					zh.setDatumZaposlenja(z.getDatumZaposlenja());
					if (z.getLozinka() != null)
						zh.setLozinka(z.getLozinka());
					zh.setSatnica(z.getSatnica());
					zh.setUsername(z.getUsername());
					zh.setEmail(z.getEmail());
					zh.setTelefon(z.getTelefon());
					DalDao.ModifikujObjekat(zh);
					ArrayList<String> izabrane = new ArrayList<String>();
					if (list.getSelectedValuesList().size() > 0)
						izabrane = (ArrayList<String>) list.getSelectedValuesList();
					DalDao.IzbirisiZaposlenikoveOdjele(zh.getId());
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
					JOptionPane.showMessageDialog(null, "Uspjesno ste modifikovali zaposlenika", "Zaposlenik modifikovan", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});

		btnSpasiIzmjene.setFont(new Font("Tahoma", Font.BOLD, 10));

		
		btnSpasiIzmjene.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSpasiIzmjene.setBounds(190, 397, 141, 23);
		panel.add(btnSpasiIzmjene);
		
		JLabel lblSatnica = new JLabel("Satnica:");
		lblSatnica.setForeground(UIManager.getColor("TextField.highlight"));
		lblSatnica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSatnica.setBounds(82, 234, 40, 14);
		panel.add(lblSatnica);
		
		JLabel lblArhiviran = new JLabel("Arhiviran:");
		lblArhiviran.setForeground(UIManager.getColor("TextField.highlight"));
		lblArhiviran.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblArhiviran.setBounds(74, 359, 60, 14);
		panel.add(lblArhiviran);		
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(92, 101, 28, 14);
		panel.add(lblEmail);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefon.setBounds(82, 126, 82, 14);
		panel.add(lblTelefon);
	}
}
