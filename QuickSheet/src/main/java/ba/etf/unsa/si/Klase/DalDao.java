package ba.etf.unsa.si.Klase;

import java.time.Month;
import java.util.ArrayList;

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

	static public <T> void DodajObjekat(T objekat)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(objekat);
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
	
	static public <T> void ModifikujObjekat(T objekat)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(objekat);
		transaction.commit();
		session.close();
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiArhiviraneZaposlenikePoImenu(String ime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE ime=:ime AND arhiviran = '1'";
		Query query = session.createQuery(hql);
		query.setString("ime", ime);
		@SuppressWarnings("unchecked")
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiNearhiviraneZaposlenikePoImenu(String ime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE ime=:ime AND arhiviran = '0'";
		Query query = session.createQuery(hql);
		query.setString("ime", ime);
		@SuppressWarnings("unchecked")
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiArhiviraneZaposlenikePoPrezimenu(String prezime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE prezime=:prezime AND arhiviran = '1'";
		Query query = session.createQuery(hql);
		query.setString("prezime", prezime);
		@SuppressWarnings("unchecked")
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiNearhiviraneZaposlenikePoPrezimenu(String prezime)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE prezime=:prezime AND arhiviran = '0'";
		Query query = session.createQuery(hql);
		query.setString("prezime", prezime);
		@SuppressWarnings("unchecked")
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}

	static public ZaposlenikHibernate VratiZaposlenika(long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		ZaposlenikHibernate results = (ZaposlenikHibernate)session.get(ZaposlenikHibernate.class, id);
		transaction.commit();
		session.close();
		return results;
	}
	
	static public AdministratorHibernate VratiAdministratora(long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		AdministratorHibernate results = (AdministratorHibernate)session.get(AdministratorHibernate.class, id);
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
		@SuppressWarnings("unchecked")
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
		@SuppressWarnings("unchecked")
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiSveNearhiviraneZaposlenike()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE arhiviran = '0'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> PretraziArhiviraneOdjelePoNazivu(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate WHERE naziv=:naziv AND arhiviran='1'";
		Query query = session.createQuery(hql);
		query.setString("naziv", naziv);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> PretraziNearhiviraneOdjelePoNazivu(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate WHERE naziv=:naziv AND arhiviran='0'";
		Query query = session.createQuery(hql);
		query.setString("naziv", naziv);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> PretraziArhiviraneOdjelePoKapacitetu(int maxBroj)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate WHERE maksimalanBrojRadnika=:maxBroj AND arhiviran='1'";
		Query query = session.createQuery(hql);
		query.setInteger("maxBroj", maxBroj);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> PretraziNearhiviraneOdjelePoKapacitetu(int maxBroj)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate WHERE maksimalanBrojRadnika=:maxBroj AND arhiviran='0'";
		Query query = session.createQuery(hql);
		query.setInteger("maxBroj", maxBroj);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> VratiSveArhiviraneOdjele()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate WHERE arhiviran='1'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<OdjelHibernate> VratiSveNearhiviraneOdjele()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate WHERE arhiviran='0'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
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
	
	static public TimesheetHibernate VratiTimesheet(long id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		TimesheetHibernate th = (TimesheetHibernate)session.get(TimesheetHibernate.class, id);
		transaction.commit();
		session.close();
		return th;
	}
	
	static public OdjelHibernate VratiOdjelPoNazivu(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelHibernate WHERE naziv=:naziv";
		Query query = session.createQuery(hql);
		query.setString("naziv", naziv);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelHibernate> results = (ArrayList<OdjelHibernate>)query.list();
		OdjelHibernate oh = new OdjelHibernate();
		if (results != null && results.size() != 0)
			oh = results.get(0);
		else oh = null;
		transaction.commit();
		session.close();
		return oh;
	}
	
	static private ArrayList<OdjelZaposlenikHibernate> VratiOdjelZaposlenikPoOdjelu (long OdjelId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelZaposlenikHibernate WHERE odjel=:OdjelId";
		Query query = session.createQuery(hql);
		query.setLong("OdjelId", OdjelId);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelZaposlenikHibernate> results = (ArrayList<OdjelZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static private ArrayList<OdjelZaposlenikHibernate> VratiOdjelZaposlenikPoZaposleniku (long ZaposlenikId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM OdjelZaposlenikHibernate WHERE zaposlenikOdjela=:ZaposlenikId";
		Query query = session.createQuery(hql);
		query.setLong("ZaposlenikId", ZaposlenikId);
		@SuppressWarnings("unchecked")
		ArrayList<OdjelZaposlenikHibernate> results = (ArrayList<OdjelZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikeUOdjelu(long OdjelId)
	{
		ArrayList<OdjelZaposlenikHibernate> odjelZaposlenici = new ArrayList<OdjelZaposlenikHibernate>();
		odjelZaposlenici = DalDao.VratiOdjelZaposlenikPoOdjelu(OdjelId);
		ArrayList<ZaposlenikHibernate> zaposlenici = new ArrayList<ZaposlenikHibernate>();
		for (int i = 0; i < odjelZaposlenici.size(); i++)
		{
			ZaposlenikHibernate zh = odjelZaposlenici.get(i).getZaposlenikOdjela();
			if (!zaposlenici.contains(zh))
				zaposlenici.add(zh);
		}
		return zaposlenici;
	}
	
	static public ArrayList<OdjelHibernate> VratiZaposlenikoveOdjele(long ZaposlenikID)
	{
		ArrayList<OdjelZaposlenikHibernate> odjeliZap = new ArrayList<OdjelZaposlenikHibernate>();
		odjeliZap = VratiOdjelZaposlenikPoZaposleniku(ZaposlenikID);
		ArrayList<OdjelHibernate> odjeli = new ArrayList<OdjelHibernate>();
		for (int i = 0; i < odjeliZap.size(); i++)
		{
			if (!odjeli.contains(odjeliZap.get(i).getOdjel()))
			odjeli.add(odjeliZap.get(i).getOdjel());
		}
		return odjeli;
	}
	
	static public ArrayList<ProjekatHibernate> VratiProjektePoNazivu(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate WHERE naziv=:naziv";
		Query query = session.createQuery(hql);
		query.setString("naziv", naziv);
		@SuppressWarnings("unchecked")
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiNearhiviraneProjektePoNazivu(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate WHERE naziv=:naziv AND arhiviran ='0'";
		Query query = session.createQuery(hql);
		query.setString("naziv", naziv);
		@SuppressWarnings("unchecked")
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiArhiviraneProjektePoNazivu(String naziv)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate WHERE naziv=:naziv AND arhiviran ='1'";
		Query query = session.createQuery(hql);
		query.setString("naziv", naziv);
		@SuppressWarnings("unchecked")
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiProjektePoNazivuKlijenta(String nazivKlijenta)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate WHERE nazivKlijenta=:nazivKlijenta";
		Query query = session.createQuery(hql);
		query.setString("nazivKlijenta", nazivKlijenta);
		@SuppressWarnings("unchecked")
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiNearhiviraneProjektePoNazivuKlijenta(String nazivKlijenta)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate WHERE nazivKlijenta=:nazivKlijenta AND arhiviran ='0'";
		Query query = session.createQuery(hql);
		query.setString("nazivKlijenta", nazivKlijenta);
		@SuppressWarnings("unchecked")
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiArhiviraneProjektePoNazivuKlijenta(String nazivKlijenta)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate WHERE nazivKlijenta=:nazivKlijenta AND arhiviran ='1'";
		Query query = session.createQuery(hql);
		query.setString("nazivKlijenta", nazivKlijenta);
		@SuppressWarnings("unchecked")
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiSveNearhiviraneProjekte()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate WHERE arhiviran='0'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		ArrayList<ProjekatHibernate> results = (ArrayList<ProjekatHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<ProjekatHibernate> VratiSveArhiviraneProjekte()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ProjekatHibernate WHERE arhiviran='1'";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
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
		String hql = "FROM TaskHibernate WHERE projekat=:ProjekatID";
		Query query = session.createQuery(hql);
		query.setLong("ProjekatID", ProjekatID);
		@SuppressWarnings("unchecked")
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
	
	static public ArrayList<TaskHibernate> VratiTaskoveZaposlenikaNaProjektu(long ProjekatID, long ZaposlenikID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TaskHibernate WHERE projekat=:ProjekatID AND zaposlenik=:ZaposlenikID";
		Query query = session.createQuery(hql);
		query.setLong("ProjekatID", ProjekatID);
		query.setLong("ZaposlenikID", ZaposlenikID);
		@SuppressWarnings("unchecked")
		ArrayList<TaskHibernate> results = (ArrayList<TaskHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<TimesheetHibernate> VratiTimesheetoveProjekta(long ProjekatID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TimesheetHibernate WHERE projekat=:ProjekatID";
		Query query = session.createQuery(hql);
		query.setLong("ProjekatID", ProjekatID);
		@SuppressWarnings("unchecked")
		ArrayList<TimesheetHibernate> results = (ArrayList<TimesheetHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}

	static public ArrayList<TimesheetHibernate> VratiNevalidiraneTimesheetoveProjekta (long ProjekatID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TimesheetHibernate WHERE projekat=:ProjekatID AND validiran='0'";
		Query query = session.createQuery(hql);
		query.setLong("ProjekatID", ProjekatID);
		@SuppressWarnings("unchecked")
		ArrayList<TimesheetHibernate> results = (ArrayList<TimesheetHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<TimesheetHibernate> VratiTimesheetoveZaposlenikaNaProjektu(long ProjekatID, long ZaposlenikID)
	{
		ArrayList<TaskHibernate> taskovi = new ArrayList<TaskHibernate>();
		taskovi = VratiTaskoveZaposlenikaNaProjektu(ProjekatID, ZaposlenikID);
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
		String hql = "FROM TimesheetTaskHibernate WHERE timesheet=:TimesheetID";
		Query query = session.createQuery(hql);
		query.setLong("TimesheetID", TimesheetID);
		@SuppressWarnings("unchecked")
		ArrayList<TimesheetTaskHibernate> results = (ArrayList<TimesheetTaskHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static private ArrayList<TimesheetTaskHibernate> VratiTimesheetTaskovePoTasku(long TaskID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM TimesheetTaskHibernate WHERE task=:TaskID";
		Query query = session.createQuery(hql);
		query.setLong("TaskID", TaskID);
		@SuppressWarnings("unchecked")
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
		String hql = "FROM TaskHibernate WHERE zaposlenik=:ZaposlenikID";
		Query query = session.createQuery(hql);
		query.setLong("ZaposlenikID", ZaposlenikID);
		@SuppressWarnings("unchecked")
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
		String hql = "FROM ProjekatHibernate WHERE koordinator=:KoordinatorID";
		Query query = session.createQuery(hql);
		query.setLong("KoordinatorID", KoordinatorID);
		@SuppressWarnings("unchecked")
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
	
	static public ZaposlenikHibernate VratiArhiviraneZaposlenikePoUsername(String username)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE username=:username AND arhiviran = '1'";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		ZaposlenikHibernate result = (ZaposlenikHibernate)query.uniqueResult();
		transaction.commit();
		session.close();
		return result;
	}
	
	static public ZaposlenikHibernate VratiNearhiviraneZaposlenikePoUsername(String username)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE username=:username AND arhiviran = '0'";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		ZaposlenikHibernate result = (ZaposlenikHibernate)query.uniqueResult();
		transaction.commit();
		session.close();
		return result;
	}
	static public AdministratorHibernate VratiAdministratoraPoUsernamu(String username)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM AdministratorHibernate WHERE username=:username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		AdministratorHibernate result = (AdministratorHibernate)query.uniqueResult();
		transaction.commit();
		session.close();
		return result;
	}
	
	static public boolean ValidirajUsername (String username, long id)
	{
		boolean validan = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE username=:username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		@SuppressWarnings("unchecked")
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		if (results.size() != 0)
		{
			Long rezultatID = results.get(0).getId();
			if (!rezultatID.equals(id))
				validan = false;
		}
		return validan;
	}
	
	static public boolean ValidirajUsername (String username)
	{
		boolean validan = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM ZaposlenikHibernate WHERE username=:username";
		Query query = session.createQuery(hql);
		query.setString("username", username);
		@SuppressWarnings("unchecked")
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		if (results.size() != 0)
		{
			validan = false;
		}
		return validan;
	}
	
	static public void IzbirisiZaposlenikoveOdjele (long id)
	{
		ArrayList<OdjelZaposlenikHibernate> ozh = VratiOdjelZaposlenikPoZaposleniku(id);
		for (int i = 0; i < ozh.size(); i++)
		{
			ObrisiObjekat(ozh.get(i));
		}
	}
	
	static public void IzbrisiZaposlenikaIzOdjela (long idZap, long idOdj)
	{
		ArrayList<OdjelZaposlenikHibernate> ozh = VratiOdjelZaposlenikPoZaposleniku(idZap);
		OdjelHibernate oh=new OdjelHibernate();
		oh=DalDao.VratiOdjel(idOdj);
		for (int i = 0; i < ozh.size(); i++)
		{
			if(ozh.get(i).getOdjel()==oh){
				ObrisiObjekat(ozh.get(i));	
			}
			
		}
	}
	static public ArrayList<TimesheetHibernate> VratiTimesheetoveZaposlenika(long zaposlenikId) {
		ArrayList<ProjekatHibernate> temp = VratiZaposlenikoveProjekte(zaposlenikId);
		ArrayList<TimesheetHibernate> timesheets = new ArrayList<TimesheetHibernate>(); 
		for(ProjekatHibernate item : temp) {
			timesheets.addAll(VratiTimesheetoveZaposlenikaNaProjektu(item.getId(), zaposlenikId));
		}
		return timesheets;
	}
	static public ArrayList<TimesheetHibernate> VratiTimesheetoveZaposlenikaZaMjesec(long zaposlenikId, Month mjesec) {
		ArrayList<TimesheetHibernate> filteredTimesheets = new ArrayList<TimesheetHibernate>();
		for(TimesheetHibernate item : VratiTimesheetoveZaposlenika(zaposlenikId)) {
			if(item.getDatumSlanja().getMonth().equals(mjesec)) {
				filteredTimesheets.add(item);
			}
		}
		return filteredTimesheets;
	}
}

