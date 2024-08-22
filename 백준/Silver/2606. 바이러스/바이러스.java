import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList[] g = new ArrayList[N];
        for(int i = 0; i < N; i++) g[i] = new ArrayList<Integer>();

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            g[a].add(b);
            g[b].add(a);
        }

        int ans = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        visited[0] = true;
        q.offer(0);
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(Integer nxt : (ArrayList<Integer>) g[cur]) {
                if(visited[nxt]) continue;
                ans++;
                visited[nxt] = true;
                q.offer(nxt);
            }
        }

        System.out.println(ans);
        br.close();
    }
}