import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;

        ArrayList[] g = new ArrayList[N];
        for(int i = 0; i < N; i++) g[i] = new ArrayList<Integer>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            g[a].add(b);
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] dist = new int[N];
        Arrays.fill(dist, 300000);
        dist[X] = 0;
        q.offer(new int[]{0, X});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int nxt : (ArrayList<Integer>) g[cur[1]]) {
                if(dist[nxt] > cur[0]+1) {
                    dist[nxt] = cur[0]+1;
                    q.offer(new int[]{cur[0]+1, nxt});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(dist[i] == K) sb.append((i+1)+"\n");
        }
        System.out.println(sb.length() == 0 ? -1 : sb);
        br.close();
    }
}