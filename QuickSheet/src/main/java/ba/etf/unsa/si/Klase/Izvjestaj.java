package ba.etf.unsa.si.Klase;

import javax.naming.directory.InvalidAttributeValueException;

public abstract class Izvjestaj {

	protected Projekat projekat;
	protected Double procenatZavrsenogRada;
	protected Double trosak;
	protected Double ukupnoVrijemeRada;
	
	public Izvjestaj(Projekat _projekat) throws InvalidAttributeValueException 
	{
		if (projekat != null)
			setProjekat(_projekat);
	}
	
	public Projekat getProjekat() 
	{
		return projekat;
	}
	
	public Double getProcenatZavrsenogRada() 
	{
		return procenatZavrsenogRada;
	}
	
	public Double getTrosak() 
	{
		return trosak;
	}
	
	public Double getUkupnoVrijemeRada() 
	{
		return ukupnoVrijemeRada;
	}
	
	abstract public void setProjekat(Projekat projekat) throws InvalidAttributeValueException;
	abstract public void IzracunajProcenatZavrsenogRada() throws InvalidAttributeValueException;
	abstract public void IzracunajTrosak() throws InvalidAttributeValueException;
	abstract public void IzracunajUkupnoVrijemeRada() throws InvalidAttributeValueException;
	abstract public void IzracunajProcenatZavrsenogRada(int mjesec) throws InvalidAttributeValueException;
	abstract public void IzracunajTrosak(int mjesec) throws InvalidAttributeValueException;
	abstract public void IzracunajUkupnoVrijemeRada(int mjesec) throws InvalidAttributeValueException;
}
