package Amuta;

import java.io.File;
import java.io.IOException;

public class AmutaModel {

private File file;
	
	public AmutaModel(File file) throws IOException {
		this.file = file;
		file.createNewFile();
	}
}
