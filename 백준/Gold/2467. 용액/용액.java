import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liquids = new int[N];
        for (int i = 0; i < N; i++) liquids[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(liquids);

        long res = 2000000001;
        int first = 0;
        int second = 0;

        int start = 0;
        int end = N-1;
        while(start < end) {
            int sum = liquids[start] + liquids[end];
            if(Math.abs(sum) <= res) {
                res = Math.abs(sum);
                first = liquids[start];
                second = liquids[end];
            }
            if(sum < 0) start++;
            else end--;
        }
        System.out.println(first+" "+second);
        br.close();
    }
}