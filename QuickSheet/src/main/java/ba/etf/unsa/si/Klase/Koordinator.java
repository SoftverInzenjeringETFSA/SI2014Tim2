package ba.etf.unsa.si.Klase;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.naming.directory.InvalidAttributeValueException;

public class Koordinator extends Zaposlenik{

	private LinkedList<Timesheet> timesheetList;
	public Koordinator(String _username, String _lozinka, String _ime, String _prezime, String _adresa, LocalDate _datum, double _cijena)
			throws InvalidAttributeValueException {
		super(_username, _lozinka, _ime, _prezime, _adresa, _datum, _cijena);
		timesheetList = new LinkedList<Timesheet>();
	}

	public LinkedList<Timesheet> getTimesheetList() 
	{
		return timesheetList;
	}
	
	public void setTimesheetList(LinkedList<Timesheet> timesheetList) 
	{
		this.timesheetList = timesheetList;
	}
	
	public boolean OdobriTimesheet(Timesheet timesheet)
	{
		if (timesheetList.contains(timesheet))
		{
			timesheet.setValidiran(true);
			return true;
		}
		else return false;
	}
	
	public void KreirajTaskProjekta(Projekat projekat, Task task) throws InvalidAttributeValueException
	{
		if (projekat.getKoordinator().equals(this) && !projekat.getTaskovi().contains(task))
			projekat.DodajTask(task);
		else throw new InvalidAttributeValueException(); 
	}
	
	public void DodajZaposlenikaUProjekat (Projekat projekat, ProjekatRadnik zaposlenik) throws InvalidAttributeValueException
	{
		if (projekat.getKoordinator().equals(this) && !projekat.getZaposlenici().contains(zaposlenik))
			projekat.DodajZaposlenika(zaposlenik);
		else throw new InvalidAttributeValueException(); 
	}
	
	public void ArhivirajProjekat (Projekat projekat) throws InvalidAttributeValueException
	{
		if (projekat.getKoordinator().equals(this))
			projekat.setArhiviran(true);
		else throw new InvalidAttributeValueException();
	}
	
	public void GenerisiIzvjestaj(Zaposlenik zaposlenik)
	{
		//TODO dodati logiku za kreiranje izvještaja
	}
	
	public void GenerisiIzvjestaj(Odjel odjel)
	{
		//TODO dodati logiku za kreiranje izvještaja
	}
	
	public void PrintajIzvjestaj()
	{
		//TODO dodati logiku printanja izvjestaja
	}
}
