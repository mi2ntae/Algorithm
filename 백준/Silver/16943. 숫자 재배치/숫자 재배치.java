import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int b;
    private static int ans = -1;
    private static int[] aNums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        b = Integer.parseInt(B);
        if(A.length() > B.length()) {
            System.out.println(ans);
        } else {
            N = A.length();
            aNums = new int[N];
            for (int i = 0; i < N; i++) aNums[i] = A.charAt(i)-'0';
            perm(0, new boolean[N], 0);
            System.out.println(ans);
        }

        br.close();
    }

    private static void perm(int cnt, boolean[] v, int num) {
        if(cnt == N) {
            if(num < b) ans = ans < num ? num : ans;
            return;
        }
        for(int i = 0; i < aNums.length; i++) {
            if(v[i] || (cnt == 0 && aNums[i] == 0)) continue;
            v[i] = true;
            num += Math.pow(10, N-cnt-1) * aNums[i];
            perm(cnt+1, v, num);
            num -= Math.pow(10, N-cnt-1) * aNums[i];
            v[i] = false;
        }

    }
}