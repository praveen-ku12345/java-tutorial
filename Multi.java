public class Multi extends Thread
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
}