<<<<<<< HEAD
package ba.etf.unsa.si.QuickSheet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PrikazTimesheeta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazTimesheeta frame = new PrikazTimesheeta();
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
	public PrikazTimesheeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblImeIPrezime = new JLabel("Ime i prezime uposlenika:");
		lblImeIPrezime.setBounds(10, 11, 120, 14);
		contentPane.add(lblImeIPrezime);
		
		JLabel lblImenkoPrezimenkovic = new JLabel("Imenko Prezimenkovic");
		lblImenkoPrezimenkovic.setBounds(156, 11, 114, 14);
		contentPane.add(lblImenkoPrezimenkovic);
		
		JLabel lblTimesheetZaPeriod = new JLabel("Timesheet za period:");
		lblTimesheetZaPeriod.setBounds(10, 32, 120, 14);
		contentPane.add(lblTimesheetZaPeriod);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(156, 32, 25, 14);
		contentPane.add(lblOd);
		
		JLabel lblNewLabel = new JLabel("18.05.2015.");
		lblNewLabel.setBounds(191, 32, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(261, 32, 25, 14);
		contentPane.add(lblDo);
		
		JLabel label = new JLabel("23.05.2015.");
		label.setBounds(296, 32, 78, 14);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 50, 364, 157);
		contentPane.add(panel);
		
		JButton button = new JButton("Prikazi");
		button.setBounds(137, 218, 74, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Odobri");
		button_1.setBounds(221, 218, 74, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Odbij");
		button_2.setBounds(300, 218, 74, 23);
		contentPane.add(button_2);
	}

}
=======
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

public class PrikazTimesheeta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazTimesheeta frame = new PrikazTimesheeta();
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
	public PrikazTimesheeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblImeIPrezime = new JLabel("Ime i prezime uposlenika:");
		lblImeIPrezime.setBounds(10, 11, 120, 14);
		contentPane.add(lblImeIPrezime);
		
		JLabel lblImenkoPrezimenkovic = new JLabel("Imenko Prezimenkovic");
		lblImenkoPrezimenkovic.setBounds(156, 11, 114, 14);
		contentPane.add(lblImenkoPrezimenkovic);
		
		JLabel lblTimesheetZaPeriod = new JLabel("Timesheet za period:");
		lblTimesheetZaPeriod.setBounds(10, 32, 120, 14);
		contentPane.add(lblTimesheetZaPeriod);
		
		JLabel lblOd = new JLabel("Od:");
		lblOd.setBounds(156, 32, 25, 14);
		contentPane.add(lblOd);
		
		JLabel lblNewLabel = new JLabel("18.05.2015.");
		lblNewLabel.setBounds(191, 32, 60, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setBounds(261, 32, 25, 14);
		contentPane.add(lblDo);
		
		JLabel label = new JLabel("23.05.2015.");
		label.setBounds(296, 32, 78, 14);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 50, 364, 157);
		contentPane.add(panel);
		
		JButton button = new JButton("Prikazi");
		button.setBounds(137, 218, 74, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Odobri");
		button_1.setBounds(221, 218, 74, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Odbij");
		button_2.setBounds(300, 218, 74, 23);
		contentPane.add(button_2);
	}

}
>>>>>>> origin/master
