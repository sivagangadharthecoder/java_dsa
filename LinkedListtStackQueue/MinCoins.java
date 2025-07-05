import java.util.Arrays;
import java.util.Collections;

public class MinCoins {
    public static void main(String[] args) {
        int amount = 11;
        Integer[] coins = { 5, 2, 1 };
        int minCoins = getMinCoins(amount, coins);
        System.out.println("Minimum number of coins required: " + minCoins);
    }

    public static int getMinCoins(int amount, Integer[] coins) {
        Arrays.sort(coins, Collections.reverseOrder());

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