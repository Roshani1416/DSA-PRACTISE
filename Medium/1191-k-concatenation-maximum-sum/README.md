# 1191. K-Concatenation Maximum Sum

**Difficulty:** Medium
**Tags:** Array, Dynamic Programming
**Language:** java
**Problem:** [https://leetcode.com/problems/k-concatenation-maximum-sum/](https://leetcode.com/problems/k-concatenation-maximum-sum/)

## Description

Given an integer array `arr` and an integer `k`, modify the array by repeating it `k` times.

For example, if `arr = [1, 2]` and `k = 3 `then the modified array will be `[1, 2, 1, 2, 1, 2]`.

Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be `0` and its sum in that case is `0`.

As the answer can be very large, return the answer **modulo** `109 + 7`.

 

**Example 1:**

**Input:** arr = [1, 2], k = 3

**Output:** 9

**Explanation:**

The concatenated array is `[1, 2, 1, 2, 1, 2]`.

The maximum-sum subarray is the entire array, with sum 1 + 2 + 1 + 2 + 1 + 2 = 9.

**Example 2:**

**Input:** arr = [1, -2, 1], k = 5

**Output:** 2

**Explanation:**

The concatenated array is `[1, -2, 1, 1, -2, 1, 1, -2, 1, 1, -2, 1, 1, -2, 1]`.

The maximum-sum subarray is `[1, 1]`, formed by the last element of one copy and the first element of the next copy, with sum 1 + 1 = 2.

**Example 3:**

**Input:** arr = [-1, -2], k = 7

**Output:** 0

**Explanation:**

Every element in the concatenated array is negative, so no subarray has a positive sum. Therefore, the maximum possible sum is 0.

 

**Constraints:**

  * `1 <= arr.length <= 105`
  * `1 <= k <= 105`
  * `-104 <= arr[i] <= 104`

## Solution

```java

class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {

        long MOD = 1_000_000_007L;
        int n = arr.length;

        long totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        long currsum = 0;
        long maxsum = 0;

        int limit = (k == 1) ? n : 2 * n;

        for (int i = 0; i < limit; i++) {
            int num = arr[i % n];

            currsum = Math.max(0, currsum + num);
            maxsum = Math.max(maxsum, currsum);
        }

        if (k > 2 && totalSum > 0) {
            maxsum += (long) (k - 2) * totalSum;
        }

        return (int) (maxsum % MOD);
    }
}
```
