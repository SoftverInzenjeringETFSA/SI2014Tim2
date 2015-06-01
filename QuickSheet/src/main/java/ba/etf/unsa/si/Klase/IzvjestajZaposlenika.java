package ba.etf.unsa.si.Klase;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import javax.naming.directory.InvalidAttributeValueException;

public class IzvjestajZaposlenika extends Izvjestaj{

	private Zaposlenik zaposlenik;
	private Integer ukupanBrojTaskova;
	public Double decimalanProcenat;
	public IzvjestajZaposlenika(Projekat _projekat, Zaposlenik _zaposlenik) throws InvalidAttributeValueException {
		super(_projekat);
		setZaposlenik(_zaposlenik);
	}

	public Integer getUkupanBrojTaskova() 
	{
		return ukupanBrojTaskova;
	}
	
	public Zaposlenik getZaposlenik() 
	{
		return zaposlenik;
	}
	
	public void setZaposlenik(Zaposlenik zaposlenik) throws InvalidAttributeValueException 
	{
		if (zaposlenik != null && projekat != null && projekat.getZaposlenici().contains(zaposlenik))
		{
			this.zaposlenik = zaposlenik;
			ukupanBrojTaskova = 0;
			IzracunajProcenatZavrsenogRada();
			IzracunajTrosak();
		}
		else throw new InvalidAttributeValueException();
	}
	
	@Override
	public void setProjekat(Projekat projekat) throws InvalidAttributeValueException 
	{
		if (projekat != null && projekat.getZaposlenici().contains(zaposlenik))
		{
			this.projekat = projekat;
			ukupanBrojTaskova = 0;
			IzracunajProcenatZavrsenogRada();
			IzracunajTrosak();
		}
		else throw new InvalidAttributeValueException();
	}

	@Override
	public void IzracunajProcenatZavrsenogRada() {
		LinkedList<ba.etf.unsa.si.Klase.Task> taskovi = projekat.getTaskovi();
		Hashtable<String, Double> taskoviZaposlenik = new Hashtable<String, Double>();
		for (ba.etf.unsa.si.Klase.Task ta: taskovi)
		{
			if (ta != null && ta.getZaposlenik().equals(zaposlenik))
				ukupanBrojTaskova++;
		}
		for (Timesheet t : projekat.getTimesheetList())
		{
			if (t.getTaskovi().get(0).getZaposlenik().equals(zaposlenik) && t.getValidiran())
			{
				for (ba.etf.unsa.si.Klase.Task task: t.getTaskovi())
				{
					taskoviZaposlenik.put(task.getNaziv(), task.getProcenatZavrsenosti());
				}
			}
		}
		Set<String> keys = taskoviZaposlenik.keySet();
		procenatZavrsenogRada = 0.0;
		for (String key: keys)
		{
			procenatZavrsenogRada += taskoviZaposlenik.get(key);
		}
		decimalanProcenat = procenatZavrsenogRada;
		procenatZavrsenogRada /= ukupanBrojTaskova;
	}

	@Override
	public void IzracunajTrosak() {
		if (zaposlenik != null)
		{
			IzracunajUkupnoVrijemeRada();		
			trosak = zaposlenik.getSatnica() * ukupnoVrijemeRada;
		}
	}

	@Override
	public void IzracunajUkupnoVrijemeRada() {
		ukupnoVrijemeRada = 0.0;
		for (Timesheet t : projekat.getTimesheetList())
		{
			if (t.getTaskovi().get(0).getZaposlenik().equals(zaposlenik) && t.getValidiran() && t.getProjekat().equals(projekat))
			{
				ukupnoVrijemeRada += t.getBrojRadnihSati(); 
			}
		}
	}
	//mjesec od 1(januar) do 12(decembar)
	@Override
	public void IzracunajProcenatZavrsenogRada(int mjesec) throws InvalidAttributeValueException {
		LinkedList<ba.etf.unsa.si.Klase.Task> taskovi = projekat.getTaskovi();
		Hashtable<String, Double> taskoviZaposlenik = new Hashtable<String, Double>();
		
		for (ba.etf.unsa.si.Klase.Task ta: taskovi)
		{
			if (ta.getZaposlenik().equals(zaposlenik) && ta.getRok().getMonth().getValue() == mjesec)
			{
				ukupanBrojTaskova++;
			}
		}
		
		for (Timesheet t : projekat.getTimesheetList())
		{
			if (t.getTaskovi().get(0).getZaposlenik().equals(zaposlenik) && t.getValidiran())
			{
				for (ba.etf.unsa.si.Klase.Task task: t.getTaskovi())
				{
					if(task.getRok().getMonth().getValue() == mjesec) 
					{
						taskoviZaposlenik.put(task.getNaziv(), task.getProcenatZavrsenosti());
					}
				}
			}
		}
		Set<String> keys = taskoviZaposlenik.keySet();
		procenatZavrsenogRada = 0.0;
		for (String key: keys)
		{
			procenatZavrsenogRada += taskoviZaposlenik.get(key);
		}
		decimalanProcenat = procenatZavrsenogRada;
		procenatZavrsenogRada /= ukupanBrojTaskova;
	}
	@Override
	public void IzracunajTrosak(int mjesec) throws InvalidAttributeValueException {
		IzracunajUkupnoVrijemeRada(mjesec);		
		trosak = zaposlenik.getSatnica() * ukupnoVrijemeRada;
	}
	@Override
	public void IzracunajUkupnoVrijemeRada(int mjesec) throws InvalidAttributeValueException {
		ukupnoVrijemeRada = 0.0;
		for (Timesheet t : projekat.getTimesheetList())
		{
			if (t.getDatumSlanja().getMonth().getValue() == mjesec && t.getTaskovi().get(0).getZaposlenik().equals(zaposlenik) && t.getValidiran() && t.getProjekat().equals(projekat))
			{
				ukupnoVrijemeRada += t.getBrojRadnihSati(); 
			}
		}
	}

}
