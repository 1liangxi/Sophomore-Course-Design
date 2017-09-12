package action;

import java.util.List;

import service.DoctorDAO;
import service.RoomDAO;
import service.impl.DoctorDAOimpl;
import service.impl.RoomDAOimpl;

import com.opensymphony.xwork2.ActionSupport;

import entity.Doctor;
import entity.Room;

public class RoomAction extends SuperAction {

	public String query()
	{
		RoomDAO rdao = new RoomDAOimpl();
		List<Room> list = rdao.queryAllRoom();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Room_List", list);
		}
		
		return "query_success";
	}
	
	public String queryByRno()
	{
		RoomDAO rdao = new RoomDAOimpl();
		String rno = request.getParameter("rno");
		Room r = rdao.queryRoomByRno(rno);
		session.setAttribute("queryByRno", r);
		return "single_query_success";
		
	}
	
	public String add()
	{
		RoomDAO rdao = new RoomDAOimpl();
		Room d = new Room();
		
		DoctorDAOimpl ddao = new DoctorDAOimpl();
		Doctor doc = ddao.queryDoctorByPid(request.getParameter("did"));
		
		if(doc==null)
		{
			return "add_fail";
		}
		
		d.setDid(request.getParameter("did"));
		d.setRname(request.getParameter("rname"));
		d.setRphone(request.getParameter("rphone"));
		d.setRtime(request.getParameter("rtime"));
		
		rdao.addRoom(d);
		return "add_success";
	}
	
	public String modify()
	{
		RoomDAO rdao = new RoomDAOimpl();
		Room d = new Room();
		
		d.setRno(request.getParameter("rno"));
		d.setDid(request.getParameter("did"));
		d.setRname(request.getParameter("rname"));
		d.setRphone(request.getParameter("rphone"));
		d.setRtime(request.getParameter("rtime"));
		rdao.updateRoom(d);
		return "modify_success";
	}
	
	public String delete()
	{
		RoomDAO rdao = new RoomDAOimpl();
		String did = request.getParameter("did");
		rdao.deleteRoom(did);
		return "delete_success";
	}
	
	public String delectAll()
	{
		int i,len;
		RoomDAO rdao = new RoomDAOimpl();
		String[] s = request.getParameterValues("checkbox");
		len = s.length;
		for(i = 0;i<len;i++)
		{
			rdao.deleteRoom(s[i]);
		}
		return "delect_all_success";
	}
	
	public String searchDoctor()
	{
		RoomDAO rdao = new RoomDAOimpl();
		String search = request.getParameter("search");
		List<Room> list = rdao.search_Doctor(search);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Room_List", list);
			session.setAttribute("tj",search);
			return "search_success";
		}
		else
		{
			return "query_fail";
		}
	}
}
