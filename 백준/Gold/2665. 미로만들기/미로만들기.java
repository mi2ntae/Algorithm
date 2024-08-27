import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    private static int[][] map;
    private static int[] dy = {-1, 0, 0, 1};
    private static int[] dx = {0, -1, 1, 0};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < N; j++) map[i][j] = a.charAt(j)-'0';
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[N][N];
        for(int[] a : dist) Arrays.fill(a, 2501);

        dist[0][0] = 0;
        q.offer(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d = 0; d < 4; d++) {
                int ny = cur[0]+dy[d];
                int nx = cur[1]+dx[d];
                if(0 <= ny && ny < N && 0 <= nx && nx < N) {
                    if(map[ny][nx] == 0) {
                        if(dist[ny][nx] > cur[2]+1) {
                            dist[ny][nx] = cur[2]+1;
                            q.offer(new int[]{ny, nx, cur[2]+1});
                        }
                    } else {
                        if(dist[ny][nx] > cur[2]) {
                            dist[ny][nx] = cur[2];
                            q.offer(new int[]{ny, nx, cur[2]});
                        }
                    }
                }
            }
        }
        System.out.println(dist[N-1][N-1]);
        br.close();
    }
}