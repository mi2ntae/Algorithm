import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] g;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        g = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " \t");
            for(int j = 0; j < N; j++)  g[i][j] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        boolean[] v = new boolean[N];

        heap.offer(new int[]{0, 0});
        long ans = 0;
        int cnt = 0;
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            if(v[cur[1]]) continue;
            v[cur[1]] = true;
            ans += cur[0];
            if(++cnt == N) break;
            for(int i = 0; i < N; i++) {
                if(v[i] || cur[1] == i) continue;
                heap.offer(new int[]{g[cur[1]][i], i});
            }
        }
        System.out.println(ans);
        br.close();
    }
}