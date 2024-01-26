import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2-o1);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(heap.size() == 0) sb.append(0);
                else sb.append(heap.poll());
                sb.append("\n");
            } else heap.offer(num);
        }
        System.out.println(sb);
        br.close();
    }
}