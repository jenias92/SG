package SignUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Users.User;

public class SignUpModel {

	private File file;
	private static SignUpModel single_instance = null;
	
	private SignUpModel(File file) throws IOException {
		this.file = file;
		file.createNewFile();
	}
	
	public static SignUpModel getInstance(File file) throws IOException 
    { 
        if (single_instance == null) 
            single_instance = new SignUpModel(file); 
  
        return single_instance; 
    } 
	
	public boolean SignUp(User user) throws IOException {

		FileReader fr = null;
		fr = new FileReader(this.file);
		BufferedReader br = new BufferedReader(fr);
		String s1 = br.readLine();

		while (s1 != null && s1.length() != 0) {
			User a = new User(s1);
			String Name = a.GetUserName();
			String pass = a.GetPassword();
			String IdUser = a.GetId();
			String EmailUser = a.GetEmail();
			String Per = a.GetPermission();
			String Association = a.getAssociation();

			if (Name.equals(user.GetUserName())) {
				br.close();
				fr.close();
				return false;
			}
			if (IdUser.equals(user.GetId())) {
				br.close();
				fr.close();
				return false;
			}
			if (EmailUser.equals(user.GetEmail())) {
				br.close();
				fr.close();
				return false;
			}

			s1 = br.readLine();
		}

		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(this.file, true));
		writer.write(user.GetCsv());
		writer.newLine();
		writer.close();
		return true;
	}
 
	public List<String>  GetAllAmutotNames() throws IOException{
		List<String> Amutot = new ArrayList<>();

		FileReader fr = null;
		fr = new FileReader(this.file);
		BufferedReader br = new BufferedReader(fr);
		String s1 = br.readLine();

		while (s1 != null && s1.length() != 0) {
			User a = new User(s1);
			if(a.GetPermission().equals("0"))
			Amutot.add(a.getAssociation());	
			s1 = br.readLine();
		}
		return Amutot;
	}
}
