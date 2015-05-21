package ba.etf.unsa.si.KlaseHibernate;

public class IzvjestajZaposlenikaHibernate{

	private ZaposlenikHibernate zaposlenik;
	private Integer ukupanBrojTaskova;
	private Double decimalanProcenat;
	private ProjekatHibernate projekat;
	private Double procenatZavrsenogRada;
	private Double trosak;
	private Double ukupnoVrijemeRada;
	
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
	
	public ZaposlenikHibernate getZaposlenik() 
	{
		return zaposlenik;
	}
	
	public void setZaposlenik(ZaposlenikHibernate zaposlenik)
	{
		this.zaposlenik = zaposlenik;		
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
