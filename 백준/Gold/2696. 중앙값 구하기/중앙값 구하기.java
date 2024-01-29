import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int M = Integer.parseInt(br.readLine());
            sb.append((M + 1) / 2 + "\n");
            Queue<Integer> sHeap = new PriorityQueue<>();
            Queue<Integer> mHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                if (j != 0 && j % 10 == 0) st = new StringTokenizer(br.readLine(), " ");
                int cur = Integer.parseInt(st.nextToken());
                if (sHeap.size() == 0) {
                    sb.append(cur+" ");
                    sHeap.offer(cur);
                    continue;
                }
                if (sHeap.size() == mHeap.size()) {
                    if (mHeap.peek() <= cur) sHeap.offer(cur);
                    else {
                        sHeap.offer(mHeap.poll());
                        mHeap.offer(cur);
                    }
                } else {
                    if (sHeap.peek() < cur) {
                        mHeap.offer(sHeap.poll());
                        sHeap.offer(cur);
                    } else  mHeap.offer(cur);
                }
                if (j % 2 == 0) {
                    if(++cnt%10 == 0) sb.append("\n");
                    sb.append(sHeap.peek() + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}