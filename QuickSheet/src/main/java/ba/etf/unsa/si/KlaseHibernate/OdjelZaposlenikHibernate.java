package ba.etf.unsa.si.KlaseHibernate;

public class OdjelZaposlenikHibernate implements java.io.Serializable{

	private long id;
	private OdjelHibernate odjel;
	private ZaposlenikHibernate zaposlenikOdjela;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public OdjelZaposlenikHibernate() {}
	
	public OdjelHibernate getOdjel() {
		return odjel;
	}

	public void setOdjel(OdjelHibernate odjel) {
		this.odjel = odjel;
	}

	public ZaposlenikHibernate getZaposlenikOdjela() {
		return zaposlenikOdjela;
	}

	public void setZaposlenikOdjela(ZaposlenikHibernate zaposlenikOdjela) {
		this.zaposlenikOdjela = zaposlenikOdjela;
	}
	
}
