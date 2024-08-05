// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class Bubble {
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
       int a[]=new int[n];
       for(int i=0;i<n;i++)
       {
           a[i]=s.nextInt();
       }
       for(int i=0;i<n;i++)
       {
           for(int j=1;j<n-i;j++)
           {
               if(a[j-1]>a[j])
               {
                   int temp=a[j-1];
                   a[j-1]=a[j];
                   a[j]=temp;
               }
               
           }
       }
       for(int i=0;i<n;i++)
       {
           System.out.print(a[i]+" ");
       }
    }
}