
public class User {

	private String UserName;
	private String Password;
	private String Id;
	private String Email;
	private String Permission;
	
	
	public void SetUserName( String name)
	{
		this.UserName=name;
	}
	public String GetUserName()
	{
		return this.UserName;
	}
	
	public void SetPassword( String pass)
	{
		this.Password=pass;
	}
	public String GetPassword()
	{
		return this.Password;
	}
	
	public void SetId( String id)
	{
		this.Id=id;
	}
	public String GetId()
	{
		return this.Id;
	}
	
	public void SetEmail( String email)
	{
		this.Email=email;
	}
	public String GetEmail()
	{
		return this.Email;
	}
	
	public void SetPermission( String per)
	{
		this.Permission=per;
	}
	public String GetPermission()
	{
		return this.Permission;
	}
	
	public String GetCsv() {
		return this.UserName + "," + this.Password + "," + this.Id + "," + this.Email+","+this.Permission;
	}
	
	public User(String UN,String Pss,String IdU,String Em,String p ) {
		UserName = UN;
		Password =Pss;
		Id=IdU;
		Email=Em;
		Permission=p;
	}
	
	public User(String csvData) {
		this.ImportCSVData(csvData);
	}
	
	public void ImportCSVData(String data ) {
		String[] UserData = data.split(",");
		this.UserName = UserData[0]; 
		this.Password  = UserData[1];
		if(UserData.length>2) {
		this.Id  = UserData[2];
		this.Email  = UserData[3];
		this.Permission = UserData[4];
		
		}

	}
}