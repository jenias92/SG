public class Elders {
	private String Id;
	private String FirstName;
	private String LastName;
	private String City;
	private String Address;
	private String BirthDay;
	private String Languages;
	private String Hobbies;

	public Elders() {
	}

	public String[] fullData() {
		String[] arr = new String[8];
		arr[0] = Id;
		arr[1] = FirstName;
		arr[2] = LastName;
		arr[3] = City;
		arr[4] = Address;
		arr[5] = BirthDay;
		arr[6] = Languages;
		arr[7] = Hobbies;
		return arr;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	public String getLanguages() {
		return Languages;
	}

	public void setLanguages(String languages) {
		Languages = languages;
	}

	public String getHobbies() {
		return Hobbies;
	}

	public void setHobbies(String hobbies) {
		Hobbies = hobbies;
	}

	// getters and setters
}
