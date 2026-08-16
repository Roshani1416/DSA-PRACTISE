import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });

                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while(!q.isEmpty() && fresh>0){

            int size = q.size();
            time++;

            for(int s =0;s<size;s++){

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int k =0;k<4;k++){
                    int newrow = r+dx[k];
                    int newcol = c+dy[k];

                    if(newrow >=0 && newrow < n && newcol >=0 && newcol<m && grid[newrow][newcol]==1){
                        grid[newrow][newcol]=2;
                        q.add(new int[]{newrow,newcol});
                        fresh--;
                    }
                }
            }
        }

        if(fresh>0) return -1;

        return time ;

    }
}
