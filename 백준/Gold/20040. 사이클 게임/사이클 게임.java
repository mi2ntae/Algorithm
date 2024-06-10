import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] p;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N];
        for(int i = 0; i < N; i++) p[i] = i;
        int ans = 0;
        boolean find = false;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if(find) continue;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(uMerge(a, b)) {
                ans = i+1;
                find = true;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static int uFind(int n) {
        if(p[n] == n) return n;
        return p[n] = uFind(p[n]);
    }

    private static boolean uMerge(int a, int b) {
        int pa = uFind(a);
        int pb = uFind(b);
        if(pa == pb) return true;
        p[pb] = pa;
        return false;
    }
}