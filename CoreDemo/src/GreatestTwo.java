import java.util.Scanner;

public class GreatestTwo {

	public static void main(String[] args) {
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 'a' value");
		a = sc.nextInt();
		System.out.println("Enter 'b' value");
		b = sc.nextInt();
		
		if(a>b) {
			System.out.println("A is greater i.e;" +a);
		}
		else {
			System.out.println("B is greater i.e;"+b);
		}
		
		sc.close();

	}

}
