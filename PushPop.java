import java.util.Stack;
class PushPop{
 public static  void main(String [] args)
 {
  Stack <Integer> stk=new Stack<>();
  boolean result=stk.empty();
  System.out.println("Is the Stack is empty:"+result);
  pushelement(stk,20);
 pushelement(stk,30);
 pushelement(stk,40);
  popelement(stk);
  try{
   popelement(stk);
}
catch(EmptyStackException e)
{
 System.out.println("Stack is empty:");
}
}
static void pushelement(Stack stk,int x)
{
stk.push(new Integer(x));
System.out.println("push->"+x);
System.out.println("Stack:"+stk);
}
static void popelement(Stack stk)
{
System.out.println("pop->");
 Integer x=(Integer)stk.pop();
System.out.println(x);
System.out.println("Stack"+x);
  }
}

 