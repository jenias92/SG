package Mitnadev;

import java.io.File;
import java.io.IOException;
import Users.*;
import Login.*;

public class MitnadevController {
	
	MitnadevPage view;
	MitnadevModel model;
	User userData;
	
	public MitnadevController(MitnadevPage v,MitnadevModel m) throws IOException {
		this.view=v;
		this.model=m;

	}
	
	public void Init(User data) {
		this.userData=data;
		view.getNameheader().setText(data.GetUserName());
		
		view.getExit().addActionListener(e->{//כאשר לוחצים על התנתק אמור להחזיר אותי לדף התחברות
			
			view.getFrame().dispose();
			LogInView lv=new LogInView();
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
		});
		
	}
}


//public static void main(String[] args) throws IOException {
////Users user1 = new Users("yevgeni", "123456", "314174690", "jenia@smorgon.com", "יד שרה");
//Volunteers m = new Volunteers("yevgeni", "123456", "314174690", "jenia@smorgon.com", "יד שרה");
//System.out.println(m.getID());
//VolunteerView v = new VolunteerView();
//VolunteersController c = new VolunteersController(m, v);
//c.initVolunteersController();
//
//}
