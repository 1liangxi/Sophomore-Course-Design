package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Doctor;
import entity.Prescription;
import service.PatientDAO;
import service.PrescriptionDAO;

public class PrescriptionDAOimpl implements PrescriptionDAO {

	@Override
	public List<Prescription> queryAllPrescription() {
		
		Transaction tx = null;
		List<Prescription> list = null;
		String hql = "from Prescription";
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	@Override
	public Prescription queryPrescriptionByPno(String pno) {
		Transaction tx = null;
		Prescription d;
		String hql = "from Prescription where Pno=?";
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			d = (Prescription)session.get(Prescription.class, pno);
			tx.commit();
			return d;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return null;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}
	
	public Prescription queryPrescriptionByPid(String pid) {
		Transaction tx = null;
		Prescription d;
		String hql = "from Prescription where Pid=?";
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter(0, pid);
			d = (Prescription)q.uniqueResult();
			tx.commit();
			return d;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return null;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	@Override
	public boolean addPrescription(Prescription p) {
		p.setPno(getNewSid());
		Transaction tx =null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(p);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	@Override
	public boolean updatePrescription(Prescription p) {
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(p);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	private String getNewSid()
	{
		Transaction tx = null;
		String hql = "";
		String pid = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select max(mno) from Prescription";
			Query query = session.createQuery(hql);
			pid = (String)query.uniqueResult();
			
			if(pid==null||pid.equals(""))
			{
				pid = "B0000001";
			}
			else
			{
				String temp = pid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				temp = String.valueOf(i);
				int len = temp.length();
				for(int j = 0;j<7-len;j++)
				{
					temp = "0"+temp;
				}
				pid = "B"+temp;
			}
			tx.commit();
			return pid;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return null;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}
	@Override
	public boolean deletePrescription(String pno) {
		Transaction tx = null;
		Prescription d = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			d = (Prescription)session.get(Prescription.class, pno);
			session.delete(d);
			tx.commit();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return false;
		}
		finally
		{
			if(tx!=null)
				tx = null;
		}
	}

	@Override
	public List<Prescription> search_Prescription(String search) {
		Transaction tx = null;
		List<Prescription> list = null;
		String hql = "from Prescription where pno like ? or pid like ?";
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setParameter(0, "%"+search+"%");
			query.setParameter(1, "%"+search+"%");
			list = query.list();
			tx.commit();

			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			tx.commit();
			return list;
		}
		finally
		{
			if(tx!=null)
			{
				tx = null;
			}
		}
	}

	
	
}
