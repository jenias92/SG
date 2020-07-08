package SignUp;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
				String assosc;
				
				
				if (view.getMitnadevRadioButton().isSelected()) {
					isMitnadev = "1";
					assosc=view.getComboBox().getSelectedItem().toString();
				} else {
					isMitnadev = "0";
					assosc=view.getTextfieldAmuta().getText();
				}
	
				User usrTmp1 = new User(userName, password, id, email, isMitnadev, assosc);
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
						c.init();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			} else {
				System.out.println("form validation failed");
			}
		});
		//בחירה של או כפתור מתנדב או עמותה 
		view.getAmutaRadioButton().addActionListener(e->{
			if(view.getAmutaRadioButton().isSelected())
			{
			   
				 view.getComboBox().setVisible(false);
			     view.getMitnadevRadioButton().setSelected(false);
			     view.getChooseAmuta().setVisible(false);
			     view.getNameAmuta().setVisible(true);
			     view.getTextfieldAmuta().setVisible(true);
			}
		});
		view.getMitnadevRadioButton().addActionListener(e->{
			if(view.getMitnadevRadioButton().isSelected())
			{
			    view.getComboBox().setVisible(true);
			    view.getAmutaRadioButton().setSelected(false);
			    view.getChooseAmuta().setVisible(true);
			     view.getNameAmuta().setVisible(false);
			     view.getTextfieldAmuta().setVisible(false);
			     List<String> list;
					try {
						list = model.GetAllAmutotNames();
						 for (int i = 0; i < list.size(); i++) {
							 
							        view.getComboBox().addItem(list.get(i)); 
					     }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
			view.getMitnadevRadioButton().setForeground(java.awt.Color.black);
			view.getAmutaRadioButton().setForeground(java.awt.Color.black);
			
		} else {
			view.getMitnadevRadioButton().setForeground(java.awt.Color.red);
			view.getAmutaRadioButton().setForeground(java.awt.Color.red);
			numOfIssues++;
		}
		if (numOfIssues > 0) {
			state = false;
		}
		return state;
	}
}
