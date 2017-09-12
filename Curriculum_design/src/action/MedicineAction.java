package action;

import java.util.List;

import service.CheckProjectDAO;
import service.MedicineDAO;
import service.PatientDAO;
import service.impl.CheckProjectDAOimpl;
import service.impl.MedicineDAOimpl;
import service.impl.PatientDAOimpl;
import entity.CheckProject;
import entity.Medicine;
import entity.Patient;

public class MedicineAction extends SuperAction {

	public String query()
	{
		MedicineDAO pdao = new MedicineDAOimpl();
		List<Medicine> list = pdao.queryAllMedicine();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Medicine_List", list);
		}
		
		return "query_success";
	}
	
	public String delete()
	{
		MedicineDAO rdao = new MedicineDAOimpl();
		String did = request.getParameter("did");
		rdao.deleteMedicine(did);
		return "delete_success";
	}
	
	public String delectAll()
	{
		int i,len;
		MedicineDAO rdao = new MedicineDAOimpl();
		String[] s = request.getParameterValues("checkbox");
		len = s.length;
		for(i = 0;i<len;i++)
		{
			rdao.deleteMedicine(s[i]);
		}
		return "delect_all_success";
	}
	
	public String searchDoctor()
	{
		MedicineDAO mdao = new MedicineDAOimpl();
		String search = request.getParameter("search");
		List<Medicine> list = mdao.search_Medicine(search);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Medicine_List", list);
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
		MedicineDAO pdao = new MedicineDAOimpl();
		Medicine p = new Medicine();
		
		
		p.setMno(request.getParameter("mno"));
		p.setMname(request.getParameter("mname"));
		p.setPrice(request.getParameter("price"));
		p.setNotes(request.getParameter("notes"));
		
		pdao.addMedicine(p);
		return "add_success";
	}
}
