import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] memoA = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) memoA[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            int[] memoB = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) memoB[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(memoA);

            int[] ans = new int[M];
            for(int i = 0; i < M; i++) {
                int cur = memoB[i];
                int start = 0;
                int end = N-1;
                while(start <= end) {
                    int mid = (start+end)/2;
                    int k = memoA[mid];
                    if(cur == k) {
                        ans[i] = 1;
                        break;
                    }
                    else if(cur < k) end = mid-1;
                    else start = mid+1;
                }
            }
            for(Integer a : ans) sb.append(a + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}