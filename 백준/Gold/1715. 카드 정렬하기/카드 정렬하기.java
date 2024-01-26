import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    private static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) heap.offer(Integer.parseInt(br.readLine()));

        int ans = 0;
        while(heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();
            ans += first+second;
            heap.offer(first+second);
        }
        System.out.println(ans);
        br.close();
    }
}