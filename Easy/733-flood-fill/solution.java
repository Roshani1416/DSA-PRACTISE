class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        int originalcolor = image[sr][sc];

        if(originalcolor==color) return image;

        boolean[][] vis =  new boolean[n][m];

        dfs(image,vis,sr,sc,originalcolor,color,n,m);

        return image;



        
    }

    public void dfs(int[][] image,boolean[][]vis,int i,int j,int originalcolor,int color,int n,int m){

        vis[i][j] = true; 
        image[i][j]=color;

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for(int k =0;k<4;k++){
            int newrow = i + dx[k];
            int newcol = j+dy[k];

            if(isvalid(newrow,newcol,n,m) && image[newrow][newcol]==originalcolor && !vis[newrow][newcol]){

                dfs(image,vis,newrow,newcol,originalcolor,color,n,m);
            }


        }

        
    }

    public boolean isvalid(int i,int j , int n , int m){

        return i>=0 && i<n && j>=0 && j < m;

    }

    
}
