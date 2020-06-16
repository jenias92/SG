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

	public Elders() {
		matchId = "None";
	}

	public String fullData() {
		String full;
		full = id + ',' + firstName + ',' + lastName + ',' + city + ',' + ',' + address + ',' + address + ',' + birthDay
				+ ',' + languages + ',' + ',' + hobbies + ',' + telephone + ',' + ',' + matchId;
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

	// getters and setters
}
