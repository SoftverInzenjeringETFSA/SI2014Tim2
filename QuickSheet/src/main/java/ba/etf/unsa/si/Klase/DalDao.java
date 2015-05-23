package ba.etf.unsa.si.Klase;

import java.util.ArrayList;
import java.util.LinkedList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.etf.unsa.si.KlaseHibernate.AdministratorHibernate;
import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.TaskHibernate;
import ba.etf.unsa.si.KlaseHibernate.TimesheetHibernate;
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
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikeUOdjelu(long _id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "SELECT zh.*"
				+ "FROM OdjelZaposlenikHibernate ozh, OdjelHibernate oh, ZaposlenikHibernate zh"
				+ "WHERE oh.id=ozh.odjel AND zh.id=ozh.zaposlenikodjela AND oh.id="+_id+"";
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
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
	
	static public ArrayList<ZaposlenikHibernate> VratiZaposlenikeNaProjektu(long _id)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "SELECT DISTINCT zh.*"
				+ "FROM TaskHibernate ozh, ProjekatHibernate oh, ZaposlenikHibernate zh"
				+ "WHERE oh.id=ozh.projekat AND zh.id=ozh.zaposlenik AND oh.id="+_id+""; 
		Query query = session.createQuery(hql);
		ArrayList<ZaposlenikHibernate> results = (ArrayList<ZaposlenikHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}
	
	static public ArrayList<TaskHibernate> VratiTaskoveProjekta(long ProjekatID, long ZaposlenikID)
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

	static public ArrayList<TaskHibernate> VratiTimesheetTaskove(long TimesheetID)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "SELECT DISTINCT zh.*"
				+ "FROM TimesheetTaskHibernate tth, TimesheetHibernate th, TaskHibernate tah"
				+ "WHERE th.id=tth.timesheet AND tah.id=tth.task AND th.id=" + TimesheetID + ""; 
		Query query = session.createQuery(hql);
		ArrayList<TaskHibernate> results = (ArrayList<TaskHibernate>)query.list();
		transaction.commit();
		session.close();
		return results;
	}

}
