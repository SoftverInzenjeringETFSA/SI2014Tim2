package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.Test;

import ba.etf.unsa.si.Klase.Administrator;
import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Lozinka;
import ba.etf.unsa.si.Klase.Odjel;
import ba.etf.unsa.si.Klase.Projekat;

import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.AdministratorHibernate;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
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
	public void testVratiOdjelPoNazivu() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		OdjelHibernate o = new OdjelHibernate();
		o.setNaziv("Odjel");
		o.setMaksimalanBrojRadnika(24);
		o.setArhiviran(false);
		DalDao.DodajObjekat(o);
		
		OdjelHibernate o1 = DalDao.VratiOdjelPoNazivu("Odjel");
		assertEquals("Odjel", o1.getNaziv());
	}
	
	@Test
	public void dodajZaposlenika() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("Dz");
		zh.setPrezime("Dz");
		zh.setAdresa("Dz");
		zh.setArhiviran(true);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("nesto");
		zh.setSatnica(20d);
		zh.setUsername("dzbr");
		DalDao.DodajObjekat(zh);
		
		ZaposlenikHibernate zh1 = DalDao.VratiZaposlenika(zh.getId());
		assertNotNull(zh1);
		
	}
	@Test
	public void getZaposlenikArhiviran() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("Dz");
		zh.setPrezime("Dz");
		zh.setAdresa("Dz");
		zh.setArhiviran(true);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("nesto");
		zh.setSatnica(20d);
		zh.setUsername("dzbr");
		DalDao.DodajObjekat(zh);
		
		ZaposlenikHibernate zh1 = DalDao.VratiZaposlenika(zh.getId());
		assertTrue(zh1.getArhiviran());
		
	}
	@Test
	public void getZaposlenikAdresa() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("Dz1");
		zh.setPrezime("Dz");
		zh.setAdresa("Dz");
		zh.setArhiviran(true);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("nesto");
		zh.setSatnica(20d);
		zh.setUsername("dzbr");
		DalDao.DodajObjekat(zh);
		
		ZaposlenikHibernate zh1 = DalDao.VratiZaposlenika(zh.getId());
		assertEquals(zh.getAdresa(), zh1.getAdresa());
		
	}
	@Test
	public void getZaposlenikUsername() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("Dz1");
		zh.setPrezime("Dz");
		zh.setAdresa("Dz");
		zh.setArhiviran(true);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("nesto");
		zh.setSatnica(20d);
		zh.setUsername("dzbr");
		DalDao.DodajObjekat(zh);
		
		ZaposlenikHibernate zh1 = DalDao.VratiZaposlenika(zh.getId());
		assertEquals(zh.getIme(), zh1.getIme());
		
	}
	
	@Test
	public void testKreirajProjekat() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("Dzenana");
		zh.setPrezime("Dzenana");
		zh.setAdresa("Dzenana");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username1111");
		DalDao.DodajObjekat(zh);
			
		ProjekatHibernate p = new ProjekatHibernate();
		p.setNaziv("projekat");
		p.setNazivKlijenta("Edin");
		p.setKoordinator(zh);
		
		DalDao.DodajObjekat(p);
		
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		
		assertEquals("projekat", p1.getNaziv());
		
	}
	
	@Test
	public void testBrisanjeProjekat() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("DzenanaBrisanje");
		zh.setPrezime("Dzenana");
		zh.setAdresa("Dzenana");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username1111");
		DalDao.DodajObjekat(zh);
			
		ProjekatHibernate p = new ProjekatHibernate();
		p.setNaziv("projekatBrisanje");
		p.setNazivKlijenta("Edin");
		p.setKoordinator(zh);
		
		DalDao.DodajObjekat(p);
		
		DalDao.ObrisiObjekat(p);
		ProjekatHibernate p1 = DalDao.VratiProjekat(p.getId());
		assertNull(p1);
		
	}
	
	
	@Test
	public void testBrisanjeZaposlenika() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("Dzenana");
		zh.setPrezime("Dzenana");
		zh.setAdresa("Dzenana");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username1111");
		DalDao.DodajObjekat(zh);
		
		DalDao.ObrisiObjekat(zh);
		ZaposlenikHibernate zh1 = DalDao.VratiZaposlenikaPoUsernamu("Dzenana");
		assertNull(zh1);
		
	}
	
	@Test
	public void testDodavanjeOdjelaObjekat() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		OdjelHibernate o = new OdjelHibernate();
		o.setNaziv("Odjeldzenanin1");
		o.setMaksimalanBrojRadnika(24);
		o.setArhiviran(true);
		
		DalDao.DodajObjekat(o);
	
		OdjelHibernate o1 = DalDao.VratiOdjelPoNazivu("Odjeldzenanin1");
		assertNotNull(o1);
		
	}
	@Test
	public void testBrisanjeOdjela() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		OdjelHibernate o = new OdjelHibernate();
		o.setNaziv("Odjeldzenanin1");
		o.setMaksimalanBrojRadnika(24);
		o.setArhiviran(true);
		
		DalDao.DodajObjekat(o);
	
		DalDao.ObrisiObjekat(o);
		OdjelHibernate zh1 = DalDao.VratiOdjel(o.getId());
		assertNull(zh1);
		
	}
	
	@Test
	public void testIzmijeniMaxBroj() throws javax.management.InvalidAttributeValueException, InvalidAttributeValueException {
		OdjelHibernate o = new OdjelHibernate();
		o.setNaziv("Odjeldzenanin1");
		o.setMaksimalanBrojRadnika(24);
		o.setArhiviran(true);
		DalDao.DodajObjekat(o);	
		
		o.setMaksimalanBrojRadnika(26);
		DalDao.ModifikujObjekat(o);
		
		OdjelHibernate o1 = DalDao.VratiOdjel(o.getId());
		Integer i =  o1.getMaksimalanBrojRadnika();
		
		assertEquals(new Integer(26), i);	
		
	}

	


	

	
	
}
