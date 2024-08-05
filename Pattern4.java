import java.util.Scanner;
class Pattern4
{
 public static void main(String [] a)
  {
   Scanner s=new Scanner(System.in);
   int n=s.nextInt();
  int i,j;
  for(i=1;i<n;i++)
{
     for(j=1;j<=n/2;j++){
     if(i==j)
    System.out.print(j);
    else if(i>4 && j==n-i)
    System.out.print(j);
    else
    System.out.print(" ");
    }
   j=j-2;
  while(j>0)
{
   if(i==j)
    System.out.print(j);
    else if(i>4 && j==n-i)
    System.out.print(j);
    else
    System.out.print(" ");
j--;
}
System.out.println();
}
}
}