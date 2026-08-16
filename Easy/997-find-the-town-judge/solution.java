class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int person = trust[i][0];
            int judge = trust[i][1];

            outDegree[person]++;
            inDegree[judge]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}
