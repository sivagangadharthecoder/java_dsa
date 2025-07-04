import java.util.Scanner;

public class UniqueChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string:");

        String input = scanner.nextLine();
        System.out.println("unique character: " + findUniqueChar(input));
        scanner.close();
    }

    private static char findUniqueChar(String str) {
        int[] charCount = new int[25];
        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }

        int count = 0;
        for (char c : str.toCharArray()) {
            if (charCount[c - 'a'] == 1) {
                count++;
            }
            if (count == 2) {
                return c;
            }
        }

        return '\0';
    }
}
