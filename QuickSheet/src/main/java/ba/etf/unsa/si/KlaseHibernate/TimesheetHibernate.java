package ba.etf.unsa.si.KlaseHibernate;

import java.time.LocalDate;
import java.util.LinkedList;

public class TimesheetHibernate implements java.io.Serializable{

	private long id;
	private LinkedList<TaskHibernate> taskovi = new LinkedList<TaskHibernate>();
	private LocalDate datumSlanja;
	private Integer brojRadnihSati;
	private ProjekatHibernate projekat;
	private Boolean validiran;
	
	public TimesheetHibernate() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public LinkedList<TaskHibernate> getTaskovi() 
	{
		return taskovi;
	}
	
	public void setTaskovi(LinkedList<TaskHibernate> taskovi) 
	{
		this.taskovi = taskovi;
	}
	
	public Integer getBrojRadnihSati() 
	{
		return brojRadnihSati;
	}
	
	public void setBrojRadnihSati(Integer brojRadnihSati)
	{
		this.brojRadnihSati = brojRadnihSati;
	}
	
	public LocalDate getDatumSlanja() 
	{
		return datumSlanja;
	}
	
	public void setDatumSlanja(LocalDate datumSlanja) 
	{
		this.datumSlanja = datumSlanja;
	}
	
	public ProjekatHibernate getProjekat() 
	{
		return projekat;
	}
	
	public void setProjekat(ProjekatHibernate projekat)
	{
		this.projekat = projekat;
	}
	
	public Boolean getValidiran() 
	{
		return validiran;
	}
	
	public void setValidiran(Boolean validiran)
	{
		this.validiran = validiran;
	}
}
