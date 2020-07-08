package StatusMatch;

import java.io.File;
import java.io.IOException;

import Volunteer.Volunteers;

public class StatusMatchModel {

	private File file;
	private Volunteers vmodel;
	
	public StatusMatchModel(File file) throws IOException {
		vmodel=new Volunteers();
		this.file = file;
		file.createNewFile();
	}
	public void UpdateVolunteer(Volunteers v) {
		try {
			vmodel.InsertIntoDB(v);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
