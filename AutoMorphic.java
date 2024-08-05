import java.util.Scanner;
class AutoMorphic
{
  public static void main(String[] args)
  {
   Scanner s=new Scanner(System.in);
   int n=s.nextInt();
  if(isAutomorphic(n))
  {
   System.out.println("given number is automorphic:");
  }
  else
  System.out.println("given number is not automorphic:");
 }
static boolean isAutomorphic(int n)
 {
  int square=n*n;
while(n>0){
 if(n%10!=square%10)
 return false;
 n=n/10;
 square=square/10;
 }
 return true;
}
}