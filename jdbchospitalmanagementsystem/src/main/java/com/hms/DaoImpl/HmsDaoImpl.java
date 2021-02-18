package com.hms.DaoImpl;
/**
 * @author yeshwanth
 * sushma
 * chandan
 * utkarsh
 * this is an implementation class used to implement all the registered methods
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.hms.Dao.HmsDao;
import com.hms.bean.Account;
import com.hms.bean.Doctor;
import com.hms.bean.Patient;
import com.hms.bean.Users;
import com.hms.db.HmsUtil;
import com.hms.main.HospitalManagement;

public class HmsDaoImpl implements HmsDao {
	static List<Doctor> doctors = new ArrayList<Doctor>();
	static List<Patient> patients = new ArrayList<Patient>();
	static List<Account> accounts = new ArrayList<Account>();
	static Logger logger = Logger.getLogger(HmsDaoImpl.class);
	Scanner sc = new Scanner(System.in);
	Connection con = HmsUtil.getConnection();
	static Set<Users> users = new HashSet<Users>();
	PreparedStatement ps = null;
	Doctor doctor = null;
	Patient patient = null;
	Account account = null;
	ResultSet rs = null;

	@Override
	public String addDoctor() {
		/**
		 * used to add details of doctors
		 */
		logger.info("ADD METHOD CALLED");
		int i = 1, n = 0;
		String message = null;

		try {
			while (i == 1) {
				doctor = new Doctor();
				/*
				 * System.out.println("Enter Doctor id ?");
				 * doctor.setDid(sc.nextInt());
				 */
				System.out.println("Enter Doctor name ?");
				doctor.setDname(sc.next());
				System.out.println("Enter gender of doctor ?");
				doctor.setDgender(sc.next());
				System.out.println("Enter qualification of doctor?");
				doctor.setDqualification(sc.next());
				System.out.println("Enter fees of doctor?");
				doctor.setDfees(sc.nextInt());
				System.out.println("Enter address of doctor?");
				doctor.setDaddress(sc.next());
				System.out.println("Enter slots of doctor?");
				doctor.setDslots(sc.nextInt());

				ps = con.prepareStatement(
						"insert into doctor(dname,dgender,dqualification,dfees,daddress,dslots) values(?,?,?,?,?,?)");

				ps.setString(1, doctor.getDname());
				ps.setString(2, doctor.getDgender());
				ps.setString(3, doctor.getDqualification());
				ps.setInt(4, doctor.getDfees());
				ps.setString(5, doctor.getDaddress());
				ps.setInt(6, doctor.getDslots());

				n = ps.executeUpdate();
				System.out.println("Do you want to add more doctor details, press 1 or else any number?");
				i = sc.nextInt();

			}
		} catch (SQLException e) {
			logger.warn("ADD METHOD EXCEPTION HANDLED");
			e.printStackTrace();
		}
		if (n != 0) {
			message = "successfully doctor details added...";
		} else {
			message = "Not able to insert.please try again...";
		}
		return message;

	}

	@Override
	public Doctor viewDoctor(int did) {
		/**
		 * used to view a specific doctor
		 */
		logger.info("VIEW METHOD CALLED");
		doctor = new Doctor();
		try {
			ps = con.prepareStatement("select * from doctor where did=?");
			ps.setInt(1, did);
			rs = ps.executeQuery();
			while (rs.next()) {
				doctor.setDid(rs.getInt(1));
				doctor.setDname(rs.getString(2));
				doctor.setDgender(rs.getString(3));
				doctor.setDqualification(rs.getString(4));
				doctor.setDfees(rs.getInt(5));
				doctor.setDaddress(rs.getString(6));
				doctor.setDslots(rs.getInt(7));

			}
		} catch (SQLException e) {
			logger.warn("VIEW METHOD EXCEPTION HANDLED");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doctor;
	}

	@Override
	public List<Doctor> viewAllDoctors() {
		/**
		 * this method is used to view all the registered doctors
		 */
		logger.info("VIEWALL METHOD CALLED");
		doctors = new ArrayList<Doctor>();
		try {
			ps = con.prepareStatement("select * from doctor");
			rs = ps.executeQuery();
			while (rs.next()) {
				doctor = new Doctor();
				doctor.setDid(rs.getInt(1));
				doctor.setDname(rs.getString(2));
				doctor.setDgender(rs.getString(3));
				doctor.setDqualification(rs.getString(4));
				doctor.setDfees(rs.getInt(5));
				doctor.setDaddress(rs.getString(6));
				doctor.setDslots(rs.getInt(7));
				doctors.add(doctor);
			}
		} catch (SQLException e) {
			logger.warn("VIEWALL METHOD EXCEPTION HANDLED");
			e.printStackTrace();
		}
		return doctors;
	}

	@Override
	public String updateDoctor(int did) {
		/***
		 * this method is used to update details of doctor
		 */
		logger.info("UPDATEDOCTOR METHOD CALLED");
		int n = 0;
		String result = null;
		try {
			System.out.println("Select Your Choice : 1. Qualification 2.  Fees 3. Address 4.Slots?");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				ps = con.prepareStatement("update doctor set dqualification=? where did=?");
				System.out.println("Enter Docotor Qualification ?");
				String qualification = sc.next();
				ps.setString(1, qualification);
				ps.setInt(2, did);
				n = ps.executeUpdate();
				break;
			case 2:
				ps = con.prepareStatement("update doctor set dfees=? where did=?");
				System.out.println("Enter Doctor Fees ?");
				int fees = sc.nextInt();
				ps.setInt(1, fees);
				ps.setInt(2, did);
				n = ps.executeUpdate();
				break;
			case 3:
				ps = con.prepareStatement("update doctor set daddress=? where did=?");
				String address = sc.next();
				ps.setString(1, address);
				ps.setInt(2, did);
				n = ps.executeUpdate();
				break;
			case 4:
				ps = con.prepareStatement("update doctor set dslots=? where did=?");
				System.out.println("Enter Doctor Slots ?");
				ps.setInt(1, sc.nextInt());
				ps.setInt(2, did);
				n = ps.executeUpdate();
				break;

			default:
				System.out.println("Please select Your choice range 1-4 only");
			}

			if (n != 0) {
				result = "Successfully Doctor details Updated....";
			} else {
				result = "Notable to Updated.Please try again...";
			}

		} catch (SQLException e) {
			logger.warn("UPDATEDOCTOR METHOD EXCEPTION HANDLED");
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String deleteDoctor(int did) {
		/**
		 * this method is used to delete details of specific doctor
		 */
		logger.info("DELETEDOCTOR METHOD CALLED");
		int n = 0;
		String msg = null;
		try {
			ps = con.prepareStatement("delete from doctor where did= ?");
			ps.setInt(1, did);
			n = ps.executeUpdate();

			if (n != 0) {
				msg = "Successfully doctor details deleted...";
			} else {
				msg = "Not able to deleted.Please try again";
			}
		} catch (SQLException e) {
			logger.warn("DELETEDOCTOR METHOD EXCEPTION HANDLED");
			e.printStackTrace();
		}
		return msg;

	}

	@Override
	public String addPatient() {
		/**
		 * this method is used to add details of doctor
		 */
		logger.info("ADD PATIENT METHOD CALLED");
		int i = 1, n = 0 ;
		String message = null;

		try {
			while (i == 1) {
				patient = new Patient();
				System.out.println("Enter patient id ?");
				patient.setPid(sc.nextInt());
				System.out.println("Enter patient name ?");
				patient.setPname(sc.next());
				System.out.println("Enter patient address ?");
				patient.setPaddress(sc.next());
				System.out.println("Enter patient age ?");
				patient.setAge(sc.nextInt());
				System.out.println("Enter gender of patient ?");
				patient.setGender(sc.next());
				System.out.println("Enter disease of patient?");
				patient.setPdisease(sc.next());
				System.out.println("Enter blood group of patient?");
				patient.setBloodgroup(sc.next());
				System.out.println("Enter id of doctor?");
				patient.setDid(sc.nextInt());

				ps = con.prepareStatement(
						"insert into patient(pid,pname,paddress,age,gender,pdisease,bloodgroup,did) values(?,?,?,?,?,?,?,?)");
				ps.setInt(1, patient.getPid());
				ps.setString(2, patient.getPname());
				ps.setString(3, patient.getPaddress());
				ps.setInt(4, patient.getAge());
				ps.setString(5, patient.getGender());
				ps.setString(6, patient.getPdisease());
				ps.setString(7, patient.getBloodgroup());
				ps.setInt(8, patient.getDid());
				n = ps.executeUpdate();
				System.out.println("Do you want to add more patient details, press 1 or else any number?");
				i = sc.nextInt();

			}
		} catch (SQLException e) {
			logger.warn("ADDPATIENT METHOD EXCEPTION HANDLED");
			e.printStackTrace();
		}
		if (n != 0) {
			message = "successfully patient details added...";
		} else {
			message = "Not able to insert.please try again...";
		}
		return message;

	}

	@Override
	public Patient viewPatient(int pid) {
		/**
		 * this method is used to view detailds of specific details
		 */
		logger.info("VIEWPATIENT METHOD CALLED");
		patient = new Patient();
		try {
			ps = con.prepareStatement("select * from patient where pid=?");
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				patient.setPid(rs.getInt(1));
				patient.setPname(rs.getString(2));
				patient.setPaddress(rs.getString(3));
				patient.setAge(rs.getInt(4));
				patient.setGender(rs.getString(5));
				patient.setPdisease(rs.getString(6));
				patient.setBloodgroup(rs.getString(7));
				patient.setDid(rs.getInt(8));
			}

		} catch (SQLException e) {
			logger.warn("VIEWPATIENT METHOD EXCEPTION HANDLED");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return patient;
	}

	@Override
	public List<Patient> viewAllPatients() {
		/**
		 * this method is used to view list of all specific details
		 */
		logger.info("VIEWALLPATIENT METHOD CALLED");

		patients = new ArrayList<Patient>();

		try {
			ps = con.prepareStatement("select * from patient");
			rs = ps.executeQuery();
			while (rs.next()) {
				patient = new Patient();
				patient.setPid(rs.getInt(1));
				patient.setPname(rs.getString(2));
				patient.setPaddress(rs.getString(3));
				patient.setAge(rs.getInt(4));
				patient.setGender(rs.getString(5));
				patient.setPdisease(rs.getString(6));
				patient.setBloodgroup(rs.getString(7));
				patient.setDid(rs.getInt(8));
				patients.add(patient);
			}
		} catch (SQLException e) {
			logger.warn("VIEWALLPATIENT METHOD EXCEPTION HANDLED");
			e.printStackTrace();
		}
		return patients;

	}

	@Override
	public String updatePatient(int pid) {
		/**
		 * this method is used to update details of patients
		 */
		logger.info("UPDATEPATIENT METHOD CALLED");

		int n = 0;
		String result = null;
		try {
			System.out.println("Select Your Choice : 1.Address  2.  Age 3. Disease ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				ps = con.prepareStatement("update patient set paddress=? where pid=?");
				System.out.println("enter patient address");
				String address = sc.next();
				ps.setString(1, address);
				ps.setInt(2, pid);
				n = ps.executeUpdate();
				break;
			case 2:
				ps = con.prepareStatement("update patient set age=? where pid=?");
				System.out.println("enter patient age");
				int age = sc.nextInt();
				ps.setInt(1, age);
				ps.setInt(2, pid);
				n = ps.executeUpdate();
				break;
			case 3:
				ps = con.prepareStatement("update patient set pdisease=? where pid=?");
				System.out.println("enter patient disease");
				String disease = sc.next();
				ps.setString(1, disease);
				ps.setInt(2, pid);
				n = ps.executeUpdate();
				break;
			default:
				System.out.println("Please select Your choice range 1-3 only");

			}
			if (n != 0) {
				result = "Successfully Patient Details Updated....";
			} else {
				result = "Notable to Updated.Please try again...";
			}
		} catch (SQLException e) {
			logger.warn("UPDATE PATIENT METHOD EXCEPTION HANDLED");
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public void bookSlot() {
		/**this method is used for patient to book slot of doctor. if available
		 * 
		 */
		logger.info("BOOKSLOT METHOD IS CALLED");
		int n = 0, i = 1;

		try {
			ps = con.prepareStatement("select * from doctor");
			rs = ps.executeQuery();
			while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getString(6) + "\t" + rs.getInt(7));
			}
			Doctor Doctor = new Doctor();
			System.out.println("Enter doctor id ?");
			Doctor.setDid(sc.nextInt());
			System.out.println("Enter doctor slot ?");
			Doctor.setDslots(sc.nextInt());
			ps = con.prepareStatement("select * from doctor where did=?");
			ps.setInt(1, Doctor.getDid());
			rs = ps.executeQuery();
			rs.next();

			if (Doctor.getDslots() != 0) {
				ps = con.prepareStatement("update doctor set dslots=? where did = ?");
				ps.setInt(1, rs.getInt(7) - Doctor.getDslots());
				ps.setInt(2, Doctor.getDid());
				n = ps.executeUpdate();

				System.out.println("------------------------------");
				System.out.println("|          BOOKED SLOT         |");
				System.out.println("------------------------------");
				System.out.println("Doctor Id            :   " + Doctor.getDid());
				System.out.println("Doctor Name          :   " + rs.getString(2));
				System.out.println("Doctor qualification :   " + rs.getString(4));
				System.out.println("Doctor fees          :   " + rs.getInt(5));

			}
						else {
				System.out.println("your slot is not booked . please try again");
			}
			System.out.println("Do you want to book more slots press 1 else any number");
			i = sc.nextInt();

		} catch (SQLException e) {
			logger.warn("BOOKSLOT METHOD EXCEPTION HANDLED");	// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void cancelSlot() {
		/**
		 * this method is used to cancel the booked slot
		 */
		logger.info("CANCELSLOT METHOD IS CALLED");
		int n = 0, i = 1;

		try {
			ps = con.prepareStatement("select * from doctor");
			rs = ps.executeQuery();
			while (rs.next()) {

				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
						+ rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getString(6) + "\t" + rs.getInt(7));
			}
			Doctor Doctor = new Doctor();
			System.out.println("Enter doctor id ?");
			Doctor.setDid(sc.nextInt());
			System.out.println("Enter doctor slot ?");
			Doctor.setDslots(sc.nextInt());
			ps = con.prepareStatement("select * from doctor where did=?");
			ps.setInt(1, Doctor.getDid());
			rs = ps.executeQuery();
			rs.next();

			if (Doctor.getDslots() != 0) {
				ps = con.prepareStatement("update doctor set dslots=? where did = ?");
				ps.setInt(1, rs.getInt(7) + Doctor.getDslots());
				ps.setInt(2, Doctor.getDid());
				n = ps.executeUpdate();
				System.out.println("Your slot is cancelled.");

				System.out.println("------------------------------");
				System.out.println("|          CANCELLED SLOT         |");
				System.out.println("------------------------------");
				System.out.println("Doctor Id            :   " + Doctor.getDid());
				System.out.println("Doctor Name          :   " + rs.getString(2));
				System.out.println("Doctor qualification :   " + rs.getString(4));
				System.out.println("Doctor fees          :   " + rs.getInt(5));

			}

			else {
				System.out.println("your slot is not cancelled . please try again");
			}
			System.out.println("Do you want to book more slots press 1 else any number");
			i = sc.nextInt();

		} catch (SQLException e) {
			logger.warn("CANCELSLOT METHOD EXCEPTION HANDLED");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void bill() {
		/**
		 * this method is used to generate the bill of the patient
		 */
		logger.info("BILL METHOD IS CALLED");
		int i = 1, n = 0;

		try {
			while (i == 1) {
				account = new Account();
				System.out.println("Enter bill id ?");
				account.setBillid(sc.nextInt());
				System.out.println("Enter patient name ?");
				account.setPatientname(sc.next());
				System.out.println("Enter Doctor name ?");
				account.setDoctorname(sc.next());
				System.out.println("Enter total bill ?");
				account.setTotalbill(sc.nextInt());
				System.out.println("Enter id of patient?");
				account.setPid(sc.nextInt());

				ps = con.prepareStatement(
						"insert into account(billid,patientname,doctorname,totalbill,pid) values(?,?,?,?,?)");
				ps.setInt(1, account.getBillid());
				ps.setString(2, account.getPatientname());
				ps.setString(3, account.getDoctorname());
				ps.setInt(4, account.getTotalbill());
				ps.setInt(5, account.getPid());
				n = ps.executeUpdate();
				System.out.println("Do you want to add more bill details, press 1 or else any number?");
				i = sc.nextInt();

			}
		} catch (SQLException e) {
			logger.warn("BILL METHOD EXCEPTION HANDLED");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (n != 0) {
			System.out.println("successfully bill details added...");
		} else {
			System.out.println("Not able to insert.please try again...");
		}

	}

	@Override
	public String register(Users u) {
		/**
		 * this method is used to registering the details of admin and doctor
		 */
		logger.info("REGISTER METHOD IS CALLED");

		String message = null;
		try {
			ps = con.prepareStatement("insert into users(username,password,type) values(?,?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getType());
			int n = ps.executeUpdate();
			if (n != 0) {
				message = "successfully user registrered..";
			} else {
				message = "Notable to registered.please try again...";
			}
			//con.close();
		} catch (SQLException e) {
			logger.warn("REGISTER METHOD EXCEPTION HANDLED");
			e.printStackTrace();
		}
		return message;
	}

	public String login(String uname, String pwd) {
		/**
		 * this method is used for login credentials 
		 */
		logger.info("LOGIN METHOD IS CALLED");

		String type = null;
		try {
			ps = con.prepareStatement("select type from users where username=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				type = rs.getString(1);
			}
			//con.close();
			//ps.close();
		} catch (SQLException e) {
			logger.warn("LOGIN METHOD EXCEPTION HANDLED");
			 e.printStackTrace();
			//System.err.print("your password/id is incorrect please try again");
		}

		return type;
	}

	
	public void back() {
		/**
		 * this method is used to go to the main menu
		 */
		HospitalManagement.main(null);

	}

}
