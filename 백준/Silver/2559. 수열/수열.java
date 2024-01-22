import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        int res = -10000001;
        for(int i = 0; i < N; i++) {
            sum += nums[i];
            if(i == K-1) res = Math.max(res, sum);
            if(i < K) continue;
            sum -= nums[i-K];
            res = Math.max(res, sum);
        }
        System.out.println(res);
        br.close();
    }
}