package service;

import java.util.List;

import entity.GuaList;
import entity.Patient;

public interface GuaListDAO {

	public List<GuaList> queryAllGuaList();
	
	public GuaList queryGuaListByGno(String gno);
	
	public boolean addGuaList(GuaList g);
	
	public boolean updateGuaList(GuaList g);
	
	public boolean deleteGuaList(String gno);
	
	public List<GuaList> search_GuaList(String search);
	
}
