class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if(a.frequency==b.frequency){
                        return b.word.compareTo(a.word);
                    }

                    return a.frequency - b.frequency;
                }
                );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String word = entry.getKey();
            int frequency = entry.getValue();

            pq.add(new Pair(entry.getKey(), entry.getValue()));

            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll().word);
        }

        Collections.reverse(ans);
        return ans;

    }

    static class Pair {

        String word;
        int frequency;

        Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
}
