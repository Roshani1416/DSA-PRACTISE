# 994. Rotting Oranges

**Difficulty:** Medium
**Tags:** Array, Breadth-First Search, Matrix
**Language:** java
**Problem:** [https://leetcode.com/problems/rotting-oranges/](https://leetcode.com/problems/rotting-oranges/)

## Description

You are given an `m x n` `grid` where each cell can have one of three values:

  * `0` representing an empty cell,
  * `1` representing a fresh orange, or
  * `2` representing a rotten orange.



Every minute, any fresh orange that is **4-directionally adjacent** to a rotten orange becomes rotten.

Return _the minimum number of minutes that must elapse until no cell has a fresh orange_. If _this is impossible, return_ `-1`.

 

**Example 1:**

![](https://assets.leetcode.com/uploads/2019/02/16/oranges.png)
    
    
    **Input:** grid = [[2,1,1],[1,1,0],[0,1,1]]
    **Output:** 4
    

**Example 2:**
    
    
    **Input:** grid = [[2,1,1],[0,1,1],[1,0,1]]
    **Output:** -1
    **Explanation:** The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    

**Example 3:**
    
    
    **Input:** grid = [[0,2]]
    **Output:** 0
    **Explanation:** Since there are already no fresh oranges at minute 0, the answer is just 0.
    

 

**Constraints:**

  * `m == grid.length`
  * `n == grid[i].length`
  * `1 <= m, n <= 10`
  * `grid[i][j]` is `0`, `1`, or `2`.

## Solution

```java
import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });

                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int time = 0;

        

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while(!q.isEmpty() && fresh>0){

            int size = q.size();
            time++;

            for(int s =0;s<size;s++){

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int k =0;k<4;k++){
                    int newrow = r+dx[k];
                    int newcol = c+dy[k];

                    if(newrow >=0 && newrow < n && newcol >=0 && newcol<m && grid[newrow][newcol]==1){
                        grid[newrow][newcol]=2;
                        q.add(new int[]{newrow,newcol});
                        fresh--;
                    }
                }
            }
        }

        if(fresh>0) return -1;

        return time ;

    }
}
```
