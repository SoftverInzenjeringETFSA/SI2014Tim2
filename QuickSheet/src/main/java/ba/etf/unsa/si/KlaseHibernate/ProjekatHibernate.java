package ba.etf.unsa.si.KlaseHibernate;

public class ProjekatHibernate implements java.io.Serializable{
	
	private long id;
	private ZaposlenikHibernate koordinator;
	private String naziv;
	private String nazivKlijenta;
	private Boolean arhiviran;
	
	public ProjekatHibernate() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
