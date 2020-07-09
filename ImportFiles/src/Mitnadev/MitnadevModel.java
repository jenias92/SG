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
	IVolunteersModel vModel;
	public MitnadevModel(IVolunteersModel volunteerModel) throws IOException {
		this.vModel=volunteerModel;
	}
	
	public Volunteers getVolunteerByUserID(User user) throws FileNotFoundException {
		return this.vModel.getVolunteerByUserID(user);
	}
}


