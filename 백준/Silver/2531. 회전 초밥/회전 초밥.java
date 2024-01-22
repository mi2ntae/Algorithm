import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());

        int[] v = new int[d+1];
        v[c] = 1;
        int kinds = 1;
        int cnt = 0;
        int ans = 0;
        for(int a = 0; a < N+k-1; a++) {
            int i = a%N;
            if(cnt >= k) {
                if(--v[sushi[a-k]] == 0) kinds--;
            }
            if(v[sushi[i]]++ == 0) kinds++;
            cnt++;
            ans = Math.max(ans, kinds);
        }
        System.out.println(ans);
        br.close();
    }
}