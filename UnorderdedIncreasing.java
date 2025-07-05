public class UnorderdedIncreasing {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4, 3, 5, 4, 6 };
        System.out.println("Length of longest unordered increasing subsequence is: " + findUnorderedIncreasing(arr));
    }

    private static int findUnorderedIncreasing(int[] arr) {
        int maxLen = 1;

        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
