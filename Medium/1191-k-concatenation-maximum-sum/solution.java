
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
