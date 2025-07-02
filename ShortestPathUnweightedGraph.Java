import java.util.*;

public class ShortestPathUnweightedGraph {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < q; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            System.out.println(bfs(adj, n, s, d));
        }
    }

    private static int bfs(List<List<Integer>> adj, int n, int s, int d) {
        if (s == d) return 0;
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});
        visited[s] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], dist = curr[1];
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    if (neighbor == d) return dist + 1;
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }
        return -1;
    }
}