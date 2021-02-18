import java.util.Scanner;

public class Operators {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Please enter a number");
        num = sc.nextInt();
        if ((num > 9 && num < 100) || (num < -9 && num > -100)) {
            System.out.println("Double digit");
            
        } else {
            System.out.println(" single digit");
            
        }
        
        sc.close();

	}

}
