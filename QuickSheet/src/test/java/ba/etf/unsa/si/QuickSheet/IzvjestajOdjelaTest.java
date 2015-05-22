package ba.etf.unsa.si.Klase;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.management.InvalidAttributeValueException;

import org.junit.Test;

public class IzvjestajOdjelaTest {

	
	
	@Test(expected=NullPointerException.class)
	public void testSetProjekat() throws NullPointerException, javax.naming.directory.InvalidAttributeValueException, InvalidAttributeValueException{
		
		String naziv="Timesheet";
		String klijent="Dean";
		
		LocalDate datum=LocalDate.now();
		Koordinator k= new Koordinator("user","ime","prezime","adresa",datum,10000);
		Projekat p= new Projekat(naziv,klijent,k);
		
		p.setNaziv(null);
		p.setKoordinator(null);
		p.setNazivKlijenta(null);
		
		
	}

	
	@Test
	public void testIzracunajProcenatZavrsenogRada() {
		fail("Not yet implemented"); // TODO
		//IzvjstajOdjelaTest.assertEquals();
	}

	@Test
	public void testIzracunajTrosak() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testIzracunajUkupnoVrijemeRada() {
		fail("Not yet implemented"); // TODO
	}

	@Test(expected=NullPointerException.class)
	public void testIzvjestajOdjela() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException, javax.naming.directory.InvalidAttributeValueException {
		Odjel o= new Odjel("Naziv",10);
		String naziv="Timesheet$#1";
		String klijent="Dean";
		LocalDate datum=LocalDate.now();
		Koordinator k= new Koordinator("user","Teo","Eterovic","Zmaja",datum,10000);
		Projekat p= new Projekat(naziv,klijent,k);
		IzvjestajOdjela io=new IzvjestajOdjela(p,o);
	}

	@Test
	public void testGetUkupanBrojTaskovaOdjela() {
	 // TODO getter
	}

	@Test
	public void testGetOdjel() {
		 // TODO getter
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testSetOdjel() throws javax.management.InvalidAttributeValueException{
		Odjel o= new Odjel("Naziv",10);
		o.setNaziv(null);
		o.setMaksimalanBrojRadnika(null);
	}
	

}

