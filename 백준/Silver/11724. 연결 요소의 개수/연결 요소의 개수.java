import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList[] g = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) g[i] = new ArrayList();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        boolean[] v = new boolean[N+1];
        int ans = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(v[i]) continue;
            ans++;
            v[i] = true;
            q.offer(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                for(Integer nxt : (ArrayList<Integer>) g[cur]){
                    if(v[nxt]) continue;
                    v[nxt] = true;
                    q.offer(nxt);
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}