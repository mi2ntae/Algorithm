import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] edges = new int[M][3];
        p = new int[N+1];
        for(int i = 1; i <= N; i++) p[i] = i;

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new int[]{c, a, b};
        }
        Arrays.sort(edges, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int ans = 0;
        for(int[] cur :edges) {
            if(uMerge(cur[1] ,cur[2])) continue;
            ans += cur[0];
        }
        System.out.println(ans);
        br.close();
    }

    private static int uFind(int n) {
        if(p[n] == n) return n;
        return p[n] = uFind(p[n]);
    }

    private static boolean uMerge(int a, int b) {
         int pa = uFind(a);
         int pb = uFind(b);
         if(pa == pb) return true;
         p[pb] = pa;
         return false;
    }
}