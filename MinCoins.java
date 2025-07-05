import java.util.Arrays;

public class MinCoins {
    public static void main(String[] args) {
        int amount = 250;
        Integer[] coins = { 1, 5, 2, 10, 20, 100 };
        int minCoins = getMinCoins(amount, coins);
        System.out.println("Minimum number of coins required: " + minCoins);
    }

    public static int getMinCoins(int amount, Integer[] coins) {
        Arrays.sort(coins, (a, b) -> b - a);

        int count = 0;
        for (int coin : coins) {
            if (amount == 0)
                break;
            if (coin <= amount) {
                int numCoins = amount / coin;
                count += numCoins;
                amount -= numCoins * coin;
            }
        }
        return count;
    }
}