import java.util.Scanner;
class CountingSort
{
public static int getMax(int a[],int n)
{
int max=a[0],i;
for(i=0;i<n;i++)
{
 if(a[i]>max)
 max=a[i];
}
return max;
}
  public static void countingSort(int a[],int n)
 {
  int output[]=new int[n+1];
  int max=getMax(a,n);
 int count[]=new int[max+1];
 int i;
 for(i=0;i<=max;i++)
{
count[i]=0;
}
for(i=0;i<n;i++)
{
count[a[i]]++;
}
for(i=1;i<=max;i++)
{
count[i]+=count[i-1];
}
for(i=n-1;i>=0;i--)
{
 output[count[a[i]]-1]=a[i];
 count[a[i]]--;
}
for(i=0;i<n;i++)
{
 a[i]=output[i];
}
}
  public static void printArray(int a[],int n)
  {
  int i;
  for(i=0;i<n;i++)
  {
  System.out.print(a[i]+" ");
  }
  }
 public static void main(String args[])
 {
   Scanner s=new Scanner(System.in);
   System.out.println("enetr the number of elements:");
   int n=s.nextInt();
   int a[]=new int[n];
   System.out.println("enetr the array elements:");
   for(int i=0;i<n;i++)
  {
  a[i]=s.nextInt();
  }
  System.out.println("before Swapping array  elements:");
  printArray(a,n);
  System.out.println();
  countingSort(a,n);
  System.out.println("after Swapping array  elements:");
  printArray(a,n);
}
}