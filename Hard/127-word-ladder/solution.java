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
