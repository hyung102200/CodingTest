import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            switch(s.charAt(i)) {
                case '(': {
                    stack.push('(');
                    break;
                }
                case ')': {
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
            }
        }
        
        if(!stack.isEmpty()) return false;

        return true;
    }
}