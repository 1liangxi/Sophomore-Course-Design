package service;

import java.util.List;

import entity.Patient;

public interface PatientDAO {

	public List<Patient> queryAllPatient();
	
	public Patient queryPatientByPid(String pid);
	
	public boolean addPatient(Patient p);
	
	public boolean updatePatient(Patient p);
	
	public boolean deletePatient(String pid);
	
	public List<Patient> search_Patient(String search);
}
