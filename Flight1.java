public class Flight1 {
    private int id = 111;
    private String airline = "Air India";
    private String source = "London";
    private String destination = "Hyderabad";
    private float fare = 3500;
    private float duration = 1.5f;  

    public static void main(String[] args) {
        Flight1 flight1 = new Flight1();

        System.out.println(flight1.id);
        System.out.println(flight1.airline);
        System.out.println(flight1.source);
        System.out.println(flight1.destination);
        System.out.println(flight1.fare);
        System.out.println(flight1.duration);
    }
}
