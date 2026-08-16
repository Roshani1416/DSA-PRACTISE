class Solution {

    public int findCenter(int[][] edges) {

        // In a star graph, the center appears
        // in both of the first two edges.

        if (edges[0][0] == edges[1][0] ||
            edges[0][0] == edges[1][1]) {

            return edges[0][0];
        }

        return edges[0][1];
    }
}
