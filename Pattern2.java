import java.util.Scanner;
class Pattern1
{
 public static void main(String ar[])
  {
         Scanner s=new Scanner(System.in);
       System.out.println("enter the number of lines u have to print:");
     int n=s.nextInt();
    int j;
    for(int i=0;i<n;i++)
    {
    for( j=0;j<n;j++)
    {
     if(i==j)
      System.out.print("*");
      else
       System.out.print("0");
      }
     j--;
    System.out.print("*");
    while(j>=1)
    {
    if(i==j)
    System.out.print("*");
     else
     System.out.print("0");
     }
    j =j-1;
   }
  System.out.println();
}
}
