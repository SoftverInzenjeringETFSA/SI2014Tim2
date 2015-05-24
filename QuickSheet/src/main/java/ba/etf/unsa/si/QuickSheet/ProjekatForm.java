package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProjekatForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjekatForm frame = new ProjekatForm();
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
	public ProjekatForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setTitle("Prikaz projekta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o projektu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 11, 340, 483);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Naziv:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(92, 30, 30, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(155, 27, 165, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Naziv klijenta:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(55, 58, 67, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 55, 165, 20);
		panel.add(textField_1);
		
		JLabel lblZaposleniciNaProjektu = new JLabel("Zaposlenici na projektu:");
		lblZaposleniciNaProjektu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposleniciNaProjektu.setBounds(10, 83, 114, 14);
		panel.add(lblZaposleniciNaProjektu);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setBounds(155, 83, 165, 121);
		panel.add(list);
		
		JLabel lblDodajZaposlenike = new JLabel("Dodaj zaposlenike:");
		lblDodajZaposlenike.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDodajZaposlenike.setBounds(29, 243, 114, 14);
		panel.add(lblDodajZaposlenike);
		
		JList list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_1.setBounds(153, 243, 165, 121);
		panel.add(list_1);
		
		JButton btnUkloniZaposlenikaSa = new JButton("Ukloni");
		btnUkloniZaposlenikaSa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUkloniZaposlenikaSa.setBounds(251, 209, 67, 23);
		panel.add(btnUkloniZaposlenikaSa);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodaj.setBounds(255, 375, 61, 23);
		panel.add(btnDodaj);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(151, 409, 165, 20);
		panel.add(comboBox);
		
		JLabel label_2 = new JLabel("Nadređeni:");
		label_2.setBounds(65, 412, 53, 14);
		panel.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnSpremiPromjene = new JButton("Spremi promjene");
		btnSpremiPromjene.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSpremiPromjene.setBounds(195, 449, 125, 23);
		panel.add(btnSpremiPromjene);
	}
	
	
	public ProjekatForm(String projekat) {
		String[] temp = projekat.split(" ");
		final long id = Long.parseLong(temp[0]);
		ProjekatHibernate prikaz = DalDao.VratiProjekat(id); 
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setTitle("Prikaz projekta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Podaci o projektu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 11, 340, 483);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Naziv:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(92, 30, 30, 14);
		panel.add(label);
		
		textField = new JTextField(prikaz.getNaziv());
		textField.setColumns(10);
		textField.setBounds(155, 27, 165, 20);
		panel.add(textField);
		
		final JLabel label_1 = new JLabel("Naziv klijenta:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(55, 58, 67, 14);
		panel.add(label_1);
		
		textField_1 = new JTextField(prikaz.getNazivKlijenta());
		textField_1.setColumns(10);
		textField_1.setBounds(155, 55, 165, 20);
		panel.add(textField_1);
		
		JLabel lblZaposleniciNaProjektu = new JLabel("Zaposlenici na projektu:");
		lblZaposleniciNaProjektu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposleniciNaProjektu.setBounds(10, 83, 114, 14);
		panel.add(lblZaposleniciNaProjektu);
		
		final JList list = new JList();
		final DefaultListModel listaZaposlenikaProjekta = new DefaultListModel();
		list.setModel(listaZaposlenikaProjekta);
		ArrayList<ZaposlenikHibernate> zaposleniciProjekta=DalDao.VratiZaposlenikeNaProjektu(id);

		for (int i=0;i<zaposleniciProjekta.size();i++)
			{
			    String tempString = zaposleniciProjekta.get(i).getId() + " " + zaposleniciProjekta.get(i).getIme() + " " + zaposleniciProjekta.get(i).getPrezime()
			    		+ " " + zaposleniciProjekta.get(i).getAdresa() + " " + zaposleniciProjekta.get(i).getSatnica();
				listaZaposlenikaProjekta.addElement(tempString);
			}
		list.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list.setBounds(155, 83, 165, 121);
		panel.add(list);
		
		JLabel lblDodajZaposlenike = new JLabel("Dodaj zaposlenike:");
		lblDodajZaposlenike.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDodajZaposlenike.setBounds(29, 243, 114, 14);
		panel.add(lblDodajZaposlenike);
		
		final JList list_1 = new JList();
		final DefaultListModel listaZaposlenika = new DefaultListModel();
		list_1.setModel(listaZaposlenika);
		ArrayList<ZaposlenikHibernate> zaposlenici=DalDao.VratiSveZaposlenike();

		for (int i=0;i<zaposlenici.size();i++)
			{
			    String tempString = zaposlenici.get(i).getId() + " " + zaposlenici.get(i).getIme() + " " + zaposlenici.get(i).getPrezime()
			    		+ " " + zaposlenici.get(i).getAdresa() + " " + zaposlenici.get(i).getSatnica();
			    listaZaposlenika.addElement(tempString);
			}
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_1.setBounds(153, 243, 165, 121);
		panel.add(list_1);
		
		JButton btnUkloniZaposlenikaSa = new JButton("Ukloni");
		btnUkloniZaposlenikaSa.addActionListener(new ActionListener() {
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
					listaZaposlenikaProjekta.remove(temp);				
				}
			}
		});
		btnUkloniZaposlenikaSa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUkloniZaposlenikaSa.setBounds(251, 209, 67, 23);
		panel.add(btnUkloniZaposlenikaSa);
		
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
					if (listaZaposlenikaProjekta.contains(listaZaposlenika.getElementAt(temp))==false){
						listaZaposlenikaProjekta.addElement(listaZaposlenika.getElementAt(temp));
					}
				}
			}
		});
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDodaj.setBounds(255, 375, 61, 23);
		panel.add(btnDodaj);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.removeAllItems();
		ArrayList<ZaposlenikHibernate> zhk=DalDao.VratiSveZaposlenikeKoordinatore();
		for(ZaposlenikHibernate z:zhk){
			comboBox.addItem(zhk);
			}
		comboBox.setSelectedItem(prikaz.getKoordinator());
		comboBox.setBounds(151, 409, 165, 20);
		panel.add(comboBox);
		
		JLabel label_2 = new JLabel("Nadređeni:");
		label_2.setBounds(65, 412, 53, 14);
		panel.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnSpremiPromjene = new JButton("Spremi promjene");
		btnSpremiPromjene.addActionListener(new ActionListener() {
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
					ProjekatHibernate phib=DalDao.VratiProjekat(id);
					phib.setNaziv(textField.getText());
					phib.setNazivKlijenta(textField_1.getText());
					
					String s=comboBox.getSelectedItem().toString();
					String[] rijecs=s.split(" ");
					long l=Long.parseLong(rijecs[0]);
					ZaposlenikHibernate zaps=DalDao.VratiZaposlenika(l);
					
					phib.setKoordinator(zaps);
					DalDao.ModifikujObjekat(phib);
					/* TODO modifikovanje taskova
					int[] indeksi=list.getSelectedIndices();
					for(int i=0;i<indeksi.length;i++){
						String selektovano=listaZaposlenikaProjekta.getElementAt(indeksi[i]).toString();
						String[] rijeciPr=selektovano.split(" ");
						long idPr=Long.parseLong(rijeciPr[0]);
						ZaposlenikHibernate zPr=DalDao.VratiZaposlenika(idPr);
						TaskHibernate tPr=new TaskHibernate();
						tPr.setProjekat(projekath);
						tPr.setZaposlenik(zPr);
						DalDao.DodajObjekat(tPr);
					
					}*/
				}
			}
		});
		btnSpremiPromjene.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSpremiPromjene.setBounds(195, 449, 125, 23);
		panel.add(btnSpremiPromjene);
	}
}