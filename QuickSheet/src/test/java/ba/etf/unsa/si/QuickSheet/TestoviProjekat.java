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

import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Task;
import ba.etf.unsa.si.Klase.Timesheet;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;

import javax.management.InvalidAttributeValueException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Task;
import ba.etf.unsa.si.Klase.Timesheet;
import ba.etf.unsa.si.Klase.Zaposlenik;

public class TestoviProjekat {

	public TestoviProjekat() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	
	@Test
	public final void testGetZaposlenici() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
	
		 String ime = "Unknown";

		 ProjekatRadnik radnik = new ProjekatRadnik();
		 
		 radnik.setIme(ime);
		 Assert.assertEquals(ime, radnik.getIme(), radnik.getIme());
	
	}
	
	
	@Test
	public final void testGetZaposlenici1() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
	
	 String prezime = "pocetak";
	
	 ProjekatRadnik radnik = new ProjekatRadnik();
	 
	 radnik.setPrezime(prezime);
	 Assert.assertEquals(prezime, radnik.getPrezime(), radnik.getPrezime());

	}
	
	@Test
	public final void testGetZaposlenici2() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
	
	 String username = "pocetak";
	
	 ProjekatRadnik radnik = new ProjekatRadnik();
	 
	 radnik.setUsername(username);
	 Assert.assertEquals(username, radnik.getUsername(), radnik.getUsername());

	}
	
	@Test
	public final void testGetZaposlenici3() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
	
	 String adresa = "pocetak";
	
	 ProjekatRadnik radnik = new ProjekatRadnik();
	 
	 radnik.setAdresa(adresa);
	 Assert.assertEquals(adresa, radnik.getAdresa(), radnik.getAdresa());

	}
	
	@Test
	public final void testGetZaposlenici4() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	
	
	 ProjekatRadnik radnik = new ProjekatRadnik();
	 
	 radnik.setDatumZaposlenja(today);
	 Assert.assertEquals(today, radnik.getDatumZaposlenja());

	}
	
	
	@Test
	public final void testGetZaposlenici5() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {

	 ProjekatRadnik radnik = new ProjekatRadnik();
	 double satnica = 25.03;
	 radnik.setSatnica(satnica);
	 Assert.assertEquals(satnica, radnik.getSatnica(),radnik.getSatnica());

	}
	

	@Test
	public final void testGetZaposlenici6() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {

	 ProjekatRadnik radnik = new ProjekatRadnik();

	 radnik.setArhiviran(true);
	 Assert.assertEquals(true, radnik.getArhiviran());

	}
	
	@Test
	public final void testGetZaposlenici7() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {

	 ProjekatRadnik radnik = new ProjekatRadnik();
	 
	 ProjekatRadnik radnik1 = new ProjekatRadnik();
	 Assert.assertNotEquals(radnik,radnik1);

	}
	
	@Test
	public final void testGetZaposlenici8() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
	 ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	 
	 ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	 Assert.assertEquals(radnik.getIme(),radnik1.getIme());

	}
	
	@Test
	public final void testGetZaposlenici9() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
		double satnica = 25.03;
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);

	 
	 ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
	 Assert.assertSame(radnik1, radnik1);

	}
	
	
	@Test
	public final void testGetZaposlenici10() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		
		 LinkedList<Task> _taskovi = new LinkedList<Task>();
	
			int satnica = 10;
			LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);	 
		 ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
		 Koordinator k = new Koordinator("username","ime","prezime","adresa",today,satnica);
		 Projekat p =  new Projekat ("ime", "klijent", k);
		 radnik1.PopuniTimesheet(_taskovi, satnica, p, today);
		 Assert.assertNotEquals( radnik1.PopuniTimesheet(_taskovi, satnica, p, today), null);
		 

	}
	
	
	@Test
	public final void testGetZaposlenici11() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		
		 LinkedList<Task> _taskovi = new LinkedList<Task>();
		
			int satnica = 10;
			LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);	 
		 ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
		 Koordinator k = new Koordinator("username","ime","prezime","adresa",today,satnica);
		 Projekat p =  new Projekat ("ime", "klijent", k);
	
		 Timesheet t1 = radnik1.PopuniTimesheet(_taskovi, satnica, p, today);
		 Timesheet t2 = radnik1.PopuniTimesheet(_taskovi, satnica, p, today);
		 Assert.assertNotEquals(t2, t1);
		 

	}
	
	
	
	
	@Test
	public final void testGetZaposlenici12() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		int satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
	    Task t = new Task("naziv","opis",1,radnik1,today );
		
	    radnik1.UrediTask(t, "komentar", 10);

	
	    Assert.assertNotEquals(getClass(), null);
		 

	}
	
	
	@Test
	public final void testGetZaposlenici13() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		int satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
	    Task t = new Task("naziv","opis",1,radnik1,today );
		
	    radnik1.UrediTask(t, "komentar", 10);

	    Assert.assertNotEquals(getClass(), null);
		 

	}
	
	@Test
	public final void testGetZaposlenici14() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
	int satnica = 10;
	LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
	LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
	ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
    Task t = new Task("naziv","opis",1,radnik1,today );
	t.getZaposlenik();
   

    Assert.assertEquals(t.getZaposlenik(), radnik1);

	}
	
	@Test
	public final void testGetZaposlenici15() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
	int satnica = 10;
	LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
	LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
	ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
    Task t = new Task("naziv","opis",1,radnik1,today );
    t.setZaposlenik(radnik1);
    
    ProjekatRadnik radnik2 = (ProjekatRadnik) t.getZaposlenik();

    Assert.assertEquals(radnik2, radnik2);

	}

	
	@Test
	public final void testGetZaposlenici16() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
	int satnica = 10; 
	LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
	ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
	 Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
	 Projekat p =  new Projekat ("ime", "klijent", k);
	 p.DodajZaposlenika(radnik1);
	 LinkedList<ProjekatRadnik> lista = new LinkedList<ProjekatRadnik>();
	 lista.add(radnik1);
	 Assert.assertEquals(lista, p.getZaposlenici());
     

	}
	
	@Test
	public final void testGetZaposlenici17() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
	int satnica = 10;
	LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
	LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
	ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
	Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
	Projekat p =  new Projekat ("ime", "klijent", k);
    Task t = new Task("naziv","opis",1,radnik1,today );
    p.DodajTask(t);
    LinkedList<Task> lista = new LinkedList<Task>();
    lista.add(t);
    
    Assert.assertEquals(lista,p.getTaskovi() );
    

	}
	
	@Test
	public final void testGetZaposlenici18() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		
		 LinkedList<Task> _taskovi = new LinkedList<Task>();
		
			int satnica = 10;
			LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);	 
		 ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
		 Koordinator k = new Koordinator("username","ime","prezime","adresa",today,satnica);
		 Projekat p =  new Projekat ("ime", "klijent", k);
	
		 Timesheet t1 = radnik1.PopuniTimesheet(_taskovi, satnica, p, today);
		 LinkedList<Timesheet> lista = new LinkedList<Timesheet>();
		 lista.add(t1);
		 p.setTimesheetList(lista);
		 
		   Assert.assertEquals(lista,p.getTimesheetList() );

	}
	
	
	@Test
	public final void testGetZaposlenici19() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		
		 LinkedList<Task> _taskovi = new LinkedList<Task>();
		
			int satnica = 10;
			LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);	 
		 ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
		 Koordinator k = new Koordinator("username","ime","prezime","adresa",today,satnica);
		 Projekat p =  new Projekat ("ime", "klijent", k);
		 p.setKoordinator(k);
	
		
		 
		   Assert.assertEquals(k,p.getKoordinator());

	}
}
