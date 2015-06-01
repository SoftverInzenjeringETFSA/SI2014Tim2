package ba.etf.unsa.si.Klase;

import javax.naming.directory.InvalidAttributeValueException;

public class IzvjestajOdjela extends Izvjestaj{

	private Odjel odjel;
	private Integer ukupanBrojTaskovaOdjela;
	public IzvjestajOdjela(Projekat _projekat, Odjel _odjel) throws InvalidAttributeValueException {
		super(_projekat);
		setOdjel(_odjel);
	}

	public Integer getUkupanBrojTaskovaOdjela() 
	{
		return ukupanBrojTaskovaOdjela;
	}
	
	public Odjel getOdjel() 
	{
		return odjel;
	}
	
	
	
	public void setOdjel(Odjel odjel) throws InvalidAttributeValueException 
	{
		if (odjel != null)
		{
			this.odjel = odjel;
			ukupanBrojTaskovaOdjela = 0;
			IzracunajProcenatZavrsenogRada();
			IzracunajTrosak();
		}
		else throw new InvalidAttributeValueException();
	}
	
	@Override
	public void setProjekat(Projekat projekat) throws InvalidAttributeValueException 
	{
		if (projekat != null)
		{
			this.projekat = projekat;
			ukupanBrojTaskovaOdjela = 0;
			IzracunajProcenatZavrsenogRada();
			IzracunajTrosak();
		}
		else throw new InvalidAttributeValueException();
	}
	
	@Override
	public void IzracunajProcenatZavrsenogRada() throws InvalidAttributeValueException
	{
		double ukupanProcenatOdjela = 0.0;
		if (odjel != null)
		{
			for (Zaposlenik zap: odjel.getZaposlenici())
			{
				if (projekat != null && projekat.getZaposlenici().contains(zap))
				{
					IzvjestajZaposlenika iz = new IzvjestajZaposlenika(projekat, zap);
					ukupanBrojTaskovaOdjela += iz.getUkupanBrojTaskova();
					ukupanProcenatOdjela += iz.decimalanProcenat;
				}
			}
			procenatZavrsenogRada = ukupanProcenatOdjela / ukupanBrojTaskovaOdjela;
		}
	}
	
	@Override
	public void IzracunajTrosak() throws InvalidAttributeValueException
	{
		trosak = 0.0;
		IzracunajUkupnoVrijemeRada();
		for (Zaposlenik zap: odjel.getZaposlenici())
		{
			if (projekat.getZaposlenici().contains(zap))
			{
				IzvjestajZaposlenika iz = new IzvjestajZaposlenika(projekat, zap);
				trosak += iz.getTrosak();
				ukupnoVrijemeRada += iz.getUkupnoVrijemeRada();
			}
		}
	}
	
	@Override
	public void IzracunajUkupnoVrijemeRada()
	{
		ukupnoVrijemeRada = 0.0;
	}
	
	@Override
	public void IzracunajProcenatZavrsenogRada(int mjesec) throws InvalidAttributeValueException {
		double ukupanProcenatOdjela = 0.0;
		for (Zaposlenik zap: odjel.getZaposlenici())
		{
			if (projekat.getZaposlenici().contains(zap))
			{
				IzvjestajZaposlenika iz = new IzvjestajZaposlenika(projekat, zap);
				iz.IzracunajProcenatZavrsenogRada(mjesec);
				ukupanBrojTaskovaOdjela += iz.getUkupanBrojTaskova();
				ukupanProcenatOdjela += iz.decimalanProcenat;
			}
		}
		procenatZavrsenogRada = ukupanProcenatOdjela / ukupanBrojTaskovaOdjela;
	}
	
	@Override
	public void IzracunajTrosak(int mjesec) throws InvalidAttributeValueException {
		trosak = 0.0;
		IzracunajUkupnoVrijemeRada();
		for (Zaposlenik zap: odjel.getZaposlenici())
		{
			if (projekat.getZaposlenici().contains(zap))
			{
				IzvjestajZaposlenika iz = new IzvjestajZaposlenika(projekat, zap);
				iz.IzracunajTrosak(mjesec);
				trosak += iz.getTrosak();
				ukupnoVrijemeRada += iz.getUkupnoVrijemeRada();
			}
		}
	}
	@Override
	public void IzracunajUkupnoVrijemeRada(int mjesec) throws InvalidAttributeValueException {
		ukupnoVrijemeRada = 0.0;
		for (Zaposlenik zap: odjel.getZaposlenici())
		{
			if (projekat.getZaposlenici().contains(zap))
			{
				IzvjestajZaposlenika iz = new IzvjestajZaposlenika(projekat, zap);
				iz.IzracunajUkupnoVrijemeRada(mjesec);
				ukupnoVrijemeRada = 0.0;
			}
		}
	}
}
