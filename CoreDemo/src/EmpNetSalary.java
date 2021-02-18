import java.util.Scanner;

public class EmpNetSalary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter emp Name");
		String emp_name= sc.next();
		System.out.println("Enter emp ID");
		int emp_ID = sc.nextInt();
		System.out.println("Enter Basic salary");
		int emp_basic=sc.nextInt();
		System.out.println("Enter HRA exemption");
		int emp_hra= sc.nextInt();
		System.out.println("Enter DA amount ");
		int emp_da=sc.nextInt();
		System.out.println("Enter PF amount");
		int emp_pf= sc.nextInt();
		
		int net_salary=0;
		net_salary = (emp_basic + emp_hra + emp_da) - emp_pf;
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Hi, " +emp_name.toUpperCase() + " your net salary is : " +net_salary);
		System.out.println("---------------------------------------------------------------------");
		sc.close();
		
		
		

	}

}
