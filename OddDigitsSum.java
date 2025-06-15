import java.util.Scanner;

public class OddDigitsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find sum of odd position digits: ");

        int number = scanner.nextInt();
        int sumOfDigits = sumOddDigits(number);
        System.out.println("Sum of odd position digits: " + sumOfDigits);

        scanner.close();
    }

    public static int sumOddDigits(int number) {
        number = Math.abs(number);
        int position = 0, sumOfDigits = 0;

        while (number > 0) {
            int digit = number % 10;
            if (position % 2 == 1) {
                sumOfDigits += digit;
            }
            number /= 10;
            position++;
        }
        return sumOfDigits;
    }
}
