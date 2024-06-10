import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList[] g = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) g[i] = new ArrayList<int[]>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new int[]{c, b});
            g[b].add(new int[]{c, a});
        }

        st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int ans = 0;
        boolean[] v = new boolean[N+1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[2] - o1[2] : o2[0] - o1[0]);
        heap.offer(new int[]{0, p, 1000000001});
        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            if(v[cur[1]]) continue;
            v[cur[1]] = true;
            if(cur[1] == q) {
                ans = cur[2];
                break;
            }
            for (int[] nxt : (ArrayList<int[]>) g[cur[1]]) {
                int res = cur[2] > nxt[0] ? nxt[0] : cur[2];
                heap.offer(new int[]{nxt[0], nxt[1], res});
            }
        }
        System.out.println(ans);
        br.close();
    }
}