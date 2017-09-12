package action;

import java.util.List;

import service.DoctorDAO;
import service.GuaListDAO;
import service.PatientDAO;
import service.impl.DoctorDAOimpl;
import service.impl.GuaListDAOimpl;
import service.impl.PatientDAOimpl;
import service.impl.RoomDAOimpl;
import entity.Doctor;
import entity.GuaList;
import entity.Patient;
import entity.Room;

public class GuaListAction extends SuperAction {

	public String query()
	{
		GuaListDAO pdao = new GuaListDAOimpl();
		List<GuaList> list = pdao.queryAllGuaList();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("GuaList_List", list);
		}
		
		return "query_success";
	}
	
	public String add()
	{
		GuaListDAO gdao = new GuaListDAOimpl();
		GuaList g = new GuaList();
		DoctorDAOimpl ddao = new DoctorDAOimpl();
		Doctor d = ddao.queryDoctorByPid(request.getParameter("did"));
		RoomDAOimpl rdao = new RoomDAOimpl();
		Room r = rdao.queryRoomByRno(request.getParameter("rno"));
		if(d==null||r==null)
		{
			return "add_fail";
		}
		else
		{
		g.setDid(request.getParameter("did"));
		g.setPrice(request.getParameter("price"));
		g.setRno(request.getParameter("rno"));
		g.setJz(request.getParameter("jz"));
		g.setPname(request.getParameter("pname"));
		g.setFz(request.getParameter("fz"));
		gdao.addGuaList(g);
		return "add_success";
		}
	}
	
	public String delete()
	{
		GuaListDAO ddao = new GuaListDAOimpl();
		String did = request.getParameter("gno");
		ddao.deleteGuaList(did);
		return "delete_success";
	}
	
	public String delectAll()
	{
		int i,len;
		GuaListDAO ddao = new GuaListDAOimpl();
		String[] s = request.getParameterValues("checkbox");
		len = s.length;
		for(i = 0;i<len;i++)
		{
			ddao.deleteGuaList(s[i]);
		}
		return "delect_all_success";
	}
	
	public String queryByDid()
	{
		GuaListDAO ddao = new GuaListDAOimpl();
		String did = request.getParameter("gno");
		GuaList d = ddao.queryGuaListByGno(did);
		session.setAttribute("queryByDid", d);
		return "single_query_success";
		
	}
	
	public String modify()
	{
		GuaListDAO ddao = new GuaListDAOimpl();
		GuaList d = new GuaList();
		
		d.setDid(request.getParameter("did"));
		d.setGno(request.getParameter("gno"));
		d.setRno(request.getParameter("rno"));
		d.setPname(request.getParameter("pname"));
		d.setJz(request.getParameter("jz"));
		d.setFz(request.getParameter("fz"));
		d.setPrice(request.getParameter("price"));
		
		ddao.updateGuaList(d);
		return "modify_success";
	}
	
	public String searchDoctor()
	{
		GuaListDAO ddao = new GuaListDAOimpl();
		String search = request.getParameter("search");
		List<GuaList> list = ddao.search_GuaList(search);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("GuaList_List", list);
			session.setAttribute("tj",search);
			return "search_success";
		}
		else
		{
			return "query_fail";
		}
	}
}
