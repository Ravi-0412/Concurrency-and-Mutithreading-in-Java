package PrintEvenOdd;

class printEvenOdd extends Thread {
    private static int currentValue = 1;
    private static int maxNumber;
    private int threadId;

    public printEvenOdd(int threadId) {
        this.threadId = threadId;
    }

    public void run() {
        while (true) {
            synchronized (printEvenOdd.class) {
                if (currentValue > maxNumber) {
                    break;
                }
                if ((currentValue - threadId) % 2 == 0) {
                    System.out.println("T" + threadId + " " + currentValue);
                    currentValue++;
                }
            }
        }
    }

    public static void setMaxNumber(int maxNumber) {
    	printEvenOdd.maxNumber = maxNumber;
    }
}