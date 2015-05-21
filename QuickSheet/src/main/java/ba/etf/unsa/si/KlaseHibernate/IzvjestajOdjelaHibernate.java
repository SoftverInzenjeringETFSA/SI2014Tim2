package ba.etf.unsa.si.KlaseHibernate;

public class IzvjestajOdjelaHibernate{

	private OdjelHibernate odjel;
	private Integer ukupanBrojTaskovaOdjela;
	private ProjekatHibernate projekat;
	private Double procenatZavrsenogRada;
	private Double trosak;
	private Double ukupnoVrijemeRada;

	public Integer getUkupanBrojTaskovaOdjela() 
	{
		return ukupanBrojTaskovaOdjela;
	}
	
	public void setUkupanBrojTaskovaOdjela(Integer _ukupanBrojTaskovaOdjela)
	{
		ukupanBrojTaskovaOdjela=_ukupanBrojTaskovaOdjela;
	}
	public OdjelHibernate getOdjel() 
	{
		return odjel;
	}
	
	public void setOdjel(OdjelHibernate odjel)
	{
		this.odjel = odjel;	
	}
	
	public ProjekatHibernate getProjekat() 
	{
		return projekat;
	}
	
	public void setProjekat(ProjekatHibernate _projekat)
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
