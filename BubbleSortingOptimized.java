import java.util.Scanner;
import java.util.Arrays;

public class BubbleSortingOptimized {

    private static int size;
    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        size = scanner.nextInt();

        array = new int[size];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        bubbleSort(array, size);
        System.out.print("Final sorted array: " + Arrays.toString(array));

        scanner.close();
    }

    private static void bubbleSort(int[] array, int size) {
        boolean swapped = true;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = false;
                }
            }
            if (swapped) {
                break;
            } else {
                swapped = true;
            }
            System.out.println("Sorted array after iteration " + i + " : " + Arrays.toString(array));
        }
    }

}
