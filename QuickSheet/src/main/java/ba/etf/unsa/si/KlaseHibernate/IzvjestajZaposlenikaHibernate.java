package ba.etf.unsa.si.KlaseHibernate;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

import javax.naming.directory.InvalidAttributeValueException;

public class IzvjestajZaposlenika{

	private Zaposlenik zaposlenik;
	private Integer ukupanBrojTaskova;
	private Double decimalanProcenat;
	private Projekat projekat;
	private Double procenatZavrsenogRada;
	private Double trosak;
	private Double ukupnoVrijemeRada;
	
	public IzvjestajZaposlenika(Projekat _projekat, Zaposlenik _zaposlenik) throws InvalidAttributeValueException {
		super(_projekat);
		setZaposlenik(_zaposlenik);
	}

	public Integer getUkupanBrojTaskova() 
	{
		return ukupanBrojTaskova;
	}
	
	public void setUkupanBrojTaskova(Integer _ukupanBrojTaskova)
	{
		ukupanBrojTaskova=_ukupanBrojTaskova;
	}
	
	public Double getDecimalanProcenat() 
	{
		return decimalanProcenat;
	}
	
	public void setDecimalanProcenat(Double _decimalanProcenat)
	{
		decimalanProcenat=_decimalanProcenat;
	}
	
	public Zaposlenik getZaposlenik() 
	{
		return zaposlenik;
	}
	
	public void setZaposlenik(Zaposlenik zaposlenik)
	{
		this.zaposlenik = zaposlenik;		
	}
	
	public Projekat getProjekat() 
	{
		return projekat;
	}
	
	public void setProjekat(Projekat _projekat)
	{
		projekat=_projekat;
	}

	public Double getProcenatZavrsenogRada() 
	{
		return procenatZavrsenogRada;
	}
	
	public void setProcenatZavrsenogRada(Double _procenatZavrsenogRada)
	{
		procenatZavrsenogRada=_procenatZavrsenogRada;
	}
	
	public Double getTrosak() 
	{
		return trosak;
	}
	
	public void setTrosak(Double _trosak)
	{
		trosak=_trosak;
	}
	
	public Double getUkupnoVrijemeRada() 
	{
		return ukupnoVrijemeRada;
	}
	
	public void setUkupnoVrijemeRada(Double _ukupnoVrijemeRada)
	{
		ukupnoVrijemeRada=_ukupnoVrijemeRada;
	}	
}
