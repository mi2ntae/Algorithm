import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] g = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) g[i][j] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] plan = new int[M];
        for (int i = 0; i < M; i++) plan[i] = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[N];
        v[plan[0]-1] = true;
        q.offer(plan[0]-1);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 0; i < N; i++) {
                if(i == cur || v[i] || g[cur][i] == 0) continue;
                v[i] = true;
                q.offer(i);
            }
        }
        boolean ans = true;
        for(int i : plan) {
            if(!v[i-1]) ans = false;
        }
        System.out.println(ans ? "YES" : "NO");
        br.close();
    }
}