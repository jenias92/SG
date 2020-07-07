

public class UserResponse {
	
	private boolean success;
	private User data;
	
	
	public void SetSuccess( boolean s)
	{
		this.success=s;
	}
	public boolean GetSuccess()
	{
		return this.success;
	}
	public void SetData( User d)
	{
		this.data=d;
	}
	public User GetData()
	{
		return this.data;
	}
	
	public UserResponse(User a,boolean d)
	{
		this.data=a;
		this.success=d;
	}

}
