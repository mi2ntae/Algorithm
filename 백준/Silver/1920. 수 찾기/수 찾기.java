import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            int find = 0;
            while(start <= end) {
                int mid = (start+end) / 2;
                if(nums[mid] == k) {
                    find = 1;
                    break;
                } else if(nums[mid] < k) start = mid+1;
                else end = mid-1;
            }
            System.out.println(find);
        }
        br.close();
    }
}