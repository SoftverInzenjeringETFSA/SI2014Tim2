package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

import ba.etf.unsa.si.Klase.Administrator;
import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Lozinka;
import ba.etf.unsa.si.Klase.Odjel;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.KlaseHibernate.AdministratorHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class AdministratorTest {

	@Test
	public void testSetUsername() throws InvalidAttributeValueException {
		
			try {
				AdministratorHibernate a= new AdministratorHibernate();
				a.setUsername("user1");
		
			    AdministratorHibernate a1 = DalDao.VratiAdministratoraPoUsernamu("user1");
				assertEquals("user1", a.getUsername());
				}
				catch(Exception ex) {
					
				}
	}



	
	@Test
	public void testSetLozinka() throws InvalidAttributeValueException {
		try {
		AdministratorHibernate a= new AdministratorHibernate();
		a.setUsername("user1");
		a.setLozinka("abc");
		AdministratorHibernate a1 = DalDao.VratiAdministratoraPoUsernamu("user1");
		assertEquals(Lozinka.validatePassword("abc", a1.getLozinka()), true);
		}
		catch(Exception ex) {
			
		}
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
	
	@Test
	public void testKreirajProjekat() throws InvalidAttributeValueException {
		String naziv="projekat";
		String klijent="Dean";
		ZaposlenikHibernate k= new ZaposlenikHibernate();
		k.setIme("Ime");
		k.setUsername("username");
		k.setKoordinator(true);
		DalDao.DodajObjekat(k);
		
		System.out.println(naziv);
	/*	
		ProjekatHibernate p= new ProjekatHibernate();  
		p.setKoordinator(k);
		p.setNaziv(naziv);
		p.setNazivKlijenta(klijent);
		p.setArhiviran(false);
		
		DalDao.DodajObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(2);
		System.out.println(p1.getNaziv());
		assertEquals("projekat", p1.getNaziv());*/
		
		
		
	    
		
	}

}
