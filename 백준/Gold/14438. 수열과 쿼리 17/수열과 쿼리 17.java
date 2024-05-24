import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] nums;
    private static int len;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = 0;
        while(Math.pow(2, k) < N) k++;
        len = (int)Math.pow(2, k);
        nums = new int[len*2];
        Arrays.fill(nums, 1000000001);
        for (int i = 0; i < N; i++) nums[len+i] = Integer.parseInt(st.nextToken());
        for(int i = len-1; i > 0; i--) nums[i] = Math.min(nums[i*2], nums[i*2+1]);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int opt = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(opt == 1) change(len+a-1, b);
            else sb.append(find(1, len, nums.length-1, len+a-1, len+b-1)+"\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void change(int d, int v) {
        nums[d] = v;
        d /= 2;
        while(d > 0) {
            nums[d] = Math.min(nums[d*2], nums[d*2+1]);
            d /=2;
        }
    }
    private static int find(int i, int l, int r, int start, int end) {
        if(start <= l && r <= end) return nums[i];
        if(l > end || start > r) return 1000000001;
        int mid = (l+r)/2;
        return Math.min(find(i*2, l, mid, start, end), find(i*2+1, mid+1, r, start, end));
    }
}