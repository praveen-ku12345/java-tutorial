//Perfect number
import java.util.*;
public class Perfect
	{
		public static void main(String args[])
		{	
			Scanner s=new Scanner(System.in);
			System.out.println("enetr the number:");
			int n=s.nextInt();
			boolean isPerfect=isPerfectOne(n);
			if(isPerfect)
			System.out.println("number is perfect:");
			else
			 System.out.println("not a perfect number:");
 		}
 public static boolean isPerfectOne(int n)
{
 int sum=0;
	for(int i=1;i<=n/2;i++){
		if(n%i==0)
		{
		sum=sum+i;	
		}
	}
  return sum==n;
}
}