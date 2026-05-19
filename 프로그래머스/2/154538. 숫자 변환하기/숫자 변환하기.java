import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean visited[] = new boolean[y + 1];
        
        q.offer(new int[]{x, 0});
        while(!q.isEmpty()) {
            int[] current = q.poll();
            
            int num = current[0];
            int count = current[1];
            
            if(num == y) return count;
            
            int[] next = {num + n, num * 2, num * 3};
            for(int i : next) {
                if(i <= y && !visited[i]) {
                    visited[i] = true;
                    q.offer(new int[]{i, count + 1});
                }
            }
        }
        
        return -1;
    }
}