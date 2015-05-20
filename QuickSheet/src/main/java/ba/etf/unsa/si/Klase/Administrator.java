package ba.etf.unsa.si.Klase;

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
	
	public void setUsername(String _username) throws InvalidAttributeValueException
	{
		if (_username != null && !_username.isEmpty() && _username.matches("^[a-zA-Z0-9]*$"))
			username = _username;
		else throw new InvalidAttributeValueException();
	}
	
	public String getLozinka()
	{
		return lozinka;
	}
	
	public void setLozinka(String _lozinka) throws InvalidAttributeValueException
	{
		if (_lozinka != null && _lozinka.length() > 5 && _lozinka.matches("^[a-zA-Z0-9]*$"))
			lozinka = _lozinka;
		else throw new InvalidAttributeValueException();
	}
	
	public Odjel kreirajOdjel(String nazivOdjela, int maksimalanBrojRadnika) throws javax.management.InvalidAttributeValueException
	{
		return new Odjel(nazivOdjela, maksimalanBrojRadnika);
	}
	
	public Projekat kreirajProjekat(String naziv, String klijent, Koordinator koordinator) throws InvalidAttributeValueException
	{
		return new Projekat(naziv, klijent, koordinator);
	}
	
	
}
