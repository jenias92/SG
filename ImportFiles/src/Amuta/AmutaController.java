package Amuta;

import java.io.File;
import java.io.IOException;

import Login.*;
import Users.*;
import ElderList.*;

public class AmutaController {

	AmutaPage view;
	AmutaModel model;
	User userData;
	
	public AmutaController(AmutaPage v,AmutaModel m) throws IOException {
		this.view=v;
		this.model=m;
	}
	public void Init(User data) {
		this.userData=data;
		
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
        view.getElderlist().addActionListener(e->{
        	view.getFrame().dispose();
			ElderListPage el=new ElderListPage();
			File usersFile = new File("users.txt");
			ElderListModel umod;
			try {
				umod = new ElderListModel(usersFile);
				ElderListController c = new ElderListController(el, umod);
				c.Init(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        });
	}
}
