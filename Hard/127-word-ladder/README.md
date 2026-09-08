# 127. Word Ladder

**Difficulty:** Hard
**Tags:** Hash Table, String, Breadth-First Search, Bidirectional Search
**Language:** java
**Problem:** [https://leetcode.com/problems/word-ladder/](https://leetcode.com/problems/word-ladder/)

## Description

A **transformation sequence** from word `beginWord` to word `endWord` using a dictionary `wordList` is a sequence of words `beginWord -> s1 -> s2 -> ... -> sk` such that:

  * Every adjacent pair of words differs by a single letter.
  * Every `si` for `1 <= i <= k` is in `wordList`. Note that `beginWord` does not need to be in `wordList`.
  * `sk == endWord`



Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return _the**number of words** in the **shortest transformation sequence** from_ `beginWord` _to_ `endWord` _, or_`0` _if no such sequence exists._

 

**Example 1:**
    
    
    **Input:** beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    **Output:** 5
    **Explanation:** One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    

**Example 2:**
    
    
    **Input:** beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    **Output:** 0
    **Explanation:** The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
    

 

**Constraints:**

  * `1 <= beginWord.length <= 10`
  * `endWord.length == beginWord.length`
  * `1 <= wordList.length <= 5000`
  * `wordList[i].length == beginWord.length`
  * `beginWord`, `endWord`, and `wordList[i]` consist of lowercase English letters.
  * `beginWord != endWord`
  * All the words in `wordList` are **unique**.

## Solution

```java
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int n = wordList.size();
        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        set.remove(beginWord);
        int level = 1;


        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                String current = q.poll();

                char[] chars = current.toCharArray();

                for(int j = 0;j<chars.length;j++){
                    char original = chars[j];

                    for(char c = 'a';c<='z';c++){
                        if(c==original){
                            continue;
                        }

                        chars[j]=c;

                        String nextword = new String(chars);


                        if(nextword.equals(endWord)){
                            return level+1;
                        }

                        if(set.contains(nextword)){
                            q.add(nextword);
                            set.remove(nextword);
                        }
                        
                    }

                    chars[j]=original;
                }
            }

            level++;
        }

        return 0;
        
    }
}
```
