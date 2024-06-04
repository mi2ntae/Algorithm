import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N;
    private static int ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] v = new int[N][N];
        for(int i = 0; i < N; i++) {
            v[i][0]++;
            for(int k = 1; k < N; k++) v[i][k]++;
            for(int k = 1; i+k < N; k++)v[i+k][k]++;
            for(int k = 1; i-k >= 0; k++)v[i-k][k]++;
            queen(v, 1);
            for(int k = 1; i-k >= 0; k++)v[i-k][k]--;
            for(int k = 1; i+k < N; k++)v[i+k][k]--;
            for(int k = 1; k < N; k++) v[i][k]--;
            v[i][0]--;
        }
        System.out.println(ans);
        br.close();
    }

    private static void queen(int[][] v, int cur) {
        if(cur == N) {
            ans++;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(v[i][cur] > 0) continue;
            v[i][cur]++;
            for(int k = 1; cur+k < N; k++) v[i][cur+k]++;
            for(int k = 1; i+k < N && cur+k < N; k++)v[i+k][cur+k]++;
            for(int k = 1; i-k >= 0 && cur+k < N; k++)v[i-k][cur+k]++;
            queen(v, cur+1);
            for(int k = 1; i+k < N && cur+k < N; k++)v[i+k][cur+k]--;
            for(int k = 1; i-k >= 0 && cur+k < N; k++)v[i-k][cur+k]--;
            for(int k = 1; cur+k < N; k++) v[i][cur+k]--;
            v[i][cur]--;
        }
    }
}