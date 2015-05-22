package ba.etf.unsa.si.Klase;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

public class AdministratorTest {

	@Test(expected=InvalidAttributeValueException.class)
	public void testSetUsername() throws InvalidAttributeValueException {
		String username="##$$2132enis123sjdhf564#$%+-";
		String lozinka="##$$2132enis123sjdhf564#$%";
		
		
			Administrator b= new Administrator(username,lozinka);
	}

	@Test
	public void testGetLozinka() {
		 // TODO ovo ne treba
	}

	
	@Test(expected=InvalidAttributeValueException.class)
	public void testSetLozinka() throws InvalidAttributeValueException {
		String username="Enis";
		String lozinka="enis";
		Administrator a= new Administrator(username,lozinka);
		a.setLozinka(null);
	}

	
	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testKreirajOdjel() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		String nazivOdjela="Testeri";
		int maxBrojRadnika=-1;
		Odjel o = new Odjel(nazivOdjela,maxBrojRadnika);
		
		String username="Enis";
		String lozinka="enis";
		Administrator a= new Administrator(username,lozinka);
		a.kreirajOdjel(null, -11);
		//koji je stvarni maksimalni broj radnika?
	}
	
	@Test(expected=InvalidAttributeValueException.class)
	public void testKreirajProjekat() throws InvalidAttributeValueException {
		String naziv="Timesheet$#1";
		String klijent="Dean";
		
		LocalDate datum=LocalDate.now();
		Koordinator k= new Koordinator(null,"Teo","Eterovic","Zmaja",datum,1000);
		Projekat p= new Projekat(naziv,klijent,k);  
		
		String username="Enis";
		String lozinka="enis";
		Administrator a= new Administrator(username,lozinka);
		
		a.kreirajProjekat("string", "string", k);
	
		
	}

}
