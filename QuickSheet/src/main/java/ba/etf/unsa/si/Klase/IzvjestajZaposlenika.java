package ba.etf.unsa.si.Klase;

import javax.naming.directory.InvalidAttributeValueException;

public class IzvjestajZaposlenika extends Izvjestaj{

	private Zaposlenik zaposlenik;
	
	public IzvjestajZaposlenika(Projekat _projekat, Zaposlenik _zaposlenik) throws InvalidAttributeValueException {
		super(_projekat);
		setZaposlenik(_zaposlenik);
	}

	public Zaposlenik getZaposlenik() 
	{
		return zaposlenik;
	}
	
	public void setZaposlenik(Zaposlenik zaposlenik) throws InvalidAttributeValueException 
	{
		if (zaposlenik != null && projekat.getZaposlenici().contains(zaposlenik))
		{
			this.zaposlenik = zaposlenik;
			IzracunajProcenatZavrsenogRada();
			IzracunajTrosak();
			IzracunajUkupnoVrijemeRada();
		}
		else throw new InvalidAttributeValueException();
	}
	
	@Override
	public void setProjekat(Projekat projekat) throws InvalidAttributeValueException 
	{
		if (projekat != null && projekat.getZaposlenici().contains(zaposlenik))
		{
			this.projekat = projekat;
			IzracunajProcenatZavrsenogRada();
			IzracunajTrosak();
			IzracunajUkupnoVrijemeRada();
		}
		else throw new InvalidAttributeValueException();
	}

	@Override
	public void IzracunajProcenatZavrsenogRada() {
		//TODO ubaciti logiku racunanja
		
	}

	@Override
	public void IzracunajTrosak() {
		//TODO ubaciti logiku racunanja
		
	}

	@Override
	public void IzracunajUkupnoVrijemeRada() {
		ukupnoVrijemeRada = 0.0;
		for (Timesheet t : projekat.getKoordinator().getTimesheetList())
		{
			if (t.getTaskovi().get(0).getZaposlenik().equals(zaposlenik) && t.getValidiran())
			{
				ukupnoVrijemeRada += t.getBrojRadnihSati(); 
			}
		}
	}

}
