package action;

import java.util.List;

import service.DoctorDAO;
import service.PrescriptionDAO;
import service.impl.DoctorDAOimpl;
import service.impl.MedicineDAOimpl;
import service.impl.PatientDAOimpl;
import service.impl.PrescriptionDAOimpl;
import entity.Doctor;
import entity.Medicine;
import entity.Patient;
import entity.Prescription;

public class PrescriptionAction extends SuperAction  {

	public String query()
	{
		PrescriptionDAO ddao = new  PrescriptionDAOimpl();
		List<Prescription> list = ddao.queryAllPrescription();
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Prescription_List", list);
		}
		
		return "query_success";
	}
	
	
	public String queryByPno()
	{
		PrescriptionDAO ddao = new PrescriptionDAOimpl();
		String did = request.getParameter("pno");
		Prescription d = ddao.queryPrescriptionByPno(did);
		session.setAttribute("queryByDid", d);
		return "single_query_success";
		
	}
	
	public String modify()
	{
		PrescriptionDAO ddao = new PrescriptionDAOimpl();
		Prescription d = new Prescription();
		
		d.setPno(request.getParameter("pno"));
		d.setMno(request.getParameter("mno"));
		d.setPrice(Integer.valueOf(request.getParameter("price")));
		d.setPid(request.getParameter("pid"));
		
		
		ddao.updatePrescription(d);
		return "modify_success";
	}
	
	public String delete()
	{
		PrescriptionDAO ddao = new PrescriptionDAOimpl();
		String did = request.getParameter("pno");
		ddao.deletePrescription(did);
		return "delete_success";
	}
	
	public String delectAll()
	{
		int i,len;
		PrescriptionDAO ddao = new PrescriptionDAOimpl();
		String[] s = request.getParameterValues("checkbox");
		len = s.length;
		for(i = 0;i<len;i++)
		{
			ddao.deletePrescription(s[i]);
		}
		return "delect_all_success";
	}
	
	public String searchDoctor()
	{
		PrescriptionDAO ddao = new PrescriptionDAOimpl();
		String search = request.getParameter("search");
		List<Prescription> list = ddao.search_Prescription(search);
		if(list!=null&&list.size()>0)
		{
			session.setAttribute("Prescription_List", list);
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
		PrescriptionDAO ddao = new PrescriptionDAOimpl();
		Prescription d = new Prescription();
		PatientDAOimpl pdao = new PatientDAOimpl();
		Patient pat = pdao.queryPatientByPid(request.getParameter("pid"));
		
		MedicineDAOimpl mdao = new MedicineDAOimpl();
		Medicine m = mdao.queryMedicineByMno(request.getParameter("mno"));
		
		if(pat==null||m==null)
		{
			return "add_fail";
		}
		
		d.setPid(request.getParameter("pid"));
		d.setPrice(Integer.valueOf(request.getParameter("price")));
		d.setMno(request.getParameter("mno"));
		ddao.addPrescription(d);
		return "add_success";
	}
}
