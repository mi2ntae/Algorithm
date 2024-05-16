import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int[] dy = {-1, 0, 0, 1};
    private static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < M; j++) map[i][j] = a.charAt(j)-'0';
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][][] v = new boolean[N][M][2];
        int ans = 1000001;
        q.offer(new int[]{0, 0, 0, 1}); // y, x, boolean, cnt

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == N-1 && cur[1] == M-1) {
                ans = ans > cur[3] ? cur[3] : ans;
                break;
            }
            for(int d = 0; d < 4; d++) {
                int ny = cur[0]+dy[d];
                int nx = cur[1]+dx[d];
                if(cur[2] == 0) {
                    if(0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if(map[ny][nx] == 0 && !v[ny][nx][0]) {
                            v[ny][nx][0] = true;
                            q.offer(new int[]{ny, nx, 0, cur[3]+1});
                        }
                        if(map[ny][nx] == 1 && !v[ny][nx][1]) {
                            v[ny][nx][1] = true;
                            q.offer(new int[]{ny, nx, 1, cur[3] + 1});
                        }
                    }
                } else {
                    if(0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] == 0 && !v[ny][nx][1]) {
                        v[ny][nx][1] = true;
                        q.offer(new int[]{ny, nx, 1, cur[3] + 1});
                    }
                }
            }

        }
        System.out.println(ans == 1000001 ? -1 : ans);
        br.close();
    }
}