import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) p[i] = Integer.parseInt(st.nextToken());
        int del = Integer.parseInt(br.readLine());

        boolean[] nonLeaf = new boolean[N];
        nonLeaf[del] = true;

        for(int i = 0; i < N; i++) {
            int cur = p[i];
            if(cur == -1) continue;
            nonLeaf[cur] = true;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            if(p[i] == del) {
                nonLeaf[i] = true;
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int d = 0; d < N; d++) {
                if(p[d] == cur) {
                    nonLeaf[d] = true;
                    q.offer(d);
                }
            }
        }
        boolean isLeaf = true;
        for(int i = 0; i < N; i++) {
            if(i != del && p[i] == p[del]) isLeaf = false;
        }
        if(isLeaf && p[del] != -1) nonLeaf[p[del]] = false;

        int ans = 0;
        for(Boolean b : nonLeaf) {
            if(!b) ans++;
        }
        System.out.println(ans);
        br.close();
    }
}