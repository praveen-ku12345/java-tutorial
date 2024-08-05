import java.util.Scanner;
public class Pattern
{
 public static void main(String [] a)
  {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    int i,j;
   for(i=0;i<n;i++)
{
 for(j=n;n>=1;j--)
  {
    if(j!=i)
    System.out.print(j);
    else
    System.out.print("*");
   }
  }
System.out.println();
}
}