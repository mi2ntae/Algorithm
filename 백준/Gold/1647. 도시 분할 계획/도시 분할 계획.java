import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node> {
        private int a;
        private int b;
        private int c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
    private static int[] p;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N];
        for(int i = 0; i < N; i++) p[i] = i;
        PriorityQueue<Node> heap = new PriorityQueue<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            Node newNode = new Node(a, b, c);
            heap.offer(newNode);
        }

        int cnt = 0;
        int ans = 0;
        while(!heap.isEmpty()) {
            Node cur = heap.poll();
            int a = cur.a;
            int b = cur.b;
            int c = cur.c;
            int tmp = 0;
            if(union(a, b)) continue;
            if(++cnt == N-1) break;
            ans += c;
        }
        System.out.println(ans);
        br.close();
    }

    private static int uFind(int n) {
        if(p[n] == n) return n;
        return p[n] = uFind(p[n]);
    }

    private static boolean union(int a, int b) {
        int pa = uFind(a);
        int pb = uFind(b);
        if(pa == pb) return true;
        p[pb] = pa;
        return false;
    }
}