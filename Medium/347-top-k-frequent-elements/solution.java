class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.frequency - b.frequency);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int element = entry.getKey();
            int frequency = entry.getValue();

            Pair curr = new Pair(element, frequency);

            if (pq.size() < k) {
                pq.add(curr);
            }

            else if (curr.frequency > pq.peek().frequency) {
                pq.poll();
                pq.add(curr);
            }

        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().element;
        }

        return ans;

    }

    static class Pair {
        int element;
        int frequency;

        Pair(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
    }

}
