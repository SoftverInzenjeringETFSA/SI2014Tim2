package ba.etf.unsa.si.Klase;

import java.util.LinkedList;

import javax.naming.directory.InvalidAttributeValueException;

public class Projekat {
	
	private LinkedList<ProjekatRadnik> zaposlenici = new LinkedList<ProjekatRadnik>();
	private LinkedList<Timesheet> timesheetList = new LinkedList<Timesheet>();
	private LinkedList<Task> taskovi = new LinkedList<Task>();
	private Koordinator koordinator;
	private String naziv;
	private String nazivKlijenta;
	private Boolean arhiviran;
	
	public Projekat(String naziv, String nazivKlijenta, Koordinator koordinator) throws InvalidAttributeValueException 
	{
		setNaziv(naziv);
		setNazivKlijenta(nazivKlijenta);
		setKoordinator(koordinator);
		arhiviran = false;
	}
	
	public Projekat(String naziv, String nazivKlijenta, Koordinator koordinator, LinkedList<ProjekatRadnik> zaposlenici, LinkedList<Task> taskovi) throws InvalidAttributeValueException 
	{
		setNaziv(naziv);
		setNazivKlijenta(nazivKlijenta);
		setKoordinator(koordinator);
		setTaskovi(taskovi);
		setZaposlenici(zaposlenici);
	}
	
	public LinkedList<Timesheet> getTimesheetList() 
	{
		return timesheetList;
	}
	
	public void setTimesheetList(LinkedList<Timesheet> timesheetList) 
	{
		this.timesheetList = timesheetList;
	}
	
	public LinkedList<ProjekatRadnik> getZaposlenici() 
	{
		return zaposlenici;
	}
	
	public void setZaposlenici(LinkedList<ProjekatRadnik> zaposlenici) throws InvalidAttributeValueException 
	{
		if (zaposlenici != null)
			this.zaposlenici = zaposlenici;
		else throw new InvalidAttributeValueException(); 
	}
	
	public LinkedList<Task> getTaskovi() 
	{
		return taskovi;
	}
	
	public void setTaskovi(LinkedList<Task> taskovi) throws InvalidAttributeValueException 
	{
		if (taskovi != null)
			this.taskovi = taskovi;
		else throw new InvalidAttributeValueException();
	}
	
	public Koordinator getKoordinator() 
	{
		return koordinator;
	}
	
	public void setKoordinator(Koordinator koordinator) throws InvalidAttributeValueException 
	{
		if (koordinator != null)
			this.koordinator = koordinator;
		else throw new InvalidAttributeValueException();
	}
	
	public String getNaziv() 
	{
		return naziv;
	}
	
	public void setNaziv(String naziv) throws InvalidAttributeValueException 
	{
		if (naziv != null && !naziv.isEmpty())
			this.naziv = naziv;
		else throw new InvalidAttributeValueException(); 
	}
	
	public String getNazivKlijenta() 
	{
		return nazivKlijenta;
	}
	
	public void setNazivKlijenta(String nazivKlijenta) throws InvalidAttributeValueException 
	{
		if (nazivKlijenta != null && !nazivKlijenta.isEmpty())
			this.nazivKlijenta = nazivKlijenta;
		else throw new InvalidAttributeValueException(); 
	}
	
	public Boolean getArhiviran() 
	{
		return arhiviran;
	}
	
	public void setArhiviran(Boolean arhiviran) 
	{
		this.arhiviran = arhiviran;
	}
	
	public void DodajTask(Task t)
	{
		taskovi.add(t);
	}
	
	public void DodajZaposlenika (ProjekatRadnik zaposlenik)
	{
		zaposlenici.add(zaposlenik);
	}
	
}
