package ba.etf.unsa.si.KlaseHibernate;

import java.util.LinkedList;

import javax.naming.directory.InvalidAttributeValueException;

public class Projekat {
	
	private LinkedList<ProjekatRadnik> zaposlenici = new LinkedList<ProjekatRadnik>();
	private LinkedList<Timesheet> timesheetList = new LinkedList<Timesheet>();
	private LinkedList<Task> taskovi = new LinkedList<Task>();
	private Zaposlenik koordinator;
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
	
	public void setZaposlenici(LinkedList<ProjekatRadnik> zaposlenici)
	{
		this.zaposlenici = zaposlenici; 
	}
	
	public LinkedList<Task> getTaskovi() 
	{
		return taskovi;
	}
	
	public void setTaskovi(LinkedList<Task> taskovi)
	{
		this.taskovi = taskovi;
	}
	
	public Koordinator getKoordinator() 
	{
		return koordinator;
	}
	
	public void setKoordinator(Koordinator koordinator)
	{
		this.koordinator = koordinator;
	}
	
	public String getNaziv() 
	{
		return naziv;
	}
	
	public void setNaziv(String naziv) 
	{
		this.naziv = naziv;
	}
	
	public String getNazivKlijenta() 
	{
		return nazivKlijenta;
	}
	
	public void setNazivKlijenta(String nazivKlijenta) 
	{
		this.nazivKlijenta = nazivKlijenta;
	}
	
	public Boolean getArhiviran() 
	{
		return arhiviran;
	}
	
	public void setArhiviran(Boolean arhiviran) 
	{
		this.arhiviran = arhiviran;
	}
	
}
