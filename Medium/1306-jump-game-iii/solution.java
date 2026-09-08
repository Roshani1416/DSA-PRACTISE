class Solution {
    public boolean canReach(int[] arr, int start) {

        int n = arr.length;
        boolean[] visited = new boolean[n];

        return dfs(arr,start,visited);

       
    }

    public boolean dfs(int[] arr , int i , boolean[] visited){

        if (i < 0 || i >= arr.length) {
            return false;
        }

        if(visited[i]){
            return false;
        }

        if(arr[i]==0){
            return true;
        }

        visited[i]=true;

        int movef = i + arr[i];
        int moveb = i-arr[i];

        return dfs(arr,movef,visited)|| dfs(arr,moveb,visited);

    }
}
