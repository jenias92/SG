package ImportElder;

import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Elders.Elders;

public class ImportElderController {

	private ImportFromExcel model;
	private ImportElderView view;

	public ImportElderController(ImportFromExcel m, ImportElderView v) {
		model = m;
		view = v;
	}

	public void initImportElderController() {
		view.setVisible(true);
		view.getjButton1().addActionListener(e -> chooseExcelFileWindow());
		view.getjButton2().addActionListener(e -> {
			try {
				processExcelFile();
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
			view.getjTextField1().setText(fileChoose.getSelectedFile().getAbsolutePath());
			view.getjButton2().setEnabled(true);
			model.setUserExcelFile(fileChoose.getSelectedFile().getAbsolutePath());
		}
	}

	private void processExcelFile() throws IOException {
		String output;
		if (!model.getUserExcelFile().isEmpty()) {
			view.getjTextArea1().setText("File in process");
			ImportFromExcel reader = new ImportFromExcel();
			List<Elders> NewEldersList = null;
			NewEldersList = reader.readBooksFromExcelFile(model.getUserExcelFile());
			output = Elders.InsertIntoDB(NewEldersList);
//			output = reader.InsertIntoDB(NewEldersList);
			view.getjTextArea1().setText(output);
		} else {
			view.getjTextArea1().setText("Couldn't load the file, please try again");
		}
	}
}
