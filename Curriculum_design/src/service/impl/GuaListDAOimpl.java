package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Doctor;
import entity.GuaList;
import entity.Patient;
import service.GuaListDAO;

public class GuaListDAOimpl implements GuaListDAO {

	@Override
	public List<GuaList> queryAllGuaList() {
		Transaction tx = null;
		List<GuaList> list = null;
		String hql = "from GuaList";
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
	public GuaList queryGuaListByGno(String gno) {
		Transaction tx = null;
		GuaList d;
		String hql = "from GuaList where Mno=?";
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			d = (GuaList)session.get(GuaList.class, gno);
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
	public boolean addGuaList(GuaList g) {
		g.setGno(getNewSid());
		Transaction tx =null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(g);
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
	public boolean updateGuaList(GuaList g) {
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(g);
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
			hql = "select max(gno) from GuaList";
			Query query = session.createQuery(hql);
			pid = (String)query.uniqueResult();
			
			if(pid==null||pid.equals(""))
			{
				pid = "G0000001";
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
				pid = "G"+temp;
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
	public boolean deleteGuaList(String gno) {
		Transaction tx = null;
		GuaList r = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			r = (GuaList)session.get(GuaList.class, gno);
			session.delete(r);
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
	public List<GuaList> search_GuaList(String search) {
		Transaction tx = null;
		List<GuaList> list = null;
		String hql = "from GuaList where gno like ? or pname like ?";
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
