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
			notifyAll();  // notify all the consumers.
						// now all threads(consumers) that got blocked seeing 'q' as empty all will awake
			
			return true;
		}
	}
	
	public int remove()
	{
		synchronized(q) {
			while(q.size() == 0)  // using 'if' will give error.
			{
				try {
					q.wait();
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


}












