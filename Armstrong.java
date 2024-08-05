import java.util.Scanner;
class Armstrong{
    static boolean isArmstrong(int n)
    {
        int temp=0,sum=0,last=0,digits=0;
        temp=n;
        while(temp>0)
        {
            temp=temp/10;
            digits++;
        }
        temp=n;
        while(n!=0)
        {
            last=n%10;
            sum+=(Math.pow(last,digits));
            n=n/10;
        }
        if(sum==temp)
        return true;
        else 
        return false;
    }
    
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
       if(isArmstrong(n)){
           System.out.println("entered number is Armstrong:");
       }
       else
        System.out.println("entered number is not Armstrong:");
      
}
}