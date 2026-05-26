import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int box = 1;

        for(int target : order) {

            while(box <= order.length && box < target) {
                stack.push(box);
                box++;
            }

            if(target == box) {
                answer++;
                box++;
            }
            
            else if(!stack.isEmpty() && stack.peek() == target) {
                answer++;
                stack.pop();
            }
            else break;
        }

        return answer;
    }
}