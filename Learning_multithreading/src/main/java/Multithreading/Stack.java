package Multithreading;

public class Stack {
	private int[] array;
	private int stackTop;  // will store index of last pushed ele i.e to of stack
	Object lock;
//	Object lock1, lock2;

	public Stack(int capacity)
	{
		array = new int[capacity];
		stackTop = -1 ;
		lock = new Object();
	}
	
	// note: 
	
	public boolean push(int element) {
		synchronized(lock) {
			if(isFull()) return false;
			++stackTop ;
			
			try {Thread.sleep(1000);} catch(Exception e) {}
			
			array[stackTop] = element;
			return true;
		}
	}
	
//	public synchronized boolean push(int element) {
//		if(isFull()) return false;
//		++stackTop ;
//			
//		try {Thread.sleep(1000);} catch(Exception e) {}
//			
//		array[stackTop] = element;
//		return true;
//	}
	
	
	
	public int pop() {
		synchronized(lock) {
			if(isEmpty()) return Integer.MIN_VALUE;
			int ele = array[stackTop];
			array[stackTop] = Integer.MIN_VALUE;
			
			try {Thread.sleep(1000);} catch(Exception e) {}
			
			stackTop --;
			return ele;
		}
	}
	
	public boolean isEmpty() {
		return stackTop < 0;
	}
	
	public boolean isFull() {
		return stackTop >= array.length - 1;
	}
}
