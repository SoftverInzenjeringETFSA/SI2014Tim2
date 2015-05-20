package ba.etf.unsa.si.KlaseHibernate;

import javax.naming.directory.InvalidAttributeValueException;

public class Administrator {
	
	private String username;
	private String lozinka;
	
	public Administrator(String _username, String _lozinka) throws InvalidAttributeValueException 
	{
		setUsername(_username);
		setLozinka(_lozinka);
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String _username)
	{
		username = _username;	
	}
	
	public String getLozinka()
	{
		return lozinka;
	}
	
	public void setLozinka(String _lozinka)
	{
		lozinka = _lozinka;
	}
		
}
