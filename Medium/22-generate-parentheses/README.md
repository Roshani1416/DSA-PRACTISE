# 22. Generate Parentheses

**Difficulty:** Medium
**Tags:** String, Dynamic Programming, Backtracking
**Language:** java
**Problem:** [https://leetcode.com/problems/generate-parentheses/](https://leetcode.com/problems/generate-parentheses/)

## Description

Given `n` pairs of parentheses, write a function to _generate all combinations of well-formed parentheses_.

 

**Example 1:**
    
    
    **Input:** n = 3
    **Output:** ["((()))","(()())","(())()","()(())","()()()"]
    

**Example 2:**
    
    
    **Input:** n = 1
    **Output:** ["()"]
    

 

**Constraints:**

  * `1 <= n <= 8`

## Solution

```java
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        solve(ans,"",0,0,n);
        return ans;
        
    }

    public void solve(List<String> ans , String current , int open , int close , int n ){
        if(open==n && close==n){
            ans.add(current);
            return ;
        }

        if(open<n){
            solve(ans,current+"(",open+1,close,n);
        }

        if(close<open){
            solve(ans,current+")",open,close+1,n);
        }
    }
}
```
