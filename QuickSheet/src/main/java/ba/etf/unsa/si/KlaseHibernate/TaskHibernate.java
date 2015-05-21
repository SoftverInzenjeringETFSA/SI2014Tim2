package ba.etf.unsa.si.KlaseHibernate;

import java.time.LocalDate;

import javax.management.InvalidAttributeValueException;

public class Task {

	private Zaposlenik zaposlenik;
	private Integer prioritet;
	private Double procenatZavrsenosti;
	private String naziv;
	private String opis;
	private String komentar;
	private LocalDate rok;
	
	public Task(String _naziv, String _opis, Integer _prioritet, Zaposlenik _zaposlenik, LocalDate _rok) throws InvalidAttributeValueException 
	{
		setNaziv(_naziv);
		setOpis(_opis);
		setPrioritet(_prioritet);
		setZaposlenik(_zaposlenik);
		setRok(_rok);
		procenatZavrsenosti = 0.0;
	}
	
	public String getNaziv() 
	{
		return naziv;
	}
	
	public void setNaziv(String naziv)
	{
		this.naziv = naziv;
	}
	
	public Integer getPrioritet() 
	{
		return prioritet;
	}
	
	public void setPrioritet(Integer prioritet)
	{
			this.prioritet = prioritet;
	}
	
	public String getKomentar() 
	{
		return komentar;
	}
	
	public void setKomentar(String komentar) 
	{
		this.komentar = komentar;
	}
	
	public String getOpis() 
	{
		return opis;
	}
	
	public void setOpis(String opis)
	{
		this.opis = opis;
	}
	
	public Zaposlenik getZaposlenik() 
	{
		return zaposlenik;
	}
	
	public void setZaposlenik(Zaposlenik zaposlenik)
	{
		this.zaposlenik = zaposlenik;
	}
	
	public Double getProcenatZavrsenosti() 
	{
		return procenatZavrsenosti;
	}
	
	public void setProcenatZavrsenosti(Integer procenatZavrsenosti) 
	{
		this.procenatZavrsenosti = procenatZavrsenosti;
	}
	
	public LocalDate getRok() 
	{
		return rok;
	}
	
	public void setRok(LocalDate rok)
	{
		this.rok = rok;
	}
	
}
