import java.util.Stack;
class StackImp
{
 public static void main(String [] args)
 {
 Stack <Integer> stk=new Stack<>();
 boolean result=stk.empty();
 pushelement(stk,20);
pushelement(stk,30);
pushelement(stk,40);
pushelement(stk,100);
popelement(stk);
try{
popelement(stk);
}
catch(StackEmptyException e)
{
System.out.println("Stack is empty:");
}
}
static void pushelement(Stack stk,int x)
{
  stk.push(new Integer(x));
 System.out.print("Push->"+x);
System.out.println("Stack:"+stk);
}
static void popelement(Stack stk){
System.out.println("pop->:");
Integer x=(Integer)stk.pop();
System.out.println("Stack:"+stk);
}

}