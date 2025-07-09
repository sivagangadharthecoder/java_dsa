import java.util.*;

public class subSetsSumTargetIndices {
    public static void main(String[] args) {

        int[] arr = { 1, 4, 3, 5 };
        int target = 9;

        System.out.print("indices in subset: " + findSubsetIndices(arr, target));
    }

    private static List<Integer> findSubsetIndices(int[] arr, int target) {
        int n = arr.length;
        int totalSubSets = 1 << n;

        for (int i = 0; i < totalSubSets; i++) {
            int currSum = 0;
            List<Integer> indices = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    currSum += arr[j];
                    indices.add(j);
                }
            }

            if (currSum == target && !indices.isEmpty()) {
                return indices;
            }
        }

        return new ArrayList<>();
    }

}