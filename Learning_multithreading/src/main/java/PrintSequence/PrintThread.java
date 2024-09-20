package PrintSequence;


class PrintThread extends Thread {
    private static int currentValue = 1;
    private static int maxNumber;
    private int threadId;
    private int totalThreads;

    public PrintThread(int threadId, int totalThreads) {
        this.threadId = threadId;
        this.totalThreads = totalThreads;     // this is equal to increment also i.e next value for current thread
    }

    public void run() {
        while (true) {
            synchronized (PrintThread.class) {
                if (currentValue > maxNumber) {
                    break;
                }
                if ((currentValue - threadId) % totalThreads == 0) {
                    System.out.println("T" + threadId + " " + currentValue);
                    currentValue++;
                }
            }
        }
    }

    public static void setMaxNumber(int maxNumber) {
        PrintThread.maxNumber = maxNumber;
    }
}


// run()
/* 
suppose it is turn of T2 but T2 is not responsible for printing the 'curValue' then,
it won't do anything and turn goes to other thread.
if current thread is responsible for printing curValue then it will print and increment the 'curValue'.
*/

