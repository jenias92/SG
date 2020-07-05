package ImportElder;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		ImportFromExcel m = new ImportFromExcel();
		ImportElderView v = new ImportElderView("ImportElders", "Welcome to Elders Import Area, please select file",
				"Select Elder File", "Process File");
		ImportElderController c = new ImportElderController(m, v);
		c.initImportElderController();

	}
}
