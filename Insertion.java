import java.util.Scanner;
class Insertion{
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       int n=s.nextInt();
        int i,j,temp=0;
       int a[]=new int[n];
       for(i=0;i<n;i++)
       {
           a[i]=s.nextInt();

       }
  for(i=1;i<n;i++)
  {
   temp=a[i];
   j=i-1;
   while(j>=0 && a[j]>temp)
   { 
    a[j+1]=a[j];
    j--; 
   }
  a[j+1]=temp;
  }
for( i=0;i<n;i++)
{
System.out.print(a[i]+" ");
  }
}
}
