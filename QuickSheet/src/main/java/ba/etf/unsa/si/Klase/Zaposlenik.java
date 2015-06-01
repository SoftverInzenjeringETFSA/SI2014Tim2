
package ba.etf.unsa.si.Klase;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.Random;

import javax.naming.directory.InvalidAttributeValueException;

public abstract class Zaposlenik {
	
	private String username;
	private String lozinka;
	private String ime;
	private String prezime;
	private String Email;
	private String Telefon;
	private String adresa;
	private LocalDate datumZaposlenja;
	private Double satnica;
	private Boolean arhiviran;
	
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
	
	public Zaposlenik(){
		
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String _username) throws InvalidAttributeValueException
	{
		if (_username != null && !_username.isEmpty() && _username.matches("^[a-zA-Z0-9]*$"))
			username = _username;
		else throw new InvalidAttributeValueException();
	}
	
	public String getLozinka()
	{
		return lozinka;
	}
	
	public void setLozinka(String lozinka) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAttributeValueException
	{
		if (lozinka != null && !lozinka.isEmpty() && lozinka.matches("^[a-zA-Z0-9]*$"))
			this.lozinka = Lozinka.generateStorngPasswordHash(lozinka);
		else throw new InvalidAttributeValueException(); 
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public void setIme(String _ime) throws InvalidAttributeValueException
	{
		if (_ime != null && !_ime.isEmpty() && _ime.matches("^[a-zA-Z]*$"))
			ime = _ime;
		else throw new InvalidAttributeValueException();
	}
	
	public String getPrezime()
	{
		return prezime;
	}
	
	public void setPrezime(String _prezime) throws InvalidAttributeValueException
	{
		if (_prezime != null && !_prezime.isEmpty() && _prezime.matches("^[a-zA-Z]*$"))
			prezime = _prezime;
		else throw new InvalidAttributeValueException();
	}
	
	public String getAdresa()
	{
		return adresa;
	}
	
	public void setAdresa(String _adresa) throws InvalidAttributeValueException
	{
		if (_adresa != null && _adresa.length() > 3 && !_adresa.trim().isEmpty())
			adresa = _adresa;
		else throw new InvalidAttributeValueException();
	}
	
	public LocalDate getDatumZaposlenja()
	{
		return datumZaposlenja;
	}
	
	public void setDatumZaposlenja(LocalDate _datum) throws InvalidAttributeValueException
	{
		if (_datum != null && (_datum.isBefore(LocalDate.now()) || _datum.isEqual(LocalDate.now())) )
			datumZaposlenja = _datum;
		else throw new InvalidAttributeValueException();
	}
	
	public double getSatnica()
	{
		return satnica;
	}
	
	public void setSatnica(Double _cijena) throws InvalidAttributeValueException
	{
		if (_cijena != null && _cijena > 0)
			satnica = _cijena;
		else throw new InvalidAttributeValueException();
	}
	
	public Boolean getArhiviran() 
	{
		return arhiviran;
	}

	public void setArhiviran(Boolean arhiviran) 
	{
		this.arhiviran = arhiviran;
	}
	
	public String getEmail() 
	{
		return Email;
	}

	public void setEmail(String email) throws InvalidAttributeValueException 
	{
		if (email != null && email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
			Email = email;
		else throw new InvalidAttributeValueException();
	}

	public String getTelefon() 
	{
		return Telefon;
	}

	public void setTelefon(String telefon) throws InvalidAttributeValueException 
	{
		if (telefon != null && telefon.matches("^\\d{9,15}$"))
			Telefon = telefon;
		else throw new InvalidAttributeValueException();
	}

}
