import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        long ans = 3000000001L;
        long[] liquids = new long[3];
        for(int i = 0; i < N; i++) {
            long cur = nums[i];

            int head = 0;
            if(head == i) head++;
            int tail = N-1;
            if(tail == i) tail--;
            while(head < tail) {
                long res = cur + nums[head] + nums[tail];
                long aRes = Math.abs(res);
                if(ans > aRes) {
                    ans = aRes;
                    liquids[0] = cur;
                    liquids[1] = nums[head];
                    liquids[2] = nums[tail];
                }
                if(aRes == 0) break;
                else if(res > 0) {
                    if(--tail == i) tail--;
                } else {
                    if(++head == i) head++;
                }
            }
        }
        Arrays.sort(liquids);
        System.out.println(liquids[0]+" "+liquids[1]+" "+liquids[2]);
        br.close();
    }
}