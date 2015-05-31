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
import javax.swing.JScrollPane;
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
import java.awt.Color;

public class OdjelForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	protected static final Logger LOGGER = Logger.getLogger("OdjelForm");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OdjelForm frame = new OdjelForm(null);
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public OdjelForm(String odjel) {
		String[] temp = odjel.split(" ");
		final long id = Long.parseLong(temp[0]);
		final OdjelHibernate prikaz = DalDao.VratiOdjel(id); 
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
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(78, 33, 102, 14);
		label.setForeground(UIManager.getColor("TextField.highlight"));
		panel.add(label);
		
		textField = new JTextField(prikaz.getNaziv());
		textField.setColumns(10);
		textField.setBounds(190, 30, 141, 20);
		panel.add(textField);
		
		JLabel lblZaposlenici = new JLabel("Zaposlenici u odjelu:");
		lblZaposlenici.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenici.setBounds(43, 55, 97, 29);
		lblZaposlenici.setForeground(UIManager.getColor("TextField.highlight"));
		panel.add(lblZaposlenici);
		
		JLabel label_3 = new JLabel("Maksimalni broj zaposlenika:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(10, 360, 152, 14);
		label_3.setForeground(UIManager.getColor("TextField.highlight"));
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 357, 141, 20);
		textField_1.setText(prikaz.getMaksimalanBrojRadnika().toString());
		panel.add(textField_1);
		
		final JLabel label_1 = new JLabel("");
		label_1.setVisible(false);
		label_1.setBounds(0, 449, 396, 14);
		label_1.setForeground(Color.RED);
		contentPane.add(label_1);
		
		final JList list = new JList();
		final DefaultListModel listaZaposlenikaOdjela = new DefaultListModel();
		list.setModel(listaZaposlenikaOdjela);
		ArrayList<ZaposlenikHibernate> zaposleniciOdjela=DalDao.VratiZaposlenikeUOdjelu(id);

		for (int i=0;i<zaposleniciOdjela.size();i++)
		{
		    String tempString = zaposleniciOdjela.get(i).toString();
			listaZaposlenikaOdjela.addElement(tempString);
		}
		JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(190, 61, 141, 106);
		list.setBounds(190, 61, 141, 106);
		panel.add(scrollPane);
		
		JButton btnSpremiPromjene = new JButton("Spremi promjene");
		btnSpremiPromjene.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		btnSpremiPromjene.setForeground(UIManager.getColor("Button.foreground"));
		btnSpremiPromjene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_1.setVisible(false);
				boolean greska = true;
				OdjelHibernate odjeli = DalDao.VratiOdjelPoNazivu(textField.getText());
				if(textField.getText().length() < 3 || !textField.getText().matches("^[a-zA-Z0-9]*$")){
					greska = false;
					label_1.setText("Unesite ispravan naziv odjela od barem tri slova!");
				}
				if (odjeli != null && odjeli.getId() != prikaz.getId())
				{
					label_1.setText("Odjel sa unesenim nazivom već postoji!");
					greska = false;
				}
				if(textField_1.getText().equals("") || !textField_1.getText().matches("^[0-9]*$")){
					greska = false;
					label_1.setText("Unesite ispravan maksimalni broj radnika!");
				}
				else
				{
					Integer broj = Integer.parseInt(textField_1.getText());
					if (listaZaposlenikaOdjela.size() > broj)
					{
						greska = false;
						label_1.setText("Prekoračili ste limit odjela!");
					}
				}
				
				if(greska == false) 
					label_1.setVisible(true);
				else
				{
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
		
		btnSpremiPromjene.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSpremiPromjene.setBounds(210, 396, 121, 22);
		panel.add(btnSpremiPromjene);
		
		JLabel lblNewLabel = new JLabel("Dodaj nove zaposlenike:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(30, 208, 121, 14);
		lblNewLabel.setForeground(UIManager.getColor("TextField.highlight"));
		panel.add(lblNewLabel);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.isSelectionEmpty())
				{
					label_1.setVisible(true);
					label_1.setText("Odaberite zaposlenika!");
				}
				else
				{
					label_1.setVisible(false);
					int[] temp = list.getSelectedIndices();
					for (int index:temp)
					{
						String ll = listaZaposlenikaOdjela.get(index).toString();
						String[] rijeci = ll.split(" ");
						long ID = Long.parseLong(rijeci[0]);
						DalDao.IzbrisiZaposlenikaIzOdjela(ID, id);
					}
					for (int i = temp.length-1; i >= 0; i--)
					{
						listaZaposlenikaOdjela.removeElementAt(temp[i]);
					}
					JOptionPane.showMessageDialog(null, "Uspjesno ste uklonili zaposlenike iz odjela!", "Zaposlenici uklonjeni", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnUkloni.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUkloni.setBounds(257, 174, 74, 22);
		panel.add(btnUkloni);
		
		final JList list_1 = new JList();
		final DefaultListModel listaZaposlenika = new DefaultListModel();
		list_1.setModel(listaZaposlenika);
		ArrayList<ZaposlenikHibernate> zaposlenici=DalDao.VratiSveNearhiviraneZaposlenike();
		for (int i=0;i<zaposlenici.size();i++)
		{
		    String tempString = zaposlenici.get(i).toString();
		    listaZaposlenika.addElement(tempString);
		}	
		JScrollPane scrollPane1 = new JScrollPane(list_1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane1.setBounds(190, 207, 141, 106);
		list_1.setBounds(190, 207, 141, 106);
		panel.add(scrollPane1);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_1.setVisible(false);
				if(list_1.isSelectionEmpty())
				{
					label_1.setVisible(true);
					label_1.setText("Odaberite zaposlenika!");
				}
				else
				{
					label_1.setVisible(false);
					int[] temp =  list_1.getSelectedIndices();
					int brojac = 0;
					for (int index: temp)
					{
						if (!listaZaposlenikaOdjela.contains(listaZaposlenika.getElementAt(index)))
						{
							brojac++;
						}
					}
					if (prikaz.getMaksimalanBrojRadnika() >= (brojac + listaZaposlenikaOdjela.size()))
					{
						for (int index: temp)
						{
							if (!listaZaposlenikaOdjela.contains(listaZaposlenika.getElementAt(index)))
							{
								String dodavanje = listaZaposlenika.getElementAt(index).toString();
								String[] rijeci = dodavanje.split(" ");
								long noviZaposlenikID = Long.parseLong(rijeci[0]);
								OdjelZaposlenikHibernate ozh = new OdjelZaposlenikHibernate();
								ozh.setZaposlenikOdjela(DalDao.VratiZaposlenika(noviZaposlenikID));
								ozh.setOdjel(DalDao.VratiOdjel(id));
								DalDao.DodajObjekat(ozh);
								listaZaposlenikaOdjela.addElement(listaZaposlenika.getElementAt(index));
							}
						}
						if (brojac != 0)
							JOptionPane.showMessageDialog(null, "Uspjesno ste dodali zaposlenike u odjel!" , "Zaposlenici dodani", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						label_1.setVisible(true);
						label_1.setText("Ne smijete prekoračiti limit odjela!");
					}
				}
			}
		});
		
		btnDodaj.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDodaj.setBounds(257, 317, 74, 22);
		panel.add(btnDodaj);
	}
}

