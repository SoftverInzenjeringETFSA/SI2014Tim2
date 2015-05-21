package ba.etf.unsa.si.KlaseHibernate;

import java.util.LinkedList;

public class ProjekatHibernate {
	
	private LinkedList<ZaposlenikHibernate> zaposlenici = new LinkedList<ZaposlenikHibernate>();
	private LinkedList<TimesheetHibernate> timesheetList = new LinkedList<TimesheetHibernate>();
	private LinkedList<TaskHibernate> taskovi = new LinkedList<TaskHibernate>();
	private ZaposlenikHibernate koordinator;
	private String naziv;
	private String nazivKlijenta;
	private Boolean arhiviran;
	
	public LinkedList<TimesheetHibernate> getTimesheetList() 
	{
		return timesheetList;
	}
	
	public void setTimesheetList(LinkedList<TimesheetHibernate> timesheetList) 
	{
		this.timesheetList = timesheetList;
	}
	
	public LinkedList<ZaposlenikHibernate> getZaposlenici() 
	{
		return zaposlenici;
	}
	
	public void setZaposlenici(LinkedList<ZaposlenikHibernate> zaposlenici)
	{
		this.zaposlenici = zaposlenici; 
	}
	
	public LinkedList<TaskHibernate> getTaskovi() 
	{
		return taskovi;
	}
	
	public void setTaskovi(LinkedList<TaskHibernate> taskovi)
	{
		this.taskovi = taskovi;
	}
	
	public ZaposlenikHibernate getKoordinator() 
	{
		return koordinator;
	}
	
	public void setKoordinator(ZaposlenikHibernate koordinator)
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
