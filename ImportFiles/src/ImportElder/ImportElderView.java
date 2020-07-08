package ImportElder;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ImportElderView extends JFrame {

	// Variables declaration - do not modify
	private javax.swing.JButton back;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTextField path;
	private javax.swing.JTextArea result;
	private javax.swing.JButton selectFile;
	private javax.swing.JButton submit;
	private javax.swing.JLabel welcomeMessage;
	// End of variables declaration

	public ImportElderView(String title, String welcome, String selectBtn, String processBtn) {

		welcomeMessage = new JLabel();
		submit = new JButton();
		back = new JButton();
		jScrollPane3 = new JScrollPane();
		result = new JTextArea();
		path = new JTextField();
		selectFile = new JButton();
		jLabel2 = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		welcomeMessage.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
		welcomeMessage.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeMessage.setText("ברוך הבא יבגני סמורגון !");

		submit.setText("טען קובץ");
		back.setText("חזור");
		result.setColumns(20);
		result.setRows(5);
		jScrollPane3.setViewportView(result);

		selectFile.setText("טען קובץ");
		selectFile.setActionCommand("aaaa");
		jLabel2.setText("ברוך הבא לאזור ייבוא קשישים,אנא בחר קובץ");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(70, 70, 70)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(76, 76, 76)
												.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(back, GroupLayout.PREFERRED_SIZE, 131,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(submit, GroupLayout.PREFERRED_SIZE, 131,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 300,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(path, GroupLayout.PREFERRED_SIZE, 179,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18).addComponent(selectFile,
																		GroupLayout.PREFERRED_SIZE, 103,
																		GroupLayout.PREFERRED_SIZE)))))
						.addGroup(layout.createSequentialGroup().addGap(127, 127, 127).addComponent(welcomeMessage))
						.addGroup(layout.createSequentialGroup().addGap(102, 102, 102).addComponent(jLabel2)))
				.addContainerGap(90, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addComponent(welcomeMessage)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(path, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(selectFile, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(submit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(back, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		pack();
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JLabel getjLabel2() {
		return jLabel2;
	}

	public void setjLabel2(JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}

	public JScrollPane getjScrollPane3() {
		return jScrollPane3;
	}

	public void setjScrollPane3(JScrollPane jScrollPane3) {
		this.jScrollPane3 = jScrollPane3;
	}

	public JTextField getPath() {
		return path;
	}

	public void setPath(JTextField path) {
		this.path = path;
	}

	public JTextArea getResult() {
		return result;
	}

	public void setResult(JTextArea result) {
		this.result = result;
	}

	public JButton getSelectFile() {
		return selectFile;
	}

	public void setSelectFile(JButton selectFile) {
		this.selectFile = selectFile;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JLabel getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(JLabel welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

}
