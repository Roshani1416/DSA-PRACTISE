class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];

        // {cost, point}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.add(new int[]{0, 0});

        int mstWeight = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            int[] current = pq.poll();

            int cost = current[0];
            int node = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            mstWeight += cost;
            count++;

            // Try connecting current node to every other point
            for (int neighbour = 0; neighbour < n; neighbour++) {

                if (visited[neighbour]) {
                    continue;
                }

                int weight = Math.abs(
                    points[node][0] - points[neighbour][0]
                ) + Math.abs(
                    points[node][1] - points[neighbour][1]
                );

                pq.add(new int[]{weight, neighbour});
            }
        }

        return mstWeight;
    }
}
