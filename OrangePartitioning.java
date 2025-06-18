import java.util.Arrays;
import java.util.Scanner;

public class OrangePartitioning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of orange sizes array: ");
        int sizeOfArray = scanner.nextInt();

        int[] orangeSizes = new int[sizeOfArray];
        System.out.print("Enter the sizes of oranges: ");
        for (int i = 0; i < sizeOfArray; i++) {
            orangeSizes[i] = scanner.nextInt();
        }

        partitioned(orangeSizes, sizeOfArray);
        System.out.print("Partitioned array: " + Arrays.toString(orangeSizes));

        scanner.close();
    }

    private static void partitioned(int[] arr, int size) {
        int j = 0;
        int pivot = arr[size - 1];
        for (int i = 0; i < size; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
