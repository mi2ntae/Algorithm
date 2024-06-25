import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) inputs[i] = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        int[] footprint = new int[N];
        int idx = 0;
        for(int i = 0; i < N; i++) {
            int cur = inputs[i];
            if(idx == 0 || nums[idx-1] < cur) {
                footprint[i] = idx;
                nums[idx++] = cur;
                continue;
            }

            int start = 0;
            int end = idx-1;
            while(start <= end) {
                int mid = (start+end) / 2;
                if(nums[mid] < cur) start = mid+1;
                else end = mid-1;
            }
            nums[start] = cur;
            footprint[i] = start;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int k = idx-1;
        for(int i = N-1; i >= 0; i--) {
            if(footprint[i] == k) {
                k--;
                q.offer(inputs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(idx + "\n");
        while(!q.isEmpty()) sb.append(q.pollLast()+" ");
        System.out.println(sb);
        br.close();
    }
}