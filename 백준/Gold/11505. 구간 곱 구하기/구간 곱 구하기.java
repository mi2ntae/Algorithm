import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int MOD = 1000000007;
    private static long[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int p = 0;
        while (Math.pow(2, p) < N) p++;
        int start = (int)Math.pow(2, p);
        nums = new long[(int) Math.pow(2, p + 1)];
        for(int i = 1; i < nums.length; i++) nums[i] = 1;
        for (int i = 0; i < N; i++) nums[start + i] = Integer.parseInt(br.readLine());
        for (int i = start - 1; i > 0; i--) nums[i] = ((nums[i * 2] % MOD) * (nums[i * 2 + 1] % MOD)) % MOD;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int op = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(op == 1) change(start+m-1, n);
            else sb.append(find(1, start+m-1, start+n-1, start, nums.length-1)+"\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void change(int loc, int num){
        nums[loc] = num;
        loc /= 2;
        while(loc > 0)  {
            nums[loc] = ((nums[loc * 2] % MOD) * (nums[loc * 2 + 1] % MOD)) % MOD;
            loc /= 2;
        }
    }
    private static long find(int n, int start, int end, int l, int r) {
        if (r < start || end < l) return 1;
        if (start <= l && r <= end) return nums[n];
        int mid = (l + r) / 2;
        return ((find(n*2, start, end, l, mid)%MOD) * (find(n*2+1, start, end, mid+1, r)%MOD))%MOD;
    }
}