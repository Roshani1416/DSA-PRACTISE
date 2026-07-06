class Solution {
    public int findMinArrowShots(int[][] points) {

        int n = points.length;
        Arrays.sort(points,(a,b)->a[1]-b[1]);
        int start1=points[0][0];
        int end1 = points[0][1];
        int arrow=end1;
        int count = 1;

        for(int i = 1;i<n;i++){

            int start2=points[i][0];
            int end2=points[i][1];

            if(arrow>=start2 && arrow<=end2){
                
                continue;
            }

            else{
                
                arrow=end2;
                count++;
                
            }


        
        }

        return count;
        
    }
}
