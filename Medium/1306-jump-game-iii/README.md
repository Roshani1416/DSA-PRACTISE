# 1306. Jump Game III

**Difficulty:** Medium
**Tags:** Array, Depth-First Search, Breadth-First Search
**Language:** java
**Problem:** [https://leetcode.com/problems/jump-game-iii/](https://leetcode.com/problems/jump-game-iii/)

## Description

Given an array of non-negative integers `arr`, you are initially positioned at `start` index of the array. When you are at index `i`, you can jump to `i + arr[i]` or `i - arr[i]`, check if you can reach **any** index with value 0.

Notice that you can not jump outside of the array at any time.

 

**Example 1:**
    
    
    **Input:** arr = [4,2,3,0,3,1,2], start = 5
    **Output:** true
    **Explanation:** 
    All possible ways to reach at index 3 with value 0 are: 
    index 5 -> index 4 -> index 1 -> index 3 
    index 5 -> index 6 -> index 4 -> index 1 -> index 3 
    

**Example 2:**
    
    
    **Input:** arr = [4,2,3,0,3,1,2], start = 0
    **Output:** true 
    **Explanation:** One possible way to reach at index 3 with value 0 is: 
    index 0 -> index 4 -> index 1 -> index 3
    

**Example 3:**
    
    
    **Input:** arr = [3,0,2,1,2], start = 2
    **Output:** false
    **Explanation:** There is no way to reach at index 1 with value 0.
    

 

**Constraints:**

  * `1 <= arr.length <= 5 * 104`
  * `0 <= arr[i] < arr.length`
  * `0 <= start < arr.length`

## Solution

```java
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
```
