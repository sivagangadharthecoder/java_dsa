import java.util.*;

public class MinVertexCoverTree {

    private static List<Integer>[] tree;
    private static boolean[] visited;
    private static int[][] dp;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tree = (ArrayList<Integer>[]) new ArrayList[n + 1];

        visited = new boolean[n + 1];
        dp = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        bfsDP(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

        sc.close();
    }

    public static void bfsDP(int root) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            stack.push(node);
            for (int child : tree[node]) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }

        while (!stack.isEmpty()) {
            int node = stack.pop();
            dp[node][0] = 0;
            dp[node][1] = 1;

            for (int child : tree[node]) {
                if (child != node && visited[child]) {
                    dp[node][0] += dp[child][1];
                    dp[node][1] += Math.min(dp[child][0], dp[child][1]);
                }
            }
        }
    }
}
