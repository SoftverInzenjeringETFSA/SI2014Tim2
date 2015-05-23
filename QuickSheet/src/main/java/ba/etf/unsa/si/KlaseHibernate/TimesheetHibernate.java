package ba.etf.unsa.si.KlaseHibernate;

import java.time.LocalDate;

public class TimesheetHibernate implements java.io.Serializable{

	private long id;
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
