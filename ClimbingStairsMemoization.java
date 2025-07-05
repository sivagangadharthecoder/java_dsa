public class ClimbingStairsMemoization {
    private static int[] memo;

    public static void main(String[] args) {
        int steps = 4;
        memo = new int[steps + 1];
        System.out.println("Number of ways to climb " + steps + " steps: " + climbStairs(steps));
    }

    public static int climbStairs(int steps) {
        if (steps <= 0)
            return 0;
        if (steps == 1)
            return 1;
        if (steps == 2)
            return 2;

        if (memo[steps] != 0) {
            return memo[steps];
        }

        memo[steps] = climbStairs(steps - 1) + climbStairs(steps - 2);
        return memo[steps];
    }
}