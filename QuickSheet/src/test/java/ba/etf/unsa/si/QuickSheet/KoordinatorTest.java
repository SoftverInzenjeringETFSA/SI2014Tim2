package ba.etf.unsa.si.Klase;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

public class KoordinatorTest {

	@Test(expected=InvalidAttributeValueException.class)
	public void testKoordinator() throws InvalidAttributeValueException{
		LocalDate datum=LocalDate.now();
		Koordinator k= new Koordinator(null,"Teo","Eterovic","Zmaja",datum,1000);
	}

	@Test
	public void testOdobriTimesheet() {
		 // TODO ne treba
	}
  
	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testKreirajTaskProjekta() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException{
		String naziv="Timesheet";
		String klijent="Ja";
		
		LocalDate datum=LocalDate.now();
		Koordinator k= new Koordinator("user","ime","prezime","adresa",datum,1000);
		Projekat p= new Projekat(naziv,klijent,k);
		
		Zaposlenik z= new ProjekatRadnik("username","ime","prezime","adresa",datum,10000);
		Task t= new Task("Zadatak"," ",10,z,LocalDate.now());
		p.DodajTask(t);
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testDodajZaposlenikaUProjekat() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		String naziv="Timesheet";
		String klijent="Dean";
		
		LocalDate datum=LocalDate.now();
		Koordinator k= new Koordinator("Username","ime","prezime","adresa",datum,10000);
		Projekat p= new Projekat(naziv,klijent,k);
		
		
		ProjekatRadnik pr= new ProjekatRadnik("","ime","prezime","adresa",datum,10000);
		k.DodajZaposlenikaUProjekat(p, pr);
	}

	@Test(expected=javax.management.InvalidAttributeValueException.class)
	public void testArhivirajProjekat() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		String naziv="Timesheet";
		String klijent="Dean";
		
		LocalDate datum=LocalDate.now();
		Koordinator k= new Koordinator("Username","ime","prezime","adresa",datum,10000);
		Projekat p= new Projekat(naziv,klijent,k);
		p.setArhiviran(false);
	}

	@Test
	public void testGenerisiIzvjestajProjekatZaposlenik() {
		 // TODO getter
	}

	@Test
	public void testGenerisiIzvjestajProjekatOdjel() {
		 // TODO gettre
	}

	@Test
	public void testPrintajIzvjestaj() {
		 // TODO
	}

}

