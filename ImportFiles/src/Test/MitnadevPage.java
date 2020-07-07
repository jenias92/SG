import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MitnadevPage {

	private JFrame frame;
	private JButton edit;
	private JButton status;
	private JButton exit;
	private JLabel staticwelcome;
	private JLabel nameheader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MitnadevPage window = new MitnadevPage();
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
	public MitnadevPage() {
		frame = new JFrame();
		this.frame.setVisible(true);
		frame.setTitle("מתנדב");
		frame.setBounds(100, 100, 582, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 edit = new JButton("עריכת פרטים");
		 status = new JButton("סטטוס התאמה");
		 exit = new JButton("התנתק");
		
		edit.setBounds(312, 161, 193, 41);
		frame.getContentPane().add(edit);
		
		status.setBounds(51, 161, 217, 41);
		frame.getContentPane().add(status);
		
		exit.setBounds(197, 353, 171, 41);
		frame.getContentPane().add(exit);	
		
		staticwelcome = new JLabel("ברוך הבא");
		staticwelcome.setBounds(328, 42, 150, 33);
		frame.getContentPane().add(staticwelcome);
		
		nameheader = new JLabel("");
		nameheader.setBounds(187, 42, 115, 33);
		frame.getContentPane().add(nameheader);
	}

	public JLabel getNameheader() {
		return nameheader;
	}

	public void setNameheader(JLabel nameheader) {
		this.nameheader = nameheader;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getEdit() {
		return edit;
	}

	public void setEdit(JButton edit) {
		this.edit = edit;
	}

	public JButton getStatus() {
		return status;
	}

	public void setStatus(JButton status) {
		this.status = status;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}
	
	

	

}
