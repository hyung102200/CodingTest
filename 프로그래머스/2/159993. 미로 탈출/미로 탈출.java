import java.util.*;
class Solution {
    char[][] arr;
    int[] x = {0, 0, -1, 1};
    int[] y = {-1, 1, 0, 0};
    int sx = 0, sy = 0;
    boolean exit = false;
    int answer = 0;
    
    public int solution(String[] maps) {
        arr = new char[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++)
            arr[i] = maps[i].toCharArray();
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[i].length(); j++) {
                if(arr[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
            }
        }
        
        bfs(sx, sy, 'L');
        if(!exit) return -1;
        bfs(sx, sy, 'E');
        
        return exit ? answer : -1;
    }
    
    private void bfs(int startX, int startY, char find) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[startX][startY] = true;
        q.offer(new int[]{startX, startY, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            int depth = now[2];
            
            if(arr[nx][ny] == find) {
                if(find == 'L')  {
                    exit = true;
                    sx = nx;
                    sy = ny;
                    answer += depth;
                    return;
                }
                else if(find == 'E' && exit) {
                    answer += depth;
                    return;
                } 
            } 
                
            for(int i=0; i<4; i++) {
                int dx = nx + x[i];
                int dy = ny + y[i];
                    
                if(dx >= 0 && dx < arr.length
                            && dy >= 0 && dy < arr[0].length && !visited[dx][dy] && arr[dx][dy] != 'X'){
                    visited[dx][dy] = true;
                    q.offer(new int[]{dx, dy, depth + 1});
                }
            }
        }
        exit = false;
        return;
    }
}