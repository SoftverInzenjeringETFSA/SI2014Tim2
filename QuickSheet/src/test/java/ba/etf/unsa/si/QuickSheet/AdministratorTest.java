package ba.etf.unsa.si.QuickSheet;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

import ba.etf.unsa.si.Klase.Administrator;
import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Odjel;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class AdministratorTest {

	@Test(expected=InvalidAttributeValueException.class)
	public void testSetUsername() throws InvalidAttributeValueException {
		String username="##$$2132enis123sjdhf564#$%+-";
		String lozinka="##$$2132enis123sjdhf564#$%";
		
		
			Administrator b= new Administrator(username,lozinka);
	}

	@Test
	public void testGetLozinka() {
		 // TODO ovo ne treba
	}

	
	@Test(expected=InvalidAttributeValueException.class)
	public void testSetLozinka() throws InvalidAttributeValueException {
		String username="Enis";
		String lozinka="enis";
		Administrator a= new Administrator(username,lozinka);
		a.setLozinka(null);
	}

	
	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testKreirajOdjel() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		String nazivOdjela="Testeri";
		int maxBrojRadnika=-1;
		Odjel o = new Odjel(nazivOdjela,maxBrojRadnika);
		
		String username="Enis";
		String lozinka="enis";
		Administrator a= new Administrator(username,lozinka);
		a.kreirajOdjel(null, -11);
		//koji je stvarni maksimalni broj radnika?
	}
	
	@Test(expected=InvalidAttributeValueException.class)
	public void testKreirajProjekat() throws InvalidAttributeValueException {
		String naziv="Timesheet$#1";
		String klijent="Dean";
		
		LocalDate datum=LocalDate.now();
		Koordinator k= new Koordinator(null,"Teo","Eterovic","Zmaja",datum,1000);
		Projekat p= new Projekat(naziv,klijent,k);  
		
		String username="Enis";
		String lozinka="enis";
		Administrator a= new Administrator(username,lozinka);
		
		a.kreirajProjekat("string", "string", k);
	
		
	}

	@Test
	public void TestirajTest()
	{
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("Dzenana");
		zh.setPrezime("Dzenana");
		zh.setAdresa("Dzenana");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username1111");
		DalDao.DodajObjekat(zh);
		System.out.println("  ");
	/*	
		ProjekatHibernate p= new ProjekatHibernate();  
		p.setKoordinator(k);
		p.setNaziv(naziv);
		p.setNazivKlijenta(klijent);
		p.setArhiviran(false);
		
		DalDao.DodajObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(2);
		System.out.println(p1.getNaziv());
		assertEquals("projekat", p1.getNaziv()); */
	}
	
}
