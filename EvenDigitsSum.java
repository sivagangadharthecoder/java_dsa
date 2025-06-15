import java.util.Scanner;

public class EvenDigitsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find sum of even position digits: ");

        int number = scanner.nextInt();
        int sumOfDigits = sumEvenDigits(number);
        System.out.println("Sum of even position digits: " + sumOfDigits);

        scanner.close();
    }

    public static int sumEvenDigits(int number) {
        int position = 0, sumOfDigits = 0;

        while (number > 0) {
            int digit = number % 10;
            if (position % 2 == 0) {
                sumOfDigits += digit;
            }
            number /= 10;
            position++;
        }
        return sumOfDigits;
    }
}
