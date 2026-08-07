# 200. Number of Islands

**Difficulty:** Medium
**Tags:** Array, Depth-First Search, Breadth-First Search, Union-Find, Matrix
**Language:** java
**Problem:** [https://leetcode.com/problems/number-of-islands/](https://leetcode.com/problems/number-of-islands/)

## Description

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return _the number of islands_.

An **island** is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

**Example 1:**
    
    
    **Input:** grid = [
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","0"]
    ]
    **Output:** 1
    

**Example 2:**
    
    
    **Input:** grid = [
      ["1","1","0","0","0"],
      ["1","1","0","0","0"],
      ["0","0","1","0","0"],
      ["0","0","0","1","1"]
    ]
    **Output:** 3
    

 

**Constraints:**

  * `m == grid.length`
  * `n == grid[i].length`
  * `1 <= m, n <= 300`
  * `grid[i][j]` is `'0'` or `'1'`.

## Solution

```java
class Solution {
    public int numIslands(char[][] grid) {

        if(grid==null || grid.length==0) return 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid,vis,i,j,n,m);
                    count++;
                }
            }
        }

        return count;
        
    }

    public void dfs(char[][] grid,boolean[][] vis , int i , int j , int n , int m){
        vis[i][j]=true;

        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};

        for(int k =0;k<4;k++){
            int newrow = i+dx[k];
            int newcol = j+dy[k];

            if(isvalid(newrow,newcol,n,m) && grid[newrow][newcol]=='1' && !vis[newrow][newcol]){
                dfs(grid,vis,newrow,newcol,n,m);
            }
        }
    }

    public boolean isvalid(int i , int j , int n , int m){
        return i>=0 && i<n && j>=0 && j<m ; 
    }
}
```
