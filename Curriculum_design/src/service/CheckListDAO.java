package service;

import java.util.List;

import entity.CheckList;
import entity.CheckProject;

public interface CheckListDAO {

	public List<CheckList> queryAllCheckList();
	
	public CheckList queryCheckListByCno(String lno);
	
	public boolean addCheckList(CheckList l);
	
	public boolean updateCheckList(CheckList l);
	
	public boolean deleteCheckList(String lno);
	
	public List<CheckList> search_CheckList(String search);
}
