package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.CheckList;
import entity.CheckProject;
import entity.Prescription;
import service.CheckListDAO;

public class CheckListDAOimpl implements CheckListDAO {

	@Override
	public List<CheckList> queryAllCheckList() {
		Transaction tx = null;
		List<CheckList> list = null;
		String hql = "from CheckList";
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
	public CheckList queryCheckListByCno(String lno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCheckList(CheckList l) {
		l.setLno(getNewSid());
		Transaction tx =null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(l);
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
	public boolean updateCheckList(CheckList l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCheckList(String lno) {
		// TODO Auto-generated method stub
		return false;
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
			hql = "select max(lno) from CheckList";
			Query query = session.createQuery(hql);
			pid = (String)query.uniqueResult();
			
			if(pid==null||pid.equals(""))
			{
				pid = "L0000001";
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
				pid = "L"+temp;
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
	public List<CheckList> search_CheckList(String search) {
		Transaction tx = null;
		List<CheckList> list = null;
		String hql = "from CheckList where lno like ? or cno like ?";
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
	
	public CheckList queryCheckListByPid(String pid) {
		Transaction tx = null;
		CheckList d;
		String hql = "from CheckList where Pid=?";
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter(0, pid);
			d = (CheckList)q.uniqueResult();
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

}
