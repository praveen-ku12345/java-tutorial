//Methods of a thread class
class Single1 extends Thread
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{
			System.out.println(i);
		}
 	}
}
class TH 
{
	public static void main(String args[])
		{
		Single1 x=new Single1();
		System.out.println("Thread id="+x.getId());
		x.start();
	}
}