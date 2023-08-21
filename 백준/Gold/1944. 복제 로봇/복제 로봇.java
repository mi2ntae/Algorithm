import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Node implements Comparable<Node> {
        private int w;
        private int d;

        public Node(int w, int d){
            this.w = w;
            this.d = d;
        }

        @Override
        public String toString() {
            return "거리 : "+w+" to : "+d;
        }
        @Override
        public int compareTo(Node o) {
            return this.w-o.w;
        }
    }

    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] keys;
    private static ArrayList<Node>[] ways;
    private static int[] dy = {-1, 0, 0, 1};
    private static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        keys = new int[M+1][2];
        int keyIndex = 1;

        ways = new ArrayList[M+1];
        for(int i = 0; i <= M; i++) ways[i] = new ArrayList<>();

        // 벽 : '-2',  길 : '-1',  열쇠 : 숫자
        for(int i = 0; i < N; i++){
            String a = br.readLine();
            for(int j = 0; j < N; j++) {
                char c = a.charAt(j);
                if(c == 'S') {
                    keys[0][0] = i;
                    keys[0][1] = j;
                    map[i][j] = 0;
                }
                else if(c == '1') map[i][j] = -2;
                else if(c == 'K') {
                    keys[keyIndex][0] = i;
                    keys[keyIndex][1] = j;
                    map[i][j] = keyIndex++;
                }
                else map[i][j] = -1;
            }
        }

        for(int k = 0; k < keys.length; k++){
            boolean[][] v = new boolean[N][N];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            int i = keys[k][0];
            int j = keys[k][1];
            v[i][j] = true;
            q.offer(new int[]{i, j, 0});
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                for(int d = 0; d < 4; d++){
                    int ni = cur[0]+dy[d];
                    int nj = cur[1]+dx[d];
                    if(0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj] && map[ni][nj] != -2) {
                        v[ni][nj] = true;
                        q.offer(new int[]{ni, nj, cur[2]+1});
                        if(map[ni][nj] != -1 && map[ni][nj] != 0) {
                            Node n = new Node(cur[2]+1, map[ni][nj]);
                            ways[map[i][j]].add(n);
                        }
                    }
                }
            }
        }

        PriorityQueue<Node> heap = new PriorityQueue<>();
        for(Node n : ways[0]) heap.offer(n);

        int ans = 0;
        int cnt = 0;
        boolean[] v = new boolean[M+1];
        v[0] = true;

        while(!heap.isEmpty()) {
            Node cur = heap.poll();
            if(v[cur.d]) continue;
            v[cur.d] = true;
            ans += cur.w;
            if(++cnt == M) break;
            for(Node n : ways[cur.d]) heap.offer(n);
        }
        System.out.println(cnt != M ? -1 : ans);
        br.close();
    }
}