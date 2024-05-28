import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] g;
    private static int ans = 2001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        g = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) g[i][j] = Integer.parseInt(st.nextToken());
        }

        comb(0, -1, new boolean[N]);
        System.out.println(ans);
        br.close();
    }

    private static void comb(int cnt, int n, boolean[] v) {
        if(cnt == N/2) {
            int start = 0;
            int link = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(v[i] && v[j]) start += g[i][j] + g[j][i];
                    else if(!v[i] && !v[j]) link += g[i][j] + g[j][i];
                }
            }
            ans = Math.min(ans, Math.abs(start-link));
            return;
        }

        for(int i = n+1; i < N; i++) {
            v[i] = true;
            comb(cnt+1, i, v);
            v[i] = false;
        }
    }
}