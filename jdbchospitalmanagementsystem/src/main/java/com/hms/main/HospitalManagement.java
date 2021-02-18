package com.hms.main;
/**
 * @author chandan
 * yeshwanth
 * sushma
 * utkarsh
 * 
 * this is a main class which manages the entire project
 */

import java.util.Scanner;
import java.util.regex.Pattern;

import com.hms.Dao.HmsDao;
import com.hms.DaoImpl.HmsDaoImpl;
import com.hms.bean.Account;
import com.hms.bean.Doctor;
import com.hms.bean.Patient;
import com.hms.bean.Users;
import com.hms.menu.HospitalDetails;

public class HospitalManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HmsDaoImpl hmsdao = new HmsDaoImpl();
		Account a = new Account();
		Doctor d = new Doctor();
		Patient p = new Patient();
		Users u = new Users();
		while (true) {
			// try {
			System.out.println("******************************");
			System.out.println("| HOSPITAL MANAGEMENT SYSTEM |");
			System.out.println("******************************");
			System.out.println("|  1.  ADMIN              |");
			System.out.println("|  2.  DOCTOR             |");
			System.out.println("|  3.  PATIENT            |");
			System.out.println("|  4.  EXIT               |");
			System.out.println("******************************");
			System.out.println();
			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				// Users u=new Users();
				System.out.println("|  1.  REGISTER               |");
				System.out.println("|  2.  LOGIN                  |");
				System.out.println("|  3.  BACK                   |");
				int c = sc.nextInt();
				if (c == 1) {
					System.out.println("Enter User Name ?");
					String name = sc.next();

					while (!Pattern.matches("[A-Za-z0-9]{1,14}", name)) {
						System.err.println("plese enter name in alphabets");
						// name = sc.next();

					}
					u.setUsername(name);

					System.out.println("Enter Password ?");
					String password = sc.next();
					while (!Pattern.matches("[0-9a-zA-Z]{1,8}", password)) {
						System.err.println("please enter valid password minimum of 8");

					}
					u.setPassword(password);

					System.out.println("Enter type?");
					u.setType(sc.next());

					String message = hmsdao.register(u);
					System.out.println(message);

				} else if (c == 2) {
					System.out.println("Enter User Name ?");
					String name = sc.next();

					while (!Pattern.matches("[A-Za-z0-9]{1,14}", name)) {
						System.err.println("please enter the valid username with in the range of 1-14 ");

					}
					u.setUsername(name);

					System.out.println("Enter Password ?");
					String password = sc.next();
					while (!Pattern.matches("[0-9a-zA-Z]{1,8}", password)) {
						System.err.println("please enter valid password max of 8 characters");

					}
					u.setPassword(password);

					String type = hmsdao.login(u.getUsername(), u.getPassword());
                 
					if (type.equals("admin")) {
						HospitalDetails.adminMenu();

					} else if (type.equals("doctor")) {

						System.out.println("please enter login details of admin");
					} else {
						System.out.println("Invalid UserName / PassWord");
					}
				} else if (c == 3) {
					HospitalManagement.main(null);
				} else {
					System.out.println("enter between 1-3 only");
					HospitalManagement.main(null);
				}
				/*
				 * System.out.println("Enter User Name ?");
				 * u.setUsername(sc.next()); //u.setReuse(u.getUserName());
				 * System.out.println("Enter Password ?");
				 * u.setPassword(sc.next()); System.out.println("Enter type?");
				 * u.setType(sc.next()); String message = hmsdao.register(u);
				 * System.out.println(message);
				 */
				break;
			case 2:
				System.out.println("|         1.  REGISTER              |");
				System.out.println("|         2.  LOGIN                 |");
				System.out.println("|         3.  BACK                  |");
				int d1 = sc.nextInt();
				if (d1 == 1) {

					System.out.println("Enter User Name ?");
					String name = sc.next();

					while (!Pattern.matches("[a-zA-Z]{1,14}", name)) {
						System.err.println("please enter the valid username with in the range of 1-14 ");
						// name = sc.next();
					}
					u.setUsername(name);

					System.out.println("Enter Password ?");
					String password = sc.next();
					while (!Pattern.matches("[0-9a-zA-Z]{1,8}", password)) {

						System.err.println("please enter valid password max of 8 characters");
						// password = sc.next();
					}
					u.setPassword(password);

					System.out.println("Enter type?");
					u.setType(sc.next());

					String message = hmsdao.register(u);
					System.out.println(message);

				} else if (d1 == 2) {
					System.out.println("Enter User Name ?");
					String name = sc.next();

					while (!Pattern.matches("[a-zA-Z0-9]{1,14}", name)) {
						System.err.println("enter name upto range of 14");
						// name = sc.next();
					}
					u.setUsername(name);

					System.out.println("Enter Password ?");
					String password = sc.next();
					while (!Pattern.matches("[0-9a-zA-Z]{1,8}", password)) {

						System.err.println("enter password within  range of 8");
						// password = sc.next();
					}
					u.setPassword(password);

					String type = hmsdao.login(name, password);
					if (type.equals("admin")) {
						// HospitalDetails.adminMenu();
						System.out.println("please enter login details of doctor");

					} else if (type.equals("doctor")) {
						HospitalDetails.Doctor();

					} else {
						System.out.println("Invalid UserName / PassWord");
					}
				} else if (d1 == 3) {
					HospitalManagement.main(null);
				} else {
					System.out.println("enter between 1-3 only");
					HospitalManagement.main(null);
				}

				/*
				 * System.out.println("Enter your Username ?"); String uname =
				 * sc.next();
				 * 
				 * System.out.println("Enter your Password ?"); String pwd =
				 * sc.next(); String type = hmsdao.login(uname, pwd); if
				 * (type.equals("admin")) { HospitalDetails.adminMenu(); } else
				 * if (type.equals("doctor")) { HospitalDetails.Doctor(); } else
				 * { System.out.println("Invalid UserName / PassWord"); }
				 */
				break;

			// UserDetails.customerMenu();
			case 3:
				HospitalDetails.Patient();

				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Please select choice range 1-3 only");

			}

		}

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * while (true) { System.out.println("-------------------------------");
		 * System.out.println("|  HOSPITAL MANAGEMENT SYSTEM |");
		 * System.out.println("-------------------------------");
		 * System.out.println("|  1. ADMIN                   |");
		 * System.out.println("|  2. DOCTOR                  |");
		 * System.out.println("|  3. PATIENT                 |");
		 * System.out.println("|  4. EXIT                    |");
		 * System.out.println("-------------------------------");
		 * System.out.println("Enter Your Choice ?"); int choice = sc.nextInt();
		 * switch (choice) { case 1: HospitalDetails.adminMenu(); break; case 2:
		 * HospitalDetails.Doctor(); break; case 3: HospitalDetails.Patient();
		 * case 4: System.exit(0); break; default:
		 * System.out.println("Please select choice range 1-3 only"); } }
		 */

	}

}
