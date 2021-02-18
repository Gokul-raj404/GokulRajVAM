package com.hms.Dao;
/**
 * this is an interface used to register all the required methods
 */

import java.util.List;

import org.apache.log4j.Logger;

import com.hms.bean.Account;
import com.hms.bean.Doctor;
import com.hms.bean.Patient;
import com.hms.bean.Users;

public interface HmsDao {
	public String login(String uname,String pwd);
	
	static Logger logger = Logger.getLogger(HmsDao.class);
	public String register(Users u);
	public String addDoctor();
	public Doctor viewDoctor(int did);
	public List<Doctor> viewAllDoctors();
	public String updateDoctor(int did);
	public String deleteDoctor(int did);
	
	
	public String addPatient();
	public Patient viewPatient(int pid);
	public List<Patient> viewAllPatients();
	public String updatePatient(int pid);
	public void bookSlot();
	public void cancelSlot();
	public void bill();
	public void back();
	
	
	
	

}
