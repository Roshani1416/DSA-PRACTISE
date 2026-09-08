class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;
        int low = grid[0][0];
        int high = n * n - 1;

        while (low <= high) {

            int guess = (low + high) / 2;
            if (canreach(grid, guess)) {
                high = guess - 1;
            }

            else {
                low = guess + 1;
            }
        }

        return low;

    }

    public boolean canreach(int[][] grid, int waterlevel) {

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> q = new LinkedList<>();

        if (grid[0][0] > waterlevel) {
            return false;
        }

        q.add(new int[] { 0, 0 });
        visited[0][0] = true;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int[] current = q.poll();

            int row = current[0];
            int col = current[1];

            if (row == n - 1 && col == n - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newrow = row + dx[i];
                int newcol = col + dy[i];

                if (newrow < 0 || newrow >= n || newcol < 0 || newcol >= n) {
                    continue;
                }

                if (visited[newrow][newcol]) {
                    continue;
                }

                if (grid[newrow][newcol] > waterlevel) {
                    continue;
                }

                visited[newrow][newcol] = true;
                q.add(new int[] { newrow, newcol });
            }
        }

        return false;

    }
}
