import java.util.*;

public class NegativeCycleDetection {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public String toString() {
            return "( " + u + ", " + v + ", " + w + " )";
        }
    }

    private static boolean isNegativeCycleDetected(int nodes, ArrayList<Edge> edgesList) {
        int[] dist = new int[nodes + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 1; i < nodes; i++) {
            for (Edge e : edgesList) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }

        for (Edge e : edgesList) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<Edge> edgesList = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edgesList.add(new Edge(u, v, w));
        }

        System.out.println("edges: " + edgesList);

        System.out.print("is found ? : " + isNegativeCycleDetected(nodes, edgesList));

        sc.close();
    }
}