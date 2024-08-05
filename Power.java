import java.util.*;
import java.io.*;
class Power
{
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
int n=s.nextInt();int flag=0;
for(int i=1;i<n;i=i+1)
{
if(Math.pow(2,i)==n)
{
flag=1;
break;
}
}
if(flag==1)
System.out.println("s");
else
System.out.println("n");
}
}
