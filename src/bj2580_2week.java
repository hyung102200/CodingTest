import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 빈칸 좌표 저장용 클래스
class Blank {
    int x;
    int y;
    Blank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class bj2580_2week {
    static int[][] sudoku;
    static ArrayList<Blank> blank;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];
        blank = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                int n =  Integer.parseInt(st.nextToken());
                sudoku[i][j] = n;
                if(n == 0) {
                    blank.add(new Blank(i, j));
                }
            }
        }
        solve(0);
    }

    private static void solve(int index) throws IOException {
        // 빈칸의 개수만큼 숫자를 채운 횟수가 같으면 출력하기
        if(index == blank.size()) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    bw.write(sudoku[i][j] + " ");
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.exit(0);
        }
        // 같지 않으면 아래코드 실행
        // 빈칸의 좌표 구하기
        int bx = blank.get(index).x;
        int by = blank.get(index).y;

        // 백트래킹 이용하여 빈칸 채우기
        for(int num=1; num<=9; num++) {
            if(check(bx, by, num)){
                sudoku[bx][by] = num;
                solve(index + 1);
                sudoku[bx][by] = 0;
            }
        }
    }

    private static boolean check(int x, int y, int num) {
        // 행 검사
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][y] == num) {
                return false;
            }
        }
        //열 검사
        for(int i = 0; i < 9; i++) {
            if(sudoku[x][i] == num) {
                return false;
            }
        }

        // 3*3 박스 검사
        // num이 포함되는 3*3박스의 첫번째 칸 좌표 구하기
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for(int i=startX; i<startX+3; i++) {
            for(int j=startY; j<startY+3; j++) {
                if(sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
