package PrintEvenOdd;

public class PrintEvenOdd1 {
    private int maxNumber;
    private volatile int currentNumber = 1; // Current number to be printed
    private final Object lock = new Object(); // Lock object for synchronization

    public PrintEvenOdd1(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public  void printEven() {
        synchronized (lock) {
            while (currentNumber <= maxNumber) {
                if (currentNumber % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                    currentNumber++;
                    lock.notify(); // Notify other thread
                } else {
                    try {
                        lock.wait(); // Wait for other thread to print
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printOdd() {
        synchronized (lock) {
            while (currentNumber <= maxNumber) {
                if (currentNumber % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + currentNumber);
                    currentNumber++;
                    lock.notify(); // Notify other thread
                } else {
                    try {
                        lock.wait(); // Wait for other thread to print
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


