import java.io.*;

public class bj2447_2week {
    private static char[][] arr;
    public static void main(String[] args) throws IOException {
        // 백준 2447번 별 찍기 - 10
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 배열 공백으로 초기화
        arr = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = ' ';

        star(0, 0, n);

        for(char[] c : arr) {
            for(char cc : c) {
                bw.write(cc + "");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    // 재귀 이용하여 별 찍기
    static private void star(int x, int y, int size) {
        if(size == 1) {
            arr[x][y] = '*';
            return;
        }
        int newSize = size / 3;

        for(int i=0; i<=2; i++) {
            for(int j=0; j<=2; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                else {
                    star(x + newSize * i, y + newSize * j, newSize);
                }
            }
        }
    }
}
