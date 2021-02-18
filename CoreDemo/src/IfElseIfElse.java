import java.util.Scanner;

public class IfElseIfElse {

	public static void main(String[] args) {

		int a,b,c;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter 'a' value");
			a = sc.nextInt();
			System.out.println("Enter 'b' value");
			b = sc.nextInt();
			System.out.println("Enter 'b' value");
			c = sc.nextInt();
		
		
		
			if (a > b && a > c) {
				System.out.println("a great");
			} else if (b > c) {
				System.out.println("B great");
			} else {
				System.out.println("C great");
			}
			sc.close();
		}
		
		
			
	}

		
  }



