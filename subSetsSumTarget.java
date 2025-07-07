public class subSetsSumTarget {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int target = 9;
        int count = countSubsets(arr, target);
        System.out.println("Number of subsets: " + count);
    }

    public static int countSubsets(int[] arr, int target) {
        int n = arr.length;
        int totalSubsets = 1 << n;
        int count = 0;

        for (int mask = 0; mask < totalSubsets; mask++) {
            int currentSum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentSum += arr[i];
                }
            }
            if (currentSum == target) {
                count++;
            }
        }
        return count;
    }
}