package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JComboBox;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class TaskForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_1;
	protected static final Logger LOGGER = Logger.getLogger("TaskForm");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaskForm frame = new TaskForm(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public TaskForm(final ProjekatHibernate p, final DefaultListModel dlm) {
		setResizable(false);
		setTitle("Dodavanje taskova");
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 383, 303);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.darkShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("TextField.darkShadow"));
		panel.setBounds(21, 11, 327, 232);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dodaj task", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("TextField.highlight")));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNazivTaska = new JLabel("Naziv taska:");
		lblNazivTaska.setForeground(UIManager.getColor("TextField.highlight"));
		lblNazivTaska.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNazivTaska.setBounds(26, 25, 59, 14);
		panel.add(lblNazivTaska);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 22, 202, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOpisTaska = new JLabel("Opis taska:");
		lblOpisTaska.setForeground(UIManager.getColor("TextField.highlight"));
		lblOpisTaska.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOpisTaska.setBounds(31, 62, 54, 14);
		panel.add(lblOpisTaska);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(95, 59, 202, 20);
		panel.add(textField_1);
		
		JLabel lblPrioritet = new JLabel("Prioritet:");
		lblPrioritet.setForeground(UIManager.getColor("TextField.highlight"));
		lblPrioritet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrioritet.setBounds(42, 170, 42, 14);
		panel.add(lblPrioritet);
		
		final JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(96, 167, 201, 20);
		panel.add(spinner);
		
		JLabel lblNewLabel = new JLabel("Rok:");
		lblNewLabel.setForeground(UIManager.getColor("TextField.highlight"));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(63, 145, 22, 14);
		panel.add(lblNewLabel);
		
		final JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_1.setModel(new SpinnerDateModel(new Date(1432245600000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(95, 139, 202, 20);
		panel.add(spinner_1);
		
		final JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setVisible(false);
		label.setBounds(0, 249, 377, 25);
		contentPane.add(label);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 98, 202, 20);
		ArrayList<ZaposlenikHibernate> zaposlenii = new ArrayList<ZaposlenikHibernate>();
		zaposlenii = DalDao.VratiZaposlenikeNaProjektu(p.getId());
		for (int i = 0; i < zaposlenii.size(); i++)
		{
			comboBox.addItem(zaposlenii.get(i).toString());
		}
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Dodaj task");
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setBackground(UIManager.getColor("TextArea.selectionBackground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean greska = true;
				if(textField_2.getText().length() < 3)
				{
					greska = false;
					label.setText("Unesite ispravan naziv taska od minimalno 3 slova!");
				}
				if(textField_1.getText().equals(""))
				{
					greska = false;
					label.setText("Unesite opis taska!");
				}
				Date d = (Date)spinner_1.getValue();
				Calendar c = Calendar.getInstance();
				c.setTime(d);
				LocalDate ld = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
				if (ld.isBefore(LocalDate.now()))
				{
					greska = false;
					label.setText("Unesite ispravan rok za task!");
				}
				if(greska == false)
					label.setVisible(true);
				else 
				{
					label.setVisible(false);
					String naziv = textField_2.getText();
					String opis = textField_1.getText();
					String zaposlenik = comboBox.getSelectedItem().toString();
					String[] rijeci = zaposlenik.split(" ");
					long id = Long.parseLong(rijeci[0]);
					TaskHibernate th = new TaskHibernate();
					th.setNaziv(naziv);
					th.setOpis(opis);
					th.setProcenatZavrsenosti(0);
					th.setProjekat(p);
					th.setZaposlenik(DalDao.VratiZaposlenika(id));
					th.setRok(ld);
					Integer prioritet = (Integer)spinner.getValue();
					th.setPrioritet(prioritet);
					DalDao.DodajObjekat(th);
					JOptionPane.showMessageDialog(null, "Uspjesno ste dodali task", "Task dodan", JOptionPane.INFORMATION_MESSAGE);
					textField_2.setText("");
					textField_1.setText("");
					spinner.setValue(1);
					String komponenta = th.getId() + " Naziv: " + th.getNaziv() + ", Zaposlenik: " + th.getZaposlenik().toString() + ", Procenat: " + th.getProcenatZavrsenosti() + "%";
					dlm.addElement(komponenta);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(196, 198, 101, 23);
		panel.add(btnNewButton);
		
		JLabel lblZaposlenik = new JLabel("Zaposlenik:");
		lblZaposlenik.setForeground(Color.WHITE);
		lblZaposlenik.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblZaposlenik.setBounds(31, 101, 54, 14);
		panel.add(lblZaposlenik);
	}
}
