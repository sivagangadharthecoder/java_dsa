import java.util.Scanner;
import java.util.Arrays;

public class NEqualsTwoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int sizeOfArray = scanner.nextInt();
        System.out.print("Enter the target sum : ");
        int targetSum = scanner.nextInt();

        System.out.print("Enter the elements of the array:");
        int[] array = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = scanner.nextInt();
        }

        boolean result = hasTwoSum(array, targetSum);

        if (result) {
            System.out.println("There are two numbers in the array that add up to " + targetSum);
        } else {
            System.out.println("No two numbers in the array add up to " + targetSum);
        }

        scanner.close();
    }

    private static boolean hasTwoSum(int[] array, int targetSum) {
        int start = 0, end = array.length - 1;
        Arrays.sort(array);
        while (start < end) {
            int currentSum = array[start] + array[end];
            if (currentSum == targetSum) {
                return true;
            } else if (currentSum < targetSum) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
