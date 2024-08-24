import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < K; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            ArrayList[] g = new ArrayList[V];
            for(int i = 0; i < V; i++) g[i] = new ArrayList();
            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                g[a].add(b);
                g[b].add(a);
            }

            boolean[] v = new boolean[V];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            boolean[] left = new boolean[V];
            boolean[] right = new boolean[V];
            boolean ans = true;
            for(int i = 0; i < V; i++) {
                if(v[i]) continue;
                v[i] = true;
                q.offer(new int[]{i, 0});
                left[i] = true;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (Integer nxt : (ArrayList<Integer>) g[cur[0]]) {
                        if(cur[1] == 0) right[nxt] = true;
                        else left[nxt] = true;
                        if(v[nxt]) continue;
                        v[nxt] = true;
                        q.offer(new int[]{nxt, ~cur[1]});
                    }
                }

            }
            for(int j = 0; j < V; j++) {
                if(left[j] == right[j]) ans = false;
            }
            if(ans) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
        br.close();
    }
}