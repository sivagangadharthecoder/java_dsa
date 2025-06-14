public class Flight2 {

    private int id;
    private String airline;
    private String source;
    private String destination;
    private float fare;
    private float duration;

    {
        System.out.println(this.id);
        System.out.println(airline);
        System.out.println(source);
        System.out.println(destination);
        System.out.println(fare);
        System.out.println(duration);

        System.out.println("----------------------------");

        this.id = 1234;
        this.airline = "Akasa";
        this.source = "Vishakapatnam";
        this.destination = "Srinagar";
        this.fare = 8900;
        this.duration = 3.5f;
    }

    public static void main(String[] args) {
        Flight2 flight2 = new Flight2();
        System.out.println(flight2.id);
        System.out.println(flight2.airline);
        System.out.println(flight2.source);
        System.out.println(flight2.destination);
        System.out.println(flight2.fare);
        System.out.println(flight2.duration);
    }
}
