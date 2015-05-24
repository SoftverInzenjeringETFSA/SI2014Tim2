package ba.etf.unsa.si.QuickSheet;


import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;

import org.junit.Test;

import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Task;
import ba.etf.unsa.si.Klase.Zaposlenik;

import javax.management.InvalidAttributeValueException;



public class TaskTest {

	

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetNaziv() throws javax.management.InvalidAttributeValueException, javax.naming.directory.InvalidAttributeValueException, NoSuchAlgorithmException, InvalidKeySpecException {
		String nazivtaska="sta";
		String opis="nesto";
		LocalDate datum=LocalDate.now();
		double cijena=20000;
		Integer prioritet=1;
		Zaposlenik zaposlenik= new ProjekatRadnik("username","ime","prezime","adresa",datum,cijena);
		zaposlenik.setUsername("Meho");
		zaposlenik.setLozinka("dsdsds");
	
		Task t= new Task(nazivtaska,opis,prioritet,zaposlenik,datum);
		t.setNaziv(nazivtaska);
		assertEquals("sta", t.getNaziv());
		
	}
	



	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetPrioritet() throws javax.management.InvalidAttributeValueException {
		Task t = new Task();
		t.setPrioritet(12);
	}


	@Test
	public void testSetOpis() throws  javax.management.InvalidAttributeValueException{
		Task t= new Task();
		t.setOpis("Dzenana");
		assertEquals("Dzenana", t.getOpis());
		
	}

	@Test(expected=InvalidAttributeValueException.class)
	public void testSetZaposlenik() throws InvalidAttributeValueException{
		Task t= new Task();
		t.setZaposlenik(null);
		assertNull(t.getZaposlenik());
	}


	@Test(expected=InvalidAttributeValueException.class)
	public void testSetRok() throws InvalidAttributeValueException{
		Task t= new Task();
		t.setRok(LocalDate.now());
		assertEquals(LocalDate.now(), t.getRok());
	}
	

}


