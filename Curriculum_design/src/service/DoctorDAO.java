package service;

import java.util.List;

import entity.Doctor;


public interface DoctorDAO {
	
	public List<Doctor> queryAllDoctor();
	
	public Doctor queryDoctorByPid(String did);
	
	public boolean addDoctor(Doctor d);
	
	public boolean updateDoctor(Doctor d);
	
	public boolean deleteDoctor(String did);
	
	public List<Doctor> search_Doctor(String search);
}
