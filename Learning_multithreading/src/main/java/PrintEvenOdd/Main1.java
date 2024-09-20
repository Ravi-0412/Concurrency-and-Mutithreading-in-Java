package PrintEvenOdd;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter maximum number: ");
        int maxNumber = scanner.nextInt();

        PrintEvenOdd1 printEvenOdd1 = new PrintEvenOdd1(maxNumber);

        // Create and start threads for printing even and odd numbers
        Thread evenThread = new Thread(() -> printEvenOdd1.printEven(), "EvenThread");
        Thread oddThread = new Thread(() -> printEvenOdd1.printOdd(), "OddThread");

        evenThread.start();
        oddThread.start();
    }
}
