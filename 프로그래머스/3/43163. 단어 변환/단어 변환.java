import java.util.*;
class Solution {
    class Words {
        String word;
        int depth;
        public Words(String word, int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (!Arrays.asList(words).contains(target)) 
            return 0;
        Queue<Words> q = new LinkedList<>();
        q.add(new Words(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            Words now = q.poll();
            String s = now.word;
            int d = now.depth;
            if(s.equals(target))
                return d;
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && check(s, words[i])){
                    visited[i] = true;
                    q.add(new Words(words[i], d + 1));
                }
            }
        }
        
        return 0;
    }
    static boolean check(String s, String e) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != e.charAt(i)) count++;
            if(count > 1) return false;
        }
        return true;
    }
}