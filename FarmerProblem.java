public class FarmerProblem {
    public static void main(String[] args) {

        int totalLand = 80;
        int segments = 5;
        int segmentLand = totalLand / segments;

        double tomatoLandHighYield = 0.3 * segmentLand;
        double tomatoLandLowYield = 0.7 * segmentLand;
        double tomatoYieldHigh = tomatoLandHighYield * 10 * 1000;
        double tomatoYieldLow = tomatoLandLowYield * 12 * 1000;
        double tomatoSales = (tomatoYieldHigh + tomatoYieldLow) * 7;

        double potatoYield = segmentLand * 10 * 1000;
        double potatoSales = potatoYield * 20;

        double cabbageYield = segmentLand * 14 * 1000;
        double cabbageSales = cabbageYield * 24;

        double sunflowerYield = segmentLand * 0.7 * 1000;
        double sunflowerSales = sunflowerYield * 200;

        double sugarcaneYield = segmentLand * 45;
        double sugarcaneSales = sugarcaneYield * 4000;

        double totalSales = tomatoSales + potatoSales + cabbageSales + sunflowerSales + sugarcaneSales;

        double salesAt11Months = tomatoSales + potatoSales + cabbageSales + sunflowerSales;

        System.out.println("Overall sales from 80 acres of land:");
        System.out.printf("Tomatoes: ₹%.2f%n", tomatoSales);
        System.out.printf("Potatoes: ₹%.2f%n", potatoSales);
        System.out.printf("Cabbage: ₹%.2f%n", cabbageSales);
        System.out.printf("Sunflower: ₹%.2f%n", sunflowerSales);
        System.out.printf("Sugarcane: ₹%.2f%n", sugarcaneSales);
        System.out.printf("Total Sales: ₹%.2f%n", totalSales);

        System.out.println("\nSales realization from chemical-free farming at the end of 11 months:");
        System.out.printf("₹%.2f%n", salesAt11Months);

    }
}