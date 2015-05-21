package ba.etf.unsa.si.KlaseHibernate;

import java.time.LocalDate;
import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

public class Timesheet {

	private LinkedList<Task> taskovi = new LinkedList<Task>();
	private LocalDate datumSlanja;
	private Integer brojRadnihSati;
	private Projekat projekat;
	private Boolean validiran;
	
	public Timesheet(LinkedList<Task> _taskovi, Integer _brojRadnihSati, Projekat _projekat, LocalDate _datumSlanja) throws InvalidAttributeValueException 
	{
		setBrojRadnihSati(_brojRadnihSati);
		setDatumSlanja(_datumSlanja);
		setTaskovi(_taskovi);
		validiran = false;
	}
	
	public LinkedList<Task> getTaskovi() 
	{
		return taskovi;
	}
	
	public void setTaskovi(LinkedList<Task> taskovi) 
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
	
	public Projekat getProjekat() 
	{
		return projekat;
	}
	
	public void setProjekat(Projekat projekat)
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
