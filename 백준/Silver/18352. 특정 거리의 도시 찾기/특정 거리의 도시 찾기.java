import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        ArrayList[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<Integer>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g[A].add(B);
        }

        Deque<int[]> q = new ArrayDeque<>();
        boolean[] v = new boolean[N + 1];
        int[] distance = new int[N + 1];

        v[X] = true;
        distance[X] = 0;
        q.offer(new int[]{X, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (Integer nxt : (ArrayList<Integer>) g[cur[0]]) {
                if (v[nxt]) continue;
                v[nxt] = true;
                distance[nxt] = cur[1] + 1;
                q.offer(new int[]{nxt, cur[1] + 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) sb.append(i+"\n");
        }
        if(sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);
        br.close();
    }

}