package ba.etf.unsa.si.Klase;

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
	
	public void setNaziv(String naziv) throws InvalidAttributeValueException 
	{
		if (naziv != null && !naziv.isEmpty())
			this.naziv = naziv;
		else throw new InvalidAttributeValueException();
	}
	
	public Integer getPrioritet() 
	{
		return prioritet;
	}
	
	public void setPrioritet(Integer prioritet) throws InvalidAttributeValueException 
	{
		if (prioritet > 0 && prioritet < 11)
			this.prioritet = prioritet;
		else throw new InvalidAttributeValueException();
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
	
	public void setOpis(String opis) throws InvalidAttributeValueException 
	{
		if (opis != null && !opis.isEmpty())
			this.opis = opis;
		else throw new InvalidAttributeValueException();
	}
	
	public Zaposlenik getZaposlenik() 
	{
		return zaposlenik;
	}
	
	public void setZaposlenik(Zaposlenik zaposlenik) throws InvalidAttributeValueException 
	{
		if (zaposlenik != null)
			this.zaposlenik = zaposlenik;
		else throw new InvalidAttributeValueException();
	}
	
	public Double getProcenatZavrsenosti() 
	{
		return procenatZavrsenosti;
	}
	
	public void setProcenatZavrsenosti(Double procenatZavrsenosti) 
	{
		if (procenatZavrsenosti > 0 && procenatZavrsenosti <= 1)
		this.procenatZavrsenosti = (double) Math.round(procenatZavrsenosti * 100) / 100;
	}
	
	public LocalDate getRok() 
	{
		return rok;
	}
	
	public void setRok(LocalDate rok) throws InvalidAttributeValueException 
	{
		if (rok != null && rok.isAfter(LocalDate.now()))
			this.rok = rok;
		else throw new InvalidAttributeValueException(); 
	}
	
}
