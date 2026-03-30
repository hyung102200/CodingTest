import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1759_3week {
    static String[] arr;
    static String[] result;
    static int l, c;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[c];
        result = new String[l];
        for(int i=0; i<c; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        makePasswd(0, 0);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
    private static void makePasswd(int start, int depth) {
        if(depth == l) {
            if(isValid()) {
                for (int i = 0; i < l; i++) {
                    sb.append(result[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for(int i=start; i<c; i++) {
            result[depth] = arr[i];
            makePasswd(i + 1, depth + 1);
        }
    }
    private static boolean isValid() {
        int mo = 0;
        int ja = 0;
        for(String s : result) {
            if(check(s)) mo++;
            else ja++;
        }
        return mo >= 1 && ja >= 2;
    }
    private static boolean check(String s) {
        return "aeiou".contains(s);
    }
}
