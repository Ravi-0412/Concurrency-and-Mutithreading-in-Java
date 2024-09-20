package PrintSequence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter maximum number: ");
        int maxNumber = scanner.nextInt();
        PrintThread.setMaxNumber(maxNumber);

        System.out.print("Enter number of threads: ");
        int numThreads = scanner.nextInt();
        
        // for threee threads
//        PrintThread thread1 = new PrintThread(1, 3);
//        PrintThread thread2 = new PrintThread(2, 3);
//        PrintThread thread3 = new PrintThread(3, 3);
        
        // generalising for any no of threads
        PrintThread[] threads = new PrintThread[numThreads];
        // numThreads is equal to increment also i.e next value for current thread
        
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new PrintThread(i + 1, numThreads);
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// why 'join()'?
/* 
After starting all the threads, the main thread waits for each thread to finish its execution
using the join() method in the second loop.
This ensures that the main thread does not proceed further until all worker threads have completed
their tasks and ensures that the output is printed in the correct sequence.
*/

