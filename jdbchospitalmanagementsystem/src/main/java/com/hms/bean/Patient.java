/**
 * @author  yeshwanth
 * sushma
 * chandan
 * utkarsh
 * this is patient class used to dclare variables 
 */
package com.hms.bean;

public class Patient {
	private int pid;

	private String pname;
	private String paddress;
	private int age;
	private String gender;
	private String pdisease;
	private String bloodgroup;
	private int did;

	public Patient() {
	};

	public Patient(int pid, String pname, String paddress, int age, String gender, String pdisease, String bloodgroup,
			int did) {
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.age = age;
		this.gender = gender;
		this.pdisease = pdisease;
		this.bloodgroup = bloodgroup;
		this.did = did;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPdisease() {
		return pdisease;
	}

	public void setPdisease(String pdisease) {
		this.pdisease = pdisease;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String toString() {
		return pid + "\t" + pname + "\t" + paddress + "\t" + age + "\t" + gender + "\t" + pdisease + "\t" + bloodgroup;
	}

}
