import java.io.*;
import java.util.*;

public class bj1260_4week {
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // (실버2) 백준 1260 DFS와 BFS
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 리스트 초기화
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a); // 양방향 그래프이므로 반대도 저장
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        dfs(v);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
    private static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for(int next : graph[v]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int v = q.poll();
            sb.append(v).append(" ");

            for(int next : graph[v]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
