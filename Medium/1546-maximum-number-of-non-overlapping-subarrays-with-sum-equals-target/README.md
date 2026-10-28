# 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target

**Difficulty:** Medium
**Tags:** Array, Hash Table, Greedy, Prefix Sum
**Language:** java
**Problem:** [https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/](https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/)

## Description

Given an array `nums` and an integer `target`, return _the maximum number of**non-empty** **non-overlapping** subarrays such that the sum of values in each subarray is equal to_ `target`.

 

**Example 1:**
    
    
    **Input:** nums = [1,1,1,1,1], target = 2
    **Output:** 2
    **Explanation:** There are 2 non-overlapping subarrays [**1,1** ,1,**1,1**] with sum equals to target(2).
    

**Example 2:**
    
    
    **Input:** nums = [-1,3,5,1,4,2,-9], target = 6
    **Output:** 2
    **Explanation:** There are 3 subarrays with sum equal to 6.
    ([5,1], [4,2], [3,5,1,4,2,-9]) but only the first 2 are non-overlapping.
    

 

**Constraints:**

  * `1 <= nums.length <= 105`
  * `-104 <= nums[i] <= 104`
  * `0 <= target <= 106`

## Solution

```java
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {

        int n = nums.length;
        int presum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int count = 0;
        int lastend = -1;


        for(int i = 0;i<n;i++){
            presum=presum+nums[i];
            int diff = presum-target;
            if(map.containsKey(diff)){
                int index = map.get(diff)+1;
                if(index>lastend){
                    count++;
                    lastend=i;

                    map.clear();
                    map.put(0,i);
                    presum=0;
                    continue;
                }
            }

            map.put(presum,i);

            
        }

        return count;
        
    }
}
```
