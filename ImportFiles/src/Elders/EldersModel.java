package Elders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Users.User;

public class EldersModel {
	private File file;

	public EldersModel(File file) throws IOException {
		this.file = file;
		file.createNewFile();
	}
	

	public List<String>  GetAllElders() throws IOException{
		List<String> Elders = new ArrayList<>();

		FileReader fr = null;
		fr = new FileReader(this.file);
		BufferedReader br = new BufferedReader(fr);
		String s1 = br.readLine();

		while (s1 != null && s1.length() != 0) {
			User a = new User(s1);
			if(a.GetPermission().equals("0"))
				Elders.add(a.getAssociation());	
			s1 = br.readLine();
		}
		return Elders;
	}
}
