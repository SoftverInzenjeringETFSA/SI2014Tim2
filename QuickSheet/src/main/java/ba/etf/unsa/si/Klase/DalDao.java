package ba.etf.unsa.si.Klase;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ba.etf.unsa.si.KlaseHibernate.OdjelHibernate;
import ba.etf.unsa.si.KlaseHibernate.ProjekatHibernate;
import ba.etf.unsa.si.KlaseHibernate.ZaposlenikHibernate;
import ba.etf.unsa.si.util.HibernateUtil;

public class DalDao {
	
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
	
	
}
