class Solution {
    int answer = 0;
    int[] queen;

    public int solution(int n) {
        queen = new int[n];
        dfs(0, n);
        return answer;
    }

    private void dfs(int row, int n) {
        if(row == n) {
            answer++;
            return;
        }
        
        for(int col=0; col<n; col++) {
            if(check(row, col)) {
                queen[row] = col;
                dfs(row + 1, n);
            }
        }
    }
    
    private boolean check(int row, int col) {
        for(int i=0; i<row; i++) {
            if(queen[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - queen[i])) return false;
        }
        
        return true;
    }
}