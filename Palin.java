import java.util.Scanner;
class Palin{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
       int temp=0,rev=0;
int x=n;
       while(n!=0)
       {
            temp=n%10;
         rev=rev*10+temp;
         n=n/10;
       }
       if(x==rev)
       System.out.println("number is palindrome:");
       else 
       System.out.println("nuber is not a palindrome:");
}
}