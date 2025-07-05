import java.util.Arrays;

public class MinCoinsDP {
    public static void main(String[] args) {
        int amount = 15;
        int[] coins = { 1, 5, 2 };

        System.out.print("Minimum number of coins required to get " + amount + " is " + getMinCoinsDP(amount, coins));
    }

    public static int getMinCoinsDP(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}