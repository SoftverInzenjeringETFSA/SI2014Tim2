package ba.etf.unsa.si.Klase;

import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

public class Odjel {

	private LinkedList<ProjekatRadnik> zaposlenici = new LinkedList<ProjekatRadnik>();
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

	public Odjel(String _naziv, int _maksimalanBrojRadnika, LinkedList<ProjekatRadnik> _zaposlenici) throws InvalidAttributeValueException 
	{
		setNaziv(_naziv);
		setMaksimalanBrojRadnika(_maksimalanBrojRadnika);
		setZaposlenici(_zaposlenici);
	}
	
	public LinkedList<ProjekatRadnik> getZaposlenici() {
		return zaposlenici;
	}
	
	public void setZaposlenici(LinkedList<ProjekatRadnik> _zaposlenici) {
		zaposlenici = _zaposlenici;
	}
	
	public Integer getMaksimalanBrojRadnika() {
		return maksimalanBrojRadnika;
	}
	
	public void setMaksimalanBrojRadnika(Integer _maksimalanBrojRadnika) throws InvalidAttributeValueException {
		if (_maksimalanBrojRadnika != null && _maksimalanBrojRadnika > 0 && _maksimalanBrojRadnika > zaposlenici.size())
			maksimalanBrojRadnika = _maksimalanBrojRadnika;
		else 
			throw new InvalidAttributeValueException();
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String _naziv) {
		naziv = _naziv;
	}
	
	public int TrenutniBrojRadnika()
	{
		return zaposlenici.size();
	}
	
	public boolean DodajZaposlenika(ProjekatRadnik zaposlenik)
	{
		if (maksimalanBrojRadnika.equals(TrenutniBrojRadnika()) || zaposlenici.contains(zaposlenik))
			return false;
		else
		{
			zaposlenici.add(zaposlenik);
			return true;
		}
	}
	
	public boolean UkloniZaposlenika(Zaposlenik zaposlenik)
	{
		return zaposlenici.remove(zaposlenik);
	}
}
