package Volunteer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import Elders.Elders;
import Mitnadev.MitnadevController;
import Mitnadev.MitnadevModel;
import Mitnadev.MitnadevPage;
import Users.User;

public class VolunteersController {

	private Volunteers model;
	private VolunteerView view;
	private String[] langs = { "עברית", "אנגלית", "רוסית", "אמהרית", "ערבית", };

	public VolunteersController(Volunteers m, VolunteerView v) {
		model = m;
		view = v;
	}

	public void initVolunteersController(User data) throws IOException {
		view.setVisible(true);
		view.setSize(510, 450);
		model.ShowInfo();
		view.getWelcomeMessage().setText("ברוך הבא " + model.GetUserName());
		view.getIdField().setText(model.getUserID());
		view.getFullnameField().setText(model.getFullname());
		view.getTelephoneField().setText(model.getPhoneNumber());
		view.getAgeField().setText(model.getAge());
		view.getCityField().setText(model.getCity());
		view.getAddressField().setText(model.getAdress());
		view.getAssosicationField().setText(model.getAssociation());
		// view.getAssosicationField().setText(model.getAssosication()); TODO: Uncomment
		// when added AMUTA
		view.getSubmit().addActionListener(e -> {
			try {
				updateVolunteer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getBack().addActionListener(e -> {
			try {
				view.dispose();
				MitnadevPage mp = new MitnadevPage();
				File usersFile = new File("users.txt");
				Volunteers vModel = new Volunteers();
				MitnadevModel mod = new MitnadevModel(vModel);
				MitnadevController c = new MitnadevController(mp, mod);
				c.Init(data);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		view.getLanguagiesField().setListData(this.langs);
		view.getLanguagiesField().setSelectedIndices(this.markVolunteerLangs());
		String[] HobbiesList = new String[Elders.readHobbiesFromDB().size()];
		HobbiesList = Elders.readHobbiesFromDB().toArray(HobbiesList);
		view.getHobbiesField().setListData(HobbiesList);
		view.getHobbiesField().setSelectedIndices(this.markHobbies(HobbiesList));
	}

	private void updateVolunteer() throws IOException {
		Boolean continueUpdate = this.validateValues();
		if (continueUpdate) {
			String hobbies = String.join(", ", view.getHobbiesField().getSelectedValuesList());
			String langs = String.join(", ", view.getLanguagiesField().getSelectedValuesList());
			hobbies = hobbies.replace(",", "/");
			langs = langs.replace(",", "/");
			model.setFullname(view.getFullnameField().getText());
			model.setPhoneNumber(view.getTelephoneField().getText());
			model.setAge(view.getAgeField().getText());
			model.setCity(view.getCityField().getText());
			model.setAdress(view.getAddressField().getText());
			model.setHobbies(hobbies);
			model.setLanguagies(langs);
			String output = Volunteers.InsertIntoDB(model);
			// update the screen with succsses message
			view.getMessage().setForeground(java.awt.Color.green);
			view.getMessage().setText(output + "              ");
			view.getMessage().setVisible(true);
		} else {
			System.out.println("form validation failed");
		}
	}

	private int[] markVolunteerLangs() {
		String[] LangArr = this.model.getLanguagies();
		int[] choosenLangs = new int[0];
		if (LangArr != null) {
			choosenLangs = new int[LangArr.length];
			List<String> list = Arrays.asList(this.langs);
			for (int i = 0; i < this.model.getLanguagies().length; i++) {
				if (list.contains(this.model.getLanguagies()[i])) {
					choosenLangs[i] = list.indexOf(this.model.getLanguagies()[i]);
				} else {
					choosenLangs[i] = -1;
				}
			}
		}
		return choosenLangs;
	}

	private int[] markHobbies(String[] HobbiesList) throws IOException {
		String[] volunteerHobbies = this.model.getHobbies();
		int[] choosenVoulnteerHobbies = new int[0];
		if (volunteerHobbies != null) {
			List<String> list = Arrays.asList(HobbiesList);
			choosenVoulnteerHobbies = new int[volunteerHobbies.length];
			for (int i = 0; i < volunteerHobbies.length; i++) {
				if (list.contains(volunteerHobbies[i])) {
					choosenVoulnteerHobbies[i] = list.indexOf(volunteerHobbies[i]);
				} else {
					choosenVoulnteerHobbies[i] = -1;
				}
			}
		}
		return choosenVoulnteerHobbies;
	}

	private Boolean validateValues() {
		String fullName = view.getFullnameField().getText();
		String teletPhone = view.getTelephoneField().getText();
		String age = view.getAgeField().getText();
		String city = view.getCityField().getText();
		String address = view.getAddressField().getText();
		String[] hobbies = new String[view.getHobbiesField().getSelectedValuesList().size()];
		hobbies = view.getHobbiesField().getSelectedValuesList().toArray(hobbies);
		String[] langs = new String[view.getLanguagiesField().getSelectedValuesList().size()];
		langs = view.getLanguagiesField().getSelectedValuesList().toArray(langs);

		int numOfIssues = 0;
		Boolean state = true;
		if (fullName.isEmpty()) {
			view.getFullNameLabel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getFullNameLabel().setForeground(java.awt.Color.black);
		}
		if (teletPhone.isEmpty()) {
			view.getTelephoneLabel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getTelephoneLabel().setForeground(java.awt.Color.black);
		}
		if (age.isEmpty()) {
			view.getAgeLabel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getAgeLabel().setForeground(java.awt.Color.black);
		}
		if (city.isEmpty()) {
			view.getCityLabel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getCityLabel().setForeground(java.awt.Color.black);
		}
		if (address.isEmpty()) {
			view.getAddressLabel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getAddressLabel().setForeground(java.awt.Color.black);
		}

		if (hobbies.length == 0) {
			view.getHobbiesLabel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getHobbiesLabel().setForeground(java.awt.Color.black);
		}

		if (langs.length == 0) {
			view.getLanguagiesLabel().setForeground(java.awt.Color.red);
			numOfIssues++;
		} else {
			view.getLanguagiesLabel().setForeground(java.awt.Color.black);
		}

		if (numOfIssues > 0) {
			view.getMessage().setForeground(java.awt.Color.red);
			view.getMessage().setText("שגיאה! קיימים שדות ריקים" + "     ");
			view.getMessage().setVisible(true);
			state = false;
		}
		return state;
	}

}
