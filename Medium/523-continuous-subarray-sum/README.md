# 523. Continuous Subarray Sum

**Difficulty:** Medium
**Tags:** Array, Hash Table, Math, Prefix Sum, Pigeonhole Principle
**Language:** java
**Problem:** [https://leetcode.com/problems/continuous-subarray-sum/](https://leetcode.com/problems/continuous-subarray-sum/)

## Description

Given an integer array nums and an integer k, return `true` _if_`nums` _has a**good subarray** or _`false` _otherwise_.

A **good subarray** is a subarray where:

  * its length is **at least two** , and
  * the sum of the elements of the subarray is a multiple of `k`.



**Note** that:

  * A **subarray** is a contiguous part of the array.
  * An integer `x` is a multiple of `k` if there exists an integer `n` such that `x = n * k`. `0` is **always** a multiple of `k`.



 

**Example 1:**
    
    
    **Input:** nums = [23,_2,4_ ,6,7], k = 6
    **Output:** true
    **Explanation:** [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
    

**Example 2:**
    
    
    **Input:** nums = [_23,2,6,4,7_], k = 6
    **Output:** true
    **Explanation:** [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
    42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
    

**Example 3:**
    
    
    **Input:** nums = [23,2,6,4,7], k = 13
    **Output:** false
    

 

**Constraints:**

  * `1 <= nums.length <= 105`
  * `0 <= nums[i] <= 109`
  * `0 <= sum(nums[i]) <= 231 - 1`
  * `1 <= k <= 231 - 1`

## Solution

```java
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;
        
        int psum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        

        

        

        for(int i = 0;i<n;i++){
            psum=psum+nums[i];
            int rem = psum%k;
            

            if(map.containsKey(rem)){
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            }

           else{
             map.put(rem,i);
           }
            
            

        }

        return false;
        
        
    }
}
```
