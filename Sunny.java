import java.util.Scanner;
public class Sunny
{
 public static void main(String arg[])
  {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    isSunny(n);
   }
    static boolean isSunnyTo(double n)
   {
     double square=Math.sqrt(n);
     return( (Math.sqrt(n)-Math.floor(square))==0);
     }
   static void isSunny(int n)
   {
   if(isSunnyTo(n+1))
   System.out.print("Given numebr is Sunny number:");
   else 
     System.out.print("Given numebr is not Sunny number:");
    }

}
 