//bubble sort 
import java.util.Scanner;
class Bubble
{
    public static void bubbleSort(int a[],int n)
    {
        int i,j;
        int temp;
        for(i=0;i<n-1;i++)
        {
            for(j=i+1;j<n-1-i;j++)
            {
                if(a[j]>a[j+1])
                {
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in)
       int n=s.nextInt();
      int a[]=new int[n];
      for(int i=0;i<n;i++)
      {
        a[i]=s.nextInt();
      }
      bubbleSort(a,a.length);
    }
}