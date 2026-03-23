import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1920_2week {
    public static void main(String args[]) throws IOException {
        // 백준 1920번 수 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st =  new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 이분 검색을 이용하기 때문에 정렬
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new  StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            bw.write(search(arr, x, 0, n-1) + "\n");
        }

        bw.flush();
        bw.close();
    }
    // 이분 검색
    static private int search(int[] arr, int key, int l, int r) {
        int mid;
        if(l <= r) {
            mid = l + (r - l)/2;
            if(key == arr[mid]) return 1;
            else if(key < arr[mid]) return search(arr, key, l, mid - 1);
            else return search(arr, key, mid + 1, r);
        }
        return 0;
    }
}
