public class ClimbingStairs {
    public static void main(String[] args) {
        int steps = 3;
        System.out.println("Number of ways to climb " + steps + " steps: " + noOfWays(steps));
    }

    private static int noOfWays(int steps) {
        if (steps <= 0)
            return 0;
        if (steps == 1)
            return 1;
        if (steps == 2)
            return 2;
        return noOfWays(steps - 1) + noOfWays(steps - 2);
    }
}