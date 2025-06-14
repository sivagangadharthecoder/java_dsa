import java.util.Scanner;

public class Grades {
    public static String isPassingGrade(int grade) {
        if (grade >= 96 && grade <= 100)
            return "Outstanding";
        else if (grade >= 81 && grade <= 95)
            return "First Class";
        else if (grade >= 60 && grade <= 80)
            return "Second Class";
        else if (grade >= 0 && grade <= 59)
            return "Fail";
        else
            return "Invalid Grade";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your grade: ");
        int grade = sc.nextInt();

        String res = isPassingGrade(grade);
        System.out.println("Your grade is: " + res);
        sc.close();

    }
}