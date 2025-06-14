public class Flight5 {
    private int id;
    private String airline;
    private String source;
    private String destination;
    private float fare;
    private float duration;

    public Flight5(int id, String airline, String source, String destination, float fare, float duration) {
        this.id = id;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.duration = duration;

        System.out.println(this.id);
        System.out.println(this.airline);
        System.out.println(this.source);
        System.out.println(this.destination);
        System.out.println(this.fare);
        System.out.println(this.duration);
    }

    public static void main(String[] args) {
        Flight5 flight5 = new Flight5(1001, "AirIndia", "Bengalore", "Delhi", 6900.5f, 3.15f);
    }
}
