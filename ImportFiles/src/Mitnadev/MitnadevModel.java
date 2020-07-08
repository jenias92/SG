package Mitnadev;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Users.User;
import Volunteer.Volunteers;
import Volunteer.*;
public class MitnadevModel {
	private File file;
	private static String VolunteersFilePath = "volunteers.txt";

	public MitnadevModel(File file) throws IOException {
		this.file = file;
		file.createNewFile();
	}

	public Volunteers getVolunteerByUserID(User userData) throws FileNotFoundException {
		File volunteerDbFile = new File(VolunteersFilePath);
		
		if (!volunteerDbFile.exists()) {
			return null;
		} else {
			Scanner fileReader = new Scanner(volunteerDbFile);
			String row[];
			while (fileReader.hasNextLine()) {
				row = fileReader.nextLine().split(",");
				if (row.length > 1) {
					if(row[0].equals(userData.GetId())) {
						Volunteers single = new Volunteers(userData);
						single.setUserID(row[0]);
						single.setFullname(row[1]);
						single.setAdress(row[2]);
						single.setCity(row[3]);
						single.setAge(row[4].replace(" ", ""));
						single.setHobbies(row[5].replace(" ", ""));
						single.setLanguagies(row[6].replace(" ", ""));
						single.setPhoneNumber(row[7].replace(" ", ""));
						single.setMatchStatus(row[8]);
						return single;
					}
				}
			}
			fileReader.close();
			}
		return null;
		}
}


