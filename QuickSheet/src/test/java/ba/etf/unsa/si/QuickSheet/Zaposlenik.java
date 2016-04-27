package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Task;
import ba.etf.unsa.si.Klase.Timesheet;

public class Zaposlenik {

	
		@Test 
		public void TestProjekatRadnik_arhiviran() throws InvalidAttributeValueException
		{
			ProjekatRadnik radnik = new ProjekatRadnik("uname", "Ime", "Prezime", "Adresa", LocalDate.of(2014, Month.JANUARY, 1), 0.2);
			radnik.setArhiviran(true);
			Assert.assertNotEquals(radnik.getArhiviran(), false);
		}
		
		@Test(expected=InvalidAttributeValueException.class)
		public void TestProjekatRadnik_UserName_error() throws InvalidAttributeValueException
		{
			ProjekatRadnik radnik = new ProjekatRadnik ("uname123", "Ime", "Prezime", "Adresa", LocalDate.now(), 0.2);
			Assert.assertNotNull(getClass());
			
		}
		
		@Test(expected=InvalidAttributeValueException.class)
		public void TestProjekatRadnik_Ime_error() throws InvalidAttributeValueException
		{
			ProjekatRadnik radnik = new ProjekatRadnik("uname", "Ime123", "Prezime", "Adresa", LocalDate.now(), 0.2);
			Assert.assertNotNull(getClass());
		}
		
		@Test(expected=InvalidAttributeValueException.class)
		public void TestProjekatRadnik_Prezime_error() throws InvalidAttributeValueException
		{
			ProjekatRadnik radnik = new ProjekatRadnik("uname", "Ime", "Prezime123", "Adresa", LocalDate.now(), 0.2);
			Assert.assertNotNull(getClass());
		}
		
		@Test(expected=InvalidAttributeValueException.class)
		public void TestProjekatRadnik_Adresa_error() throws InvalidAttributeValueException
		{
			ProjekatRadnik radnik = new ProjekatRadnik("uname", "Ime", "Prezime", "", LocalDate.now(), 0.2);
			Assert.assertNotNull(getClass());
		}
		
		@Test(expected=InvalidAttributeValueException.class)
		public void TestProjekatRadnik_Datum_error() throws InvalidAttributeValueException
		{
			ProjekatRadnik radnik = new ProjekatRadnik("uname", "Ime", "Prezime", "Adresa", null, 0.2);
			Assert.assertNotNull(getClass());
		}
		
		@Test(expected=InvalidAttributeValueException.class)
		public void TestProjekatRadnik_Satnica_error() throws InvalidAttributeValueException
		{
			ProjekatRadnik radnik = new ProjekatRadnik("uname", "Ime", "Prezime", "Adresa", LocalDate.now(), -1.2);
			Assert.assertNotNull(getClass());
		}
		
		
		@Test
		public final void testRadnik1() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
		
			 String ime = "Unknown";
			 ProjekatRadnik radnik = new ProjekatRadnik();			 
			 radnik.setIme(ime);
			 Assert.assertEquals(ime, radnik.getIme(), radnik.getIme());
		
		}
		
		
		@Test
		public final void testRadnik2() throws  javax.naming.directory.InvalidAttributeValueException {
		
		 String prezime = "Prezime";
		 ProjekatRadnik radnik = new ProjekatRadnik();
		 radnik.setPrezime(prezime);
		 Assert.assertEquals(prezime, radnik.getPrezime(), radnik.getPrezime());

		}
		
		@Test
		public final void testRadnik3() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
		
		 String username = "pocetak";
		
		 ProjekatRadnik radnik = new ProjekatRadnik();
		 
		 radnik.setUsername(username);
		 Assert.assertEquals(username, radnik.getUsername(), radnik.getUsername());

		}
		
		@Test
		public final void testRadnik4() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
		
		 String adresa = "Adresa";
		 ProjekatRadnik radnik = new ProjekatRadnik();
		 
		 radnik.setAdresa(adresa);
		 Assert.assertEquals(adresa, radnik.getAdresa(), radnik.getAdresa());

		}
		
		@Test
		public final void testRadnik5() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
		LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		ProjekatRadnik radnik = new ProjekatRadnik();
		 
		 radnik.setDatumZaposlenja(today);
		 Assert.assertEquals(today, radnik.getDatumZaposlenja());

		}
		
		
		@Test
		public final void testRadnik6() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {

		 ProjekatRadnik radnik = new ProjekatRadnik();
		 double satnica = 25.03;
		 radnik.setSatnica(satnica);
		 Assert.assertEquals(satnica, radnik.getSatnica(),radnik.getSatnica());

		}
		

		@Test
		public final void testRadnik7() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {

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
		public final void testRadnik8() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
		double satnica = 25.03;
	   	LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);
		 ProjekatRadnik radnik = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);		 
		 ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
		 Assert.assertEquals(radnik.getIme(),radnik1.getIme());

		}
		
		@Test
		public final void testRadnik9() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException {
			double satnica = 25.03;
			LocalDate today = LocalDate.of(2014, Month.JANUARY, 1);

		 
		 ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today,satnica);
		 Assert.assertSame(radnik1, radnik1);

		}
		
		
		@Test
		public final void testRadnik10() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException, javax.management.InvalidAttributeValueException {
			
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
		public final void testRadnik11() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException, javax.management.InvalidAttributeValueException {
			
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
		public final void testRadnik12() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException, javax.management.InvalidAttributeValueException {
			int satnica = 10;
			LocalDate today = LocalDate.of(2016, Month.JANUARY, 1);	 
			LocalDate today1 = LocalDate.of(2013, Month.JANUARY, 1);	
			ProjekatRadnik radnik1 = new ProjekatRadnik("username","ime","prezime","adresa",today1,satnica);
		    Task t = new Task("naziv","opis",1,radnik1,today );
			
		    radnik1.UrediTask(t, "komentar", 10);

		
		    Assert.assertNotEquals(getClass(), null);
			 

		}
		
		
		
		

}
