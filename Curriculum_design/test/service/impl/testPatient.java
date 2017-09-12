package service.impl;

import java.util.List;

import org.junit.Test;

import entity.Patient;
import service.PatientDAO;

public class testPatient {

	@Test
	public void testqueryAllPatient()
	{
		PatientDAO pdao = new PatientDAOimpl();
		List<Patient> list = pdao.queryAllPatient();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
}
