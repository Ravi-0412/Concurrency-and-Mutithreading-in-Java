package PrintEvenOdd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter maximum number: ");
        int maxNumber = scanner.nextInt();
        printEvenOdd.setMaxNumber(maxNumber);

        printEvenOdd thread1 = new printEvenOdd(1);
        printEvenOdd thread2 = new printEvenOdd(2);
        
        thread1.start();
        thread2.start();
        
        try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
