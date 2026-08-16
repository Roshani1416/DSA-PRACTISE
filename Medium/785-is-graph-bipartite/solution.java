class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] colors=new int[n];
        Arrays.fill(colors,-1);

        for(int i = 0 ; i < n ;i++){

            if(colors[i]==-1){
                if(!dfs(graph,i,0,colors)){
                    return false;
                }
            }
        }

        return true;
        
    }

    public boolean dfs(int[][] graph , int node , int color , int[] colors){

        colors[node]=color;

        for(int neigh : graph[node]){
            if(colors[neigh]==color){
                return false;
            }

            if(colors[neigh]==-1){
                if(!dfs(graph,neigh,1-color,colors)){
                    return false;
                }
            }
        }

        return true;
    }
}
