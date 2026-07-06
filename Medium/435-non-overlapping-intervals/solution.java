class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n = intervals.length;
       
        int count = 0;

       

        Arrays.sort(intervals,(a,b)-> a[1]-b[1]);
         int end = intervals[0][1];


        for(int i = 1;i<n;i++){
            int currstart=intervals[i][0];
            
            if(end>currstart){
                count++;
            }

            else{
               end=intervals[i][1];
            }



           


        }

        return count ; 
        
    }
}
