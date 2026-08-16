class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        // First column and last column
        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(board, vis, i, 0, n, m);
            }

            if (board[i][m - 1] == 'O' && !vis[i][m - 1]) {
                dfs(board, vis, i, m - 1, n, m);
            }
        }

        // First row and last row
        for (int j = 0; j < m; j++) {

            if (board[0][j] == 'O' && !vis[0][j]) {
                dfs(board, vis, 0, j, n, m);
            }

            if (board[n - 1][j] == 'O' && !vis[n - 1][j]) {
                dfs(board, vis, n - 1, j, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }

            }
        }

        

    }

    public void dfs(char[][] board, boolean[][] vis ,int i , int j, int n , int m ){

        vis[i][j]=true;
        
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int k = 0;k<4;k++){
            int newrow = i + dx[k];
            int newcol = j+dy[k];

             if (isvalid(newrow, newcol, n, m)
                    && board[newrow][newcol] == 'O'
                    && !vis[newrow][newcol]) {

                dfs(board, vis, newrow, newcol, n, m);
            }
        }

    }

    public boolean isvalid(int i , int j , int n , int m){
        return i>=0 && i<n && j>=0 && j<m;
    }
}
