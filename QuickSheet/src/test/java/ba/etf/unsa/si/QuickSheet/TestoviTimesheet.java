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

public class TestoviTimesheet {

	public TestoviTimesheet() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test1() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
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
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    
	    Assert.assertNotNull(time);
	    
	    
	}
	@Test
	public final void test2() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Timesheet t = new Timesheet();
	    Assert.assertNotEquals(null, t);
    
	    
	}
	
	@Test
	public final void test3() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
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
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    time.setTaskovi(lista);
	    
	    Assert.assertEquals(lista, time.getTaskovi());
    

	}
	
	
	//for empty
	@Test
	public final void test4() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		int satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
	    Task t = new Task("naziv","opis",1,radnik1,today );
	    p.DodajTask(t);
	    LinkedList<Task> lista = new LinkedList<Task>();
	  
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    time.setTaskovi(lista);
	    
	    Assert.assertEquals(lista, time.getTaskovi());
    

	}
	
	@Test
	public final void test5() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
	    Task t = new Task("naziv","opis",1,radnik1,today );
	    p.DodajTask(t);
	    LinkedList<Task> lista = new LinkedList<Task>();
	    lista.add(t);
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    time.setBrojRadnihSati(satnica);
	    
	   Assert.assertEquals(satnica, time.getBrojRadnihSati());
	 
    

	}
	
	@Test
	public final void test6() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
	    Task t = new Task("naziv","opis",1,radnik1,today );
	    p.DodajTask(t);
	    LinkedList<Task> lista = new LinkedList<Task>();
	    lista.add(t);
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    time.setDatumSlanja(today1);
	    
	   Assert.assertEquals(today1, time.getDatumSlanja());
	 
    

	}
	
	
	@Test
	public final void test7() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
	    Task t = new Task("naziv","opis",1,radnik1,today );
	    p.DodajTask(t);
	    LinkedList<Task> lista = new LinkedList<Task>();
	    lista.add(t);
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    time.setProjekat(p);
	    
	   Assert.assertEquals(p, time.getProjekat());
	 
    

	}
	
	@Test
	public final void test8() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
	    Task t = new Task("naziv","opis",1,radnik1,today );
	    p.DodajTask(t);
	    LinkedList<Task> lista = new LinkedList<Task>();
	    lista.add(t);
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    time.setValidiran(true);
	    
	   Assert.assertEquals(true, time.getValidiran());
	 
    

	}
	
	@Test
	public final void test9() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
	    Task t = new Task("naziv","opis",1,radnik1,today );
	    p.DodajTask(t);
	    LinkedList<Task> lista = new LinkedList<Task>();
	    lista.add(t);
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    time.setValidiran(false);
	    
	   Assert.assertNotEquals(true, time.getValidiran());
	 
    

	}
	
	
	@Test
	public final void test10() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException {
		Integer satnica = 10;
		LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
		LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
		ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		Koordinator k = new Koordinator("username","ime","prezime","adresa",today1,satnica);
		Projekat p =  new Projekat ("ime", "klijent", k);
	    Task t = new Task("naziv","opis",1,radnik1,today );
	    p.DodajTask(t);
	    LinkedList<Task> lista = new LinkedList<Task>();
	    lista.add(t);
	    Timesheet time = new Timesheet(lista, satnica , p,today);
	    time.setProjekat(p);
	    
	    
	    Projekat p1 =  new Projekat ("ime", "klijent", k);
	    Task t1 = new Task("naziv","opis",1,radnik1,today );
	    p1.DodajTask(t1);
	    LinkedList<Task> lista1 = new LinkedList<Task>();
	    lista.add(t1);
	    Timesheet time1 = new Timesheet(lista, satnica , p,today);
	    time1.setProjekat(p1);
	    
	   Assert.assertNotEquals(time1,time);
	 
    

	}

}
