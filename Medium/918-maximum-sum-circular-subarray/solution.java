
class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int currsum = nums[0];
        int maxsum = nums[0];

        int totalsum = nums[0];
        int currminsum = nums[0];
        int minsum = nums[0];

        for (int i = 1; i < n; i++) {
            totalsum += nums[i];

            currsum = Math.max(nums[i], currsum + nums[i]);
            maxsum = Math.max(maxsum, currsum);

          
            currminsum = Math.min(nums[i], currminsum + nums[i]);
            minsum = Math.min(minsum, currminsum);
        }

        if (maxsum < 0) {
            return maxsum;
        }

        int circularsum = totalsum - minsum;

        return Math.max(maxsum, circularsum);
    }
}
