import java.util.Scanner;

public class MinimumCableLength {

    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of computers: ");
        int computers = scanner.nextInt();

        System.out.print("Enter state of each computer (true/false): ");
        boolean[] computerState = new boolean[computers];

        System.out.println("minimum cable length required: " + calculateMinimumCableLength(computerState));

        scanner.close();
    }

    private static int calculateMinimumCableLength(boolean[] computerState) {
        count = 0;
        for (int i = 0; i < computerState.length; i++) {
            if (!computerState[i]) {
                count++;
            }
        }
        return count;
    }
}
