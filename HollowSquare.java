import java.util.Scanner;

public class HollowSquare {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of lines for the hollow square: ");

		toHollowShape(scanner.nextInt());

		scanner.close();
	}

	private static void toHollowShape(int number) {
		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= number; j++) {
				if (i == j || i + j == number + 1 || i == 1 || i == number || j == 1 || j == number) {
					if(i == (number / 2) + 1 && j == (number / 2) + 1) {
						System.out.print("@");
					}
					else {
						System.out.print("*");
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
