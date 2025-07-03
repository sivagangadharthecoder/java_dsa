public class SecondSmallest {
    public static void main(String[] args) {
        int[] arr = new int[] { 10, 9, 2, 3 };
        System.out.println("Second smallest element: " + secondMinE(arr));
    }

    private static int secondMinE(int[] arr) {

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < firstSmallest) {
                secondSmallest = firstSmallest;
                firstSmallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != firstSmallest) {
                secondSmallest = arr[i];
            }
        }

        return secondSmallest;
    }
}