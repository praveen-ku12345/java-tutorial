import java.util.Scanner;
class QuickSort
{
public static int  partition(int a[],int low,int high)
{
 int pivot=a[low];
 int lb=low+1;
 int ub=high;
 while(true)
 {
  while(lb<=ub && pivot>a[lb])
  {
 lb++;
  }
  while(lb<=ub && pivot<a[ub])
  {
  ub--;
  }
  if(lb<=ub)
  {
  int temp=a[ub];
  a[ub]=a[lb];
  a[lb]=temp;
  }
  else
  {
  break;
  }
 }
 int temp=a[low];
 a[low]=a[ub];
 a[ub]=temp;
return ub;
}
public static void quickSort(int []a,int low,int high){
if(low<high)
{
  int p=partition(a,low,high);
  quickSort(a,low,p-1);
 quickSort(a,p+1,high);
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
  System.out.println("enter the number of elements:");
  int n=s.nextInt();
  int a[]=new int[n];
  System.out.println("enter the array elements:"); 
  int i;
  for(i=0;i<n;i++)
  {
   a[i]=s.nextInt();
  }
  System.out.println("before Swapping array  elements:");
  printArray(a,n);
  System.out.println();
  quickSort(a,0,n-1);
  System.out.println("after Swapping array  elements:");
  printArray(a,n);
 }
}

  