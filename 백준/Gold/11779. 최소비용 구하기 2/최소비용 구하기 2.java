import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList[] g = new ArrayList[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<int[]>();

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            g[s].add(new int[]{d, w});
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken())-1;
        int end = Integer.parseInt(st.nextToken())-1;

        int[] v = new int[N];
        int[] pre = new int[N];
        Arrays.fill(pre, -1);
        Arrays.fill(v, 1000000001);
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1] == 0 ? o1[0] - o2[0] : o1[1] - o2[1]);
        v[start] = 0;
        heap.offer(new int[]{start, 0});

        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            if(v[cur[0]] < cur[1]) continue;

            for(int[] nxt : (ArrayList<int[]>) g[cur[0]]) {
                if(v[nxt[0]] > cur[1]+nxt[1]) {
                    pre[nxt[0]] = cur[0];
                    v[nxt[0]] = cur[1]+nxt[1];
                    heap.offer(new int[]{nxt[0], cur[1] + nxt[1]});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(v[end] + "\n");
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int k = end;
        while(k != -1) {
            q.offer(k+1);
            k = pre[k];
        }
        sb.append(q.size() + "\n");
        while (!q.isEmpty()) sb.append(q.pollLast()+" ");
        System.out.println(sb);
        br.close();
    }
}