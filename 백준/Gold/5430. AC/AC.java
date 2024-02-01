import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; t++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

            boolean front = true;
            int fi = 0;
            int bi = n-1;
            boolean isError = false;
            for(char cur : command.toCharArray()) {
                if(cur == 'D') {
                    if(fi > bi) {
                        isError = true;
                        break;
                    }
                    if(front) fi++;
                    else bi--;
                } else front = !front;
            }
            if(isError) {
                sb.append("error\n");
                continue;
            }
            if(front) {
                sb.append("[");
                for(int i = fi; i <= bi; i++) {
                    sb.append(nums[i]);
                    if(i != bi) sb.append(",");
                }
                sb.append("]");
            } else {
                sb.append("[");
                for(int i = bi; i >= fi; i--) {
                    sb.append(nums[i]);
                    if(i != fi) sb.append(",");
                }
                sb.append("]");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}