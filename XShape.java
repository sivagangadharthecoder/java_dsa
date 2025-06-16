
public class XShape {
	
	public static void main(String[] args) {
		toXShape(5);
	}
	
	private static void toXShape(int number) {
		for(int i = 1; i <= number; i++) {
			for(int j = 1; j <= number; j++) {
				if(i == j || i+j == number + 1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
