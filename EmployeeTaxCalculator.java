import java.util.Scanner;

public class EmployeeTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter employee name:");
        String name = scanner.nextLine();

        System.out.println("Enter employee location (cosmopolitan/semi urban/rural):");
        String location = scanner.nextLine().toLowerCase();

        System.out.println("Enter employee designation:");
        String designation = scanner.nextLine();

        System.out.println("Enter basic salary:");
        double basicSalary = scanner.nextDouble();

        System.out.println("Enter charity amount under 80G:");
        double charity = scanner.nextDouble();

        System.out.println("Enter home loan interest paid (max 120000):");
        double homeLoanInterest = scanner.nextDouble();

        System.out.println("Is employee eligible for section 87? (true/false):");
        boolean section87Eligible = scanner.nextBoolean();

        double hra;
        switch (location) {
            case "cosmopolitan":
                hra = 0.15 * basicSalary;
                break;
            case "semi urban":
                hra = 0.10 * basicSalary;
                break;
            case "rural":
                hra = 0.05 * basicSalary;
                break;
            default:
                hra = 0;
                System.out.println("Invalid location. HRA set to 0.");
        }

        double da = 0.12 * basicSalary;
        double monthlyBonus = 0.20 * basicSalary;

        double monthlySalaryWithoutBonus = basicSalary + hra + da;
        double monthlyGrossSalary = monthlySalaryWithoutBonus + monthlyBonus;
        double annualGrossSalary = monthlyGrossSalary * 12;
        double annualBonus = monthlyBonus * 12;

        double standardDeduction = Math.min(homeLoanInterest, 120000);
        double section87Deduction = section87Eligible ? 300000 : 0;

        double taxableIncome = annualGrossSalary - charity - standardDeduction - section87Deduction;
        if (taxableIncome < 0)
            taxableIncome = 0;

        double tax = calculateTax(taxableIncome);

        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Designation: " + designation);

        System.out.println("\nSalary Details:");
        System.out.printf("Basic Salary: ₹%.2f%n", basicSalary);
        System.out.printf("Monthly Gross Salary: ₹%.2f%n", monthlyGrossSalary);
        System.out.printf("Annual Gross Salary: ₹%.2f%n", annualGrossSalary);
        System.out.printf("Annual Bonus: ₹%.2f%n", annualBonus);

        System.out.println("\nTax Details:");
        System.out.printf("Taxable Income: ₹%.2f%n", taxableIncome);
        System.out.printf("Total Standard Deductions: ₹%.2f%n", (standardDeduction + section87Deduction + charity));
        System.out.printf("Tax Amount Payable: ₹%.2f%n", tax);

        scanner.close();
    }

    private static double calculateTax(double income) {
        double tax = 0;

        if (income > 2000000) {
            tax += (income - 2000000) * 0.30;
            income = 2000000;
        }
        if (income > 1500000) {
            tax += (income - 1500000) * 0.25;
            income = 1500000;
        }
        if (income > 1200000) {
            tax += (income - 1200000) * 0.20;
            income = 1200000;
        }
        if (income > 1000000) {
            tax += (income - 1000000) * 0.20;
            income = 1000000;
        }
        if (income > 800000) {
            tax += (income - 800000) * 0.15;
            income = 800000;
        }
        if (income > 500000) {
            tax += (income - 500000) * 0.10;
        }

        return tax;
    }
}