package service;

import java.util.List;

import entity.Doctor;
import entity.Prescription;

public interface PrescriptionDAO {

	public List<Prescription> queryAllPrescription();
	
	public Prescription queryPrescriptionByPno(String pno);
	
	public boolean addPrescription(Prescription p);
	
	public boolean updatePrescription(Prescription p);
	
	public boolean deletePrescription(String pno);
	
	public List<Prescription> search_Prescription(String search);
	
}
