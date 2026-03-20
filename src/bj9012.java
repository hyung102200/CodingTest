import java.io.*;

public class bj9012 {
    public static void main(String[] args) throws IOException {
        // 백준 9012번 괄호
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s =  br.readLine();
            int count = 0;
            boolean b = true;

            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '(') count++;
                else count--;

                if(count < 0) {
                    b = false;
                    break;
                }
            }

            if(count != 0) b = false;
            bw.write(b ? "YES\n" : "NO\n");
        }

        bw.flush();
        bw.close();
    }
}
