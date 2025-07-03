import java.util.ArrayList;
import java.util.List;

public class MinHeapClass {

    private static List<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        arr.add(10);
        arr.add(3);
        arr.add(2);
        arr.add(5);
        arr.add(1);
        arr.add(11);
        arr.add(4);

        System.out.println("Original array: " + arr);
        buildHeapDown(arr);
        System.out.println("HeapifyDown array: " + arr);

        arr.clear();
        arr.add(10);
        arr.add(3);
        arr.add(2);
        arr.add(5);
        arr.add(1);
        arr.add(11);
        arr.add(4);

        System.out.println("Original array: " + arr);
        buildHeapUp(arr);
        System.out.println("HeapifyUp array: " + arr);

        System.out.println("Peek: " + peekHeap());
        System.out.println("poll: " + pollHeap());
        System.out.println("Array after poll: " + arr);
        offerHeap(0);
        System.out.println("Array after offering 0: " + arr);
    }

    private static int peekHeap() {
        return arr.get(0);
    }

    private static int pollHeap() {
        int root = arr.get(0);
        arr.set(0, arr.remove(arr.size() - 1));
        heapifyDown(arr, arr.size(), 0);
        return root;
    }

    private static void offerHeap(int value) {
        arr.add(value);
        heapifyUp(arr, arr.size() - 1);
    }

    private static void buildHeapDown(List<Integer> arr) {
        for (int i = arr.size() / 2 - 1; i >= 0; i--) {
            heapifyDown(arr, arr.size(), i);
        }
    }

    private static void buildHeapUp(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            heapifyUp(arr, i);
        }
    }

    private static void heapifyDown(List<Integer> arr, int heapSize, int nodeIndex) {
        int leftChildIndex = 2 * nodeIndex + 1;
        int rightChildIndex = 2 * nodeIndex + 2;
        int smallest = nodeIndex;

        if (leftChildIndex < heapSize && arr.get(leftChildIndex) < arr.get(smallest)) {
            smallest = leftChildIndex;
        }
        if (rightChildIndex < heapSize && arr.get(rightChildIndex) < arr.get(smallest)) {
            smallest = rightChildIndex;
        }

        if (smallest != nodeIndex) {
            swapHeap(arr, nodeIndex, smallest);
            heapifyDown(arr, heapSize, smallest);
        }
    }

    private static void swapHeap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private static void heapifyUp(List<Integer> arr, int nodeIndex) {
        if (nodeIndex == 0)
            return;

        int parentIndex = (nodeIndex - 1) / 2;
        if (arr.get(nodeIndex) < arr.get(parentIndex)) {
            swapHeap(arr, nodeIndex, parentIndex);
            heapifyUp(arr, parentIndex);
        }
    }
}