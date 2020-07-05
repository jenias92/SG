package Volunteer;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
//		Users user1 = new Users("yevgeni", "123456", "314174690", "jenia@smorgon.com", "יד שרה");
		Volunteers m = new Volunteers("yevgeni", "123456", "314174690", "jenia@smorgon.com", "יד שרה");
		System.out.println(m.getID());
		VolunteerView v = new VolunteerView();
		VolunteersController c = new VolunteersController(m, v);
		c.initVolunteersController();

	}

}
