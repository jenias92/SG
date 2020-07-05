package Users;

public class Users {
	public String Username;
	private String Password;
	public String Id;
	private String EmailAddress;
	public String Assosication;
	public String Permission;

	public Users(String Username, String Password, String Id, String Email, String Assosication) {
		this.Username = Username;
		this.Password = Password;
		this.Id = Id;
		this.EmailAddress = Email;
		this.Assosication = Assosication;
		this.Permission = "User";
	}

	public Users() {
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getUsername() {
		return this.Username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getPermission() {
		return Permission;
	}

	public void setPermission(String permission) {
		this.Permission = permission;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.EmailAddress = emailAddress;
	}

	public String getID() {
		return Id;
	}

	public void setID(String iD) {
		this.Id = iD;
	}

	public String getAssosication() {
		return Assosication;
	}

	public void setAssosication(String assosication) {
		this.Assosication = assosication;
	}
}