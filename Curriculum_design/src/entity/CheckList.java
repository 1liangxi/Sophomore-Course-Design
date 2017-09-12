package entity;

import java.io.Serializable;

public class CheckList  implements Serializable {

	private String lno;
	private String cno;
	private String pid;
	private String cmoney;

	public String getLno() {
		return lno;
	}
	public void setLno(String lno) {
		this.lno = lno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCmoney() {
		return cmoney;
	}
	public void setCmoney(String cmoney) {
		this.cmoney = cmoney;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	
	
}
