package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.time.Period;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Zaposlenik;

public class ZaposlenikTest {

	@Test(expected=InvalidAttributeValueException.class)
	public void testZaposlenik() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime#%","prezime","adresa",datum,10000);		
	}

	@Test
	public void testGetUsername() throws InvalidAttributeValueException {
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		String u = z.getUsername();
		assertEquals("username", u);		
	}

	@Test(expected=javax.naming.directory.InvalidAttributeValueException.class)
	public void testSetUsername() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setUsername(null);
		
	}

	

	@Test
	public void testSetLozinka() throws InvalidAttributeValueException, NoSuchAlgorithmException, InvalidKeySpecException {
		LocalDate datum=LocalDate.now().minus(Period.ofDays(1));
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setLozinka("aaaa");
	}

	@Test
	public void testGetIme() throws InvalidAttributeValueException {
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		String u = z.getIme();
		assertEquals("ime", u);	
	}

	@Test(expected=javax.naming.directory.InvalidAttributeValueException.class)
	public void testSetIme() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setIme(" ");
	}

	@Test
	public void testGetPrezime() throws InvalidAttributeValueException {
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		String u = z.getPrezime();
		assertEquals("prezime", u);	
	}

	@Test(expected=javax.naming.directory.InvalidAttributeValueException.class)
	public void testSetPrezime() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setPrezime(" ");
	}

	@Test
	public void testGetAdresa() throws InvalidAttributeValueException {
			LocalDate datum=LocalDate.now();
			Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
			String u = z.getAdresa();
			assertEquals("adresa", u);	
		}

	@Test(expected=javax.naming.directory.InvalidAttributeValueException.class)
	public void testSetAdresa() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setAdresa("");
	}

	@Test
	public void testGetDatumZaposlenja() throws InvalidAttributeValueException {
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		LocalDate d = z.getDatumZaposlenja();
		assertEquals(datum, d);	
	}

	@Test(expected=javax.naming.directory.InvalidAttributeValueException.class)
	public void testSetDatumZaposlenja() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setDatumZaposlenja(null);
	}

	@Test
	public void testGetSatnica() throws InvalidAttributeValueException {
		LocalDate datum=LocalDate.now().minus(Period.ofDays(1));
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		double s = z.getSatnica();
		assertEquals(10000, s, 0.1);
	}

	@Test(expected=javax.naming.directory.InvalidAttributeValueException.class)
	public void testSetSatnica() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setSatnica(null);
	}

	@Test
	public void testGetArhiviran() throws InvalidAttributeValueException {
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setArhiviran(true);
		assertTrue(z.getArhiviran());
	}

	@Test
	public void testSetArhiviran() throws InvalidAttributeValueException {
		LocalDate datum=LocalDate.now();
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		z.setArhiviran(true);
	}

}


