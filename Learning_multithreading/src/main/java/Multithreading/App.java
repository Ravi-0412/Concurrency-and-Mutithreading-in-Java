package Multithreading;

import java.lang.Thread.State;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "main is starting...." );
  /** 
        // 1) Creating thread using 'Thread' class
        Thread thread1 = new Thread1("thread1");
        thread1.setDaemon(true); // if uncomment this then, thread1 won't be a user thread
        //it will a daemon thread and may terminate when main finished executing if no other user thread is running.
        System.out.println( "Thread1 is starting, extended the Thread class...." );
        thread1.start();   
 **/
        
 /**      
//        // 2) using Runnable Interface
//        Thread thread2 = new Thread(new Thread2() , "thread2"); //(object_runnable_interface , threadName)
//        
//        // for calling the run() using lambda function.
//        // just write whole run() implementation like: 
////        Thread thread2 = new Thread(() ->
////        {
////        	for(int i= 0; i < 5; i++)
////    			System.out.println("Inside " + Thread.currentThread() + " " + i);
////        }, "thread2");


//        System.out.println( "Thread2 is starting using Runnable interface...." );
//        thread2.start();

**/
        // stack class
//        Stack stack = new Stack(5);
//        
//        // 1st thread for pushing 100
//        new Thread(() -> {
//        	int counter = 0;
//        	while(++ counter < 10)
//        		System.out.println("Pushed: " + stack.push(100));
//        }, "Pusher").start();
        
     // 2nd thread for poping 100
//        new Thread(() -> {
//        	int counter = 0;
//        	while(++ counter < 10)
//        		System.out.println("Poped: " + stack.pop());
//        }, "Popper").start();
//                
//        System.out.println( "main is exiting...." );
//        
//    }
    

 // Printing thread states

// 		Thread thread3 = new Thread(() -> {
// 			try {
// 				Thread.sleep(1);
// 				for(int i= 10000; i > 0; i--);
// 			 }  catch(InterruptedException e) {
// 				e.printStackTrace();
// 			}
// 		}, "states");
//
// 		thread3.start();
//
// 		while(true)
// 		{
// 			Thread.State state = thread3.getState();
// 		    System.out.println(state);
// 			if(state == Thread.State.TERMINATED) break;
// 		}
        
        
        // Thread joining
        
//        Thread thread5 = new Thread(() -> {
//        	System.out.println(Thread.currentThread());
//        }, "Our Thread5");
//        
//        thread5.start();
//        
//        try {
//			thread5.join();  // 1st this thread all its child will execute
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
        
        // thread priority
//        System.out.println(thread5.getPriority()); // will default one i.e = 5
//        thread5.setPriority(9);

/**        
 		Creating deadlock situation
        Two threads are there and need lock1 and lock2 to access critical section
        Thread1 has acquired lock1 and need lock2 to access critical section and
        Thread2 has acquired lock2 and need lock1 to access critical section and
        
         No thread will able to run.
**/       
        String lock1 = "ravi";
        String lock2 = "raushan";
        
        Thread thread1 = new Thread(() -> {
        	synchronized (lock1) {
        		try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        		synchronized (lock2) {
        			System.out.println("lock acquired by thread1");		
				}
			}
        }, "thread1");
        
        Thread thread2 = new Thread(() -> {
        	synchronized (lock2) {
        		try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        		synchronized (lock1) {
        			System.out.println("lock acquired by thread2");		
				}
			}
        }, "thread2");
        
        thread1.start();
        thread2.start();
        
        System.out.println("main is exiting");
}
}



