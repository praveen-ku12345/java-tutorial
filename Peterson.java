import java.util.Scanner;
class Peterson
{
 public static void main(String arg[])
{
 Scanner s=new Scanner(System.in);
int n=s.nextInt();
int r=0,sum=0,fact=1;
int temp=n;
while(n>0)
{
  r=n%10;
   fact=1;
 for(int i=r;i>=1;i--)
  fact=fact*i;
 sum=fact+sum;
n=n/10;
}
if(sum==temp)
System.out.println("Peterson number:");
else
System.out.println("not a peterson number:");
}
}