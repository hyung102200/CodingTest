import java.util.*;

class Solution {
    class Node {
        int x;
        int y;
        int count;
        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        int startX = 0, startY = 0;
        
        char[][] miro = new char[n][m];
        
        for(int i=0; i<n; i++) {
            miro[i] = board[i].toCharArray();
            for(int j=0; j<m; j++) {
                if(miro[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[n][m];
        visited[startX][startY] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY, 0));
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            if(miro[now.x][now.y] == 'G') {
                return now.count;
            }
            
            for(int i=0; i<4; i++) {
                int nx = now.x;
                int ny = now.y;
                int ncount = now.count;
                
                while(true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if(tx < 0 || ty < 0 || tx >= n || ty >= m 
                       || miro[tx][ty] == 'D') {
                        break;
                    }
                    nx = tx;
                    ny = ty;
                    
                    
                }
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, ncount + 1));        
                }
            }
        }
        return -1;
    }
}







