class T1 extends Thread
{
     Thread t=Thread.currentThread();
	public void run()
		{
		for(int i=0;i<5;i++)
		{  try{
		t.sleep(1500);
		System.out.println(i);}
		catch(Exception e){}}}
  public static void main(String args[])
{
T1 t1=new T1();
t1.start();
t1.start();
}
}