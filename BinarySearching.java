import java.util.Scanner;

public class BinarySearching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");

        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter the elements of the array: ");

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the target element to search: ");
        int target = sc.nextInt();

        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.print("Element found at index: " + result);
        } else {
            System.out.print("Element not found in the array at: " + result);
        }

        sc.close();
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        do {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } while (left <= right);

        return -1;
    }
}
