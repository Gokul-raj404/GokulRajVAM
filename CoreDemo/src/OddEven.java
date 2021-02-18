
public class OddEven {

	public static void main(String[] args) {
		int number=10;  
		System.out.println("Odd\tEven");  
		for (int i=1; i<=number; i++)   
		{  
		  
		if (i%2!=0)   
		{  
		System.out.print(i + " ");  
		} 
		else if(i%2==0)
		{
			System.out.println("\t"+i);
		}

	}

}}
