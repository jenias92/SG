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
			String userName = view.getUserNameText().getText();
			String password = view.getPasswordField().getText();
			String id = view.getIdText().getText();
			String email = view.getEmailText().getText();
			String isMitnadev;
			if (view.getMitnadevRadioButton().isSelected()) {
				isMitnadev = "1";
			} else {
				isMitnadev = "0";
			}

			User usrTmp1 = new User(userName, password, id, email, isMitnadev);
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

}
