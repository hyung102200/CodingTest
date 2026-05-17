import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.add(c);
        }

        for (int i = 0; i < s.length(); i++) {
            if (isValid(q)) {
                answer++;
            }
            // Deque를 한 칸 회전시킵니다.
            q.add(q.pollFirst());
        }
        return answer;
    }

    private boolean isValid(Deque<Character> q) {
        Stack<Character> stack = new Stack<>();
        for (char c : q) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char openBracket = stack.pop();
                if ((c == ')' && openBracket != '(') ||
                    (c == '}' && openBracket != '{') ||
                    (c == ']' && openBracket != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}