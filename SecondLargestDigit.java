import java.util.Scanner;

public class SecondLargestDigit {

    private static int number;
    private static int largestDigit;
    private static int secondLargestDigit;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find the second largest digit: ");
        number = scanner.nextInt();

        findSecondLargestDigit();
        System.out.println("Largest digit is " + largestDigit);
        System.out.println("Second largest digit is " + secondLargestDigit);

        scanner.close();
    }

    public static void findSecondLargestDigit() {
        int tempNumber = number;

        while (tempNumber > 0) {
            int digit = tempNumber % 10;

            if (digit > largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = digit;
            } else if (digit > secondLargestDigit && digit < largestDigit) {
                secondLargestDigit = digit;
            }
            tempNumber /= 10;
        }
    }
}
