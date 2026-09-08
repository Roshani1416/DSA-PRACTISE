# 1631. Path With Minimum Effort

**Difficulty:** Medium
**Tags:** Array, Binary Search, Depth-First Search, Breadth-First Search, Union-Find, Heap (Priority Queue), Matrix, Dijkstra's Algorithm
**Language:** java
**Problem:** [https://leetcode.com/problems/path-with-minimum-effort/](https://leetcode.com/problems/path-with-minimum-effort/)

## Description

You are a hiker preparing for an upcoming hike. You are given `heights`, a 2D array of size `rows x columns`, where `heights[row][col]` represents the height of cell `(row, col)`. You are situated in the top-left cell, `(0, 0)`, and you hope to travel to the bottom-right cell, `(rows-1, columns-1)` (i.e., **0-indexed**). You can move **up** , **down** , **left** , or **right** , and you wish to find a route that requires the minimum **effort**.

A route's **effort** is the **maximum absolute difference****** in heights between two consecutive cells of the route.

Return _the minimum**effort** required to travel from the top-left cell to the bottom-right cell._

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2020/10/04/ex1.png)
    
    
    **Input:** heights = [[1,2,2],[3,8,2],[5,3,5]]
    **Output:** 2
    **Explanation:** The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
    This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
    

**Example 2:**

![](https://assets.leetcode.com/uploads/2020/10/04/ex2.png)
    
    
    **Input:** heights = [[1,2,3],[3,8,4],[5,3,5]]
    **Output:** 1
    **Explanation:** The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
    

**Example 3:**

![](https://assets.leetcode.com/uploads/2020/10/04/ex3.png)
    
    
    **Input:** heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
    **Output:** 0
    **Explanation:** This route does not require any effort.
    

 

**Constraints:**

  * `rows == heights.length`
  * `columns == heights[i].length`
  * `1 <= rows, columns <= 100`
  * `1 <= heights[i][j] <= 106`

## Solution

```java
class Solution {
    public int minimumEffortPath(int[][] heights) {

         int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };


        while(!pq.isEmpty()){

            int[] current = pq.poll();

            int effort = current[0];
            int row = current[1];
            int col = current[2];

            if(row==n-1 && col==m-1){
                return effort; //destination reached 
            }

            if(effort>dist[row][col]){
                continue;
            }

             for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Boundary check
                if (newRow < 0 || newRow >= n ||
                    newCol < 0 || newCol >= m) {
                    continue;
                }

                // Effort required for this particular move
                int currentDiff = Math.abs(
                    heights[row][col] - heights[newRow][newCol]
                );

                // Path effort = maximum difference encountered so far
                int newEffort = Math.max(effort, currentDiff);

                if (newEffort < dist[newRow][newCol]) {

                    dist[newRow][newCol] = newEffort;

                    pq.add(new int[]{
                        newEffort,
                        newRow,
                        newCol
                    });
                }
            }


        }

        return 0;


        
    }
}
```
