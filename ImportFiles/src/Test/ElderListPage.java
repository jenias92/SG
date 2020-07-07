package Test;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ElderListPage {

	private JFrame frame;
	private JButton deleteelder;
	private JButton Importelder;
	private JButton editelder;
	private JButton exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElderListPage window = new ElderListPage();
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
	public ElderListPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("רשימת קשישים");
		frame.setVisible(true);
		frame.setBounds(100, 100, 593, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 deleteelder = new JButton("מחק קשישים");
		 Importelder = new JButton("ייבוא קשישים");
		 editelder = new JButton("עריכת קשישים");
		 exit = new JButton("חזור");
		
		
		deleteelder.setBounds(26, 126, 191, 41);
		frame.getContentPane().add(deleteelder);
		
		Importelder.setBounds(305, 126, 191, 41);
		frame.getContentPane().add(Importelder);
		
		editelder.setBounds(146, 213, 220, 41);
		frame.getContentPane().add(editelder);
		
		exit.setBounds(167, 350, 171, 41);
		frame.getContentPane().add(exit);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getDeleteelder() {
		return deleteelder;
	}

	public void setDeleteelder(JButton deleteelder) {
		this.deleteelder = deleteelder;
	}

	public JButton getImportelder() {
		return Importelder;
	}

	public void setImportelder(JButton importelder) {
		Importelder = importelder;
	}

	public JButton getEditelder() {
		return editelder;
	}

	public void setEditelder(JButton editelder) {
		this.editelder = editelder;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

}
