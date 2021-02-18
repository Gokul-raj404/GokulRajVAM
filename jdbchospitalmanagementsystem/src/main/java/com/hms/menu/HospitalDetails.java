package com.hms.menu;
/**
 * this is menu class used to class methods accordingly to the users
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import com.hms.Dao.HmsDao;
import com.hms.DaoImpl.HmsDaoImpl;
import com.hms.bean.Doctor;
import com.hms.bean.Patient;
import com.hms.db.HmsUtil;

public class HospitalDetails {
	static Scanner sc = new Scanner(System.in);
	static HmsDaoImpl hmsdao = new HmsDaoImpl();
	static Doctor da = new Doctor();
	static Patient pa = new Patient();
	static Connection con = HmsUtil.getConnection();
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public static void adminMenu() {
		System.out.println("-----------------------");
		System.out.println("|   ADMIN MAIN MENU   |");
		System.out.println("-----------------------");
		System.out.println("| 1.Add Doctor        |");
		System.out.println("| 2.View Doctor       |");
		System.out.println("| 3.View All Doctors  |");
		System.out.println("| 4.Update Doctor     |");
		System.out.println("| 5.Delete Doctor     |");
		System.out.println("| 6.Add Patient       |");
		System.out.println("| 7.View patient      |");
		System.out.println("| 8.View all patients |");
		System.out.println("| 9.update patient    |");
		System.out.println("|10.Genrate bill      |");
		System.out.println("|11.Back              |");
		System.out.println("-----------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		
		case 1:
			hmsdao.addDoctor();
			adminMenu();
			break;
		case 2:
			System.out.println("Enter Doctor Id ?");
			Doctor doctor = hmsdao.viewDoctor(sc.nextInt());
			System.out.println("DID" + "\t" + "DNAME" + "\t" + "GENDER" + "\t"  + "QUALIFICATION" + "\t" + "FEES" + "\t" + "ADDRESS"+ "SLOTS");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.println(doctor);
			adminMenu();
			break;
		case 3:
			List<Doctor> doctors = hmsdao.viewAllDoctors();
			System.out.println("DID" + "\t" + "DNAME" + "\t" + "GENDER" + "\t"  + "QUALIFICATION" + "\t" + "FEES" + "\t" + "ADDRESS"+ "SLOTS");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			for (Doctor d : doctors) {
				System.out.println(d);
			}
			adminMenu();
			break;
		case 4:
			System.out.println("Enter Updating DOCTOR Id ?");
			da.setDid(sc.nextInt());
			String message = hmsdao.updateDoctor(da.getDid());
            System.out.println(message);
			adminMenu();
			break;
		case 5:
			System.out.println("Enter Deleting Doctor Id ?");
			da.setDid(sc.nextInt());
			String msg=hmsdao.deleteDoctor(da.getDid());
			System.out.println(msg);
			adminMenu();
			break;
		case 6:
			hmsdao.addPatient();
			adminMenu();
			break;
		case 7:
			System.out.println("Enter patient Id ?");
			Patient patient = hmsdao.viewPatient(sc.nextInt());
			System.out.println("PID" + "\t" + "PNAME" + "\t" +"ADDRESS" + "\t" + "AGE" + "\t" + "GENDER"+"\t" + "DISEASE"+ "\t" +"BLOOD GROUP");
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			System.out.println(patient);
			adminMenu();
			break;

		case 8:
			List<Patient> patients = hmsdao.viewAllPatients();
			System.out.println("PID" + "\t" + "PNAME" + "\t" +"ADDRESS" + "\t" + "AGE" + "\t" + "GENDER"+"\t" + "DISEASE"+ "\t" +"BLOOD GROUP");
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			for (Patient p : patients) {
				System.out.println(p);
			}
			adminMenu();
			break;

		case 9:
			System.out.println("Enter Updating patient Id ?");
			pa.setPid(sc.nextInt());
			
			String result = hmsdao.updatePatient(pa.getPid());
			System.out.println(result);
			adminMenu();
			break;

		case 10:
			hmsdao.bill();
			adminMenu();
			break;
		case 11:
			hmsdao.back();

			break;

		default:
			System.out.println("Please select your choice range 1-11 only");

		}
	}

	public static void Doctor() {
		System.out.println("-----------------------");
		System.out.println("|   DOCTOR MAIN MENU   |");
		System.out.println("-----------------------");

		System.out.println("| 1.View patient      |");
		System.out.println("| 2.View all patients |");
		System.out.println("| 3.Back              |");

		System.out.println("-----------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			System.out.println("Enter PATIENT Id ?");
			Patient patient = hmsdao.viewPatient(sc.nextInt());
			System.out.println("PID" + "\t" + "PNAME" + "\t" +"ADDRESS" + "\t" + "AGE" + "\t" + "GENDER"+"\t" + "DISEASE"+ "\t" +"BLOOD GROUP");
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println(patient);
			Doctor();
			break;
		case 2:
			List<Patient> doctors = hmsdao.viewAllPatients();
			System.out.println("PID" + "\t" + "PNAME" + "\t" +"ADDRESS" + "\t" + "AGE" + "\t" + "GENDER"+"\t" + "DISEASE"+ "\t" +"BLOOD GROUP");
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			for (Patient d : doctors) {
				System.out.println(d);
			}
			Doctor();
			break;
		case 3:
			hmsdao.back();

			break;

		default:
			System.out.println("Please select your choice range 1-3 only");

		}
	}

	public static void Patient() {
		System.out.println("-----------------------");
		System.out.println("|   Patient MAIN MENU   |");
		System.out.println("-----------------------");

		System.out.println("| 1.View doctor     |");
		System.out.println("| 2.View all doctor |");
		System.out.println("| 3.bookSlot        |");
		System.out.println("| 4.cancelSlot      |");
		System.out.println("| 5.Back            |");

		System.out.println("-----------------------");
		System.out.println("Enter Your Choice ?");
		int choice1 = sc.nextInt();
		switch (choice1) {

		case 1:
			System.out.println("Enter doctor Id ?");
			Doctor doctor = hmsdao.viewDoctor(sc.nextInt());
			System.out.println("DID" + "\t" + "DNAME" + "\t" + "GENDER" + "\t"  + "QUALIFICATION" + "\t" + "FEES" + "\t" + "ADDRESS"+ "SLOTS");
			System.out.println("------------------------------------");
			System.out.println(doctor);
			Patient();
			break;
		case 2:
			List<Doctor> doctors = hmsdao.viewAllDoctors();
			System.out.println("DID" + "\t" + "DNAME" + "\t" + "GENDER" + "\t"  + "QUALIFICATION" + "\t" + "FEES" + "\t" + "ADDRESS"+ "SLOTS");
			System.out.println("------------------------------------");
			for (Doctor d : doctors) {
				System.out.println(d);
			}
			Patient();
			break;

		case 3:
			hmsdao.bookSlot();
			break;

		case 4:
			hmsdao.cancelSlot();

			break;
		case 5:
			hmsdao.back();

			break;

		default:
			System.out.println("Please select your choice range 1-5 only");

		}

	}

}
