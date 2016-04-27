package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.directory.InvalidAttributeValueException;

import junit.framework.Assert;

import org.junit.Test;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class testZaposlenikHibernate {

	@Test
	public void test1() {

		
		LinkedList <ZaposlenikHibernate> lista = new LinkedList <ZaposlenikHibernate>();
		
		Assert.assertNotNull(DalDao.VratiSveZaposlenike());
	}
	
	@Test
	public void test2() {
		ArrayList<ZaposlenikHibernate> h = new ArrayList<ZaposlenikHibernate> ();
		LinkedList <ZaposlenikHibernate> lista = new LinkedList <ZaposlenikHibernate>();
		lista.addAll(h);
		
		DalDao.DodajObjekte(lista);
		
		Assert.assertNotSame(lista, DalDao.VratiSveZaposlenike());
	}
	
	
	@Test
	public void test3() {
		ArrayList<ZaposlenikHibernate> h = new ArrayList<ZaposlenikHibernate> ();
		LinkedList <ZaposlenikHibernate> lista = new LinkedList <ZaposlenikHibernate>();
		lista.addAll(h);
		
		DalDao.DodajObjekte(lista);

		
		Assert.assertNotSame(lista, DalDao.VratiSveZaposlenike());
	}
	
	@Test
	public void test4() throws InvalidAttributeValueException {
	double satnica = 25.03;
	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	ZaposlenikHibernate radnik = new ZaposlenikHibernate();
	radnik.setUsername("imeusera");
	radnik.setIme("ime");
	radnik.setPrezime("prezime");
	radnik.setAdresa("adresa");
	radnik.setDatumZaposlenja(today);
	radnik.setSatnica(satnica);
	 
   DalDao.DodajObjekat(radnik);
   Assert.assertNotSame(radnik,DalDao.VratiSveZaposlenike());
	
	}
	
	@Test
	public void test5() throws InvalidAttributeValueException {
	double satnica = 25.03;
	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	ZaposlenikHibernate radnik = new ZaposlenikHibernate();
	radnik.setUsername("imeusera");
	radnik.setIme("ime");
	radnik.setPrezime("prezime");
	radnik.setAdresa("adresa");
	radnik.setDatumZaposlenja(today);
	radnik.setSatnica(satnica);
	 
   DalDao.DodajObjekat(radnik);
   Assert.assertNotSame(radnik,DalDao.VratiZaposlenikePoImenu("ime1"));
	
	}
	
	@Test
	public void test6() throws InvalidAttributeValueException {
	double satnica = 25.03;
	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	ZaposlenikHibernate radnik = new ZaposlenikHibernate();
	radnik.setUsername("imeusera");
	radnik.setIme("ime");
	radnik.setPrezime("prezime");
	radnik.setAdresa("adresa");
	radnik.setDatumZaposlenja(today);
	radnik.setSatnica(satnica);
	 
   DalDao.DodajObjekat(radnik);
   Assert.assertNotSame(radnik,DalDao.VratiZaposlenikePoPrezimenu("ime1"));
	
	}
	
	@Test
	public void test7() throws InvalidAttributeValueException {
	double satnica = 25.03;
	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	ZaposlenikHibernate radnik = new ZaposlenikHibernate();
	radnik.setUsername("imeusera");
	radnik.setIme("ime");
	radnik.setPrezime("prezime");
	radnik.setAdresa("adresa");
	radnik.setDatumZaposlenja(today);
	radnik.setSatnica(satnica);
	 
   DalDao.DodajObjekat(radnik);
   Assert.assertNotSame(radnik,DalDao.VratiZaposlenikePoUsername("ime1"));
	
	}
	
	@Test
	public void test8() throws InvalidAttributeValueException {
	double satnica = 25.03;
	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	ZaposlenikHibernate radnik = new ZaposlenikHibernate();
	radnik.setUsername("imeusera");
	radnik.setIme("ime");
	radnik.setPrezime("prezime");
	radnik.setAdresa("adresa");
	radnik.setDatumZaposlenja(today);
	radnik.setSatnica(satnica);
	 
   DalDao.DodajObjekat(radnik);
   Assert.assertNotSame(radnik,DalDao.VratiZaposlenika(0));
	
	}
	
	@Test
	public void test9() throws InvalidAttributeValueException {
	double satnica = 25.03;
	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	ZaposlenikHibernate radnik = new ZaposlenikHibernate();
	radnik.setUsername("imeusera");
	radnik.setIme("ime");
	radnik.setPrezime("prezime");
	radnik.setAdresa("adresa");
	radnik.setDatumZaposlenja(today);
	radnik.setSatnica(satnica);
	 
   DalDao.DodajObjekat(radnik);
   
   Assert.assertNotSame(radnik,DalDao.VratiZaposlenika(1));
	
	}
	
	@Test
	public void test10() throws InvalidAttributeValueException {
	double satnica = 25.03;
	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	ZaposlenikHibernate radnik = new ZaposlenikHibernate();
	radnik.setUsername("imeusera");
	radnik.setIme("ime");
	radnik.setPrezime("prezime");
	radnik.setAdresa("adresa");
	radnik.setDatumZaposlenja(today);
	radnik.setSatnica(satnica);
	
	
	 
   DalDao.DodajObjekat(radnik);
   
   Assert.assertNotSame(radnik,DalDao.VratiZaposlenika(1));
	
	}
}
