//Thread Methods
class Single1 extends Thread
 {

    public void run()
	 {
  	Thread t=currentThread();
	System.out.println("thread status="+t.isAlive());
          for (int i = 0; i <= 5; i++) {
 	try {
	System.out.println(i);
	t.sleep(1000);
	}
	catch(Exception e){}
            
        }
    }

    @SuppressWarnings("deprecation")
    public static void main(String args[]) 
	{
        Single1 x = new Single1();
	Single1 y=new Single1();
      /*  System.out.println("Thread id=" + x.getId());  // Suppress deprecation warning
        System.out.println("Thread name=" + x.getName());  // Suppress deprecation warning
	x.setName("Praveen");
	System.out.println("after changeing Thread name=" + x.getName());
	System.out.println("Priority of threadis="+x.getPriority());*/
        	x.start();
 	try{
	x.join(1000);
	}
	catch(Exception e)
	{}
	System.out.println("thread status="+x.isAlive());
	y.start();
    }
}
