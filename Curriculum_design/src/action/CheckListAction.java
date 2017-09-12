package action;

import java.util.List;

import service.CheckListDAO;
import service.CheckProjectDAO;
import service.impl.CheckListDAOimpl;
import service.impl.CheckProjectDAOimpl;
import service.impl.PatientDAOimpl;
import entity.CheckList;
import entity.CheckProject;
import entity.Patient;

public class CheckListAction extends SuperAction {

	public String query()
	{
		CheckListDAO rdao = new CheckListDAOimpl();
		List<CheckList> list = rdao.queryAllCheckList();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("CheckList_List", list);
		}
		
		return "query_success";
	}
	
	public String add()
	{
		CheckListDAO pdao = new CheckListDAOimpl();
		CheckList p = new CheckList();
		
		CheckProjectDAOimpl cdao = new CheckProjectDAOimpl();
		CheckProject c = cdao.queryCheckProjectByCno(request.getParameter("cno"));
		
		PatientDAOimpl pi = new PatientDAOimpl();
		Patient pa = pi.queryPatientByPid(request.getParameter("pid"));
		
		if(c==null||pa==null)
		{
			return "add_fail";
		}
		else
		{
			p.setCno(request.getParameter("cno"));
			p.setCmoney(request.getParameter("cmoney"));
			p.setPid(request.getParameter("pid"));
			
			pdao.addCheckList(p);
			return "add_success";
		}
	}
	
	public String searchDoctor()
	{
		CheckListDAO rdao = new CheckListDAOimpl();
		String search = request.getParameter("search");
		List<CheckList> list = rdao.search_CheckList(search);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("CheckList_List", list);
			session.setAttribute("tj",search);
			return "search_success";
		}
		else
		{
			return "query_fail";
		}
	}
}
