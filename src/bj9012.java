import java.io.*;
import java.util.Stack;

public class bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            char[] arr = (br.readLine()).toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean b = true;
            for(char c : arr) {
                if(c == '(') stack.push(c);
                else if(c == ')') {
                    if (stack.isEmpty()) {
                        b = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) b = false;

            if(b) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }
}
