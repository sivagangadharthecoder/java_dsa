import java.util.ArrayList;
import java.util.Arrays;

public class DFS_Traversal {

    private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if (adj == null || adj.size() == 0)
            return result;

        boolean[] visited = new boolean[adj.size()];
        dfsHelper(1, adj, visited, result);
        return result;
    }

    private static void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        adj.add(new ArrayList<>(Arrays.asList(6)));
        adj.add(new ArrayList<>(Arrays.asList(8, 7)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());

        System.out.println("adjacency list: " + adj);
        ArrayList<Integer> res = dfs(adj);
        System.out.println("dfs: " + res);
    }
}