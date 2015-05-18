package ba.etf.unsa.si.Klase;

import javax.naming.directory.InvalidAttributeValueException;

public class IzvjestajOdjela extends Izvjestaj{

	private Odjel odjel;
	
	public IzvjestajOdjela(Projekat _projekat, Odjel _odjel) throws InvalidAttributeValueException {
		super(_projekat);
		
	}

	public Odjel getOdjel() 
	{
		return odjel;
	}
	
	public void setOdjel(Odjel odjel) throws InvalidAttributeValueException 
	{
		if (odjel != null)
			this.odjel = odjel;
		else throw new InvalidAttributeValueException();
	}
	
	@Override
	public void setProjekat(Projekat projekat) throws InvalidAttributeValueException 
	{
		if (projekat != null)
			this.projekat = projekat;
		else throw new InvalidAttributeValueException();
	}
	
	@Override
	public void IzracunajProcenatZavrsenogRada()
	{
		//TODO ubaciti logiku racunanja
	}
	
	@Override
	public void IzracunajTrosak()
	{
		//TODO ubaciti logiku racunanja
		
	}
	
	@Override
	public void IzracunajUkupnoVrijemeRada()
	{
		//TODO ubaciti logiku racunanja
	}
}
