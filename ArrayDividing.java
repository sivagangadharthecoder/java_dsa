import java.util.Scanner;
import java.util.Arrays;

public class ArrayDividing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int sizeOfArray = scanner.nextInt();
        System.out.print("Enter the x : ");
        int x = scanner.nextInt();
        System.out.print("Enter the y : ");
        int y = scanner.nextInt();

        System.out.print("Enter the elements of the array:");
        int[] array = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("The number of integers: " + hasTwoSum(array, x, y));

        scanner.close();
    }

    private static int hasTwoSum(int[] array, int x, int y) {
        Arrays.sort(array);
        return array[y] - array[y - 1] - 1;
    }
}
