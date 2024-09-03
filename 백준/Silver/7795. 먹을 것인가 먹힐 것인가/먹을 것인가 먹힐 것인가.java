import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] aNums = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) aNums[i] = Integer.parseInt(st.nextToken());
            int[] bNums = new int[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) bNums[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(bNums);
            int ans = 0;

            for(int i = 0; i < N; i++) {
                int nums = aNums[i];

                int start = 0;
                int end = M-1;
                while(start <= end) {
                    int mid = (start+end)/2;
                    if(nums > bNums[mid]) start = mid+1;
                    else end = mid-1;
                }
                
                ans += start;
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}