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
