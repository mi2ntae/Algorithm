import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            if(K == 0) break;
            int[] nums = new int[K];
            for (int i = 0; i < K; i++) nums[i] = Integer.parseInt(st.nextToken());

            boolean[] v = new boolean[K];
            comb(nums, v, 0, 0, new int[6], sb);
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void comb(int[] nums, boolean[] v, int start, int n, int[] pick, StringBuilder sb) {
        if(n == 6) {
            for(int i = 0; i < 6; i++) sb.append(pick[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i = start; i < nums.length; i++) {
            v[i] = true;
            pick[n] = nums[i];
            comb(nums, v, i+1, n+1, pick, sb);
            v[i] = false;
        }
    }
}