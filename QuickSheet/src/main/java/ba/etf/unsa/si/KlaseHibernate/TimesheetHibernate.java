package ba.etf.unsa.si.Klase;

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
	
	public void setTaskovi(LinkedList<Task> taskovi) throws InvalidAttributeValueException 
	{
		if (taskovi != null)
			this.taskovi = taskovi;
		else throw new InvalidAttributeValueException();
	}
	
	public Integer getBrojRadnihSati() 
	{
		return brojRadnihSati;
	}
	
	public void setBrojRadnihSati(Integer brojRadnihSati) throws InvalidAttributeValueException 
	{
		if (brojRadnihSati > 0 && brojRadnihSati <= 12)
			this.brojRadnihSati = brojRadnihSati;
		else throw new InvalidAttributeValueException();
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
	
	public void setProjekat(Projekat projekat) throws InvalidAttributeValueException 
	{
		if (projekat != null)
			this.projekat = projekat;
		else throw new InvalidAttributeValueException();
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
