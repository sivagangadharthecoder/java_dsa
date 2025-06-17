import java.util.Arrays;
import java.util.Scanner;

public class AlternativeStanding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] girls = new int[size];
        System.out.print("Enter the heights of girls:");
        for (int i = 0; i < size; i++) {
            girls[i] = scanner.nextInt();
        }

        int[] boys = new int[size];
        System.out.print("Enter the heights of boys:");
        for (int i = 0; i < size; i++) {
            boys[i] = scanner.nextInt();
        }

        System.out.println("Is it possible to make the arrangement ? " + (checkArrangement(girls, boys, size)));

        scanner.close();
    }

    private static boolean checkArrangement(int[] girls, int[] boys, int size) {
        Arrays.sort(girls);
        Arrays.sort(boys);

        boolean isValid = true;

        for (int i = 0; i < size; i++) {
            if (girls[i] > boys[i]) {
                isValid = false;
                break;
            }
            if (i > 0 && girls[i - 1] > boys[i]) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            for (int i = 0; i < size; i++) {
                if (girls[i] < boys[i]) {
                    isValid = false;
                    break;
                }
                if (i > 0 && boys[i - 1] > girls[i]) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }
}
