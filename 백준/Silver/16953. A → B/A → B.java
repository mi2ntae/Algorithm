import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int ans = -1;
    private static int b;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        ab(a, 0);
        System.out.println(ans == -1 ? ans : ans+1);
        br.close();
    }

    private static void ab(int n, int cnt) {
        if(n == b) {
            if(ans == -1) ans = cnt;
            else ans = ans > cnt ? cnt : ans;
        }
        if(n*2 <= 1000000000) ab(n*2, cnt+1);
        if(n <= 100000000) ab(n * 10 + 1, cnt + 1);
    }
}