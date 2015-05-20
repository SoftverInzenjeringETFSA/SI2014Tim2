package ba.etf.unsa.si.Klase;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

public class Koordinator extends Zaposlenik{

	public Koordinator(String _username, String _lozinka, String _ime, String _prezime, String _adresa, LocalDate _datum, double _cijena)
			throws InvalidAttributeValueException {
		super(_username, _lozinka, _ime, _prezime, _adresa, _datum, _cijena);
	}
	
	public void OdobriTimesheet(Timesheet timesheet)
	{
		timesheet.setValidiran(true);
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
	
	public IzvjestajZaposlenika GenerisiIzvjestaj(Projekat _projekat, Zaposlenik _zaposlenik) throws InvalidAttributeValueException
	{
		return new IzvjestajZaposlenika(_projekat, _zaposlenik);
	}
	
	public IzvjestajOdjela GenerisiIzvjestaj(Projekat _projekat, Odjel _odjel) throws InvalidAttributeValueException
	{
		return new IzvjestajOdjela(_projekat, _odjel);
	}
	
	public void PrintajIzvjestaj(String naziv)
	{
		//TODO dodati logiku printanja izvjestaja
	}
}
