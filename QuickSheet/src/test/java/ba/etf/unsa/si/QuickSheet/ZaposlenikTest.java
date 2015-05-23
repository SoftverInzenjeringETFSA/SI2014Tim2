package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Zaposlenik;

public class ZaposlenikTest {

	@Test(expected=NullPointerException.class)
	public void testZaposlenik() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime#%","prezime","adresa",datum,10000);
		
	}

	@Test
	public void testGetUsername() {
	 // TODO getter
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetUsername() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setUsername(null);
		
	}

	@Test
	public void testGetLozinka() {
		 // TODO getter
	}

	@Test
	public void testSetLozinka() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetIme() {
		 // TODO getter
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetIme() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setIme(" ");
	}

	@Test
	public void testGetPrezime() {
	 // TODO getter
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetPrezime() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setPrezime(" ");
	}

	@Test
	public void testGetAdresa() {
		 // TODO getter
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetAdresa() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setAdresa(" ");
	}

	@Test
	public void testGetDatumZaposlenja() {
		 // TODO getter
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetDatumZaposlenja() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setDatumZaposlenja(null);
	}

	@Test
	public void testGetSatnica() {
		 // TODO getters
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetSatnica() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setSatnica(null);
	}

	@Test
	public void testGetArhiviran() {
		//getter
	}

	@Test
	public void testSetArhiviran() {
		Boolean arhiviran=true;
		assertTrue(arhiviran);
	}

}


