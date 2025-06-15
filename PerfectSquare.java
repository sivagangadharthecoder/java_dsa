public class PerfectSquare {
    public static boolean isPerfectSquare(int n) {
        if (n < 0) {
            return false;
        }

        int start = 1;
        while (start * start <= n) {
            if (start * start == n) {
                return true;
            }
            start++;
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 10000;
        if (isPerfectSquare(number)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
