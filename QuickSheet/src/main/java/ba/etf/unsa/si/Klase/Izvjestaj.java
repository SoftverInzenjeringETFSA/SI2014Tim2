package ba.etf.unsa.si.Klase;

import javax.naming.directory.InvalidAttributeValueException;

public abstract class Izvjestaj {

	Projekat projekat;
	
	public Izvjestaj(Projekat _projekat) throws InvalidAttributeValueException 
	{
		setProjekat(_projekat);
	}
	
	public Projekat getProjekat() 
	{
		return projekat;
	}
	
	public void setProjekat(Projekat projekat) throws InvalidAttributeValueException 
	{
		if (projekat != null)
			this.projekat = projekat;
		else throw new InvalidAttributeValueException();
	}
}
