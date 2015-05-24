package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class TestProjekatHibernate {

	@Test
	public void test() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		

		Assert.assertNotSame(p.getKoordinator(),DalDao.VratiZaposlenikeNaProjektu(1));
		
		
	}
	
	
	@Test
	public void test1() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertNull(p.getKoordinator());
		
		
	}
	
	@Test
	public void test2() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertNotNull(p.getNaziv());
		
		
	}
	
	@Test
	public void test3() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertNotNull(p.getNazivKlijenta());
		
		
	}
	
	@Test
	public void test4() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		p.setArhiviran(false);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertNotNull(p.getArhiviran());
		
		
	}
	
	@Test
	public void test5() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertNotNull(p.getClass());
		
		
	}
	
	@Test
	public void test6() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertNotNull(p.getId());
		
		
	}
	
	@Test
	public void test7() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertNotSame(p.getClass(), DalDao.VratiProjekat(1));
		
		
	}
	
	@Test
	public void test8() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		p.setArhiviran(true);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertEquals(true,p.getArhiviran());
		
		
	}

	
	@Test
	public void test9() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(null);
		p.setArhiviran(true);
		
		DalDao.DodajObjekat(p);
	//	ProjekatHibernate p1 = new ProjekatHibernate(1,"naziv","nazivKlijenta",radnik);

		Assert.assertNotNull(DalDao.VratiNearhiviraneZaposlenikePoPrezimenu("prezime"));
		
		
	}
}
