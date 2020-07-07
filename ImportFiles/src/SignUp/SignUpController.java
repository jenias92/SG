package SignUp;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import Login.LogInView;
import Login.UserController;
import Login.UserModel;
import Users.User;

public class SignUpController {

	private SignUpView view;
	private SignUpModel model;

	public SignUpController(SignUpView v, SignUpModel m) throws IOException {
		this.view = v;
		this.model = m;
	}

	public void init() {
		view.getNext().addActionListener(e -> {
			Boolean continueSignup = this.validateValues();
			if (continueSignup) {
				String userName = view.getUserNameText().getText();
				String password = view.getPasswordField().getText();
				String id = view.getIdText().getText();
				String email = view.getEmailText().getText();
				String isMitnadev;
				// String Association = view.getAssociation().getText();
				String Association = "תנו לחיות לחיות";
				if (view.getMitnadevRadioButton().isSelected()) {
					isMitnadev = "1";
				} else {
					isMitnadev = "0";
				}

				User usrTmp1 = new User(userName, password, id, email, isMitnadev, Association);
				boolean success = false;
				try {
					success = model.SignUp(usrTmp1);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if (!success) {
					JOptionPane.showMessageDialog(view.getFrame(), "הפרטים שהזנת שגויים! נסה שנית");
					;
				} else {
					JOptionPane.showMessageDialog(view.getFrame(), "AidFinder-נרשמת בהצלחה ל");
					view.getFrame().dispose();
					LogInView lv = new LogInView();
					File usersFile = new File("users.txt");
					UserModel umod;
					try {
						umod = new UserModel(usersFile);
						UserController c = new UserController(lv, umod);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} else {
				System.out.println("form validation failed");
			}

		});
		view.getAmutaRadioButton().addActionListener(e -> {
			if (e.getSource() == view.getAmutaRadioButton()) {
				view.getComboBox().setVisible(false); // set the textfields that you want to be hidden once the
														// Rectangle button is chosen.
				view.getChooseAmuta().setVisible(false);
			}
		});
		view.getMitnadevRadioButton().addActionListener(e -> {
			if (e.getSource() == view.getMitnadevRadioButton()) {
				view.getComboBox().setVisible(true); // set the textfields that you want to be hidden once the Rectangle
														// button is chosen.
				view.getChooseAmuta().setVisible(true);
			}

		});

	}

	private Boolean validateValues() {
		String userName = view.getUserNameText().getText();
		String password = view.getPasswordField().getText();
		String email = view.getEmailText().getText();
		String id = view.getIdText().getText();

		int numOfIssues = 0;
		Boolean state = true;
		if (userName.isEmpty()) {
			view.getUsernametitel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getUsernametitel().setForeground(java.awt.Color.black);
		}
		if (password.isEmpty()) {
			view.getPasstitel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getPasstitel().setForeground(java.awt.Color.black);
		}
		if (email.isEmpty()) {
			view.getEmailtitel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getEmailtitel().setForeground(java.awt.Color.black);
		}
		if (id.isEmpty()) {
			view.getIdtitel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getIdtitel().setForeground(java.awt.Color.black);
		}
		if (!view.getMitnadevRadioButton().isSelected() || !view.getAmutaRadioButton().isSelected()) {
			view.getMitnadevRadioButton().setForeground(java.awt.Color.red);
			view.getAmutaRadioButton().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getMitnadevRadioButton().setForeground(java.awt.Color.black);
			view.getAmutaRadioButton().setForeground(java.awt.Color.black);
		}
		if (numOfIssues > 0) {
			state = false;
		}
		return state;
	}

}
