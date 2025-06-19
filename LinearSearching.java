import java.util.Scanner;

public class LinearSearching {
    private static int size;
    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        size = scanner.nextInt();
        array = new int[size];
        System.out.print("Enter the elements: ");

        for (int i = 0; i < size; ++i) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int target = scanner.nextInt();

        int result = sentinelLinearSearch(array, size, target);
        if (result != -1) {
            System.out.println("Element is found at index: " + result);
        } else {
            System.out.println("Element is not found in the array.");
        }

        scanner.close();
    }

    public static int sentinelLinearSearch(int[] arr, int n, int target) {
        int last = arr[n - 1];
        arr[n - 1] = target;

        int i = 0;
        while (arr[i] != target) {
            i++;
        }

        arr[n - 1] = last;

        if (i < n - 1 || arr[n - 1] == target) {
            return i;
        }
        return -1;
    }
}
