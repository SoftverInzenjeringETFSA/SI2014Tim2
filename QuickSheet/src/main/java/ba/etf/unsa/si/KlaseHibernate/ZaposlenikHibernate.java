
package ba.etf.unsa.si.KlaseHibernate;

import java.time.LocalDate;
import java.util.Random;

import javax.naming.directory.InvalidAttributeValueException;

public class Zaposlenik {
	
	private String username;
	private String lozinka;
	private String ime;
	private String prezime;
	private String adresa;
	private LocalDate datumZaposlenja;
	private Double satnica;
	private Boolean arhiviran;
	private Boolean koordinator;
	
	public Zaposlenik (String _username, String _ime, String _prezime, String _adresa, LocalDate _datum, double _cijena) throws InvalidAttributeValueException
	{
		setUsername(_username);
		setIme(_ime);
		setPrezime(_prezime);
		setAdresa(_adresa);
		setDatumZaposlenja(_datum);
		setSatnica(_cijena);
		arhiviran = false;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String _username)
	{
		username = _username;
	}
	
	public String getLozinka()
	{
		return lozinka;
	}
	
	public void setLozinka(String lozinka)
	{
		this.lozinka = lozinka;
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public void setIme(String _ime)
	{
		ime = _ime;
	}
	
	public String getPrezime()
	{
		return prezime;
	}
	
	public void setPrezime(String _prezime)
	{
		prezime = _prezime;
	}
	
	public String getAdresa()
	{
		return adresa;
	}
	
	public void setAdresa(String _adresa)
	{
		adresa = _adresa;
	}
	
	public LocalDate getDatumZaposlenja()
	{
		return datumZaposlenja;
	}
	
	public void setDatumZaposlenja(LocalDate _datum)
	{
		datumZaposlenja = _datum;
	}
	
	public double getSatnica()
	{
		return satnica;
	}
	
	public void setSatnica(Double _cijena)
	{
		satnica = _cijena;
	}
	
	public Boolean getArhiviran() {
		return arhiviran;
	}

	public void setArhiviran(Boolean arhiviran) {
		this.arhiviran = arhiviran;
	}
	
	public Boolean getKoordinator() {
		return koordinator;
	}

	public void setKoordinator(Boolean koordinator) {
		this.koordinator = koordinator;
	}
}
