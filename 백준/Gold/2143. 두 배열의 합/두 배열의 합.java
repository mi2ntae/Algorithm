import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] n = new int[N];
        int[] accn = new int[N*(N+1)/2];
        for (int i = 0; i < N; i++) n[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] m = new int[M];
        int[] accm = new int[M*(M+1)/2];
        for (int i = 0; i < M; i++) m[i] = Integer.parseInt(st.nextToken());

        int nidx = 0;
        for(int i = 0; i < N; i++) {
            int acc = 0;
            for(int j = i; j < N; j++) {
                acc += n[j];
                accn[nidx++] = acc;
            }
        }

        int midx = 0;
        for(int i = 0; i < M; i++) {
            int acc = 0;
            for(int j = i; j < M; j++) {
                acc += m[j];
                accm[midx++] = acc;
            }
        }

        Arrays.sort(accn);
        Arrays.sort(accm);

        long ans = 0;
        int left = 0;
        int right = M*(M+1)/2-1;
        while(left < N*(N+1)/2 && right >= 0) {
            int sum = accn[left] + accm[right];
            if(sum == T) {
                long lc = 1;
                long rc = 1;
                while(left+1 < N*(N+1)/2 && accn[left] == accn[left+1]) {
                    lc++;
                    left++;
                }
                while(right-1 >= 0 && accm[right] == accm[right-1]) {
                    rc++;
                    right--;
                }
                ans += lc*rc;
                left++;
                right--;
            }
            else if(sum < T) left++;
            else right--;
        }

        System.out.println(ans);
        br.close();
    }
}