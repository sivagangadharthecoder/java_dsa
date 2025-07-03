import java.util.*;

public class GraphDSA {

    public static void main(String[] args) {

        int v = 4;
        ArrayList<Edge>[] graph =  new ArrayList[v];
         for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        createGraph(graph);

        for (int i = 0; i < graph[3].size(); i++) {
            Edge e = graph[3].get(i);
            System.out.print("{ " + e.src + " ");
            System.out.print(e.dest + " ");
            System.out.print(e.weight + " }");
            System.out.println();
        }
    }

    private static void createGraph(ArrayList<Edge> graph[]) {

        graph[0].add(new Edge(0, 2, 2));
        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, 1));
    }
}

class Edge {
    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}
