import java.util.Arrays;
import java.util.Scanner;

public class SelectionSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        selectionSort(array, size);
        System.out.print("Final sorted array: " + array);

        scanner.close();
    }

    private static void selectionSort(int[] array, int size) {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            System.out.println("sorted array after iteration " + i + " : " + Arrays.toString(array));
        }
    }
}
