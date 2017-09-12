package entity;

public class Patient {

	private String pid;
	private String gno;
	private String pidcard;
	private int page;
	private String allergy;
	private String pname;
	private String psex;
	private String birthday;
	private String homeplace;
	private String pphone;
	private String paddress;
	private String cphone;
	private String caddress;
	
	public Patient()
	{
		
	}

	public Patient(String pid, String pidcard, int page, String allergy,
			String pname, String psex, String birthday, String homeplace,
			String pphone, String paddress, String cphone, String caddress) {
		super();
		this.pid = pid;
		this.pidcard = pidcard;
		this.page = page;
		this.allergy = allergy;
		this.pname = pname;
		this.psex = psex;
		this.birthday = birthday;
		this.homeplace = homeplace;
		this.pphone = pphone;
		this.paddress = paddress;
		this.cphone = cphone;
		this.caddress = caddress;
	}
	
	

	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPidcard() {
		return pidcard;
	}

	public void setPidcard(String pidcard) {
		this.pidcard = pidcard;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPsex() {
		return psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHomeplace() {
		return homeplace;
	}

	public void setHomeplace(String homeplace) {
		this.homeplace = homeplace;
	}

	public String getPphone() {
		return pphone;
	}

	public void setPphone(String pphone) {
		this.pphone = pphone;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getCphone() {
		return cphone;
	}

	public void setCphone(String cphone) {
		this.cphone = cphone;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	
	
	
}
