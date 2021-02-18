/**
 * @author yeshwanth
 * sushma
 * chandan
 * utkarsh
 * this is doctor class used to declare variables used for doctor
 */
package com.hms.bean;

public class Doctor {
	private int did;
	private String dname;
	private String dgender;
	private String dqualification;
	private int dfees;
	private String daddress;
	private int dslots;
	public Doctor(){};
	public Doctor(int did, String dname, String dgender, String dqualification, int dfees, String daddress,int dslots) {
		
		this.did = did;
		this.dname = dname;
		this.dgender = dgender;
		this.dqualification = dqualification;
		this.dfees = dfees;
		this.daddress = daddress;
		this.dslots=dslots;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDgender() {
		return dgender;
	}
	public void setDgender(String dgender) {
		this.dgender = dgender;
	}
	public String getDqualification() {
		return dqualification;
	}
	public void setDqualification(String dqualification) {
		this.dqualification = dqualification;
	}
	public int getDfees() {
		return dfees;
	}
	public void setDfees(int dfees) {
		this.dfees = dfees;
	}
	public String getDaddress() {
		return daddress;
	}
	public void setDaddress(String daddress) {
		this.daddress = daddress;
	}
	
	public int getDslots() {
		return dslots;
	}
	public void setDslots(int dslots) {
		this.dslots = dslots;
	}
	public String toString()
	{
		return did+"\t"+dname+"\t"+dgender+"\t"+dqualification+"\t"+dfees+"\t"+daddress;
	}

}
