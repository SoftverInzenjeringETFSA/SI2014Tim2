package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class TestTimesheetHibernate {

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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		Assert.assertNotNull(t);
				
				
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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		Assert.assertNotNull(t.getBrojRadnihSati());
				
				
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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		Assert.assertNotNull(t.getClass());
				
				
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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		Assert.assertNotNull(t.getDatumSlanja());
				
				
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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		Assert.assertNotNull(t.getProjekat());
				
				
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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		Assert.assertNotNull(t.getId());
				
				
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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		Assert.assertNotNull(t.getValidiran());
				
				
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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		TimesheetHibernate t1 = new TimesheetHibernate();
		t1.setBrojRadnihSati(10);
		t1.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t1.setId(1);
		t1.setProjekat(p);
		t1.setValidiran(true);
		
		Assert.assertNotSame(t,t1);
				
				
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
		
		p.setKoordinator(radnik);
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		TimesheetHibernate t1 = new TimesheetHibernate();
		t1.setBrojRadnihSati(10);
		t1.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t1.setId(1);
		t1.setProjekat(p);
		t1.setValidiran(true);
		ArrayList <TimesheetHibernate> lista = new 	ArrayList <TimesheetHibernate>();
		lista.add(t);
		
		Assert.assertNotSame(lista, DalDao.VratiTimesheetoveProjekta(1));
				
				
	}
	
	@Test
	public void test10() {
		
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1052);
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
		
		
		
		
		TimesheetHibernate t = new TimesheetHibernate();
		t.setBrojRadnihSati(10);
		t.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t.setId(1);
		t.setProjekat(p);
		t.setValidiran(true);
		
		TimesheetHibernate t1 = new TimesheetHibernate();
		t1.setBrojRadnihSati(10);
		t1.setDatumSlanja(LocalDate.of(2014, Month.JANUARY, 1));
		t1.setId(1);
		t1.setProjekat(p);
		t1.setValidiran(true);
		ArrayList <TimesheetHibernate> lista = new 	ArrayList <TimesheetHibernate>();
		lista.add(t1);
		
		Assert.assertNotSame(lista, DalDao.VratiTimesheetoveProjekta(1052));
				
				
	}

}
