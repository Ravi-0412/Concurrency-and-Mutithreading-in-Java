package Multithreading.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	
	private Queue<Integer> q;
	
	private int capacity;
	
	public BlockingQueue(int cap)
	{
		q = new LinkedList<>();
		capacity = cap;
	}
	
	
	// adding ele at front.
	// a lot of thread(producers) will try to add items
	
	public boolean add(int item)
	{
		// passing 'q' object as 'lock' variable
		synchronized(q) {
			while(q.size() == capacity)  // using 'if' will give error.
			{
				try {
					q.wait();  // adder1, adder2
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			q.add(item);
			notifyAll();  // notify all the consumers/ thread who is waiting to have some item in queue to pop
						// now all threads(consumers) that got blocked(was waiting to get some item in q) seeing 
			            // 'q' as empty all will awake
			
			return true;
		}
	}
	
	public int remove()
	{
		synchronized(q) {
			while(q.size() == 0)  // using 'if' will give error.
			{
				try {
					q.wait(); // this thread has to wait until any adder thread add value in queue
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			int ele = q.poll();
			notifyAll(); // will notify producers that they can add items.
			return ele;
		}
	}


// Note: if we use 'if' instead of while loop then there will be inconsistency in values for threads.
// suppose two thread adder1 and adder2 go inside 'add()' and there is no free space and now later
// adder1 get the access and add item . Now queue is again full.
// Now adder2 can also add because it has already checked 'if' condition and this will make 'index out of bound'.
	
// For this use 'while' in-place of 'if'.	

}












