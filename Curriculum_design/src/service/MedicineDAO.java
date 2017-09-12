package service;

import java.util.List;

import entity.Medicine;

public interface MedicineDAO {

	public List<Medicine> queryAllMedicine();
	
	public Medicine queryMedicineByMno(String Mno);
	
	public boolean addMedicine(Medicine m);
	
	public boolean updateMedicine(Medicine m);
	
	public boolean deleteMedicine(String mno);
	
	public List<Medicine> search_Medicine(String search);
}
