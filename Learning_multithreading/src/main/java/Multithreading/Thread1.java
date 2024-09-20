package Multithreading;

public class Thread1 extends Thread{
	
	public Thread1(String threadName)
	{
		super(threadName);
	}
	
	// to get thread name by passing in constructor
	@Override
	public void run()
	{
		for(int i= 0; i < 5; i++)
			// to print whole thread info i.e (threadName, thread priority, parent thread) and value
//			System.out.println("Inside " + Thread.currentThread() + " " + i);
			
		// to print only threadName  and value
			System.out.println("Inside Thread1" + Thread.currentThread().getName() + " " + i);
			
	}
	
//	@Override
//	public void run()
//	{
//		for(int i= 0; i<5; i++)
//			System.out.println("Inside Thread1: " + i);
//	}

}
