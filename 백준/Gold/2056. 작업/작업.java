import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList[] g = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) g[i] = new ArrayList<Integer>();
        int[] indegrees = new int[N+1];
        int[] weights = new int[N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            weights[i] = weight;
            for(int j = 0; j < cnt; j++) {
                int bef = Integer.parseInt(st.nextToken());
                g[bef].add(i);
                indegrees[i]++;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegrees[i] == 0) {
                q.add(new int[]{i, weights[i]});
                indegrees[i]--;
            }

        }

        int[] maxBef = new int[N+1];
        int maxTime = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int c = cur[0];
            int w = cur[1];
            maxTime = Math.max(maxTime, w);
            for(Integer nxt : (ArrayList<Integer>) g[c]) {
                maxBef[nxt] = Math.max(maxBef[nxt], w);
                if(--indegrees[nxt] <= 0) q.offer(new int[]{nxt, maxBef[nxt] + weights[nxt]});
            }
        }

        System.out.println(maxTime);
        br.close();
    }
}