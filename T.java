class T extends Thread
	{

		public void run()
		{
                        Thread t=Thread.currentThread();
			for(int i=0;i<5;i++)
			{ 		
				try{
				t.sleep(1000);
				System.out.println(i);
       				}
			catch(Exception e)
				{
				System.out.println(e);
				}
			}
		}

    //@SuppressWarnings("deprecation")
	public static void main(String args[])
	{
	 T t1=new T();
	t1.start();
	}
	}