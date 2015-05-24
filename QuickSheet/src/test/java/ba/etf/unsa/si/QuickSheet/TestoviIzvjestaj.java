package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.etf.unsa.si.Klase.Izvjestaj;
import ba.etf.unsa.si.Klase.IzvjestajOdjela;
import ba.etf.unsa.si.Klase.IzvjestajZaposlenika;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Odjel;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Task;
import ba.etf.unsa.si.Klase.Timesheet;
import ba.etf.unsa.si.Klase.Zaposlenik;

public class TestoviIzvjestaj {

	public TestoviIzvjestaj() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test1() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		Assert.assertNotNull(null, getClass());
	    
	}
	
	@Test
	public final void test2() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    
		Assert.assertEquals("nekoIme", odjel.getNaziv());
	    
	}
	
	@Test
	public final void test3() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		Double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
		Assert.assertEquals(broj, odjel.getMaksimalanBrojRadnika());
	    
	}
	
	@Test
	public final void test4() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		Double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o1 = new IzvjestajOdjela();
		
	    
		Assert.assertNotEquals(o,o1);
	    
	}
	
	
	@Test
	public final void test5() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		Double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o1 = new IzvjestajOdjela();
	    o1 = o;
		
	    
		Assert.assertEquals(o,o1);
	    
	}
	
	
	@Test
	public final void test6() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		Double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o1 = new IzvjestajOdjela();
	    o1 = o;
	    
	    odjel.setArhiviran(true);
		
	    
		Assert.assertEquals(true, odjel.getArhiviran());
	    
	}
	
	@Test
	public final void test7() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		Double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o1 = new IzvjestajOdjela();
	    o1 = o;
	    
	    LinkedList<Zaposlenik> lista = new LinkedList<Zaposlenik>();
	    lista.add(radnik);
	    
	    odjel.setZaposlenici(lista);
		
	    
		Assert.assertEquals(lista, odjel.getZaposlenici());
	    
	}

	
	@Test
	public final void test8() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		Double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o1 = new IzvjestajOdjela();
	    o1 = o;
	    
	    LinkedList<Zaposlenik> lista = new LinkedList<Zaposlenik>();
	    
	    LinkedList<Zaposlenik> lista1 = new LinkedList<Zaposlenik>();
	    lista.add(radnik);
	    lista1.add(radnik);
	    

		
	    
		Assert.assertEquals(lista, lista1);
	    
	}



	@Test
	public final void test9() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		Double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o1 = new IzvjestajOdjela();
	    o1 = o;
	    
	    LinkedList<Zaposlenik> lista = new LinkedList<Zaposlenik>();
	    lista.add(radnik);
	    
	    odjel.setZaposlenici(lista);
	    odjel.DodajZaposlenika(radnik);
	    odjel.UkloniZaposlenika(radnik);
		
	    
		Assert.assertNotEquals(null, odjel.getZaposlenici());
	    
	}

	@Test
	public final void test10() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		IzvjestajOdjela o = new IzvjestajOdjela();
		
		Double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    
		Assert.assertEquals(null, o.getTrosak());
	    
	}

	
	@Test
	public final void test11() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o = new IzvjestajOdjela(p,odjel);
	   
	    
		Assert.assertNotEquals(null, o.getProcenatZavrsenogRada());
	    
	}
	
	@Test
	public final void test12() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o = new IzvjestajOdjela(p,odjel);
	  
	    
		Assert.assertNotEquals(null,  o.getTrosak());
	    
	}
	
	@Test
	public final void test13() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o = new IzvjestajOdjela(p,odjel);
	
	    
		Assert.assertNotEquals(null,   o.getUkupanBrojTaskovaOdjela());
	    
	}
	
	@Test
	public final void test14() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o = new IzvjestajOdjela(p,odjel);
	
	    
		Assert.assertNotEquals(null,   o.getUkupanBrojTaskovaOdjela());
	    
	}

	
	@Test
	public final void test15() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajOdjela o = new IzvjestajOdjela(p,odjel);
	
	    
		Assert.assertNotEquals(null, o.getOdjel());
	    
	}
	
	
	
	@Test
	public final void test16() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajZaposlenika o = new IzvjestajZaposlenika(p,radnik1);
	
	    
		Assert.assertNotNull(o);
	    
	}
	
	@Test
	public final void test17() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajZaposlenika o = new IzvjestajZaposlenika(p,radnik1);
	  
		Assert.assertNotNull( o.getDecimalniProcenat());
	    
	}
	

	@Test
	public final void test18() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajZaposlenika o = new IzvjestajZaposlenika(p,radnik1);
	   o.setZaposlenik(radnik);
	    
		Assert.assertNotEquals(o.getZaposlenik(), radnik1);
	    
	}
	

	@Test
	public final void test19() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
		
		Double satnica1 = 25.03;
	    ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica1);
	    
	    Odjel odjel = new Odjel();
	    odjel.setNaziv("nekoIme");
	    Integer broj = 150;
	    odjel.setMaksimalanBrojRadnika(broj);
	    
	    IzvjestajZaposlenika o = new IzvjestajZaposlenika(p,radnik1);
	   o.setZaposlenik(radnik);
	    
		Assert.assertEquals(o.getZaposlenik(), radnik);
	    
	}
	
}
