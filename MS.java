//Thread Synchronization
/*class Example
{
	 void display()//synchronized void display()
	{
	Thread g=Thread.currentThread();
	{
	for(int i=0;i<=5;i++)
	{ 
	try{
		Thread.sleep(500);
		System.out.println("thread  "+g.getName()+" "+i);
		}
	catch(Exception e){ }
   	}
	}
	synchronized(this){
	for(int i=0;i<=5;i++)
	{ 
	try{
		Thread.sleep(500);
		System.out.println("thread  "+g.getName()+" "+i);
		}
	catch(Exception e){ }
   	}
	}
	}
}
class T extends Thread
{
	Example e;
	T(Example e)
	{
		this.e=e;
	}
		public void run()
		{
			e.display();
		}
}
class MS
{
	public static void main(String args[])
	{
		Example ex=new Example();
		T t1=new T(ex);
		T t2=new T(ex);
		T t3=new T(ex);
		t1.start();
		t2.start();
		t3.start();
	}
}*/
//Synchronized static block

class Example
{
	 synchronized static void display()
	{
	Thread g=Thread.currentThread();

	for(int i=0;i<=5;i++)
	{ 
	try{
		Thread.sleep(500);
		System.out.println("thread  "+g.getName()+" "+i);
		}
	catch(Exception e){ }
   	}
	}
	
}
class T extends Thread
{
		public void run()
		{
			Example.display();
		}
}
class MS
{
	public static void main(String args[])
	{
		T t1=new T();
		T t2=new T();
		T t3=new T();
		t1.start();
		t2.start();
		t3.start();
	}
}
