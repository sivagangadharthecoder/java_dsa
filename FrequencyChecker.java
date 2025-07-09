public class FrequencyChecker {

    public static void main(String[] args) {
        int num = 23145556;
        checkFrequency(num);
    }

    private static void checkFrequency(int num) {
        int temp = num;
        int[] arr = new int[10];

        while (temp > 0) {
            int digit = temp % 10;
            arr[digit]++;
            temp /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i] != 0) {
                System.out.println(i + " " + arr[i]);
            }
        }
    }
}