import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList[] g = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) g[i] = new ArrayList<Integer>();

        int[] p = new int[N+1];
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g[s].add(d);
            g[d].add(s);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[N+1];
        q.offer(1);
        v[1] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : (ArrayList<Integer>) g[cur]){
                if(v[nxt]) continue;
                v[nxt] = true;
                p[nxt] = cur;
                q.offer(nxt);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) sb.append(p[i]+"\n");
        System.out.println(sb);
        br.close();
    }
}