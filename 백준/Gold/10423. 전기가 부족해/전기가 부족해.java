import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        HashMap<Integer, Boolean> generator = new HashMap<>();
        for (int i = 0; i < K; i++) generator.put(Integer.parseInt(st.nextToken()), true);

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            heap.offer(new int[]{w, u, v});
        }

        p = new int[N + 1];
        for(int i = 1; i <= N; i++) p[i] = i;

        int ans = 0;
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int pu = uFind(cur[1]);
            int pv = uFind(cur[2]);
            if(pu == pv) continue;
            if(generator.containsKey(pu) && generator.containsKey(pv)) continue;
            uMerge(cur[1], cur[2], generator);
            ans += cur[0];
        }

        System.out.println(ans);
        br.close();

    }

    private static int uFind(int n) {
        if(p[n] == n) return n;
        return p[n] = uFind(p[n]);
    }

    private static void uMerge(int a, int b, HashMap<Integer, Boolean> generator) {
        int pa = uFind(a);
        int pb = uFind(b);
        if(generator.containsKey(pa)) p[pb] = pa;
        else p[pa] = pb;
    }
}