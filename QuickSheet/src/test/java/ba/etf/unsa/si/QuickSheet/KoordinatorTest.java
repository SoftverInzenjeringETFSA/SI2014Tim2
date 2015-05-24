package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javassist.compiler.ast.NewExpr;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.Klase.ProjekatRadnik;
import ba.etf.unsa.si.Klase.Task;
import ba.etf.unsa.si.Klase.Zaposlenik;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

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
	

	@Test
	public void testDodajZaposlenikaUProjekat() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("DzenanaBrisanje");
		zh.setPrezime("prezime");
		zh.setAdresa("DzenanaAdresa");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(true);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username222");
		DalDao.DodajObjekat(zh);
		
		ProjekatHibernate p = new ProjekatHibernate();
		p.setKoordinator(zh);
		p.setNaziv("projekatTestiranje");
		p.setNazivKlijenta("Dean");
		p.setArhiviran(true);
		
		DalDao.DodajObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		ZaposlenikHibernate zh1 = p1.getKoordinator();
		
		assertEquals(zh1.getIme(), zh.getIme());
	}

	@Test
	public void testArhivirajProjekatTrue() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("DzenanaBrisanje");
		zh.setPrezime("prezime");
		zh.setAdresa("DzenanaAdresa");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(true);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username222");
		DalDao.DodajObjekat(zh);
		
		ProjekatHibernate p = new ProjekatHibernate();
		p.setKoordinator(zh);
		p.setNaziv("projekatTestiranje");
		p.setNazivKlijenta("Dean");
		p.setArhiviran(true);
		
		DalDao.DodajObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		assertTrue(p1.getArhiviran());
		
	}

	@Test
	public void testArhivirajProjekatFalse() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("DzenanaBrisanje");
		zh.setPrezime("prezime");
		zh.setAdresa("DzenanaAdresa");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(true);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username222");
		DalDao.DodajObjekat(zh);
		
		ProjekatHibernate p = new ProjekatHibernate();
		p.setKoordinator(zh);
		p.setNaziv("projekatTestiranje");
		p.setNazivKlijenta("Dean");
		p.setArhiviran(false);
		
		DalDao.DodajObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		assertFalse(p1.getArhiviran());
		
	}
	
	@Test
	public void testDaLiJeKoordinatorTrue() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("DzenanaBrisanje");
		zh.setPrezime("prezime");
		zh.setAdresa("DzenanaAdresa");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(true);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username222");
		
		DalDao.DodajObjekat(zh);
		assertTrue(zh.getKoordinator());
	}
	
	@Test
	public void testDaLiJeKoordinatorFalse() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("DzenanaBrisanje");
		zh.setPrezime("prezime");
		zh.setAdresa("DzenanaAdresa");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username222");
		
		DalDao.DodajObjekat(zh);
		assertFalse(zh.getKoordinator());
	}

}

