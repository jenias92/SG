import java.io.File;
import java.io.IOException;

public class ElderListController {

	ElderListPage view;
	ElderListModel model;
	User userData;
	
	public ElderListController(ElderListPage v,ElderListModel m) throws IOException {
		this.view=v;
		this.model=m;
	}
	public void Init(User data) {
		this.userData=data;
		view.getExit().addActionListener(e->{
			view.getFrame().dispose();
			AmutaPage ap=new AmutaPage();
			File usersFile = new File("users.txt");
			AmutaModel umod;
			try {
				umod = new AmutaModel(usersFile);
				AmutaController c = new AmutaController(ap, umod);
				c.Init(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
}
