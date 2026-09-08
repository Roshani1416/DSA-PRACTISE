class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>>graph = new ArrayList<>();

        for(int i = 0; i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[]time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];


            graph.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[1]-b[1]
        );

        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            if(distance>dist[node]){
                continue;
            }

            for(int[] edge: graph.get(node)){
                int neighbour = edge[0];
                int weight = edge[1];
                int newdist = distance+weight;

                if(newdist<dist[neighbour]){
                    dist[neighbour]=newdist;
                    pq.add(new int[]{neighbour,newdist});
                }
            }

        }

        int ans = 0;
        for(int i =1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }

            ans = Math.max(ans,dist[i]);
        }

        return ans;
        
    }
}
