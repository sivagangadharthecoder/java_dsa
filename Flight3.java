public class Flight3 {
    private int id;
    private String airline;
    private String source;
    private String destination;
    private float fare;
    private float duration;

    public static void main(String[] args) {
        Flight3 flight3 = new Flight3();

        System.out.println(flight3.id);
        System.out.println(flight3.airline);
        System.out.println(flight3.source);
        System.out.println(flight3.destination);
        System.out.println(flight3.fare);
        System.out.println(flight3.duration);
    }
}
