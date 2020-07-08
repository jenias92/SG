package ImportElder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Amuta.AmutaController;
import Amuta.AmutaModel;
import Amuta.AmutaPage;
import Elders.Elders;
import Users.User;

public class ImportElderController {

	private ImportFromExcel model;
	private ImportElderView view;

	public ImportElderController(ImportFromExcel m, ImportElderView v) {
		model = m;
		view = v;
	}

	public void initImportElderController(User data) {
		view.setVisible(true);
		view.getSelectFile().addActionListener(e -> chooseExcelFileWindow());
		view.getSubmit().setEnabled(false);
		view.getSubmit().addActionListener(e -> {
			try {
				processExcelFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getBack().addActionListener(e -> {
			try {
				view.dispose();
				AmutaPage ap = new AmutaPage();
				File usersFile = new File("users.txt");
				AmutaModel amod = new AmutaModel(usersFile);
				AmutaController ac = new AmutaController(ap, amod);
				ac.Init(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	private void chooseExcelFileWindow() {
		JFileChooser fileChoose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChoose.setAcceptAllFileFilterUsed(false);
		fileChoose.setDialogTitle("Select a .xlsx file");
		FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .xlsx files", "xlsx");
		fileChoose.addChoosableFileFilter(restrict);
		int r = fileChoose.showOpenDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			// set the label to the path of the selected file
			view.getPath().setText(fileChoose.getSelectedFile().getAbsolutePath());
			view.getSubmit().setEnabled(true);
			model.setUserExcelFile(fileChoose.getSelectedFile().getAbsolutePath());
		}
	}

	private void processExcelFile() throws IOException {
		String output;
		if (!model.getUserExcelFile().isEmpty()) {
			view.getResult().setText("File in process");
			ImportFromExcel reader = new ImportFromExcel();
			List<Elders> NewEldersList = null;
			NewEldersList = reader.readBooksFromExcelFile(model.getUserExcelFile());
			output = Elders.InsertIntoDB(NewEldersList);
//			output = reader.InsertIntoDB(NewEldersList);
			view.getResult().setText(output);
		} else {
			view.getResult().setText("Couldn't load the file, please try again");
		}
	}
}
