class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        int count = 1;

        for (int i = 1; i < n; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (start1 >= start2 && end1 <= end2 || start1 <= start2 && end1 >= end2) {
                continue;

            } else {
                count++;
                start1 = start2;
                end1 = end2;
            }
        }

        return count;

    }
}
