package Amuta;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class AmutaPage {

	private JFrame frame;
	private JButton volunteerlist ;
	private JButton elderlist;
	private JButton volunteeredit;
	private JButton exit; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmutaPage window = new AmutaPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AmutaPage() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("עמותה");
		frame.setBounds(100, 100, 565, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 volunteerlist = new JButton("רשימת מתנדבים");
		 elderlist = new JButton("רשימת קשישים");
		 volunteeredit = new JButton("עריכת פרטים אישיים");
		 exit = new JButton("התנתקות");

		
		volunteerlist.setBounds(26, 118, 233, 41);
		frame.getContentPane().add(volunteerlist);
		
		elderlist.setBounds(285, 118, 222, 41);
		frame.getContentPane().add(elderlist);
		
		volunteeredit.setBounds(116, 187, 281, 41);
		frame.getContentPane().add(volunteeredit);
		
		exit.setBounds(180, 364, 171, 41);
		frame.getContentPane().add(exit);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getVolunteerlist() {
		return volunteerlist;
	}

	public void setVolunteerlist(JButton volunteerlist) {
		this.volunteerlist = volunteerlist;
	}

	public JButton getElderlist() {
		return elderlist;
	}

	public void setElderlist(JButton elderlist) {
		this.elderlist = elderlist;
	}

	public JButton getVolunteeredit() {
		return volunteeredit;
	}

	public void setVolunteeredit(JButton volunteeredit) {
		this.volunteeredit = volunteeredit;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}
	

}
