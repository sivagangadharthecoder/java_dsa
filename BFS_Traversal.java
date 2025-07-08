import java.util.*;

class BFS_Traversal {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if (adj == null || adj.size() == 0)
            return result;

        int V = adj.size();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        BFS_Traversal solution = new BFS_Traversal();

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

        ArrayList<Integer> bfsTraversal = solution.bfs(adj);
        System.out.println("adjacency list: " + adj);
        System.out.println("BFS Traversal: " + bfsTraversal);
    }
}
