import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        public int par;

        public Node(int par) {
            this.par = par;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList[] g = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) g[i] = new ArrayList<Integer>();

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        int res = 0;
        boolean[] v = new boolean[N+1];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[1] = true;
        q.offer(new int[]{1, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cnt = 0;
            for (Integer nxt : (ArrayList<Integer>) g[cur[0]]) {
                if(v[nxt]) continue;
                cnt++;
                v[nxt] = true;
                q.offer(new int[]{nxt, cur[1]+1});
            }
            if(cnt == 0) res += cur[1];
        }

        System.out.println(res%2 == 0 ? "No" : "Yes");
        br.close();

    }

}