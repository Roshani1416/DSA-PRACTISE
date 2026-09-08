class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];

        dfs(0,rooms,visited);

        for(boolean room : visited){
            if(!room){
                return false;
            }
        }

        return true;
    }

    public void dfs(int room , List<List<Integer>> rooms , boolean[] visited){

        if(visited[room]){
            return;
        }

        visited[room]=true;

        for(int keys: rooms.get(room)){
            dfs(keys,rooms,visited);
        }
    }
}
