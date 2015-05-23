package ba.etf.unsa.si.Klase;

import java.util.ArrayList;
import java.util.LinkedList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.etf.unsa.si.KlaseHibernate.AdministratorHibernate;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.OdjelZaposlenikHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetTaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;
import ba.etf.unsa.si.util.HibernateUtil;

public class DalDao {
	
	static public String HashirajLozinku (String lozinka)
	{
		Integer loz = lozinka.hashCode();
		return loz.toString();
	}
	
	static public void DodajObjekte(LinkedList<?> kolekcija)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		for (int i = 0; i < kolekcija.size(); i++)
		{
			session.save(kolekcija.get(i));
		}
		transaction.commit();
		session.close();
	}
	
	static public <T> void DodajObjekat(T objekat)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(objekat);
		transaction.commit();
		session.close();
	}
	
	static public void ObrisiObjekte(LinkedList<?> kolekcija)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		for (int i = 0; i < kolekcija.size(); i++)
		{
			session.delete(kolekcija.get(i));
		}
		transaction.commit();
		session.close();
	}
	
	static public <T> void ObrisiObjekat(T objekat)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(objekat);
		transaction.commit();
		session.close();
	}
	
	static public void ModifikujObjekte(LinkedList<?> kolekcija)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		for (int i = 0; i < kolekcija.size(); i++)
		{
			session.update(kolekcija.get(i));
		}
		transaction.commit();
		session.close();
	}
	
	static public <T> void ModifikujObjekat(T objekat)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(objekat);
		transaction.commit();
		session.close();
	}
	
	static public boolean VerifikujAdministratora(Administrator admin)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM AdministratorHibernate where username='" + admin.getUsername() + "' and lozinka ='" + admin.getLozinka() + "'";
		Query query = session.createQuery(hql);
		ArrayList<AdministratorHibernate> results = (ArrayList<AdministratorHibernate>)query.list();
		transaction.commit();
		session.close();
		if (results.isEmpty())
			return false;
		else return true;
	}
	
	static public boolean VerifikujKorisnika(Zaposlenik zaposlenik)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where username='" + zaposlenik.getUsername() + "' and lozinka ='" + zaposlenik.getLozinka() + "'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		if (results.isEmpty())
			return false;
		else return true;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikePoUsername(String username)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where username='" + username + "'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiNearhiviraneZaposlenikePoUsername(String username)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where username='" + username + "' AND arhiviran = '0'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikePoImenu(String ime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where ime='" + ime + "'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiNearhiviraneZaposlenikePoImenu(String ime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where ime='" + ime + "' AND arhiviran = '0'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikePoPrezimenu(String prezime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where prezime='" + prezime + "'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiNearhiviraneZaposlenikePoPrezimenu(String prezime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where prezime='" + prezime + "' AND arhiviran = '0'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikePoMailu(String email)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where email='" + email + "'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiNearhiviraneZaposlenikePoMailu(String email)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where email='" + email + "' AND arhiviran = '0'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ZaposlenikHibernate VratiZaposlenika(long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ZaposlenikHibernate results = (ZaposlenikHibernate)session.get(Zaposlenik.class, id);
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiSveZaposlenike()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiSveZaposlenikeKoordinatore()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE koordinator = '1' AND arhiviran = '0'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiSveNearhiviranaZaposlenike()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where arhiviran = '0'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> PretraziOdjele(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate where naziv='" + naziv + "'";
		Query query = session.createQuery(hql);
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> VratiSveOdjele()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate";
		Query query = session.createQuery(hql);
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> VratiSveNearhiviraneOdjele()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate where arhiviran='0'";
		Query query = session.createQuery(hql);
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiNadredjeneZaposlenike()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate where koordinator = '1' and arhiviran = '0'";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public OdjelHibernate VratiOdjel(long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
	    OdjelHibernate oh = (OdjelHibernate)session.get(OdjelHibernate.class, id);
		transaction.commit();
		session.close();
		return oh;
	}
	
	static private ArrayList<OdjelZaposlenikHibernate> VratiOdjelZaposlenik (long OdjelId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelZaposlenikHibernate where odjel = '" + OdjelId + "'";
		Query query = session.createQuery(hql);
		ArrayList<OdjelZaposlenikHibernate> results = (ArrayList<OdjelZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikeUOdjelu(long OdjelId)
	{
		ArrayList<OdjelZaposlenikHibernate> odjelZaposlenici = new ArrayList<OdjelZaposlenikHibernate>();
		odjelZaposlenici = DalDao.VratiOdjelZaposlenik(OdjelId);
		ArrayList<ZaposlenikHibernate> zaposlenici = new ArrayList<ZaposlenikHibernate>();
		for (int i = 0; i < odjelZaposlenici.size(); i++)
		{
			ZaposlenikHibernate zh = odjelZaposlenici.get(i).getZaposlenikOdjela();
			if (!zaposlenici.contains(zh))
				zaposlenici.add(zh);
		}
		return zaposlenici;
	}
	
	static public ArrayList<ProjekatHibernate> VratiProjektePoNazivu(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate where naziv='" + naziv + "'";
		Query query = session.createQuery(hql);
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiNearhiviraneProjektePoNazivu(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate where naziv='" + naziv + "' and arhiviran ='0'";
		Query query = session.createQuery(hql);
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiProjektePoNazivuKlijenta(String nazivKlijenta)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate where nazivKlijenta='" + nazivKlijenta + "'";
		Query query = session.createQuery(hql);
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiNearhiviraneProjektePoNazivuKlijenta(String nazivKlijenta)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate where nazivKlijenta='" + nazivKlijenta + "' and arhiviran ='0'";
		Query query = session.createQuery(hql);
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiSveProjekte()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate";
		Query query = session.createQuery(hql);
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiSveNearhiviraneProjekte()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate where arhiviran='0'";
		Query query = session.createQuery(hql);
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
		
	static public ProjekatHibernate VratiProjekat(long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ProjekatHibernate oh = (ProjekatHibernate)session.get(ProjekatHibernate.class, id);
		transaction.commit();
		session.close();
		return oh;
	}
	
	static public ArrayList<TaskHibernate> VratiSveTaskoveProjekta(long ProjekatID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TaskHibernate WHERE projekat ='" + ProjekatID + "'";
		Query query = session.createQuery(hql);
		ArrayList<TaskHibernate> results = (ArrayList<TaskHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikeNaProjektu(long ProjekatID)
	{
		ArrayList<TaskHibernate> taskovi = new ArrayList<TaskHibernate>();
		taskovi = DalDao.VratiSveTaskoveProjekta(ProjekatID);
		ArrayList<ZaposlenikHibernate> projekatZaposlenici = new ArrayList<ZaposlenikHibernate>();
		for (int i = 0; i < taskovi.size(); i++)
		{
			ZaposlenikHibernate zh = taskovi.get(i).getZaposlenik();
			if (!projekatZaposlenici.contains(zh))
				projekatZaposlenici.add(zh);
		}
		return projekatZaposlenici;
	}
	
	static public ArrayList<TaskHibernate> VratiTaskoveKorisnikaNaProjektu(long ProjekatID, long ZaposlenikID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TaskHibernate where projekat='" + ProjekatID + "' and zaposlenik ='" + ZaposlenikID + "'";
		Query query = session.createQuery(hql);
		ArrayList<TaskHibernate> results = (ArrayList<TaskHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<TimesheetHibernate> VratiTimesheetoveProjekta(long ProjekatID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TimesheetHibernate where projekat='" + ProjekatID + "'";
		Query query = session.createQuery(hql);
		ArrayList<TimesheetHibernate> results = (ArrayList<TimesheetHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}

	static public ArrayList<TimesheetHibernate> VratiNevalidiraneTimesheetoveProjekta (long ProjekatID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TimesheetHibernate WHERE projekat='" + ProjekatID + "' AND validiran='0'";
		Query query = session.createQuery(hql);
		ArrayList<TimesheetHibernate> results = (ArrayList<TimesheetHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<TimesheetHibernate> VratiTimesheetoveZaposlenikaNaProjektu(long ProjekatID, long ZaposlenikID)
	{
		ArrayList<TaskHibernate> taskovi = new ArrayList<TaskHibernate>();
		taskovi = VratiTaskoveKorisnikaNaProjektu(ProjekatID, ZaposlenikID);
		ArrayList<TimesheetHibernate> timesheetovi = new ArrayList<TimesheetHibernate>();
		for (int i = 0; i < taskovi.size(); i++)
		{
			ArrayList<TimesheetTaskHibernate> timeshe = DalDao.VratiTimesheetTaskovePoTasku(taskovi.get(i).getId());
			for (int j = 0; j < timeshe.size(); j++)
			{
				TimesheetHibernate th = timeshe.get(j).getTimesheet();
				if (!timesheetovi.contains(th))
					timesheetovi.add(th);
			}
		}
		return timesheetovi;
	}
	
	static private ArrayList<TimesheetTaskHibernate> VratiTimesheetTaskove(long TimesheetID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TimesheetTaskHibernate where timesheet = '" + TimesheetID + "'";
		Query query = session.createQuery(hql);
		ArrayList<TimesheetTaskHibernate> results = (ArrayList<TimesheetTaskHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static private ArrayList<TimesheetTaskHibernate> VratiTimesheetTaskovePoTasku(long TaskID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TimesheetTaskHibernate where task = '" + TaskID + "'";
		Query query = session.createQuery(hql);
		ArrayList<TimesheetTaskHibernate> results = (ArrayList<TimesheetTaskHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<TaskHibernate> VratiTimesheetTaskoveZaposlenika(long TimesheetID)
	{
		ArrayList<TimesheetTaskHibernate> taskTimesheet = new ArrayList<TimesheetTaskHibernate>();
		taskTimesheet = VratiTimesheetTaskove(TimesheetID);
		ArrayList<TaskHibernate> taskoviZaposlenika = new ArrayList<TaskHibernate>();
		for (int index = 0; index < taskTimesheet.size(); index++)
		{
			TaskHibernate th = taskTimesheet.get(index).getTask();
			if (!th.getProcenatZavrsenosti().equals(100) || taskoviZaposlenika.contains(th))
			{
				taskoviZaposlenika.add(th);
			}
		}
		return taskoviZaposlenika;
	}

	static public ArrayList<TaskHibernate> VratiSveZaposlenikoveTaskove(long ZaposlenikID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TaskHibernate where zaposlenik='" + ZaposlenikID + "'";
		Query query = session.createQuery(hql);
		ArrayList<TaskHibernate> results = (ArrayList<TaskHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiZaposlenikoveProjekte (long ZaposlenikID)
	{
		ArrayList<TaskHibernate> taskovi = VratiSveZaposlenikoveTaskove(ZaposlenikID);
		ArrayList<ProjekatHibernate> projekti = new ArrayList<ProjekatHibernate>();
		for (int i = 0; i < taskovi.size(); i++)
		{
			ProjekatHibernate ph = taskovi.get(i).getProjekat();
			if (!projekti.contains(ph))
				projekti.add(ph);
		}
		return projekti;
	}

	static public ArrayList<ProjekatHibernate> VratiSveKoordinatorskeProjekte (long KoordinatorID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate where koordinator='" + KoordinatorID + "'";
		Query query = session.createQuery(hql);
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
		
	static public ArrayList<TimesheetHibernate> VratiTimesheetoveZaValidaciju (long KoordinatorID)
	{
		ArrayList<ProjekatHibernate> projekti = new ArrayList<ProjekatHibernate>();
		projekti = VratiSveKoordinatorskeProjekte(KoordinatorID);
		ArrayList<TimesheetHibernate> trebaValidirati = new ArrayList<TimesheetHibernate>();
		for (int i = 0; i < projekti.size(); i++)
		{
			ArrayList<TimesheetHibernate> projekatTimesheet = VratiNevalidiraneTimesheetoveProjekta(projekti.get(i).getId());
			trebaValidirati.addAll(projekatTimesheet);
		}
		return trebaValidirati;
	}
}

