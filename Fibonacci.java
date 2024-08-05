import java.util.Scanner;
public class Fibonacci{

     public static void main(String []args){
         Scanner s=new Scanner(System.in);
        int a=0,b=1,c=0;
        System.out.println("enter the number of fibanaccci series u want:");
        int n=s.nextInt();
        System.out.print(a+" "+b+" ");
        for(int i=0;i<n;i++)
        {
            c=a+b;
            System.out.print(c+" ");
            a=b;
            b=c;
        }
     }
}