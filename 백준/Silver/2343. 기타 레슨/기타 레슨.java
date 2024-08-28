import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int INF = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " '");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = INF;
        while(start <= end) {
            int mid = (start+end)/2;
            int sum = 0;
            int group = 1;
            boolean small = false;
            for(int i = 0; i < N; i++) {
                if(nums[i] > mid) {
                    small = true;
                    break;
                }
                if(sum+nums[i] > mid) {
                    group++;
                    sum = nums[i];
                } else sum += nums[i];
            }
            if(sum > mid) group++;

            if(small || group > M) start = mid+1;
            else end = mid-1;
        }

        System.out.println(start);
        br.close();
    }
}