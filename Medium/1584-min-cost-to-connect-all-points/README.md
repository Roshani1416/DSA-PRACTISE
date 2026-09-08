# 1584. Min Cost to Connect All Points

**Difficulty:** Medium
**Tags:** Array, Union-Find, Graph Theory, Minimum Spanning Tree, Prim's Algorithm, Kruskal's Algorithm, Borůvka's Algorithm
**Language:** java
**Problem:** [https://leetcode.com/problems/min-cost-to-connect-all-points/](https://leetcode.com/problems/min-cost-to-connect-all-points/)

## Description

You are given an array `points` representing integer coordinates of some points on a 2D-plane, where `points[i] = [xi, yi]`.

The cost of connecting two points `[xi, yi]` and `[xj, yj]` is the **manhattan distance** between them: `|xi - xj| + |yi - yj|`, where `|val|` denotes the absolute value of `val`.

Return _the minimum cost to make all points connected._ All points are connected if there is **exactly one** simple path between any two points.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/08/26/d.png)
    
    
    **Input:** points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
    **Output:** 20
    **Explanation:** 
    ![](https://assets.leetcode.com/uploads/2020/08/26/c.png)
    We can connect the points as shown above to get the minimum cost of 20.
    Notice that there is a unique path between every pair of points.
    

**Example 2:**
    
    
    **Input:** points = [[3,12],[-2,5],[-4,1]]
    **Output:** 18
    

 

**Constraints:**

  * `1 <= points.length <= 1000`
  * `-106 <= xi, yi <= 106`
  * All pairs `(xi, yi)` are distinct.

## Solution

```java
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
```
