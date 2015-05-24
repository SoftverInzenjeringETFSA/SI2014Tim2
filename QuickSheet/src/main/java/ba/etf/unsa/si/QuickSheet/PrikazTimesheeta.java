package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class PrikazTimesheeta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazTimesheeta frame = new PrikazTimesheeta(null);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 124, 629, 198);
		panel_1.add(panel);
		JLabel lblImeIPrezime = new JLabel("Ime i prezime uposlenika:");
		lblImeIPrezime.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImeIPrezime.setBounds(10, 31, 120, 14);
		panel_1.add(lblImeIPrezime);
		
		JLabel lblImenkoPrezimenkovic = new JLabel("Imenko Prezimenkovic");
		lblImenkoPrezimenkovic.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblImenkoPrezimenkovic.setBounds(156, 31, 114, 14);
		panel_1.add(lblImenkoPrezimenkovic);
		
		JLabel lblTimesheetZaPeriod = new JLabel("Timesheet za period:");
		lblTimesheetZaPeriod.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTimesheetZaPeriod.setBounds(10, 56, 100, 14);
		panel_1.add(lblTimesheetZaPeriod);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOd.setBounds(10, 81, 25, 14);
		panel_1.add(lblOd);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDo.setBounds(175, 81, 25, 14);
		panel_1.add(lblDo);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(36, 78, 130, 20);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinner_1.setModel(new SpinnerDateModel(new Date(1432072800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(200, 78, 130, 20);
		panel_1.add(spinner_1);
		
		JButton button_1 = new JButton("Odobri");
		button_1.setBounds(486, 350, 74, 23);
		panel_1.add(button_1);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton button_2 = new JButton("Odbij");
		button_2.setBounds(565, 350, 74, 23);
		panel_1.add(button_2);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
	}
}
