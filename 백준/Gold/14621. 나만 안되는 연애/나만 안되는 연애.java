import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] mw = new boolean[N];
        p = new int[N];
        for(int i = 0; i < N; i++) p[i] = i;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            if(st.nextToken().charAt(0) == 'M') mw[i] = true;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());
            if(mw[u] == mw[v]) continue;
            heap.offer(new int[]{d, u, v});
        }

        int ans = 0;
        int cnt = 0;
        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            if(union(cur[1], cur[2])) continue;
            ans += cur[0];
            if(++cnt == N-1) break;
        }
        System.out.println(cnt == N-1 ? ans : -1);
        br.close();
    }

    private static int uFind(int n) {
        if(p[n] == n) return n;
        return p[n] = uFind(p[n]);
    }

    private static boolean union(int a, int b) {
        int pa = uFind(a);
        int pb = uFind(b);
        if(pa == pb) return true;
        p[pa] = pb;
        return false;
    }
}