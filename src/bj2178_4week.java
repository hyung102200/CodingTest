import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178_4week {

    static class xy {
        int x, y;
        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int a, b;

    public static void main(String[] args) throws IOException {
        // (실버1) 백준 2178번 미로탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int[][] miro = new int[a+1][b+1];
        int[][] distance = new int[a+1][b+1];

        for(int i = 1; i <= a; i++) {
            char[] c = br.readLine().toCharArray();
            for(int j = 1; j <= b; j++) {
                miro[i][j] = c[j-1] - '0';
            }
        }

        bfs(1, 1, miro, distance);

        bw.write(distance[a][b] + "");

        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y, int[][] miro, int[][] distance) {
        Queue<xy> q = new LinkedList<>();
        q.offer(new xy(x, y));
        distance[x][y] = 1;

        while(!q.isEmpty()) {
            xy temp = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= 1 && nx <= a && ny >= 1 && ny <= b
                        && miro[nx][ny] == 1 && distance[nx][ny] == 0) {

                    distance[nx][ny] = distance[temp.x][temp.y] + 1;
                    q.offer(new xy(nx, ny));
                }
            }
        }
    }
}