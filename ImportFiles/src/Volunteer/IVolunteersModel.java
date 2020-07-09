package Volunteer;

import java.io.FileNotFoundException;

import Users.User;

public interface IVolunteersModel {
	public Volunteers getVolunteerByUserID(User userData) throws FileNotFoundException;
}
