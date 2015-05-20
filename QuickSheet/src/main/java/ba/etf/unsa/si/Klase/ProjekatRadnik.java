package ba.etf.unsa.si.Klase;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.naming.directory.InvalidAttributeValueException;

public class ProjekatRadnik extends Zaposlenik{

	public ProjekatRadnik(String _username, String _lozinka, String _ime, String _prezime, String _adresa, LocalDate _datum, double _cijena)
			throws InvalidAttributeValueException {
		super(_username, _lozinka, _ime, _prezime, _adresa, _datum, _cijena);
	}
	
	public Timesheet PopuniTimesheet(LinkedList<Task> _taskovi, Integer radniSati, Projekat _projekat) throws javax.management.InvalidAttributeValueException
	{
		return new Timesheet(_taskovi, radniSati, _projekat);
	}
	
	public void UrediTask(Task task, String komentar, Integer procenatZavrsenosti) throws InvalidAttributeValueException
	{
		if (this.equals(task.getZaposlenik()))
		{
			task.setKomentar(komentar);
			task.setProcenatZavrsenosti(procenatZavrsenosti);
		}
		else throw new InvalidAttributeValueException();
	}
	
	public void SlanjeTimesheetaNaReviziju(Timesheet timesheet)
	{
		timesheet.getProjekat().getTimesheetList().add(timesheet);
	}
}
