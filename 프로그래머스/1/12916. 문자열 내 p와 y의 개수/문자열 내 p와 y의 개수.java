class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        char[] c = s.toCharArray();
        int p = 0, y = 0;
        for(char py : c) {
            if(py == 'p' || py == 'P') p++;
            else if(py == 'y' || py == 'Y') y++;
        }
        if(p != y) answer = false;

        return answer;
    }
}