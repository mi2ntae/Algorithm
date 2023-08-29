import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static boolean[] isMid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ArrayList[] g = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) g[i] = new ArrayList();
        int[] indegree = new int[N+1];
        int[][] sul = new int[N+1][N];

        isMid = new boolean[N+1];
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            isMid[a] = true;
            indegree[a]++;
            g[b].add(new int[]{a, c});
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            if(isMid[i]) continue;
            for(int[] nxt : (ArrayList<int[]>) g[i]) {
                sul[nxt[0]][i] = nxt[1];
                if(--indegree[nxt[0]] == 0) q.offer(nxt[0]);
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int[] nxt : (ArrayList<int[]>) g[cur]) {
                for(int i = 0; i < N; i++) sul[nxt[0]][i] += sul[cur][i] * nxt[1];
                if(--indegree[nxt[0]] == 0) q.offer(nxt[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N; i++) {
            if(sul[N][i] == 0) continue;
            sb.append(i+" "+sul[N][i]+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}