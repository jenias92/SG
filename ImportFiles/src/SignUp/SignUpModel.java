import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpModel {

	private File file;
	public SignUpModel(File file) throws IOException {
		this.file = file;
		file.createNewFile();
	}
	public boolean SignUp(User user) throws IOException {
	
			FileReader fr = null;
			fr = new FileReader(this.file);
			BufferedReader br = new BufferedReader(fr);
			String s1 = br.readLine();
			
			
			while( s1 !=null&&s1.length()!=0) {
				User a=new User(s1);
				String Name =a.GetUserName() ; 
				String pass  =a.GetPassword();
				String IdUser  = a.GetId();
				String EmailUser  =a.GetEmail() ;
				String Per=a.GetPermission();
			
				if( Name.equals(user.GetUserName())) {
					br.close();
					fr.close();
					return false;	
				}
				if( IdUser.equals(user.GetId())) {
					br.close();
					fr.close();
					return false;	
				}
				if( EmailUser.equals(user.GetEmail())) {
					br.close();
					fr.close();
					return false;	
				}
				
				s1=br.readLine();
			}

			BufferedWriter writer = null;
			writer = new BufferedWriter(new FileWriter(this.file,true));
			writer.write(user.GetCsv());
			writer.newLine();
			writer.close();				
			return true;	
	}

}
