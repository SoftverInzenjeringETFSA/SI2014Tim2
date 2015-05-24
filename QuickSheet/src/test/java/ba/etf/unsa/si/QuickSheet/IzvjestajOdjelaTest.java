package ba.etf.unsa.si.QuickSheet;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.management.InvalidAttributeValueException;

import org.junit.Test;

import ba.etf.unsa.si.Klase.DalDao;
import ba.etf.unsa.si.Klase.IzvjestajOdjela;
import ba.etf.unsa.si.Klase.Koordinator;
import ba.etf.unsa.si.Klase.Odjel;
import ba.etf.unsa.si.Klase.Projekat;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;

public class IzvjestajOdjelaTest {

	
	
	

	
	@Test
	public void testIzracunajProcenatZavrsenogRada() {
		ZaposlenikHibernate zh = new ZaposlenikHibernate();
		zh.setIme("Dzenana1");
		zh.setPrezime("Dzenana");
		zh.setAdresa("Dzenana");
		zh.setArhiviran(false);
		zh.setDatumZaposlenja(LocalDate.now());
		zh.setKoordinator(false);
		zh.setLozinka("dsdasd");
		zh.setSatnica(20d);
		zh.setUsername("Username222");
		
		DalDao.DodajObjekat(zh);
			
		ProjekatHibernate p1 = new ProjekatHibernate();
		p1.setNaziv("projekat");
		p1.setNazivKlijenta("Edin");
		p1.setKoordinator(zh);
		
		DalDao.DodajObjekat(p1);
		
		TimesheetHibernate ts = new TimesheetHibernate();
		ts.setBrojRadnihSati(2);
		ts.setProjekat(p1);
		ts.setValidiran(true);
		ts.setDatumSlanja(LocalDate.now());
		DalDao.DodajObjekat(ts);
		
		TimesheetHibernate ts1 = new TimesheetHibernate();
		ts1.setBrojRadnihSati(2);
		ts1.setProjekat(p1);
		ts1.setValidiran(true);
		ts1.setDatumSlanja(LocalDate.now());
		DalDao.DodajObjekat(ts1);
		
		Integer ukupno = 0;
		ArrayList<TimesheetHibernate> lista = DalDao.VratiTimesheetoveProjekta(p1.getId());
		for(int i = 0; i < lista.size(); i++){
			ukupno += lista.get(i).getBrojRadnihSati();
		}
		
		Integer cijena = 0;
		cijena = (int) (zh.getSatnica()) * ukupno;
		assertEquals(new Integer(80), cijena);
	}


	@Test
	public void testIzracunajUkupnoVrijemeRada() {
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
		
		TimesheetHibernate ts = new TimesheetHibernate();
		ts.setBrojRadnihSati(2);
		ts.setProjekat(p);
		ts.setValidiran(true);
		ts.setDatumSlanja(LocalDate.now());
		DalDao.DodajObjekat(ts);
		
		TimesheetHibernate ts1 = new TimesheetHibernate();
		ts1.setBrojRadnihSati(2);
		ts1.setProjekat(p);
		ts1.setValidiran(true);
		ts1.setDatumSlanja(LocalDate.now());
		DalDao.DodajObjekat(ts1);
		
		Integer ukupno = 0;
		ArrayList<TimesheetHibernate> lista = DalDao.VratiTimesheetoveProjekta(p.getId());
		for(int i = 0; i < lista.size(); i++){
			ukupno += lista.get(i).getBrojRadnihSati();
		}
		
		assertEquals(new Integer(4), ukupno);
		
		
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

