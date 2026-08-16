# 1971. Find if Path Exists in Graph

**Difficulty:** Easy
**Tags:** Depth-First Search, Breadth-First Search, Union-Find, Graph Theory
**Language:** java
**Problem:** [https://leetcode.com/problems/find-if-path-exists-in-graph/](https://leetcode.com/problems/find-if-path-exists-in-graph/)

## Description

There is a **bi-directional** graph with `n` vertices, where each vertex is labeled from `0` to `n - 1` (**inclusive**). The edges in the graph are represented as a 2D integer array `edges`, where each `edges[i] = [ui, vi]` denotes a bi-directional edge between vertex `ui` and vertex `vi`. Every vertex pair is connected by **at most one** edge, and no vertex has an edge to itself.

You want to determine if there is a **valid path** that exists from vertex `source` to vertex `destination`.

Given `edges` and the integers `n`, `source`, and `destination`, return `true` _if there is a**valid path** from _`source` _to_`destination` _, or_`false` _otherwise_ _._

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/08/14/validpath-ex1.png)
    
    
    **Input:** n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
    **Output:** true
    **Explanation:** There are two paths from vertex 0 to vertex 2:
    - 0 -> 1 -> 2
    - 0 -> 2
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/08/14/validpath-ex2.png)
    
    
    **Input:** n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
    **Output:** false
    **Explanation:** There is no path from vertex 0 to vertex 5.
    

 

**Constraints:**

  * `1 <= n <= 2 * 105`
  * `0 <= edges.length <= 2 * 105`
  * `edges[i].length == 2`
  * `0 <= ui, vi <= n - 1`
  * `ui != vi`
  * `0 <= source, destination <= n - 1`
  * There are no duplicate edges.
  * There are no self edges.

## Solution

```java
import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return dfs(source, destination, adj, visited);

    }

    public boolean dfs(int node, int destination,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited) {

                if(node==destination){
                    return true;
                }

                visited[node]=true;

                for(int neighbour : adj.get(node)){

                    if(!visited[neighbour]){

                        if(dfs(neighbour,destination,adj,visited)){
                            return true;
                        }
                    }
                }

                return false;




    }
}
```
