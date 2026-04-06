import java.io.*;
import java.util.PriorityQueue;

public class bj11286_4week {
    public static void main(String[] args) throws IOException {
        // (실버1) 백준 11286 절댓값 힙
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 단순히 리스트를 사용하면 값을 꺼낼 때마다 정렬해야 한다.
        // 우선순위 큐를 사용해 절댓값이 가장 작은 값을 먼저 꺼낼 수 있도록 함.
        // 우선순위 큐는 기본적으로 오름차순으로 정렬된 힙 이므로 정렬 기준을 절댓값 기준으로 변경함.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b))
                return a-b;
            return Math.abs(a) - Math.abs(b);
        });

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                bw.write(pq.isEmpty() ? "0\n" : pq.poll()+"\n");
            }
            else pq.add(num);
        }

        bw.flush();
        bw.close();
    }
}
