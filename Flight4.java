public class Flight4 {
    private int id;
    private String airline;
    private String source;
    private String destination;
    private float fare;
    private float duration;

    public Flight4() {
        id = 5678;
        System.out.println(id);
        System.out.println(airline);
        System.out.println(source);
        System.out.println(destination);
        System.out.println(fare);
        System.out.println(duration);
    }

    public static void main(String[] args) {
        Flight4 flight4 = new Flight4();
    }
}
