package staffMS.src.cn.edu.jsu.lzy.pojo;

import java.io.Serializable;

public class Staff implements Serializable {//Serializableʹ�������
	private String company;
	private String department;
	private String stuffNumber;
	private String sex;
	private String name;
	private String entryDate;
	public Staff() {
		super();
		this.company = company;
		this.department = department;
		this.stuffNumber = stuffNumber;
		this.sex = sex;
		this.name = name;
		this.entryDate = entryDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStuffNumber() {
		return stuffNumber;
	}
	public void setStuffNumber(String stuffNumber) {
		this.stuffNumber = stuffNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String toString() {
		return "��˾����=" + company + ", ��������=" + department +", ְ������=" + stuffNumber+ ", �Ա�=" + sex + ", ����=" + name +", ��������=" + entryDate ;
	}



}
