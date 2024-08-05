import java.uti.Scanner;
public class ExceptionHandling{
    public static void main(String args[]){
        int n,res=0;
        Scanner sc=new Scanner(System.in);
	try{
		System.out.println("Enter a number:");
		n=sc.nextInt();
		res=10/n;
		System.out.println("Result = " + res);
	}catch(ArithmeticException e){
		System.out.println("Error: Cannot divide a number with zero");
	}catch(Exception e){
		System.out.println("Unexpected error ocoured");
	}finally{
		sc.close();
	}
}
}