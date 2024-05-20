import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] g = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) g[i][j] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int[] v = new int[N];
            v[i] = 0;
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for(int k = 0; k < N; k++) {
                    if(v[k] == 1) continue;
                    if(g[cur][k] == 0) continue;
                    v[k] = 1;
                    q.offer(k);
                }
            }
            for(Integer a : v) sb.append(a + " ");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}