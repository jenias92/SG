package Elders;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Elders {
	private String id;
	private String firstName;
	private String lastName;
	private String city;
	private String address;
	private String birthDay;
	private String languages;
	private String hobbies;
	private String telephone;
	private String matchId;
	private static String elderDbFilePath = "C:/test/Elders.txt";
	private static String hobbiesDBfilePath = "C:/test/EldersHobbies.txt";

	public Elders() {
		matchId = "None";
	}

	public String fullData() {
		String full;
		full = id + ',' + firstName + ',' + lastName + ',' + city + ',' + address + ',' + birthDay + ',' + languages
				+ ',' + hobbies + ',' + telephone + ',' + matchId;
		return full;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getLanguages() {
		return this.languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getHobbies() {
		return this.hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getMatchId() {
		return this.matchId;
	}

	public void setElderDbFilePath(String ElderDbFilePath) {
		Elders.elderDbFilePath = ElderDbFilePath;
	}

	public String getElderDbFilePath() {
		return Elders.elderDbFilePath;
	}

	// getters and setters

	public static List<Elders> ReadDataFromDB() throws IOException {
		List<Elders> eldersDbContent = new ArrayList<Elders>();
		File eldersDbFile = new File(elderDbFilePath);
		if (!eldersDbFile.exists()) {
			System.out.println("Going to create the file as its not exist");
			eldersDbFile.createNewFile();
		} else {
			Scanner fileReader = new Scanner(eldersDbFile);
			String row[];
			while (fileReader.hasNextLine()) {
				Elders single = new Elders();
				row = fileReader.nextLine().split(",");
				if (row.length > 1) {
					single.setId(row[0]);
					single.setFirstName(row[1]);
					single.setLastName(row[2]);
					single.setCity(row[3]);
					single.setAddress(row[4]);
					single.setBirthDay(row[5]);
					single.setLanguages(row[6]);
					single.setHobbies(row[7]);
					eldersDbContent.add(single);
				}
			}
			fileReader.close();
		}
		return eldersDbContent;
	}

	public static ArrayList<String> readHobbiesFromDB() throws IOException {
		ArrayList<String> hobbiesDbContent = new ArrayList<String>();
		File hobbiesDbFile = new File(hobbiesDBfilePath);
		if (!hobbiesDbFile.exists()) {
			System.out.println("Going to create the file as its not exist");
			hobbiesDbFile.createNewFile();
		} else {
			Scanner fileReader = new Scanner(hobbiesDbFile);
			while (fileReader.hasNextLine()) {
				String singleRow;
				singleRow = fileReader.nextLine();
				hobbiesDbContent.add(singleRow);
			}
			fileReader.close();
		}
		return hobbiesDbContent;
	}

	public static String InsertIntoDB(List<Elders> ElderList) throws IOException {
		boolean elderExist = false;
		File elderDbFile = new File(elderDbFilePath);
		File hobbiesDBfile = new File(hobbiesDBfilePath);
		String output = "";
		FileWriter fileWritter = new FileWriter(elderDbFile, true);
		BufferedWriter buffer = new BufferedWriter(fileWritter);
		FileWriter hobbiesFileWritter = new FileWriter(hobbiesDBfile, true);
		BufferedWriter hobbiesBuffer = new BufferedWriter(hobbiesFileWritter);
		List<Elders> db = ReadDataFromDB();
		ArrayList<String> hobbiesDb = readHobbiesFromDB();
		// run over elders list and import them if they not exist in File
		for (int i = 0; i < ElderList.size(); i++) {
			String id = ElderList.get(i).getId();
			String hobbies = ElderList.get(i).getHobbies();
			if (i == 0) {
				continue;
			}
			elderExist = searchElderInDB(id, db);
			ArrayList<String> newHobbies = newHobbiesToDb(hobbies, hobbiesDb);
			if (elderExist) {
				System.out.printf("Skip ID: %s as it already in DB\n", id);
				output += "Skip ID: " + id + " as it already in DB\n";
				continue;
			} else {
				System.out.printf("Importing ID: %s\n", id);
				output += "Importing ID: " + id + "\n";
				String single = ElderList.get(i).fullData();
				buffer.write(single + "\n");
				// write hobby to file if not exist in file.
				if (newHobbies.size() > 0) {
					System.out.println("going to add new Hobbies to DB file");
					for (int j = 0; j < newHobbies.size(); j++) {
						System.out.println(newHobbies.get(j));
						hobbiesBuffer.write(newHobbies.get(j) + "\n");
					}
				}
			}
		}
		buffer.close();
		hobbiesBuffer.close();
		System.out.println("Import Completed");
		output += "Import Completed";
		return output;
	}

	private static boolean searchElderInDB(String id, List<Elders> db) {
		Elders single = null;
		System.out.println("Going to search Elder:" + id + " in DB");
		for (int i = 0; i < db.size(); i++) {
			single = db.get(i);
			String UserID = single.getId();
			System.out.println(UserID + " " + i);
			if (id.equals(UserID)) {
				System.out.println("Elder:" + id + " found in DB");
				return true;
			}
		}
		System.out.println("Elder:" + id + " not found in DB");
		return false;
	}

	private static ArrayList<String> newHobbiesToDb(String hobbies, ArrayList<String> db) {
		String[] hobbiesList = hobbies.split("/");
		ArrayList<String> newHobbies = new ArrayList<String>();
		for (int i = 0; i < hobbiesList.length; i++) {
			if (!db.contains(hobbiesList[i])) {
				newHobbies.add(hobbiesList[i]);
			}
		}
		return newHobbies;
	}

}
