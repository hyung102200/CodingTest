import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(long i=left; i<=right; i++){
            int num = (int) Math.max(i / n, i % n) + 1;
            arr.add(num);
        }
        for(int i=0; i<answer.length; i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}