import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static int[] op;
    static int opCount = 0;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for(int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
            opCount += op[i];
        }

        dfs(1, nums[0], 0);
        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    static void dfs(int idx, int result, int count) {
        if(count == opCount) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(op[i] != 0) {
                op[i]--;
                if(i == 0) dfs(idx + 1, result + nums[idx], count+1);
                else if(i == 1) dfs(idx + 1, result - nums[idx], count+1);
                else if(i == 2) dfs(idx + 1, result * nums[idx], count+1);
                else dfs(idx + 1, result / nums[idx], count+1);
                op[i]++;
            }
        }
    }
}
