import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class UserController {
	
	private LogInView view;
	private UserModel model;
	
	public UserController(LogInView v,UserModel m) throws IOException {
		this.view=v;
		this.model=m;
	}
	
	
	public void init() {
		view.getLogin().addActionListener(e -> {
			try {
				String userName = view.getUsernameField().getText();
				String password = view.getPasswordField().getText();
				User usrTmp= new User(userName,password,null,null,null);
				UserResponse res = model.SignIn(usrTmp);
				
			
				if(!res.GetSuccess())//אם החזיר "שקר" זה אומר שלא מצא את הפרטים שנשלחו ושולח הודעה שגיאה בהתאם
				{
					JOptionPane.showMessageDialog(view.getFrame(), "פרטי ההתחברות שהזנת שגויים!");;
				}
				else//כאשר מצא , שולח הודעה ומקשר לעמוד המתאים לפי סוג המשתמש.
				{
					JOptionPane.showMessageDialog(view.getFrame(), "AidFinder-ברוך הבא ל");
					if(usrTmp.GetPermission().equals("1"))
					{
						view.getFrame().dispose();
						MitnadevPage mp=new MitnadevPage();
						File usersFile = new File("users.txt");
						MitnadevModel mod = new MitnadevModel(usersFile);
						MitnadevController c = new MitnadevController(mp, mod);
						
						c.Init(res.GetData());
					}
					else
					{
						view.getFrame().dispose();
						AmutaPage ap=new AmutaPage();
						File usersFile = new File("users.txt");
						AmutaModel amod = new AmutaModel(usersFile);
						AmutaController ac = new AmutaController(ap, amod);
						
						ac.Init(res.GetData());
					}
					
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		view.getSignup().addActionListener(e->{
			view.getFrame().dispose();
			SignUpView v=new SignUpView();
			File usersFile = new File("users.txt");
			SignUpModel sm;
			try {
				sm = new SignUpModel(usersFile);
				SignUpController m=new SignUpController(v,sm);
				m.init();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	
	


}