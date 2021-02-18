import java.util.Scanner;

public class EvenOrOdd {

	public static void main(String[] args) {
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 'a' value");
		a = sc.nextInt();
		
		
		if ( a % 2 == 0 ) {
	        System.out.println("Entered number is even");
		}
	     else {
	        System.out.println("Entered number is odd");
	  }
		sc.close();
	}
	
	}


