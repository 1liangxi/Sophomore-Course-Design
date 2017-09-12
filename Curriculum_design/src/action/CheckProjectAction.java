package action;

import java.util.List;

import service.CheckProjectDAO;
import service.PatientDAO;
import service.RoomDAO;
import service.impl.CheckProjectDAOimpl;
import service.impl.PatientDAOimpl;
import service.impl.RoomDAOimpl;
import entity.CheckProject;
import entity.Patient;
import entity.Room;

public class CheckProjectAction extends SuperAction {

	public String query()
	{
		CheckProjectDAO rdao = new CheckProjectDAOimpl();
		List<CheckProject> list = rdao.queryAllCheckProject();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("CheckProject_List", list);
		}
		
		return "query_success";
	}
	
	public String delete()
	{
		CheckProjectDAO rdao = new CheckProjectDAOimpl();
		String did = request.getParameter("did");
		rdao.deleteCheckProject(did);
		return "delete_success";
	}
	
	public String delectAll()
	{
		int i,len;
		CheckProjectDAO rdao = new CheckProjectDAOimpl();
		String[] s = request.getParameterValues("checkbox");
		len = s.length;
		for(i = 0;i<len;i++)
		{
			rdao.deleteCheckProject(s[i]);
		}
		return "delect_all_success";
	}
	
	public String searchDoctor()
	{
		CheckProjectDAO rdao = new CheckProjectDAOimpl();
		String search = request.getParameter("search");
		List<CheckProject> list = rdao.search_CheckProject(search);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("CheckProject_List", list);
			session.setAttribute("tj",search);
			return "search_success";
		}
		else
		{
			return "query_fail";
		}
	}
	
	public String add()
	{
		CheckProjectDAO pdao = new CheckProjectDAOimpl();
		CheckProject p = new CheckProject();
		
		
		p.setCno(request.getParameter("cno"));
		p.setCname(request.getParameter("cname"));
		p.setMoney(request.getParameter("money"));
		p.setNotes(request.getParameter("notes"));
		
		pdao.addCheckProject(p);
		return "add_success";
	}
}
