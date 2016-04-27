package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import junit.framework.Assert;

import org.junit.Test;

import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class TestTaskHibernate {

	@Test
	public void test1() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
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
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getKomentar());
		
	}
	@Test
	public void test3() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getNaziv());
		
	}
	@Test
	public void test4() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getOpis());
		
	}
	
	@Test
	public void test() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getClass());
		
	}
	@Test
	public void test5() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getId());
		
	}
	
	@Test
	public void test() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getPrioritet());
		
	}
	
	@Test
	public void test6() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getProcenatZavrsenosti());
		
	}
	
	@Test
	public void test7() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getProjekat());
		
	}
	
	@Test
	public void test8() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getRok());
		
	}
	
	@Test
	public void test9() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertNotNull(t.getZaposlenik());
		
	}
	
	@Test
	public void test10() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertEquals(t.getZaposlenik(), radnik);
		
	}
	
	@Test
	public void test11() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertEquals(t.getProjekat(), p);
		
	}
	
	@Test
	public void test12() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertEquals(t.getZaposlenik(), radnik);
		
	}
	
	@Test
	public void test13() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertEquals(t.getNaziv(), "naziv");
		
	}
	
	@Test
	public void test10() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertEquals(t.getKomentar(), "komentar");
		
	}
	
	@Test
	public void test10() {
		ProjekatHibernate p = new ProjekatHibernate();
		p.setArhiviran(true);
		p.setId(1);
		p.setNaziv("naziv");
		p.setNazivKlijenta("nazivKlijenta");
		
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);
		ZaposlenikHibernate radnik = new ZaposlenikHibernate();
		radnik.setUsername("imeusera");
		radnik.setIme("ime");
		radnik.setPrezime("prezime");
		radnik.setAdresa("adresa");
		radnik.setDatumZaposlenja(today);
		radnik.setSatnica(satnica);
		
		p.setKoordinator(radnik);
		
		TaskHibernate t = new TaskHibernate();
		t.setId(1);
		t.setKomentar("komentar");
		
		t.setNaziv("naziv");
		t.setOpis("opis");
		t.setPrioritet(1);
		t.setProcenatZavrsenosti(10);
		t.setProjekat(p);
		t.setRok(today);
		t.setZaposlenik(radnik);
		
		Assert.assertEquals(t.getRok(), today);
		
	}


}
