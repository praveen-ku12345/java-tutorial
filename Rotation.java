//Array Rotation Using Java
import java.util.Scanner;
class Rotation
{
  public static void main(String args[])
   {
     Scanner s=new Scanner(System.in);
System.out.println("enter the size of array:");
    int n=s.nextInt();
System.out.println("enter the size to rotate array:");
    int k=s.nextInt();

    int a[]=new int [n];
System.out.println("enter the array elemnets:");
   for(int i=0;i<n;i++)
{
 a[i]=s.nextInt();
}
rotation(a,n,k);
for(int i=0;i<n;i++)
{
System.out.print(a[i]+" ");
}
}
public static void rotation(int a[],int n,int k)
{
  k=k%n;
rotationOf(a,0,n-1);
rotationOf(a,0,k-1);
//rotationOf(a,k,n-1);
}
public static void rotationOf(int a[],int low,int high)
{
while(low<=high)
{
int temp=a[low];
a[low]=a[high];
a[high]=temp;
low++;
high--;
}
}
}