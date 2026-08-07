class Solution {
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0) return 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid,vis,i,j,n,m);
                    count++;
                }
            }
        }

        return count;
        
    }

    public void dfs(char[][] grid,boolean[][] vis , int i , int j , int n , int m){
        vis[i][j]=true;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int k =0;k<4;k++){
            int newrow = i+dx[k];
            int newcol = j+dy[k];

            if(isvalid(newrow,newcol,n,m) && grid[newrow][newcol]=='1' && !vis[newrow][newcol]){
                dfs(grid,vis,newrow,newcol,n,m);
            }
        }
    }

    public boolean isvalid(int i , int j , int n , int m){
        return i>=0 && i<n && j>=0 && j<m ; 
    }
}
