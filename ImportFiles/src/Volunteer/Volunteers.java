package Volunteer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Users.User;

public class Volunteers extends User implements IVolunteersModel {

	private String Fullname;
	private String Adress;
	private String UserID;
	private String City;
	private String Age;
	private String[] Hobbies;
	private String[] Languagies;
	private String PhoneNumber;
	private String MatchStatus = null;
	private static int VolunteerOldDataLocation;
	private static String VolunteersFilePath = "volunteers.txt";

	public Volunteers(User single) {
		super(single.GetUserName(), single.GetPassword(), single.GetId(), single.GetEmail(), single.GetPermission(),
				single.getAssociation());
		VolunteerOldDataLocation = -1;
	}

	public Volunteers() {
		super();
		VolunteerOldDataLocation = -1;
	}

	public User getUserData() {
		User user = new User(this.UserName, this.Password, this.Id, this.Email, this.Permission, this.Association);
		return user;
	}

	public String getAllData() {
		String full;
		String HobbiesString = Arrays.toString(Hobbies).replace(",", "/").replace("[", "").replace("]", "");
		String LanguagiesString = Arrays.deepToString(Languagies).replace(",", "/").replace("[", "").replace("]", "");
		full = UserID + "," + Fullname + "," + Adress + "," + City + "," + Age + "," + HobbiesString + ","
				+ LanguagiesString + "," + PhoneNumber + "," + MatchStatus;
		return full;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		this.Fullname = fullname;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		this.Adress = adress;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		this.UserID = userID;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		this.Age = age;
	}

	public String[] getHobbies() {
		return Hobbies;
	}

	public void setHobbies(String hobbies) {
		this.Hobbies = hobbies.split("/");
	}

	public String[] getLanguagies() {
		return Languagies;
	}

	public void setLanguagies(String languagies) {
		this.Languagies = languagies.split("/");
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}

	public String getMatchStatus() {
		return MatchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.MatchStatus = matchStatus;
	}

	public int getVolunteerOldDataLocation() {
		return VolunteerOldDataLocation;
	}

	public static List<Volunteers> ReadDataFromDB() throws IOException {
		List<Volunteers> volunteerDbContent = new ArrayList<Volunteers>();
		File volunteerDbFile = new File(VolunteersFilePath);
		if (!volunteerDbFile.exists()) {
			System.out.println("Going to create the file as its not exist");
			volunteerDbFile.createNewFile();
		} else {
			Scanner fileReader = new Scanner(volunteerDbFile);
			String row[];
			while (fileReader.hasNextLine()) {
				Volunteers single = new Volunteers();
				row = fileReader.nextLine().split(",");
				if (row.length > 1) {
					single.setUserID(row[0]);
					single.setFullname(row[1]);
					single.setAdress(row[2]);
					single.setCity(row[3]);
					single.setAge(row[4].replace(" ", ""));
					single.setHobbies(row[5].replace(" ", ""));
					single.setLanguagies(row[6].replace(" ", ""));
					single.setPhoneNumber(row[7].replace(" ", ""));
					single.setMatchStatus(row[8]);
					volunteerDbContent.add(single);
				}
			}
			fileReader.close();
		}
		return volunteerDbContent;
	}

	public void ShowInfo() throws IOException {
		List<Volunteers> db = ReadDataFromDB();
		InsertVolunteerToObjectIfExist(this.GetId(), db);
		if (VolunteerOldDataLocation != -1) {
			System.out.println(getAllData());
		} else {
			System.out.println("Voulnteer not found");
			UserID = this.GetId();

		}
	}

	public void InsertVolunteerToObjectIfExist(String firstId, List<Volunteers> db) {
		Volunteers single = null;
		for (int i = 0; i < db.size(); i++) {
			single = db.get(i);
			if (firstId.equals(db.get(i).getUserID())) {
				System.out.println("Insert Voulnteer to object from DB");
				VolunteerOldDataLocation = i;
				Fullname = single.getFullname();
				Adress = single.getAdress();
				UserID = Id;
				City = single.getCity();
				Age = single.getAge();
				Hobbies = single.getHobbies();
				Languagies = single.getLanguagies();
				PhoneNumber = single.getPhoneNumber();
				MatchStatus = single.getMatchStatus();
				break;
			}
		}
		System.out.println("nothing to insert as volunteer doesn't exist in voulnteer table");
	}

	public static Boolean checkIfVolunteerExist(String id, List<Volunteers> db) {
		Volunteers single = null;
		Boolean exist = false;
		System.out.println("Going to search Voulnteer in DB");
		for (int i = 0; i < db.size(); i++) {
			single = db.get(i);
			String UserID = single.getUserID();
			if (id.equals(UserID)) {
				System.out.println("Voulnteer found");
				VolunteerOldDataLocation = i;
				exist = true;
				break;
			}
		}
		return exist;
	}

	public static String InsertIntoDB(Volunteers SingleUser) throws IOException {
		boolean VoulnteerExist = false;
		String output = "";
		List<Volunteers> db = ReadDataFromDB();
		File voulnteerDbFile = new File(VolunteersFilePath);
		FileWriter fileWritter = new FileWriter(voulnteerDbFile, false);
		BufferedWriter buffer = new BufferedWriter(fileWritter);
		String id = SingleUser.GetId();
		VoulnteerExist = checkIfVolunteerExist(id, db);
		if (VoulnteerExist) {
			System.out.println("delete old record from db: " + VolunteerOldDataLocation);
			db.remove(VolunteerOldDataLocation);
		}
		db.add(SingleUser);
		System.out.println(db.get(0).getAllData());
		for (int i = 0; i <= db.size() - 1; i++) {
			String single = db.get(i).getAllData();
			buffer.write(single + "\n");
		}
		buffer.close();
		output = "עודכן בהצלחה!";
		System.out.println("Update Completed");
		return output;
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
					if (row[0].equals(userData.GetId())) {
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