import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList[] g = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            g[parent].add(child);
            g[child].add(parent);
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[] w = new int[n+1];
        boolean[] v = new boolean[n+1];
        v[a] = true;
        w[a] = 0;
        q.offer(new int[]{a, 1});
        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(Integer nxt : (ArrayList<Integer>) g[cur[0]]) {
                if(v[nxt]) continue;
                w[nxt] = cur[1];
                v[nxt] = true;
                q.offer(new int[]{nxt, cur[1]+1});
            }
        }
        System.out.println(w[b] == 0 ? -1 : w[b]);
        br.close();
    }
}