public class ClimbingStairsTabulation {
    public static void main(String[] args) {
        int steps = 4;
        System.out.println("Number of ways to climb " + steps + " steps: " + climbStairs(steps));
    }

    public static int climbStairs(int steps) {
        if (steps <= 0)
            return 0;
        if (steps == 1)
            return 1;
        if (steps == 2)
            return 2;

        int[] dp = new int[steps + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= steps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[steps];
    }
}