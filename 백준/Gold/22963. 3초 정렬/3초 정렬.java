import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] footprint = new int[N];
        int[] lis = new int[N];
        int idx = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            int cur = nums[i];
            if(idx == 0 || lis[idx-1] <= cur) {
                lis[idx] = cur;
                footprint[i] = idx++;
                continue;
            }
            int start = 0;
            int end = idx-1;
            while(start <= end) {
                int mid = (start+end)/2;
                if(lis[mid] <= cur) start = mid+1;
                else end = mid-1;
            }
            lis[start] = cur;
            footprint[i] = start;
        }

        boolean[] v = new boolean[N];
        int res = nums.length;
        for(int i = N-1; i >= 0; i--) {
            if(footprint[i] == idx-1) {
                res--;
                v[i] = true;
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(res > 3 ) {
            sb.append("NO");
        } else {
            sb.append("YES\n");
            sb.append(res + "\n");

            for(int i = 0; i < N; i++) {
                if(v[i]) continue;
                if(i == 0) {
                    int k = i;
                    while(!v[k]) k++;
                    sb.append((i+1)+" "+nums[k]+"\n");
                    nums[i] = nums[k];
                }
                else {
                    sb.append((i+1)+" "+nums[i-1]+"\n");
                    nums[i] = nums[i-1];
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}