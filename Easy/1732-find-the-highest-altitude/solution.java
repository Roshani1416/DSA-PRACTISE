class Solution {
    public int largestAltitude(int[] gain) {

        int n = gain.length;
        int sum = 0;
        int maxsum = 0;


        for(int i = 0;i<n;i++){
            sum = sum+gain[i];
            maxsum=Math.max(maxsum,sum);

        }

        return maxsum;
        
    }
}
