public class CaseChanging {
    public static void main(String[] args) {

        String input = "Hello World!";
        char ch = input.charAt(0);

        if (Character.isUpperCase(ch)) {
            String output = input.toUpperCase();
            System.out.println("Lowercase: " + output);
        } else {
            String output = input.toLowerCase();
            System.out.println("Uppercase: " + output);
        }
    }
}
