package Login;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LogInView {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel AidFinder;
	private JLabel LoginTitel;
	private JLabel username;
	private JLabel password;
	private JButton login;
	private JButton signup;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInView window = new LogInView();
					File usersFile = new File("users.txt");
					UserModel model = new UserModel(usersFile);
					UserController uc = new UserController(window, model);
					
					uc.init();
					
					
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
	public LogInView() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 598, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 AidFinder = new JLabel("AidFinder");
		 LoginTitel = new JLabel("התחברות: ");
		 username = new JLabel("שם משתמש:");
		 password = new JLabel("סיסמא:");
		 login = new JButton("התחבר");
		 signup = new JButton("הרשמה");
		 
	
		 usernameField = new JTextField();
		 passwordField = new JPasswordField();
		
		AidFinder.setBounds(222, 28, 154, 33);
		frame.getContentPane().add(AidFinder);
		
		LoginTitel.setBounds(400, 76, 140, 33);
		frame.getContentPane().add(LoginTitel);
		
		username.setBounds(325, 137, 166, 33);
		frame.getContentPane().add(username);
		
		password.setBounds(325, 193, 102, 33);
		frame.getContentPane().add(password);
		
		login.setBounds(39, 253, 171, 41);
		frame.getContentPane().add(login);
		
		signup.setBounds(347, 316, 171, 41);
		frame.getContentPane().add(signup);
		
		usernameField.setBounds(84, 134, 236, 39);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField.setBounds(84, 190, 236, 39);
		frame.getContentPane().add(passwordField);
		
	
	}
	//get and set for all

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JLabel getAidFinder() {
		return AidFinder;
	}

	public void setAidFinder(JLabel aidFinder) {
		AidFinder = aidFinder;
	}

	public JLabel getLoginTitel() {
		return LoginTitel;
	}

	public void setLoginTitel(JLabel loginTitel) {
		LoginTitel = loginTitel;
	}

	public JLabel getUsername() {
		return username;
	}

	public void setUsername(JLabel username) {
		this.username = username;
	}

	public JLabel getPassword() {
		return password;
	}

	public void setPassword(JLabel password) {
		this.password = password;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getSignup() {
		return signup;
	}

	public void setSignup(JButton signup) {
		this.signup = signup;
	}

	

}
