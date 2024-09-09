import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] check = new int[9];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        int ans = 0;
        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken())-1;
            if(check[a]++ == 0) cnt++;
            while(cnt > 2) {
                if(--check[q.poll()] == 0) cnt--;
            }
            q.offer(a);
            ans = ans < q.size() ? q.size() : ans;
        }
        System.out.println(ans);
        br.close();
    }
}