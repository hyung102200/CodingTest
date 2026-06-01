import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        List<Integer> list = new ArrayList<>();
        char[][] land = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            land[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {

                if (land[i][j] == 'X' || visited[i][j]) continue;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;

                int sum = 0;

                while (!q.isEmpty()) {
                    int[] narr = q.poll();
                    int nx = narr[0];
                    int ny = narr[1];

                    sum += land[nx][ny] - '0';

                    for (int k = 0; k < 4; k++) {
                        int xx = nx + dx[k];
                        int yy = ny + dy[k];

                        if (xx < 0 || xx >= maps.length ||
                            yy < 0 || yy >= maps[0].length()) {
                            continue;
                        }

                        if (visited[xx][yy] || land[xx][yy] == 'X') {
                            continue;
                        }

                        visited[xx][yy] = true;
                        q.add(new int[]{xx, yy});
                    }
                }

                list.add(sum);
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}