package ba.etf.unsa.si.KlaseHibernate;

import javax.naming.directory.InvalidAttributeValueException;

public class IzvjestajOdjela{

	private Odjel odjel;
	private Integer ukupanBrojTaskovaOdjela;
	private Projekat projekat;
	private Double procenatZavrsenogRada;
	private Double trosak;
	private Double ukupnoVrijemeRada;
	
	public IzvjestajOdjela(Projekat _projekat, Odjel _odjel) throws InvalidAttributeValueException {
		super(_projekat);
		setOdjel(_odjel);
	}

	public Integer getUkupanBrojTaskovaOdjela() 
	{
		return ukupanBrojTaskovaOdjela;
	}
	
	public void setUkupanBrojTaskovaOdjela(Integer _ukupanBrojTaskovaOdjela)
	{
		ukupanBrojTaskovaOdjela=_ukupanBrojTaskovaOdjela;
	}
	public Odjel getOdjel() 
	{
		return odjel;
	}
	
	public void setOdjel(Odjel odjel)
	{
		this.odjel = odjel;	
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
