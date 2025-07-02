import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    bfs(grid, i, j, directions);
                }
            }
        }

        return islandCount;
    }

    private void bfs(char[][] grid, int startX, int startY, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startX, startY });
        grid[startX][startY] = '0';

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < grid.length &&
                        newY >= 0 && newY < grid[0].length &&
                        grid[newX][newY] == '1') {

                    queue.offer(new int[] { newX, newY });
                    grid[newX][newY] = '0';
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '0', '1', '0', '1', '0' },
                { '0', '0', '1', '1', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println("Number of islands: " + solution.numIslands(grid));
    }
}
