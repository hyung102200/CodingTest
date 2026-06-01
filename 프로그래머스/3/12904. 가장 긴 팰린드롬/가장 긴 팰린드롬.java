class Solution {
    int answer = 0;

    public int solution(String s) {

        for (int i = 0; i < s.length(); i++) {
            isPal(i, i, s);       // 홀수 길이
            isPal(i, i + 1, s);   // 짝수 길이
        }

        return answer;
    }

    private void isPal(int s, int e, String ss) {
        if (s < 0 || e >= ss.length()) return;

        if (ss.charAt(s) != ss.charAt(e)) return;

        answer = Math.max(answer, e - s + 1);

        isPal(s - 1, e + 1, ss);
    }
}