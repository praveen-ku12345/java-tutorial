import java.lang.Math;
import java.util.Scanner;
    class Random
    {
        public static void main(String args[])
        {
            Scanner s=new Scanner(System.in);
            int max=s.nextInt();
            int min=s.nextInt();
            double a=Math.random()*(max-min+1)+min;
            System.out.println(a);
            int b=(int)(Math.random()*(max-min+1)+min);
            System.out.println(b);
        }
    }