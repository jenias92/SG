import java.io.File;
import java.io.IOException;

public class ElderListModel {
private File file;
	
	public ElderListModel(File file) throws IOException {
		this.file = file;
		file.createNewFile();
	}

}
