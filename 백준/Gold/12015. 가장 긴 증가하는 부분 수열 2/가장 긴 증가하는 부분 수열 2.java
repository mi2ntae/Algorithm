import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(idx == 0) {
                nums[idx++] = cur;
                continue;
            }
            if(nums[idx-1] < cur) nums[idx++] = cur;
            else {
                int start = 0;
                int end = idx-1;
                while(start <= end) {
                    int mid = (start+end) / 2;
                    if(nums[mid] >= cur) end = mid-1;
                    else start = mid+1;
                }
                nums[start] = cur;
            }
        }
        System.out.println(idx);

        br.close();
    }
}