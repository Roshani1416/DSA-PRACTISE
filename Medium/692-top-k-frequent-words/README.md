# 692. Top K Frequent Words

**Difficulty:** Medium
**Tags:** Array, Hash Table, String, Trie, Sorting, Heap (Priority Queue), Bucket Sort, Counting
**Language:** java
**Problem:** [https://leetcode.com/problems/top-k-frequent-words/](https://leetcode.com/problems/top-k-frequent-words/)

## Description

Given an array of strings `words` and an integer `k`, return _the_`k` _most frequent strings_.

Return the answer **sorted** by **the frequency** from highest to lowest. Sort the words with the same frequency by their **lexicographical order**.

 

**Example 1:**
    
    
    **Input:** words = ["i","love","leetcode","i","love","coding"], k = 2
    **Output:** ["i","love"]
    **Explanation:** "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
    

**Example 2:**
    
    
    **Input:** words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
    **Output:** ["the","is","sunny","day"]
    **Explanation:** "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
    

 

**Constraints:**

  * `1 <= words.length <= 500`
  * `1 <= words[i].length <= 10`
  * `words[i]` consists of lowercase English letters.
  * `k` is in the range `[1, The number of **unique** words[i]]`



 

**Follow-up:** Could you solve it in `O(n log(k))` time and `O(n)` extra space?

## Solution

```java
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
```
