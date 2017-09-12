package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import db.MyHibernateSessionFactory;
import entity.Doctor;
import entity.Room;
import service.RoomDAO;

public class RoomDAOimpl implements RoomDAO {

	@Override
	public List<Room> queryAllRoom() {
		Transaction tx = null;
		List<Room> list = null;
		String hql = "from Room";
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
	public Room queryRoomByRno(String rno) {
		Transaction tx = null;
		Room r;
		String hql = "from Room where Rno=?";
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			r = (Room)session.get(Room.class,rno);
			tx.commit();
			return r;
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
	public boolean addRoom(Room d) {
		d.setRno(getNewSid());
		Transaction tx =null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(d);
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
			hql = "select max(rno) from Room";
			Query query = session.createQuery(hql);
			pid = (String)query.uniqueResult();
			
			if(pid==null||pid.equals(""))
			{
				pid = "R0000001";
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
				pid = "R"+temp;
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
	public boolean updateRoom(Room d) {
		Transaction tx = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(d);
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
	public boolean deleteRoom(String rno) {
		Transaction tx = null;
		Room d = null;
		try
		{
			Session session = MyHibernateSessionFactory.getsessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			d = (Room)session.get(Room.class, rno);
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
	public List<Room> search_Doctor(String search) {
		Transaction tx = null;
		List<Room> list = null;
		String hql = "from Room where rno like ? or rname like ?";
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
