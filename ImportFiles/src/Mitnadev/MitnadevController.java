package Mitnadev;

import java.io.File;
import java.io.IOException;

import Login.LogInView;
import Login.UserController;
import Login.UserModel;
import Users.User;
import Volunteer.VolunteerView;
import Volunteer.Volunteers;
import Volunteer.VolunteersController;

public class MitnadevController {

	MitnadevPage view;
	MitnadevModel model;
	User userData;

	public MitnadevController(MitnadevPage v, MitnadevModel m) throws IOException {
		this.view = v;
		this.model = m;

	}

	public void Init(User data) {
		this.userData = data;
		view.getNameheader().setText(data.GetUserName());

		view.getExit().addActionListener(e -> {// כאשר לוחצים על התנתק אמור להחזיר אותי לדף התחברות

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
		});

		view.getEdit().addActionListener(e -> {// כאשר לוחצים על התנתק אמור להחזיר אותי לדף התחברות

			view.getFrame().dispose();
//			Users user1 = new Users("yevgeni", "123456", "314174690", "jenia@smorgon.com", "יד שרה");

			Volunteers m = new Volunteers(userData);
			System.out.println(m.getUserID());
			VolunteerView v = new VolunteerView();
			VolunteersController c = new VolunteersController(m, v);
			try {
				c.initVolunteersController();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}
}
