import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0]);
        PriorityQueue<Integer> res = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            heap.offer(new int[]{d, w});
        }

        boolean[] v = new boolean[1001];
        int bef = 0;
        int remain = 0;
        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            if(cur[0]-bef > 1) remain += cur[0]-bef-1;
            if(v[cur[0]]) {
                if(remain > 0) {
                    remain--;
                    res.offer(cur[1]);
                } else {
                    if(res.peek() < cur[1]) {
                        res.poll();
                        res.offer(cur[1]);
                    }
                }
            } else {
                v[cur[0]] = true;
                res.offer(cur[1]);
            }
            bef = cur[0];
        }

        int ans = 0;
        while(!res.isEmpty()) {
            int k = res.poll();
            ans += k;
        }
        System.out.println(ans);
        br.close();
    }
}