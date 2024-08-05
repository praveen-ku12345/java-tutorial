abstract class MyAbstract
{
	abstract void display();
	void display1()
	{
	System.out.println("Heelo java");
	}
}
class Main extends MyAbstract
{
	public void display()
	{
	System.out.println("hello sru");
	}
}
class Abstract
{
	
	public static void main(String args[])
	{
	Main x=new Main();
	x.display();
	x.display1();
	}
}