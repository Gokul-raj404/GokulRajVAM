import java.util.Scanner;

public class StudentGrade {

	public static void main(String[] args) {
		int marks1=0,marks2=0,marks3=0;
		int total=0,y=1;
		Scanner sc = new Scanner(System.in);
		while(y==1) {
			System.out.println("Enter student name");
			String name = sc.next();
			System.out.println("Enter college code");
			String clgcode= sc.next();
			System.out.println("Enter no.of subjects attempted");
			int subj= sc.nextInt();
			if(subj<=3) {
				for(int x=1;x<=subj;x++) {
					if(x==1) {
						System.out.println("Enter subject " +x+ " marks");
						marks1 = sc.nextInt();

					}
					else if(x==2) {
						System.out.println("Enter subject " +x+ " marks");
						marks2 = sc.nextInt();


					}else if(x==3) {
						System.out.println("Enter subject " +x+ " marks");
						marks3 = sc.nextInt();
					}
					else {
						System.out.println("You can only enter 3 subjects");
					}

				}
			}else {
				System.out.println("You only have 3 subjects. Reenter!");
			}

			
			
			total = marks1 + marks2 + marks3;
			int avg = total/3;
			System.out.println("------------------------------");
			System.out.println("Sum of your marks :" +total+"/300");
			System.out.println("Average score :" +avg);

			if(avg>=90 && avg<=100) {
				System.out.println(name.toUpperCase()+" has secured 'A-Grade'");
			}
			else if(avg>=70 && avg<=89) {
				System.out.println(name.toUpperCase()+" has Secured 'B-Grade'");
			}
			else if(avg<=69 && avg>=35) {
				System.out.println(name.toUpperCase()+" has Secured 'C-Grade");
			}
			else {
				System.out.println("Status : Failed");
			}
			System.out.println("---------------------------------");
			
			System.out.println("Press 1-2");
			System.out.println("1.CONTINUE");
			System.out.println("2.EXIT");
			int z=sc.nextInt();
			
			
			switch(z) {
			case 1:
				System.out.println("Enter details below.");
				
				break;
			case 2:
				System.out.println("Thank you...!");
				y++;
				break;
			default:
				System.out.println("1-2");
				
				
			}
			

		}
}}
