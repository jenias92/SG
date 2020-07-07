import java.io.File;
import java.io.IOException;

public class MitnadevModel {
	private File file;
	
	public MitnadevModel(File file) throws IOException {
		this.file = file;
		file.createNewFile();
	}

}
