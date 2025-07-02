import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeapClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the array (space-separated): ");
        String input = sc.nextLine();

        List<Integer> arr = new ArrayList<>();
        for (String s : input.trim().split(" ")) {
            arr.add(Integer.parseInt(s));
        }

        System.out.println("Original array: " + arr);
        buildHeap(arr);
        System.out.println("Heapified array: " + arr);
        sc.close();
    }

    private static void buildHeap(List<Integer> arr) {
        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.size(), i);
        }
    }

    private static void heapify(List<Integer> arr, int heapSize, int nodeIndex) {
        int leftChildIndex = 2 * nodeIndex + 1;
        int rightChildIndex = 2 * nodeIndex + 2;
        int largest = nodeIndex;

        if (leftChildIndex < heapSize && arr.get(leftChildIndex) > arr.get(largest)) {
            largest = leftChildIndex;
        }
        if (rightChildIndex < heapSize && arr.get(rightChildIndex) > arr.get(largest)) {
            largest = rightChildIndex;
        }

        if (largest != nodeIndex) {
            swapHeap(arr, nodeIndex, largest);
            heapify(arr, heapSize, largest);
            
        }
    }

    private static void swapHeap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}