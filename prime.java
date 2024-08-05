//Prime number
import java.util.*;
public class Prime
	{
		public static void main(String args[])
		{	
			Scanner s=new Scanner(System.in);
			System.out.println("enetr the number:");
			int n=s.nextInt();
			boolean isPrime=isPrimeOne(n);
			if(isPrime)
			System.out.println("number is Prime:");
			else
			 System.out.println("not a prime number:");
 		}
 public static boolean isPrimeOne(int n)
{
	int flag=1;
	if(n==0 || n==1)
	flag=0;
	for(int i=2;i<=n/2;i++)
	{
	if(n%i==0)
	{
	flag=0;break;}
	}
 return flag==1;
}
}