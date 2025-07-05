import java.util.HashSet;

public class CommonUniqueElements {
    public static void main(String[] args) {
        int[] arr1 = { 4, 5, 9, 9 };
        int[] arr2 = { 9, 4, 9, 8, 4, 5 };

        findCommon(arr1, arr2);
    }

    private static void findCommon(int[] arr1, int[] arr2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            set2.add(num);
        }

        if (set1.size() < set2.size()) {
            set2.retainAll(set1);
            System.out.println("Common elements: " + set2);
        } else {
            set1.retainAll(set2);
            System.out.println("Common elements: " + set1);
        }
    }
}
