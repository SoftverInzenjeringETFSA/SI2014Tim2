package ba.etf.unsa.si.KlaseHibernate;

import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

public class OdjelHibernate implements java.io.Serializable{

	private long id;
	private LinkedList<ZaposlenikHibernate> zaposlenici = new LinkedList<ZaposlenikHibernate>();
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

	public OdjelHibernate(String _naziv, int _maksimalanBrojRadnika, LinkedList<ZaposlenikHibernate> _zaposlenici) throws InvalidAttributeValueException 
	{
		setNaziv(_naziv);
		setMaksimalanBrojRadnika(_maksimalanBrojRadnika);
		setZaposlenici(_zaposlenici);
	}
	
	public LinkedList<ZaposlenikHibernate> getZaposlenici() {
		return zaposlenici;
	}
	
	public void setZaposlenici(LinkedList<ZaposlenikHibernate> _zaposlenici) {
		zaposlenici = _zaposlenici;
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
	
}
