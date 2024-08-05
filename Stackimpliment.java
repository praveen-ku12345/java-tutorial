//stacks empty() method implementation
import java.util.Stack;
class StackImpliment
{
 public static void main(String [] args)
 { 
   Stack <Integer> s=new Stack<>();
boolean result=s.empty();
 System.out.println("Is the stack empty:"+result);
 s.push(10);
s.push(49);
result=s.empty();
System.out.println("Is the Stack empty:"+result);
}
}