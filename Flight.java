import java.util.Objects;

public class Flight {
    private int id = 111;
    private String airline = "SpiceJet";
    private String source = "Chennai";
    private String destination = "Hyderabad";
    private float fare = 3500;
    private float duration = 1.5f;

    {
        System.out.println("From the Instance Initializer Block");
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

    public Flight() {

    }

    public Flight(int id, String airline, String source, String destination, float fare, float duration) {
        super();
        System.out.println("From the All Arg Cons");
        System.out.println(this.id);
        System.out.println(this.airline);
        System.out.println(this.source);
        System.out.println(this.destination);
        System.out.println(this.fare);
        System.out.println(this.duration);
        System.out.println("----------------------------");
        this.id = id;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.duration = duration;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Flight [id=" + id + ", airline=" + airline + ", source=" + source + ", destination=" + destination
                + ", fare=" + fare + ", duration=" + duration + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(airline, destination, duration, fare, id, source);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Flight other = (Flight) obj;
        return Objects.equals(airline, other.airline) && Objects.equals(destination, other.destination)
                && Float.floatToIntBits(duration) == Float.floatToIntBits(other.duration)
                && Float.floatToIntBits(fare) == Float.floatToIntBits(other.fare) && id == other.id
                && Objects.equals(source, other.source);
    }

    public static void main(String[] args) {
        Flight flight2 = new Flight(1001, "AirIndia", "Bengaluru", "Delhi", 6900.5f, 3.15f);
        System.out.println("Flight details initialized by the User");
        System.out.println(flight2.id);
        System.out.println(flight2.airline);
        System.out.println(flight2.source);
        System.out.println(flight2.destination);
        System.out.println(flight2.fare);
        System.out.println(flight2.duration);
    }
}
