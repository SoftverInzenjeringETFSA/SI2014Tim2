//package test;

package ba.etf.unsa.si.Klase;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

import ba.etf.unsa.si.Klase.Odjel;
import ba.etf.unsa.si.Klase.Zaposlenik;

public class OdjelTest {

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testOdjelStringInt() throws javax.management.InvalidAttributeValueException{
		Odjel o= new Odjel("Naziv",10);
		o.setNaziv(null);
		o.setMaksimalanBrojRadnika(null);
	}

	@Test
	public void testGetArhiviran() {
		 // TODO gettera
	}

	@Test
	public void testSetArhiviran() {
		 // TODO obicni setter
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testOdjelStringIntLinkedListOfZaposlenik() throws javax.management.InvalidAttributeValueException{
		Odjel o= new Odjel("Naziv",10);
		o.setNaziv(null);
		o.setMaksimalanBrojRadnika(null);
		o.setZaposlenici(null);
	}

	@Test
	public void testGetZaposlenici() {
		 // TODO ne treba
	}

	@Test
	public void testSetZaposlenici() {
		 // TODO ne treba
	}

	@Test
	public void testGetMaksimalanBrojRadnika() {
			// TODO ne treba
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetMaksimalanBrojRadnika() throws javax.management.InvalidAttributeValueException{
		Odjel o= new Odjel("Naziv",10);
		o.setMaksimalanBrojRadnika(null);
		
	}

	@Test
	public void testGetNaziv() {
		 // TODO getter
	}

	@Test
	public void testSetNaziv() {
		 // TODO ne treba getter
	}

	@Test
	public void testTrenutniBrojRadnika() {
	// TODO getter
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testDodajZaposlenika() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException {
		Odjel o= new Odjel("Naziv",10);
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		o.DodajZaposlenika(z);
		 
	}

	@Test
	public void testUkloniZaposlenika() {
		fail("Not yet implemented"); // TODO
	}

}


