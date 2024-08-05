import java.util.Scanner;
class Reverse
{
  public static void main(String[] args)
  {
   Scanner s=new Scanner(System.in);
   int n=s.nextInt();
    int r=0,rev=0;
   while(n!=0)
    {
       r=n%10;
       rev=r+rev*10;
       n=n/10;
   }
System.out.println("reverse of given number="+rev);
}
}