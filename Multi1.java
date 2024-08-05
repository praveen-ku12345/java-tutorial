/*public class Single extends Thread
{
  public  void run()
	{	
		System.out.println("This run method");
	}
public static void main(String args[])
	{
	Multi x=new Multi();
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
	Multi1 y=new Multi1();
         Thread xy=new Thread(y);
     	xy.start();
	}
}