package action;

import java.util.List;

import service.PatientDAO;
import service.impl.CheckListDAOimpl;
import service.impl.GuaListDAOimpl;
import service.impl.PatientDAOimpl;
import service.impl.PrescriptionDAOimpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.CheckList;
import entity.GuaList;
import entity.Patient;
import entity.Prescription;

public class PatientAction extends SuperAction {
	
	public String delectAll()
	{
		int i,len;
		PatientDAO pdao = new PatientDAOimpl();
		String[] s = request.getParameterValues("checkbox");
		len = s.length;
		for(i = 0;i<len;i++)
		{
			pdao.deletePatient(s[i]);
		}
		return "delect_all_success";
	}
	
	public String query()
	{
		PatientDAO pdao = new PatientDAOimpl();
		List<Patient> list = pdao.queryAllPatient();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Patient_List", list);
		}
		
		return "query_success";
	}
	
	public String queryByPid()
	{
		PatientDAO pdao = new PatientDAOimpl();
		String pid = request.getParameter("pid");
		Patient p = pdao.queryPatientByPid(pid);
		session.setAttribute("queryByPid", p);
		return "single_query_success";
		
	}
	
	public String delete()
	{
		
		
		PatientDAO pdao = new PatientDAOimpl();
		String pid = request.getParameter("pid");
		
		PrescriptionDAOimpl prdao = new PrescriptionDAOimpl();
		Prescription p = prdao.queryPrescriptionByPid(request.getParameter("pid"));
		
		CheckListDAOimpl cdao = new CheckListDAOimpl();
		CheckList c = cdao.queryCheckListByPid(request.getParameter("pid"));
		
		System.out.println(p);
		System.out.println(c);
		
		if(p!=null||c!=null)
		{
			return "delete_fail";
		}
		else
		{
		pdao.deletePatient(pid);
		return "delete_success";
		}
	}
	
	public String modify()
	{
		PatientDAO pdao = new PatientDAOimpl();
		Patient p = new Patient();
		p.setPid(request.getParameter("pid"));
		p.setPphone(request.getParameter("pphone"));
		p.setPidcard(request.getParameter("pidcard"));
		p.setPage(Integer.valueOf(request.getParameter("page")));
		p.setCphone(request.getParameter("cphone"));
		p.setPaddress(request.getParameter("paddress"));
		p.setCaddress(request.getParameter("caddress"));
		p.setAllergy(request.getParameter("allergy"));
		p.setPid(request.getParameter("pid"));
		p.setBirthday(request.getParameter("birthday"));
		p.setHomeplace(request.getParameter("homeplace"));
		p.setPname(request.getParameter("pname"));
		if(request.getParameter("psex").equals("1"))
		{
			p.setPsex("ÄÐ");
		}
		else
		{	System.out.println(request.getParameter("psex"));
			p.setPsex("Å®");
		}
		pdao.updatePatient(p);
		return "modify_success";
	}
	
	public String add()
	{
		PatientDAO pdao = new PatientDAOimpl();
		Patient p = new Patient();
		GuaListDAOimpl gdao = new GuaListDAOimpl();
		GuaList g = gdao.queryGuaListByGno(request.getParameter("gno"));
		if(g==null)
		{
			return "add_fail";
		}
		else
		{
			int page;
			if(request.getParameter("page").equals(""))
			{
				page = 0;
			}
			else
			{
				page = Integer.valueOf(request.getParameter("page"));
			}
			p.setPid(request.getParameter("pid"));
			p.setPphone(request.getParameter("pphone"));
			p.setPidcard(request.getParameter("pidcard"));
			p.setPage(page);
			
			p.setPid(request.getParameter("pid"));
			p.setBirthday(request.getParameter("birthday"));
			p.setHomeplace(request.getParameter("homeplace"));
			p.setPname(request.getParameter("pname"));
			if(request.getParameter("psex").equals("1"))
			{
				p.setPsex("ÄÐ");
			}
			else
			{	System.out.println(request.getParameter("psex"));
				p.setPsex("Å®");
			}
			pdao.addPatient(p);
			return "add_success";
		}
	}
	
	public String searchPatient()
	{
		PatientDAO pdao = new PatientDAOimpl();
		String search = request.getParameter("search");
		List<Patient> list = pdao.search_Patient(search);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Patient_List", list);
			session.setAttribute("tj",search);
			return "search_success";
		}
		else
		{
			return "query_fail";
		}
	}
	
}
