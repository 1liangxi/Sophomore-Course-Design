package action;

import java.util.List;

import service.DoctorDAO;
import service.PatientDAO;
import service.impl.DoctorDAOimpl;
import service.impl.PatientDAOimpl;
import entity.Doctor;
import entity.Patient;

public class DoctorAction extends SuperAction {

	public String query()
	{
		DoctorDAO ddao = new DoctorDAOimpl();
		List<Doctor> list = ddao.queryAllDoctor();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Doctor_List", list);
		}
		
		return "query_success";
	}
	
	public String queryByDid()
	{
		DoctorDAO ddao = new DoctorDAOimpl();
		String did = request.getParameter("did");
		Doctor d = ddao.queryDoctorByPid(did);
		session.setAttribute("queryByDid", d);
		return "single_query_success";
		
	}
	
	public String modify()
	{
		DoctorDAO ddao = new DoctorDAOimpl();
		Doctor d = new Doctor();
		
		d.setDid(request.getParameter("did"));
		d.setDidcard(request.getParameter("didcard"));
		d.setDjod(request.getParameter("djod"));
		d.setDname(request.getParameter("dname"));
		d.setDroom(request.getParameter("droom"));
		d.setPhone(request.getParameter("phone"));
		if(request.getParameter("dsex").equals("1"))
		{
			d.setDsex("ÄÐ");
		}
		else
		{	System.out.println(request.getParameter("dsex"));
			d.setDsex("Å®");
		}
		ddao.updateDoctor(d);
		return "modify_success";
	}
	
	public String delete()
	{
		DoctorDAO ddao = new DoctorDAOimpl();
		String did = request.getParameter("did");
		ddao.deleteDoctor(did);
		return "delete_success";
	}
	
	public String delectAll()
	{
		int i,len;
		DoctorDAO ddao = new DoctorDAOimpl();
		String[] s = request.getParameterValues("checkbox");
		len = s.length;
		for(i = 0;i<len;i++)
		{
			ddao.deleteDoctor(s[i]);
		}
		return "delect_all_success";
	}
	
	public String searchDoctor()
	{
		DoctorDAO ddao = new DoctorDAOimpl();
		String search = request.getParameter("search");
		List<Doctor> list = ddao.search_Doctor(search);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Doctor_List", list);
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
		DoctorDAO ddao = new DoctorDAOimpl();
		Doctor d = new Doctor();
		
		
		d.setDid(request.getParameter("did"));
		d.setDidcard(request.getParameter("didcard"));
		d.setDjod(request.getParameter("djid"));
		d.setDname(request.getParameter("dname"));
		d.setDroom(request.getParameter("dname"));
		d.setDsex(request.getParameter("dsex"));
		d.setPhone(request.getParameter("phone"));
		
		if(request.getParameter("dsex").equals("1"))
		{
			d.setDsex("ÄÐ");
		}
		else
		{	System.out.println(request.getParameter("dsex"));
			d.setDsex("Å®");
		}
		ddao.addDoctor(d);
		return "add_success";
	}
}
