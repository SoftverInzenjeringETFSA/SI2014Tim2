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
		Koordinator k = new Koordinator(null,"Teo","Eterovic","Zmaja",datum,1000);
		
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
	public void testPromjenaKoordinatoraUProjektu() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("DzB");
		zh.setPrezime("P");
		zh.setAdresa("Dzenana");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("opak");
		zh.setSatnica(20d);
		zh.setUsername("Username1");
		DalDao.DodajObjekat(zh);
		
		ZaposlenikHibernate zh2 = new ZaposlenikHibernate();
		zh2.setIme("DzBrr");
		zh2.setPrezime("nekoPrezime");
		zh2.setAdresa("adr5");
		zh2.setArhiviran(true);
		zh2.setDatumZaposlenja(LocalDate.now());
		zh2.setKoordinator(true);
		zh2.setLozinka("ljhlk");
		zh2.setSatnica(20d);
		zh2.setUsername("usernameDzBr");
		DalDao.DodajObjekat(zh2);
		
		ProjekatHibernate p = new ProjekatHibernate();
		p.setKoordinator(zh);
		p.setNaziv("projekatTestiranje");
		p.setNazivKlijenta("Anes");
		p.setArhiviran(true);
		
		DalDao.DodajObjekat(p);
		p.setKoordinator(zh2);
		DalDao.ModifikujObjekat(p);
		
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		ZaposlenikHibernate zh1 = p1.getKoordinator();
		
		
		
		assertEquals("usernameDzBr", zh1.getUsername());
		DalDao.ObrisiObjekat(p);
		DalDao.ObrisiObjekat(zh2);
		DalDao.ObrisiObjekat(zh);
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
		DalDao.ObrisiObjekat(p);
		DalDao.ObrisiObjekat(zh);
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
		DalDao.ObrisiObjekat(p);
		DalDao.ObrisiObjekat(zh);
	}
	@Test
	public void testProjekatNaziv() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
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
		p.setNaziv("projekatTestiranjeImena");
		p.setNazivKlijenta("Dean");
		p.setArhiviran(true);
		
		DalDao.DodajObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		assertEquals("projekatTestiranjeImena", p1.getNaziv());
		DalDao.ObrisiObjekat(p);
		DalDao.ObrisiObjekat(zh);
		
	}
	@Test
	public void testProjekatNazivKlijenta() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
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
		p.setNaziv("projekatTestiranjeImena");
		p.setNazivKlijenta("Dean");
		p.setArhiviran(true);
		
		DalDao.DodajObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		assertEquals("Dean", p1.getNazivKlijenta());
		DalDao.ObrisiObjekat(p);
		DalDao.ObrisiObjekat(zh);
		
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
		DalDao.ObrisiObjekat(p);
		DalDao.ObrisiObjekat(zh);
		
	}
	
	@Test
	public void testProjekatPromjenaNaziva() throws InvalidAttributeValueException, javax.management.InvalidAttributeValueException{
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("DzenanaBrisanje");
		zh.setPrezime("prezime");
		zh.setAdresa("DzenanaAdresa");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(true);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username2222");
		DalDao.DodajObjekat(zh);
		
		ProjekatHibernate p = new ProjekatHibernate();
		p.setKoordinator(zh);
		p.setNaziv("projekatTestiranjeee");
		p.setNazivKlijenta("Dean");
		p.setArhiviran(true);
		
		DalDao.DodajObjekat(p);
		
		p.setNaziv("projekaTestiranje1");
		DalDao.ModifikujObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		assertEquals("projekaTestiranje1", p1.getNaziv());
		DalDao.ObrisiObjekat(p);
		DalDao.ObrisiObjekat(zh);
		
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
		DalDao.ObrisiObjekat(zh);
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
		DalDao.ObrisiObjekat(zh);
	}

	

	
	

}

