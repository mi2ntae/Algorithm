import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        int[] res = new int[N];
        Arrays.fill(res, 1001);
        int size = 0;
        res[0] = nums[0];
        for(int i = 1; i < N; i++){
            int num = nums[i];
            if(res[size] > num) res[++size] = num;
            else {
                int beg = 0;
                int end = size;
                while(beg <= end) {
                    int mid = (beg + end) / 2;
                    if(res[mid] == num) {
                        beg = mid;
                        break;
                    }
                    if(res[mid] < num) end = mid-1;
                    else if(res[mid] > num) beg = mid+1;
                }
                res[beg] = num;
            }
        }
        System.out.println(size+1);
        br.close();
    }
}