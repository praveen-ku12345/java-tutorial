class AThread implements Runnable
{
	public void run()
	{
	for(int i=1;i<=10;i++)
	try{
	 System.out.println("5 * " + i + " = " + 5 * i);
	Thread.sleep(200);
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	}
}
class BThread implements Runnable
{
	public void run()
	{
	for(int i=2;i<=50;i=i+2)
	try{
	System.out.print(i+" ");
	Thread.sleep(200);
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	}
}
class ABThread
{
	public static void main(String args[])
	{
		AThread x=new AThread();
		BThread y=new BThread();
		Thread x1=new Thread(x);
		Thread y1=new Thread(y);
		x1.start();
		y1.start();
	}
}	