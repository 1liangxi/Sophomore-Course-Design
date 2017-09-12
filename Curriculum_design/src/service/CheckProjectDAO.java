package service;

import java.util.List;

import entity.CheckProject;
import entity.Patient;

public interface CheckProjectDAO {
	
	public List<CheckProject> queryAllCheckProject();
	
	public CheckProject queryCheckProjectByCno(String cno);
	
	public boolean addCheckProject(CheckProject c);
	
	public boolean updateCheckProject(CheckProject c);
	
	public boolean deleteCheckProject(String cno);
	
	public List<CheckProject> search_CheckProject(String search);

}
