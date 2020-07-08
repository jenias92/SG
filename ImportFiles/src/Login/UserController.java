package Login;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import Amuta.AmutaController;
import Amuta.AmutaModel;
import Amuta.AmutaPage;
import Mitnadev.MitnadevController;
import Mitnadev.MitnadevModel;
import Mitnadev.MitnadevPage;
import SignUp.SignUpController;
import SignUp.SignUpModel;
import SignUp.SignUpView;
import Users.User;
import Users.UserResponse;

public class UserController {

	private LogInView view;
	private UserModel model;

	public UserController(LogInView v, UserModel m) throws IOException {
		this.view = v;
		this.model = m;
	}

	public void init() {
		view.getLogin().addActionListener(e -> {
			try {
				String userName = view.getUsernameField().getText();
				String password = view.getPasswordField().getText();
				Boolean continueLogin = this.validateValues();
				if (continueLogin) {
					view.getUsername().setForeground(java.awt.Color.black);
					view.getPassword().setForeground(java.awt.Color.black);
					User usrTmp = new User(userName, password, null, null, null, null);
					UserResponse res = model.SignIn(usrTmp);
					if (!res.GetSuccess())// אם החזיר "שקר" זה אומר שלא מצא את הפרטים שנשלחו ושולח הודעה שגיאה בהתאם
					{
						JOptionPane.showMessageDialog(view.getFrame(), "פרטי ההתחברות שהזנת שגויים!");
						;
					} else// כאשר מצא , שולח הודעה ומקשר לעמוד המתאים לפי סוג המשתמש.
					{
						JOptionPane.showMessageDialog(view.getFrame(), "AidFinder-ברוך הבא ל");
						if (usrTmp.GetPermission().equals("1")) {//עם הוא מתנדב
							view.getFrame().dispose();
							MitnadevPage mp = new MitnadevPage();
							File usersFile = new File("users.txt");
							MitnadevModel mod = new MitnadevModel(usersFile);
							MitnadevController c = new MitnadevController(mp, mod);
							c.Init(res.GetData());
						} else {//אם הוא עמותה
							view.getFrame().dispose();
							AmutaPage ap = new AmutaPage();
							File usersFile = new File("users.txt");
							AmutaModel amod = new AmutaModel(usersFile);
							AmutaController ac = new AmutaController(ap, amod);
							ac.Init(res.GetData());
						}
					}
				} else {
					System.out.println("form validation failed");
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		view.getSignup().addActionListener(e -> {
			view.getFrame().dispose();
			SignUpView v = new SignUpView();
			File usersFile = new File("users.txt");
			SignUpModel sm;
			try {
				sm = new SignUpModel(usersFile);
				SignUpController m = new SignUpController(v, sm);
				m.init();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	private Boolean validateValues() {
		String userName = view.getUsernameField().getText();
		String password = view.getPasswordField().getText();

		int numOfIssues = 0;
		Boolean state = true;
		if (userName.isEmpty()) {
			view.getUsername().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getUsername().setForeground(java.awt.Color.black);
		}
		if (password.isEmpty()) {
			view.getPassword().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getPassword().setForeground(java.awt.Color.black);
		}
		if (numOfIssues > 0) {
			state = false;
		}
		return state;
	}

}
