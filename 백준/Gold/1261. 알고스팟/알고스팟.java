import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int[] dy = {-1, 0, 0, 1};
    private static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] miro = new int[N][M];
        int[][] v = new int[N][M];
        for(int i = 0; i< N; i++) {
            String a = br.readLine();
            for(int j = 0; j < M; j++) {
                miro[i][j] = a.charAt(j)-'0';
                v[i][j] = 10000;
            }
        }

        int ans = 100000;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        v[0][0] = 0;
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == N-1 && cur[1] == M-1) ans = ans > cur[2] ? cur[2] : ans;
            for(int d = 0; d < 4; d++){
                int ny = cur[0]+dy[d];
                int nx = cur[1]+dx[d];
                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if(miro[ny][nx] == 0 && v[ny][nx] > cur[2]) {
                        v[ny][nx] = cur[2];
                        q.offer(new int[]{ny, nx, cur[2]});
                    } else if(miro[ny][nx] == 1 && v[ny][nx] > cur[2]+1){
                        v[ny][nx] = cur[2]+1;
                        q.offer(new int[]{ny, nx, cur[2] + 1});
                    }
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}