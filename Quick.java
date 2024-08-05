import java.util.Scanner;
class Quick
{  
public static int partition(int a[],int low,int high)
{
 int  pivot=a[0];
  int lowerbound=low+1;
  int upperbound=high;
  while(lowerbound<=upperbound && pivot>a[lowerbound])
  lowerbound++; 
  while(lowerbound<=upperbound && pivot<a[upperbound])
  upperbound--;
if(lowerbound<=upperbound)
 {
  int temp=a[upperbound];
  a[upperbound]=a[lowerbound];
  a[lowerbound]=temp;
}
else{
int temp1=a[upperbound];
a[upperbound]=pivot;
pivot=temp1;
}
return upperbound;

  }
  public static void quickSort(int a[],int low,int high)
{
 if(low<high){
  int p=partition(a,low,high);
   quickSort(a,low,p-1);
    quickSort(a,p+1,high);
}
}
  public static void printArr(int a[]){
 for(int i=0;i<a.length;i++)
{
 System.out.print(a[i]+" ");
}
}
 public static void main(String args[])
  {
  Scanner s=new Scanner(System.in);
  int n=s.nextInt();
  int a[]=new int[n];
  for(int i=0;i<n;i++)
  {
   a[i]=s.nextInt();
  }
   System.out.println("Before Swapping:");
  printArr(a);
  quickSort(a,0,n-1);
  System.out.println("after Swapping:");
  printArr(a);
  }
}