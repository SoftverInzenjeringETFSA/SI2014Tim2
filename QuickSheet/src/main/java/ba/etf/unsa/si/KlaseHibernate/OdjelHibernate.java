package ba.etf.unsa.si.KlaseHibernate;

public class OdjelHibernate implements java.io.Serializable{

	private long id;
	private String naziv;
	private Integer maksimalanBrojRadnika;
	private Boolean arhiviran;
	
	public OdjelHibernate() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Boolean getArhiviran() {
		return arhiviran;
	}

	public void setArhiviran(Boolean arhiviran) {
		this.arhiviran = arhiviran;
	}
	
	public Integer getMaksimalanBrojRadnika() {
		return maksimalanBrojRadnika;
	}
	
	public void setMaksimalanBrojRadnika(Integer _maksimalanBrojRadnika)
	{
		maksimalanBrojRadnika = _maksimalanBrojRadnika;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String _naziv) {
		naziv = _naziv;
	}
	
	@Override
	public String toString() {
		return this.getId() + " " + this.getNaziv();
	}
	
}
