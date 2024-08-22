import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] costs = new int[N][N];
        int[][] g = new int[N][N];

        for (; M > 0; M--) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            if(g[a][b] == 0) g[a][b] = c;
            else g[a][b] = g[a][b] < c ? g[a][b] : c;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(g[i][j] == 0) g[i][j] = 100000001;
            }
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            int[] v = new int[N];
            Arrays.fill(v, 100000001);
            v[i] = 0;
            q.offer(new int[]{i, 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for(int k = 0; k < N; k++) {
                    if(v[k] <= cur[1]+g[cur[0]][k]) continue;
                    v[k] = cur[1]+g[cur[0]][k];
                    q.offer(new int[]{k, v[k]});
                }
            }
            for(int j = 0; j < N; j++) costs[i][j] = v[j];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if(costs[i][j] == 100000001) sb.append(0 + " ");
                else sb.append(costs[i][j] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}