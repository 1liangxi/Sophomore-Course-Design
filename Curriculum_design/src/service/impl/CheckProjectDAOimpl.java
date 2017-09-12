package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.CheckProject;
import entity.Doctor;
import entity.Room;
import service.CheckProjectDAO;

public class CheckProjectDAOimpl implements CheckProjectDAO {

	@Override
	public List<CheckProject> queryAllCheckProject() {
		Transaction tx = null;
		List<CheckProject> list = null;
		String hql = "from CheckProject";
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
	public CheckProject queryCheckProjectByCno(String cno) {
		Transaction tx = null;
		CheckProject d;
		String hql = "from CheckProject where cno=?";
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			d = (CheckProject)session.get(CheckProject.class, cno);
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
	public boolean addCheckProject(CheckProject c) {
		c.setCno(getNewSid());
		Transaction tx =null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(c);
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
	public boolean updateCheckProject(CheckProject c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCheckProject(String cno) {
		Transaction tx = null;
		CheckProject d = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			d = (CheckProject)session.get(CheckProject.class, cno);
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
	public List<CheckProject> search_CheckProject(String search) {
		Transaction tx = null;
		List<CheckProject> list = null;
		String hql = "from CheckProject where cno like ? or cname like ?";
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
	
	
	
	private String getNewSid()
	{
		Transaction tx = null;
		String hql = "";
		String pid = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "select max(cno) from CheckProject";
			Query query = session.createQuery(hql);
			pid = (String)query.uniqueResult();
			
			if(pid==null||pid.equals(""))
			{
				pid = "C0000001";
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
				pid = "C"+temp;
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
}
