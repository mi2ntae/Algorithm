import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList[] g = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<Integer>();

        int[] indegree = new int[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            indegree[b]++;
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] ans = new int[N+1];
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                ans[i] = 1;
                q.offer(new int[]{i, 1});
            }
        }


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (Integer nxt : (ArrayList<Integer>) g[cur[0]]) {
                if(--indegree[nxt] == 0) {
                    ans[nxt] = cur[1]+1;
                    q.offer(new int[]{nxt, cur[1]+1});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(ans[i] + " ");
        System.out.println(sb);
        br.close();
    }
}