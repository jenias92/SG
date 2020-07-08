package SignUp;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpView {

	private JFrame frame;
	private JTextField userNameText;
	private JTextField idText;
	private JPasswordField passwordField;
	private JTextField emailText;
	private JLabel signuptitle;
	private JLabel usernametitel;
	private JLabel passtitel;
	private JLabel idtitel;
	private JLabel emailtitel;
	private JRadioButton amutaRadioButton;
	private JRadioButton mitnadevRadioButton;
	private JLabel chooseAmuta;
	private JComboBox comboBox;
	private JButton next;
	private JTextField textfieldAmuta;
	private JLabel NameAmuta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView window = new SignUpView();
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
	public SignUpView() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 621, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		signuptitle = new JLabel("הרשמה");
		usernametitel = new JLabel("שם משתמש:");
		passtitel = new JLabel("סיסמא:");
		idtitel = new JLabel("תעודת זהות:");
		emailtitel = new JLabel("אימייל:");
		userNameText = new JTextField();
		idText = new JTextField();
		passwordField = new JPasswordField();
		emailText = new JTextField();
		 amutaRadioButton = new JRadioButton("עמותה");
		 mitnadevRadioButton = new JRadioButton("מתנדב");
		 chooseAmuta = new JLabel("בחר עמותה:");
		 comboBox = new JComboBox();
		 next = new JButton("המשך");
		 textfieldAmuta = new JTextField();
		 NameAmuta = new JLabel("שם עמותה:");

		signuptitle.setBounds(239, 28, 115, 33);
		frame.getContentPane().add(signuptitle);

		usernametitel.setBounds(371, 95, 166, 33);
		frame.getContentPane().add(usernametitel);

		passtitel.setBounds(371, 147, 101, 33);
		frame.getContentPane().add(passtitel);

		idtitel.setBounds(372, 208, 155, 33);
		frame.getContentPane().add(idtitel);

		emailtitel.setBounds(371, 269, 89, 33);
		frame.getContentPane().add(emailtitel);

		userNameText.setBounds(115, 89, 236, 39);
		frame.getContentPane().add(userNameText);
		userNameText.setColumns(10);

		idText.setBounds(118, 205, 236, 39);
		frame.getContentPane().add(idText);
		idText.setColumns(10);

		passwordField.setBounds(115, 147, 239, 36);
		frame.getContentPane().add(passwordField);

		emailText.setBounds(118, 266, 236, 39);
		frame.getContentPane().add(emailText);
		emailText.setColumns(10);

		amutaRadioButton.setBounds(103, 329, 134, 41);
		frame.getContentPane().add(amutaRadioButton);

		mitnadevRadioButton.setBounds(286, 329, 251, 41);
		frame.getContentPane().add(mitnadevRadioButton);

		chooseAmuta.setBounds(371, 381, 154, 33);
		frame.getContentPane().add(chooseAmuta);

		comboBox.setBounds(187, 378, 161, 39);
		frame.getContentPane().add(comboBox);

		next.setBounds(40, 441, 171, 41);
		frame.getContentPane().add(next);
		
		textfieldAmuta.setBounds(115, 378, 236, 39);
		frame.getContentPane().add(textfieldAmuta);
		textfieldAmuta.setColumns(10);
		textfieldAmuta.setVisible(false);
		
		NameAmuta.setBounds(371, 381, 138, 33);
		frame.getContentPane().add(NameAmuta);
		NameAmuta.setVisible(false);
	}

	public JTextField getTextfieldAmuta() {
		return textfieldAmuta;
	}

	public void setTextfieldAmuta(JTextField textfieldAmuta) {
		this.textfieldAmuta = textfieldAmuta;
	}

	public JLabel getNameAmuta() {
		return NameAmuta;
	}

	public void setNameAmuta(JLabel nameAmuta) {
		NameAmuta = nameAmuta;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getUserNameText() {
		return userNameText;
	}

	public void setUserNameText(JTextField userNameText) {
		this.userNameText = userNameText;
	}

	public JTextField getIdText() {
		return idText;
	}

	public void setIdText(JTextField idText) {
		this.idText = idText;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextField getEmailText() {
		return emailText;
	}

	public void setEmailText(JTextField emailText) {
		this.emailText = emailText;
	}

	public JLabel getSignuptitle() {
		return signuptitle;
	}

	public void setSignuptitle(JLabel signuptitle) {
		this.signuptitle = signuptitle;
	}

	public JLabel getUsernametitel() {
		return usernametitel;
	}

	public void setUsernametitel(JLabel usernametitel) {
		this.usernametitel = usernametitel;
	}

	public JLabel getPasstitel() {
		return passtitel;
	}

	public void setPasstitel(JLabel passtitel) {
		this.passtitel = passtitel;
	}

	public JLabel getIdtitel() {
		return idtitel;
	}

	public void setIdtitel(JLabel idtitel) {
		this.idtitel = idtitel;
	}

	public JLabel getEmailtitel() {
		return emailtitel;
	}

	public void setEmailtitel(JLabel emailtitel) {
		this.emailtitel = emailtitel;
	}

	public JRadioButton getAmutaRadioButton() {
		return amutaRadioButton;
	}

	public void setAmutaRadioButton(JRadioButton amutaRadioButton) {
		this.amutaRadioButton = amutaRadioButton;
	}

	public JRadioButton getMitnadevRadioButton() {
		return mitnadevRadioButton;
	}

	public void setMitnadevRadioButton(JRadioButton mitnadevRadioButton) {
		this.mitnadevRadioButton = mitnadevRadioButton;
	}

	public JLabel getChooseAmuta() {
		return chooseAmuta;
	}

	public void setChooseAmuta(JLabel chooseAmuta) {
		this.chooseAmuta = chooseAmuta;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}
}
