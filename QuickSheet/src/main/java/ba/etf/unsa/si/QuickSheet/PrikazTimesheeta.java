package ba.etf.unsa.si.QuickSheet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetHibernate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PrikazTimesheeta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JList list;
	private JTextField textField_2;
	protected static final Logger LOGGER = Logger.getLogger("PrikazTimesheeta");
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimesheetHibernate t = DalDao.VratiTimesheet(1);
					t.setDatumSlanja(LocalDate.now());
					DalDao.ModifikujObjekat(t);
					String podatak = t.getId() + " " + t.getProjekat().getNaziv();
					ArrayList<TaskHibernate> th = DalDao.VratiTimesheetTaskoveZaposlenika(1);
					th.get(0).setRok(LocalDate.now().plusDays(5));
					DalDao.ModifikujObjekat(th.get(0));
					PrikazTimesheeta frame = new PrikazTimesheeta(podatak);
					frame.setVisible(true);
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE,"context",e);
				}
			}
		});
	}

	public PrikazTimesheeta(String timesheetString) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("qs.png"));
		setResizable(false);
		setTitle("Prikaz timesheeta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Timesheet", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(22, 11, 649, 384);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblImeIPrezime = new JLabel("Ime i prezime uposlenika:");
		lblImeIPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImeIPrezime.setBounds(10, 31, 120, 14);
		panel_1.add(lblImeIPrezime);
		
		JLabel lblTimesheetZaPeriod = new JLabel("Timesheet poslan:");
		lblTimesheetZaPeriod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTimesheetZaPeriod.setBounds(43, 56, 87, 14);
		panel_1.add(lblTimesheetZaPeriod);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(140, 53, 166, 20);
		panel_1.add(spinner);
		
		JButton button_1 = new JButton("Odobri");
		button_1.setBounds(486, 350, 74, 23);
		panel_1.add(button_1);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton button_2 = new JButton("Odbij");
		button_2.setBounds(565, 350, 74, 23);
		panel_1.add(button_2);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblBrojRadnihSati = new JLabel("Broj radnih sati:");
		lblBrojRadnihSati.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBrojRadnihSati.setBounds(53, 87, 77, 14);
		panel_1.add(lblBrojRadnihSati);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setEnabled(false);
		textField.setBounds(141, 28, 165, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(141, 84, 165, 20);
		panel_1.add(textField_1);
		
		JLabel lblTaskovi = new JLabel("Taskovi:");
		lblTaskovi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTaskovi.setBounds(10, 124, 40, 14);
		panel_1.add(lblTaskovi);
		
		list = new JList();
		list.setEnabled(false);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(67, 141, 553, 158);
		panel_1.add(list);
		
		JLabel lblKomentar = new JLabel("Komentar:");
		lblKomentar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblKomentar.setBounds(10, 314, 59, 14);
		panel_1.add(lblKomentar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(67, 310, 553, 23);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		String[] rijeci = timesheetString.split(" ");
		long id = Long.parseLong(rijeci[0]);
		final TimesheetHibernate times = DalDao.VratiTimesheet(id);
		
		ArrayList<TaskHibernate> taskovi = DalDao.VratiTimesheetTaskoveZaposlenika(id);
		textField.setText(taskovi.get(0).getZaposlenik().getIme() + " " + taskovi.get(0).getZaposlenik().getPrezime());
		textField_1.setText(times.getBrojRadnihSati().toString());
		Calendar c = Calendar.getInstance();
		c.set(times.getDatumSlanja().getYear(), times.getDatumSlanja().getMonthValue(), times.getDatumSlanja().getDayOfMonth());
		Date d = c.getTime();
		spinner.setValue(d);
		DefaultListModel lista = new DefaultListModel();
		list.setModel(lista);
		
		for (int i = 0; i < taskovi.size(); i++)
		{
			String podaci = taskovi.get(i).getId() + " " + "Naziv: " + taskovi.get(i).getNaziv() + ", Procenat završenosti: " + taskovi.get(i).getProcenatZavrsenosti().toString() + "%, Rok: " + taskovi.get(i).getRok().toString();
			lista.addElement(podaci);
		}
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				times.setValidiran(true);
				DalDao.ModifikujObjekat(times);
				ArrayList<TaskHibernate> taskovi = DalDao.VratiTimesheetTaskoveZaposlenika(times.getId());
				for (int i = 0; i < taskovi.size(); i++)
				{
					taskovi.get(i).setKomentar("Odobren:" + " " + textField_2.getText());
					DalDao.ModifikujObjekat(taskovi.get(i));
				}
				JOptionPane.showMessageDialog(null, "Uspjesno ste odobrili timesheet", "Timesheet odobren", JOptionPane.INFORMATION_MESSAGE);
				PrikazTimesheeta.this.setVisible(false);
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				times.setValidiran(true);
				DalDao.ModifikujObjekat(times);
				ArrayList<TaskHibernate> taskovi = DalDao.VratiTimesheetTaskoveZaposlenika(times.getId());
				for (int i = 0; i < taskovi.size(); i++)
				{
					taskovi.get(i).setKomentar("Odbijen:" + " " + textField_2.getText());
					DalDao.ModifikujObjekat(taskovi.get(i));
				}
				JOptionPane.showMessageDialog(null, "Uspjesno ste odbili timesheet", "Timesheet odbijen", JOptionPane.INFORMATION_MESSAGE);
				PrikazTimesheeta.this.setVisible(false);
			}
		});
	}
}
