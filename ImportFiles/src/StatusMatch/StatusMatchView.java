package StatusMatch;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class StatusMatchView {

	private JFrame frame;
	private JButton findmatch;
	private JLabel firstname ;
	private JLabel id;
	private JLabel birthDay;
	private JLabel languages;
	private JLabel lastname;
	private JLabel city ;
	private JLabel telephone;
	private JLabel address;
	private JLabel hobbies;
	private JLabel firstnameAnswer;
	private JLabel idAnswer;
	private JLabel birthdayAnswer;
	private JLabel languagesAnswer;
	private JLabel hobbiesAnswer;
	private JLabel lastnameAnswer;
	private JLabel cityAnswer;
	private JLabel addressAnswer;
	private JLabel telephoneAnswer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusMatchView window = new StatusMatchView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatusMatchView() {
		frame = new JFrame();
		this.frame.setVisible(true);
		frame.setTitle("סטטוס התאמה");
		frame.setBounds(100, 100, 586, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		findmatch = new JButton("חפש התאמה");
		 firstname = new JLabel("שם פרטי:");
		 id = new JLabel("ת\"ז:");
		 birthDay = new JLabel("ת.לידה:");
		 languages = new JLabel("שפה:");
		 lastname = new JLabel("שם משפחה:");
		 city = new JLabel("עיר:");
		 telephone = new JLabel("טלפון:");
		 address = new JLabel("כתובת:");
		 hobbies = new JLabel("תחביבים:");
		 firstnameAnswer = new JLabel("");
		 idAnswer = new JLabel("");
		 birthdayAnswer = new JLabel("");
		 languagesAnswer = new JLabel("");
		 hobbiesAnswer = new JLabel("");
		 lastnameAnswer = new JLabel("");
		 cityAnswer = new JLabel("");
		 addressAnswer = new JLabel("");
		 telephoneAnswer = new JLabel("");
	
		
		findmatch.setBounds(167, 190, 194, 41);
		frame.getContentPane().add(findmatch);
		
		firstname.setBounds(431, 78, 123, 33);
		frame.getContentPane().add(firstname);
		
		id.setBounds(431, 133, 115, 33);
		frame.getContentPane().add(id);
		
		birthDay.setBounds(431, 194, 115, 33);
		frame.getContentPane().add(birthDay);
		
		languages.setBounds(431, 255, 115, 33);
		frame.getContentPane().add(languages);
		
		lastname.setBounds(150, 78, 152, 33);
		frame.getContentPane().add(lastname);
		
		city.setBounds(150, 133, 115, 33);
		frame.getContentPane().add(city);
		
		telephone.setBounds(150, 255, 115, 33);
		frame.getContentPane().add(telephone);
		
		address.setBounds(150, 194, 115, 33);
		frame.getContentPane().add(address);
		
		hobbies.setBounds(431, 317, 115, 33);
		frame.getContentPane().add(hobbies);
		
		
		firstnameAnswer.setBounds(314, 78, 115, 33);
		frame.getContentPane().add(firstnameAnswer);
		
		
		idAnswer.setBounds(314, 133, 115, 33);
		frame.getContentPane().add(idAnswer);
		
		
		birthdayAnswer.setBounds(314, 194, 115, 33);
		frame.getContentPane().add(birthdayAnswer);
		
		
		languagesAnswer.setBounds(314, 255, 115, 33);
		frame.getContentPane().add(languagesAnswer);
		
		
		hobbiesAnswer.setBounds(314, 316, 115, 33);
		frame.getContentPane().add(hobbiesAnswer);
		
		
		lastnameAnswer.setBounds(26, 78, 115, 33);
		frame.getContentPane().add(lastnameAnswer);
		
		
		cityAnswer.setBounds(26, 133, 115, 33);
		frame.getContentPane().add(cityAnswer);
		
		
		addressAnswer.setBounds(26, 194, 115, 33);
		frame.getContentPane().add(addressAnswer);
		
		
		telephoneAnswer.setBounds(26, 255, 115, 33);
		frame.getContentPane().add(telephoneAnswer);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getFirstnameAnswer() {
		return firstnameAnswer;
	}

	public void setFirstnameAnswer(JLabel firstnameAnswer) {
		this.firstnameAnswer = firstnameAnswer;
	}

	public JLabel getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(JLabel idAnswer) {
		this.idAnswer = idAnswer;
	}

	public JLabel getBirthdayAnswer() {
		return birthdayAnswer;
	}

	public void setBirthdayAnswer(JLabel birthdayAnswer) {
		this.birthdayAnswer = birthdayAnswer;
	}

	public JLabel getLanguagesAnswer() {
		return languagesAnswer;
	}

	public void setLanguagesAnswer(JLabel languagesAnswer) {
		this.languagesAnswer = languagesAnswer;
	}

	public JLabel getHobbiesAnswer() {
		return hobbiesAnswer;
	}

	public void setHobbiesAnswer(JLabel hobbiesAnswer) {
		this.hobbiesAnswer = hobbiesAnswer;
	}

	public JLabel getLastnameAnswer() {
		return lastnameAnswer;
	}

	public void setLastnameAnswer(JLabel lastnameAnswer) {
		this.lastnameAnswer = lastnameAnswer;
	}

	public JLabel getCityAnswer() {
		return cityAnswer;
	}

	public void setCityAnswer(JLabel cityAnswer) {
		this.cityAnswer = cityAnswer;
	}

	public JLabel getAddressAnswer() {
		return addressAnswer;
	}

	public void setAddressAnswer(JLabel addressAnswer) {
		this.addressAnswer = addressAnswer;
	}

	public JLabel getTelephoneAnswer() {
		return telephoneAnswer;
	}

	public void setTelephoneAnswer(JLabel telephoneAnswer) {
		this.telephoneAnswer = telephoneAnswer;
	}

	public JButton getFindmatch() {
		return findmatch;
	}

	public void setFindmatch(JButton findmatch) {
		this.findmatch = findmatch;
	}

	public JLabel getFirstname() {
		return firstname;
	}

	public void setFirstname(JLabel firstname) {
		this.firstname = firstname;
	}

	public JLabel getId() {
		return id;
	}

	public void setId(JLabel id) {
		this.id = id;
	}

	public JLabel getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(JLabel birthDay) {
		this.birthDay = birthDay;
	}

	public JLabel getLanguages() {
		return languages;
	}

	public void setLanguages(JLabel languages) {
		this.languages = languages;
	}

	public JLabel getLastname() {
		return lastname;
	}

	public void setLastname(JLabel lastname) {
		this.lastname = lastname;
	}

	public JLabel getCity() {
		return city;
	}

	public void setCity(JLabel city) {
		this.city = city;
	}

	public JLabel getTelephone() {
		return telephone;
	}

	public void setTelephone(JLabel telephone) {
		this.telephone = telephone;
	}

	public JLabel getAddress() {
		return address;
	}

	public void setAddress(JLabel address) {
		this.address = address;
	}

	public JLabel getHobbies() {
		return hobbies;
	}

	public void setHobbies(JLabel hobbies) {
		this.hobbies = hobbies;
	}
}
