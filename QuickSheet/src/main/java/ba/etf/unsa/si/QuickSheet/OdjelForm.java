package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.OdjelZaposlenikHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;
import javax.swing.UIManager;

public class OdjelForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	protected static final Logger LOGGER = Logger.getLogger("OdjelForm");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdjelForm frame = new OdjelForm();
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public OdjelForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("Prikaz odjela");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 402, 492);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setBounds(22, 11, 350, 435);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Podaci o odjelu", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		contentPane.add(panel);
		
		JLabel label = new JLabel("Naziv odjela:");
		label.setForeground(UIManager.getColor("TextField.highlight"));
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(78, 33, 102, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(190, 30, 141, 20);
		panel.add(textField);
		
		JLabel lblZaposlenici = new JLabel("Zaposlenici u odjelu:");
		lblZaposlenici.setForeground(UIManager.getColor("TextField.highlight"));
		lblZaposlenici.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici.setBounds(43, 55, 97, 29);
		panel.add(lblZaposlenici);
		
		JLabel label_3 = new JLabel("Maksimalni broj zaposlenika:");
		label_3.setForeground(UIManager.getColor("TextField.highlight"));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 360, 152, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 357, 141, 20);
		panel.add(textField_1);
		
		final JLabel label_1 = new JLabel("");
		label_1.setVisible(false);
		label_1.setBounds(0, 449, 396, 14);
		contentPane.add(label_1);
		
		JButton btnSpremiPromjene = new JButton("Spremi promjene");
		btnSpremiPromjene.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		btnSpremiPromjene.setForeground(UIManager.getColor("Button.foreground"));
		btnSpremiPromjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(textField.getText().equals("")){
					greska = false;
					label_1.setVisible(true);
					label_1.setText("Unesite naziv odjela!");
					
				}
				else if(textField_1.getText().equals("")){
					greska = false;
					label_1.setVisible(true);
					label_1.setText("Unesite maksimalni broj radnika!");
				}
				else if(Integer.parseInt(textField_1.getText()) > 12){
					label_1.setText("Broj zaposlenika mora biti manji od 12!");
					greska = false;
				}
				else greska = true;
				
				if(greska == false) label_1.setVisible(true);
				else{
					label_1.setVisible(false);
					
				}
			}
		});
		
		btnSpremiPromjene.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSpremiPromjene.setBounds(200, 396, 131, 22);
		panel.add(btnSpremiPromjene);
		
		final JList list = new JList();
		list.setBounds(190, 61, 141, 106);
		panel.add(list);
		
		JLabel lblNewLabel = new JLabel("Dodaj nove zaposlenike:");
		lblNewLabel.setForeground(UIManager.getColor("TextField.highlight"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(30, 208, 121, 14);
		panel.add(lblNewLabel);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		btnUkloni.setForeground(UIManager.getColor("Button.foreground"));
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(list.isSelectionEmpty()){
					greska = false;
				}
				if(greska == false){
					label_1.setVisible(true);
					label_1.setText("Odaberite zaposlenika!");
				}
				else{
					label_1.setVisible(false);
					
				}
			}
		});
		
		btnUkloni.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUkloni.setBounds(257, 174, 74, 22);
		panel.add(btnUkloni);
		
		final JList list_1 = new JList();
		final DefaultListModel listaZaposlenika = new DefaultListModel();
		list_1.setModel(listaZaposlenika);
		ArrayList<ZaposlenikHibernate> zaposlenici=DalDao.VratiSveZaposlenike();

		for (int i=0;i<zaposlenici.size();i++)
			{
			    String tempString = zaposlenici.get(i).getId() + " " + zaposlenici.get(i).getIme() + " " + zaposlenici.get(i).getPrezime()
			    		+ " " + zaposlenici.get(i).getAdresa() + " " + zaposlenici.get(i).getSatnica();
			}	
		
		list_1.setBounds(190, 207, 141, 106);
		panel.add(list_1);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		btnDodaj.setForeground(UIManager.getColor("Button.foreground"));
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(list_1.isSelectionEmpty()){
					greska = false;
				}
				if(greska == false){
					label_1.setVisible(true);
					label_1.setText("Odaberite zaposlenika!");
				}
				else{
					label_1.setVisible(false);
					
				}
			}
		});
		btnDodaj.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDodaj.setBounds(257, 317, 74, 22);
		panel.add(btnDodaj);
		
		
	}
	
	public OdjelForm(String odjel) {
		String[] temp = odjel.split(" ");
		final long id = Long.parseLong(temp[0]);
		OdjelHibernate prikaz = DalDao.VratiOdjel(id); 
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("Prikaz odjela");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 402, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 11, 350, 435);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Podaci o odjelu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		
		JLabel label = new JLabel("Naziv odjela:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(78, 33, 102, 14);
		panel.add(label);
		
		textField = new JTextField(prikaz.getNaziv());
		textField.setColumns(10);
		textField.setBounds(190, 30, 141, 20);
		panel.add(textField);
		
		JLabel lblZaposlenici = new JLabel("Zaposlenici u odjelu:");
		lblZaposlenici.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici.setBounds(43, 55, 97, 29);
		panel.add(lblZaposlenici);
		
		JLabel label_3 = new JLabel("Maksimalni broj zaposlenika:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 360, 152, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 357, 141, 20);
		textField_1.setText(prikaz.getMaksimalanBrojRadnika().toString());
		panel.add(textField_1);
		
		final JLabel label_1 = new JLabel("");
		label_1.setVisible(false);
		label_1.setBounds(0, 449, 396, 14);
		contentPane.add(label_1);
		
		final JList list = new JList();
		final DefaultListModel listaZaposlenikaOdjela = new DefaultListModel();
		list.setModel(listaZaposlenikaOdjela);
		ArrayList<ZaposlenikHibernate> zaposleniciOdjela=DalDao.VratiZaposlenikeUOdjelu(id);

		for (int i=0;i<zaposleniciOdjela.size();i++)
			{
			    String tempString = zaposleniciOdjela.get(i).getId() + " " + zaposleniciOdjela.get(i).getIme() + " " + zaposleniciOdjela.get(i).getPrezime()
			    		+ " " + zaposleniciOdjela.get(i).getAdresa() + " " + zaposleniciOdjela.get(i).getSatnica();
				listaZaposlenikaOdjela.addElement(tempString);
			}
		
		list.setBounds(190, 61, 141, 106);
		panel.add(list);
		
		JButton btnSpremiPromjene = new JButton("Spremi promjene");
		btnSpremiPromjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(textField.getText().equals("")){
					greska = false;
					label_1.setVisible(true);
					label_1.setText("Unesite naziv odjela!");
					
				}
				else if(textField_1.getText().equals("")){
					greska = false;
					label_1.setVisible(true);
					label_1.setText("Unesite maksimalni broj radnika!");
				}
				else if(Integer.parseInt(textField_1.getText()) > 12){
					label_1.setText("Broj zaposlenika mora biti manji od 12!");
					greska = false;
				}
				else greska = true;
				
				if(greska == false) label_1.setVisible(true);
				else{
					OdjelHibernate phib=DalDao.VratiOdjel(id);
					phib.setNaziv(textField.getText());
					phib.setMaksimalanBrojRadnika(Integer.parseInt(textField_1.getText()));
					
					DalDao.ModifikujObjekat(phib);
					
					int[] indeksi=list.getSelectedIndices();
					for(int i=0;i<indeksi.length;i++){
						String selektovano=listaZaposlenikaOdjela.getElementAt(indeksi[i]).toString();
						String[] rijeciPr=selektovano.split(" ");
						long idPr=Long.parseLong(rijeciPr[0]);
						ZaposlenikHibernate zPr=DalDao.VratiZaposlenika(idPr);
						OdjelHibernate o=DalDao.VratiOdjel(id);
						OdjelZaposlenikHibernate tPr=new OdjelZaposlenikHibernate();
						tPr.setOdjel(o);
						tPr.setZaposlenikOdjela(zPr);
						DalDao.DodajObjekat(tPr);
					
					}
					JOptionPane.showMessageDialog(null, "Uspješno ste izmijenili odjel.", "OK", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		
		btnSpremiPromjene.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnSpremiPromjene.setBounds(210, 396, 121, 22);
		panel.add(btnSpremiPromjene);
		
		JLabel lblNewLabel = new JLabel("Dodaj nove zaposlenike:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(30, 208, 121, 14);
		panel.add(lblNewLabel);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(list.isSelectionEmpty()){
					greska = false;
				}
				if(greska == false){
					label_1.setVisible(true);
					label_1.setText("Odaberite zaposlenika!");
				}
				else{
					label_1.setVisible(false);
					int temp=list.getSelectedIndex();
					listaZaposlenikaOdjela.remove(temp);	
				}
			}
		});
		btnUkloni.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUkloni.setBounds(257, 174, 74, 22);
		panel.add(btnUkloni);
		
		final JList list_1 = new JList();
		final DefaultListModel listaZaposlenika = new DefaultListModel();
		list_1.setModel(listaZaposlenika);
		ArrayList<ZaposlenikHibernate> zaposlenici=DalDao.VratiSveZaposlenike();

		for (int i=0;i<zaposlenici.size();i++)
			{
			    String tempString = zaposlenici.get(i).getId() + " " + zaposlenici.get(i).getIme() + " " + zaposlenici.get(i).getPrezime()
			    		+ " " + zaposlenici.get(i).getAdresa() + " " + zaposlenici.get(i).getSatnica();
			}	
		
		list_1.setBounds(190, 207, 141, 106);
		panel.add(list_1);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean greska = true;
				if(list_1.isSelectionEmpty()){
					greska = false;
				}
				if(greska == false){
					label_1.setVisible(true);
					label_1.setText("Odaberite zaposlenika!");
				}
				else{
					label_1.setVisible(false);
					int temp=list_1.getSelectedIndex();
					if (listaZaposlenikaOdjela.contains(listaZaposlenika.getElementAt(temp))==false){
						listaZaposlenikaOdjela.addElement(listaZaposlenika.getElementAt(temp));
					}
					
				}
			}
		});
		
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnDodaj.setBounds(257, 317, 74, 22);
		panel.add(btnDodaj);
	}
}

