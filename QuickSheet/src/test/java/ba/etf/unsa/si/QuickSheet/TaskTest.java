package ba.etf.unsa.si.QuickSheet;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;

import org.junit.Test;

import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Task;
import ba.etf.unsa.si.Klase.Zaposlenik;

import javax.management.InvalidAttributeValueException;


//import javax.naming.directory.InvalidAttributeValueException;
//dodao sam konstruktor bez parametara u klasu Task, jel može ovako
public class TaskTest {

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testTask() throws  javax.management.InvalidAttributeValueException  {
		Task a= new Task(null, null, null, null, null);
	}

	@Test
	public void testGetNaziv() {
		 // TODO Ovo se ne testira
	}

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
		
		
		
		/*Task t= new Task();
		t.setNaziv("");
		t.setNaziv(null);
		//hocu li ove posebno napraviti*/
	}

	@Test
	public void testGetPrioritet() {
	 // TODO ne testira se
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetPrioritet() throws javax.management.InvalidAttributeValueException {
		Task t = new Task();
		t.setPrioritet(12);
	}

	@Test
	public void testGetKomentar() {
		 // TODO Nece se implementirati
	}

	@Test
	public void testSetKomentar() {
		 // TODO Ova ne treba
	}

	@Test
	public void testGetOpis() {
		 // TODO Ne treba
	}

	@Test(expected=InvalidAttributeValueException.class)
	public void testSetOpis() throws  javax.management.InvalidAttributeValueException{
		Task t= new Task();
		t.setOpis(null);
		t.setOpis("");
	}

	@Test
	public void testGetZaposlenik() {
		 // TODO nepotrebno
	}

	@Test(expected=InvalidAttributeValueException.class)
	public void testSetZaposlenik() throws InvalidAttributeValueException{
		Task t= new Task();
		t.setZaposlenik(null);
	}

	@Test
	public void testGetProcenatZavrsenosti() {
		 // TODO getter
	}

	@Test
	public void testSetProcenatZavrsenosti() {
		//?? treba li implementirati?
	}
	@Test
	public void testGetRok() {
		 // TODO getter
	}

	@Test(expected=InvalidAttributeValueException.class)
	public void testSetRok() throws InvalidAttributeValueException{
		Task t= new Task();
		t.setRok(LocalDate.now());
	}

}


