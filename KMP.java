import java.util.Arrays;

public class KMP {

    public static void main(String args[]) {

        String str = "aababacaab";
        System.out.println(findLength(str));
    }

    private static int findLength(String str) {

        int n = str.length();
        int res[] = new int[n];
        System.out.println("initial: " + Arrays.toString(res));

        int i = 1, len = 0;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                res[i] = len;
                i++;
                System.out.println(Arrays.toString(res));
            } else {
                if (len != 0) {
                    len = res[len - 1];
                    System.out.println(Arrays.toString(res));
                } else if (len == 0) {
                    i++;
                    System.out.println(Arrays.toString(res));
                }
            }
        }
        return res[n - 1];
    }
}