package com.hms.bean;
/**
 * 
 * @author yeshwanth
 * sushma
 * chandan
 * utkarsh
 *this is account class used toadd variables of account table
 */
public class Account {
	private int billid;

	private String patientname;
	private String doctorname;
	private int totalbill;
	private int pid;
	private String uname;
	private String password;
	

	public Account() {
	};

	public Account(int billid, String patientname, String doctorname, int totalbill,int pid,String uname,String password) {

		this.billid = billid;
		this.patientname = patientname;
		this.doctorname = doctorname;
		this.totalbill = totalbill;
		this.pid=pid;
	}

	public int getBillid() {
		return billid;
	}

	public void setBillid(int billid) {
		this.billid = billid;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public int getTotalbill() {
		return totalbill;
	}

	public void setTotalbill(int totalbill) {
		this.totalbill = totalbill;
	}
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Account [billid=" + billid + ", patientname=" + patientname + ", doctorname=" + doctorname
				+ ", totalbill=" + totalbill + "]";

	}
}