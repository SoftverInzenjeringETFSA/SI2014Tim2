package ba.etf.unsa.si.KlaseHibernate;

import java.time.LocalDate;

public class TaskHibernate implements java.io.Serializable{

	private long id;
	private ZaposlenikHibernate zaposlenik;
	private Integer prioritet;
	private Integer procenatZavrsenosti;
	private String naziv;
	private String opis;
	private String komentar;
	private LocalDate rok;
	private ProjekatHibernate projekat;

	public TaskHibernate() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public ZaposlenikHibernate getZaposlenik() 
	{
		return zaposlenik;
	}
	
	public void setZaposlenik(ZaposlenikHibernate zaposlenik)
	{
		this.zaposlenik = zaposlenik;
	}
	
	public Integer getProcenatZavrsenosti() 
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
	
	public ProjekatHibernate getProjekat() {
		return projekat;
	}

	public void setProjekat(ProjekatHibernate projekat) {
		this.projekat = projekat;
	}
	
	@Override 
	public String toString() {
		return this.getId() + " " + this.getNaziv();
	}
}
