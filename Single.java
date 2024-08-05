//using Thread class
/*public class Single extends Thread
{
  public  void run()
	{	
		System.out.println("This run method");
	}
       public static void main(String args[])
	{
	Single x=new Single();
	x.start();
	}
}*/
//using Runnable interface
public class Single implements Runnable
{
	public void run()
	{
	System.out.println("Runnable interface");
	}
    	public static void main(String args[])
	{
	Single y=new Single();
         Thread xy=new Thread(y);
     	xy.start();
	}
}