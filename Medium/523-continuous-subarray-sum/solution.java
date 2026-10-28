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
