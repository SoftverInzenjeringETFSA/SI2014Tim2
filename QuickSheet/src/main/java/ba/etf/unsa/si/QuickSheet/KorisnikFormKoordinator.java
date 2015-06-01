package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

public class KorisnikFormKoordinator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	protected static final Logger LOGGER = Logger.getLogger("KorisnikFormKoordinator");
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KorisnikFormKoordinator frame = new KorisnikFormKoordinator("Test");
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public KorisnikFormKoordinator(String zaposlenik) {
		String[] parametri = zaposlenik.split(" ");
		long id = Long.parseLong(parametri[0]);
		ZaposlenikHibernate prikaz = DalDao.VratiZaposlenika(id); 
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("Dialog", Font.PLAIN, 11));
		setResizable(false);
		setTitle("Profil zaposlenika");
		setBounds(100, 100, 389, 405);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setBounds(22, 11, 341, 354);
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
		
		JLabel lblSatnica = new JLabel("Satnica:");
		lblSatnica.setForeground(UIManager.getColor("TextField.highlight"));
		lblSatnica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSatnica.setBounds(80, 155, 58, 14);
		panel.add(lblSatnica);
		
		JLabel label_5 = new JLabel("Datum zapošljavanja:");
		label_5.setForeground(UIManager.getColor("TextField.highlight"));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(15, 183, 113, 14);
		panel.add(label_5);
		
		JLabel lblOdjeli = new JLabel("Odjeli:");
		lblOdjeli.setForeground(UIManager.getColor("TextField.highlight"));
		lblOdjeli.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOdjeli.setBounds(88, 208, 40, 14);
		panel.add(lblOdjeli);
		
		JLabel label_7 = new JLabel("Korisničko ime:");
		label_7.setForeground(UIManager.getColor("TextField.highlight"));
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(52, 267, 82, 14);
		panel.add(label_7);
		
		JLabel lblKoordinator = new JLabel("Koordinator:");
		lblKoordinator.setForeground(UIManager.getColor("TextField.highlight"));
		lblKoordinator.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKoordinator.setBounds(62, 292, 82, 14);
		panel.add(lblKoordinator);
		
		textField = new JTextField(prikaz.getIme());
		textField.setDisabledTextColor(Color.BLACK);
		textField.setBorder(null);
		textField.setBackground(Color.WHITE);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(164, 21, 167, 20);
		panel.add(textField);
		
		textField_1 = new JTextField(prikaz.getPrezime());
		textField_1.setDisabledTextColor(Color.BLACK);
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(164, 46, 167, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField(prikaz.getAdresa());
		textField_2.setDisabledTextColor(Color.BLACK);
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(164, 71, 167, 20);
		panel.add(textField_2);
		
		Double satnica = prikaz.getSatnica();
		textField_3 = new JTextField(satnica.toString());
		textField_3.setDisabledTextColor(Color.BLACK);
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(164, 152, 167, 20);
		panel.add(textField_3);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, prikaz.getDatumZaposlenja().getYear());
		cal.set(Calendar.MONTH, prikaz.getDatumZaposlenja().getMonthValue());
		cal.set(Calendar.DAY_OF_MONTH, prikaz.getDatumZaposlenja().getDayOfMonth());
		Date d = cal.getTime();

		ArrayList<OdjelHibernate> oh = new ArrayList<OdjelHibernate>();
		oh = DalDao.VratiZaposlenikoveOdjele(id);
		DefaultListModel lista = new DefaultListModel();
		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setEnabled(false);
		JScrollPane scrollPane1 = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setBounds(164, 207, 167, 51);
		list.setBounds(164, 173, 167, 51);
		list.setModel(lista);
		for (int i = 0; i < oh.size(); i++)
		{
			String podatak = oh.get(i).getNaziv();
			lista.addElement(podatak);
		}
		panel.add(scrollPane1);
		
		textField_5 = new JTextField(prikaz.getUsername());
		textField_5.setDisabledTextColor(Color.BLACK);
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(164, 264, 167, 20);
		panel.add(textField_5);
		
		JCheckBox chckbxDa = new JCheckBox("Da");
		chckbxDa.setEnabled(false);
		chckbxDa.setForeground(Color.BLACK);
		chckbxDa.setBackground(UIManager.getColor("Button.background"));
		chckbxDa.setBounds(164, 288, 45, 23);
		chckbxDa.setSelected(prikaz.getKoordinator());
		panel.add(chckbxDa);
		
		textField_4 = new JTextField(prikaz.getDatumZaposlenja().toString());
		textField_4.setDisabledTextColor(Color.BLACK);
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(164, 180, 167, 20);
		panel.add(textField_4);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(92, 103, 98, 14);
		panel.add(lblEmail);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefon.setBounds(82, 128, 82, 14);
		panel.add(lblTelefon);
		
		textField_7 = new JTextField(prikaz.getEmail());
		textField_7.setDisabledTextColor(Color.BLACK);
		textField_7.setEnabled(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBorder(null);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(164, 100, 167, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField(prikaz.getTelefon());
		textField_8.setDisabledTextColor(Color.BLACK);
		textField_8.setEnabled(false);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBorder(null);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(164, 125, 167, 20);
		panel.add(textField_8);
		
		JLabel labela_error = new JLabel("");
		labela_error.setVisible(false);
		labela_error.setBounds(0, 312, 383, 14);
		contentPane.add(labela_error);
	}
}
