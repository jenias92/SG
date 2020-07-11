package StatusMatch;

import java.io.IOException;
import java.util.List;

import Elders.Elders;
import Volunteer.Volunteers;

public class StatusMatchController {
	StatusMatchView view;
	StatusMatchModel model;
	Volunteers VolunteerData;

	public StatusMatchController(StatusMatchView v, StatusMatchModel m) throws IOException {
		this.view = v;
		this.model = m;

	}

	public void Init(Volunteers vol) {
		this.VolunteerData = vol;
		if (vol.getMatchStatus().equals("null")) {
			TurnOffButtons();
			view.getFindmatch().addActionListener(e -> {
				try {
					List<Elders> listElder = Elders.ReadDataFromDB();
					for (int i = 0; i < listElder.size(); i++) {
						if (VolunteerData.getMatchStatus().equals("null")) {
							if (listElder.get(i).getCity().equals(VolunteerData.getCity())) {
								VolunteerData.setMatchStatus(listElder.get(i).getId());
								listElder.get(i).setMatchId(VolunteerData.GetId());
								Volunteers.InsertIntoDB(VolunteerData);
								Elders.UpdateDB(listElder.get(i));
								TurnOnTheButtons();
								showMatchedView();
							}
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		} else {
			showMatchedView();
		}
	}

	public void showMatchedView() {
		view.getFindmatch().setVisible(false);
		List<Elders> listElder;
		try {
			listElder = Elders.ReadDataFromDB();
			for (int i = 0; i < listElder.size(); i++) {
				if (listElder.get(i).getId().equals(VolunteerData.getMatchStatus())) {
					view.getAddressAnswer().setText(listElder.get(i).getAddress());
					view.getBirthdayAnswer().setText(listElder.get(i).getBirthDay());
					view.getCityAnswer().setText(listElder.get(i).getCity());
					view.getFirstnameAnswer().setText(listElder.get(i).getFirstName());
					view.getHobbiesAnswer().setText(listElder.get(i).getHobbies());
					view.getIdAnswer().setText(listElder.get(i).getId());
					view.getLanguagesAnswer().setText(listElder.get(i).getLanguages());
					view.getLastnameAnswer().setText(listElder.get(i).getLastName());
					view.getTelephoneAnswer().setText(listElder.get(i).getTelephone());
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void TurnOffButtons() {// מסתיר את פרטי הקשיש
		view.getAddress().setVisible(false);
		view.getBirthDay().setVisible(false);
		view.getCity().setVisible(false);
		view.getFirstname().setVisible(false);
		view.getHobbies().setVisible(false);
		view.getId().setVisible(false);
		view.getLanguages().setVisible(false);
		view.getLastname().setVisible(false);
		view.getTelephone().setVisible(false);
	}

	public void TurnOnTheButtons() {// מסתיר את פרטי הקשיש
		view.getAddress().setVisible(true);
		view.getBirthDay().setVisible(true);
		view.getCity().setVisible(true);
		view.getFirstname().setVisible(true);
		view.getHobbies().setVisible(true);
		view.getId().setVisible(true);
		view.getLanguages().setVisible(true);
		view.getLastname().setVisible(true);
		view.getTelephone().setVisible(true);
	}
}
