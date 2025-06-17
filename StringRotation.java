import java.util.Scanner;

public class StringRotation {
    private static String originalString;
    private static String rotatedString;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string:");
        originalString = scanner.nextLine();
        System.out.print("Enter the second string:");
        rotatedString = scanner.nextLine();

        if (isRotated(originalString, rotatedString)) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }

        scanner.close();
    }

    public static boolean isRotated(String original, String rotated) {
        if (original.length() != rotated.length()) {
            return false;
        }
        String concatenated = rotated + rotated;
        return concatenated.contains(original);
    }
}
