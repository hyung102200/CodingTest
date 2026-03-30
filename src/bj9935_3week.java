import java.io.*;
import java.util.Stack;

public class bj9935_3week {
    public static void main(String[] args) throws IOException {
        // (골드4) 백준 9935번 문자열 폭발
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();
        String s = br.readLine();
        String bomb = br.readLine();
        char last = bomb.charAt(bomb.length()-1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);

            // 매 문자열마다 검사하기엔 비효율적인거 같아서 마지막 문자열이 같을 때만 검사하기
            if(c==last && bomb.length() <= stack.size()) {
                boolean b = true;
                for(int j=0; j<bomb.length(); j++) {
                    if(stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        b = false;
                        break;
                    }
                }
                if(b){
                    for(int j=0; j<bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            bw.write("FRULA");
        }
        else {
            for(char c : stack){
                bw.write(c);
            }
        }
        bw.flush();
        bw.close();
    }
}
