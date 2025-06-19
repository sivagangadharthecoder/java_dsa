import java.util.*;

public class KaprekarNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if (number < 1000 || number > 9999) {
            System.out.println("Input must be a 4-digit number (1000-9999).");
            scanner.close();
            return;
        }
        int steps = findKaprekarNumber(number);
        System.out.println("Steps to reach 6174: " + steps);
        scanner.close();
    }

    private static int count = 0;

    private static int findKaprekarNumber(int number) {
        if (number == 6174) {
            return count;
        }

        String numStr = String.format("%04d", number);
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = numStr.charAt(i) - '0';
        }

        Arrays.sort(arr);
        int res1 = arrayToNumber(arr);

        int[] descendingArr = new int[4];
        for (int i = 0; i < 4; i++) {
            descendingArr[i] = arr[3 - i];
        }
        int res2 = arrayToNumber(descendingArr);

        int finalResult = res2 - res1;
        count++;

        if (finalResult == 6174) {
            return count;
        } else {
            return findKaprekarNumber(finalResult);
        }
    }

    public static int arrayToNumber(int[] digits) {
        int number = 0;
        for (int digit : digits) {
            number = number * 10 + digit;
        }
        return number;
    }
}