import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N];
        for(int i = 0; i < N; i++) p[i] = i;

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);

        int cnt = 0;
        int ans = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(d == 1) union(a, b);
            else heap.offer(new int[]{c, a, b});
        }

        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            if(!union(cur[1], cur[2])) ans += cur[0];
        }
        System.out.println(ans);
        br.close();
    }

    private static int uFind(int n) {
        if(p[n] == n) return p[n];
        return p[n] = uFind(p[n]);
    }

    private static boolean union(int a, int b) {
        int pa = uFind(a);
        int pb = uFind(b);
        if(pa == pb) return false;
        p[pa] = pb;
        return true;
    }
}