package ba.etf.unsa.si.KlaseHibernate;

import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

public class Odjel {

	private LinkedList<Zaposlenik> zaposlenici = new LinkedList<Zaposlenik>();
	private String naziv;
	private Integer maksimalanBrojRadnika;
	private Boolean arhiviran;
	
	public Odjel(String _naziv, int _maksimalanBrojRadnika) throws InvalidAttributeValueException 
	{
		setNaziv(_naziv);
		setMaksimalanBrojRadnika(_maksimalanBrojRadnika);
	}
	
	public Boolean getArhiviran() {
		return arhiviran;
	}

	public void setArhiviran(Boolean arhiviran) {
		this.arhiviran = arhiviran;
	}

	public Odjel(String _naziv, int _maksimalanBrojRadnika, LinkedList<Zaposlenik> _zaposlenici) throws InvalidAttributeValueException 
	{
		setNaziv(_naziv);
		setMaksimalanBrojRadnika(_maksimalanBrojRadnika);
		setZaposlenici(_zaposlenici);
	}
	
	public LinkedList<Zaposlenik> getZaposlenici() {
		return zaposlenici;
	}
	
	public void setZaposlenici(LinkedList<Zaposlenik> _zaposlenici) {
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
