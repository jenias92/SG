package ElderList;

import java.io.File;
import java.io.IOException;

import Amuta.AmutaController;
import Amuta.AmutaModel;
import Amuta.AmutaPage;
import ImportElder.ImportElderController;
import ImportElder.ImportElderView;
import ImportElder.ImportFromExcel;
import Users.User;

public class ElderListController {

	ElderListPage view;
	ElderListModel model;
	User userData;

	public ElderListController(ElderListPage v, ElderListModel m) throws IOException {
		this.view = v;
		this.model = m;
	}

	public void Init(User data) {
		this.userData = data;
		view.getExit().addActionListener(e -> {
			view.getFrame().dispose();
			AmutaPage ap = new AmutaPage();
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
		view.getImportelder().addActionListener(e -> {
			view.getFrame().dispose();
			ImportFromExcel m = new ImportFromExcel();
			ImportElderView v = new ImportElderView("ImportElders", "Welcome to Elders Import Area, please select file",
					"Select Elder File", "Process File");
			ImportElderController c = new ImportElderController(m, v);
			c.initImportElderController(data);
		});
	}

}
