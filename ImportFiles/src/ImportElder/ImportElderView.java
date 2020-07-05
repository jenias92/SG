package ImportElder;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author ysmorgon
 */
public class ImportElderView extends JFrame {

	// Variables declaration - do not modify
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JTextField jTextField1;
	private String path;
	// End of variables declaration

	public ImportElderView(String title, String welcome, String selectBtn, String processBtn) {

		jLabel1 = new JLabel();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jTextField1 = new JTextField();
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();

		setTitle(title);
		jLabel1.setText(welcome);
		jButton1.setText(selectBtn);
		jButton2.setText(processBtn);
		jButton2.setActionCommand(processBtn);
		jButton2.setEnabled(false);
		setResizable(false);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(36, 36, 36).addComponent(jTextField1).addGap(18, 18, 18)
								.addComponent(jButton1).addGap(32, 32, 32))
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(47, 47, 47).addComponent(jLabel1))
								.addGroup(layout.createSequentialGroup().addGap(110, 110, 110).addComponent(jButton2)))
						.addContainerGap(62, Short.MAX_VALUE))
				.addGroup(
						layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jButton1)
								.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(jButton2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE).addContainerGap()));

		pack();
	}

	public JButton getjButton1() {
		return jButton1;
	}

	public void setjButton1(JButton jButton1) {
		this.jButton1 = jButton1;
	}

	public JButton getjButton2() {
		return jButton2;
	}

	public void setjButton2(JButton jButton2) {
		this.jButton2 = jButton2;
	}

	public JLabel getjLabel1() {
		return jLabel1;
	}

	public void setjLabel1(JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public void setjScrollPane1(JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	public JTextArea getjTextArea1() {
		return jTextArea1;
	}

	public void setjTextArea1(JTextArea jTextArea1) {
		this.jTextArea1 = jTextArea1;
	}

	public JTextField getjTextField1() {
		return jTextField1;
	}

	public void setjTextField1(JTextField jTextField1) {
		this.jTextField1 = jTextField1;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
