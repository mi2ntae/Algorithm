import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int rx, ry, rd;
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        ry = Integer.parseInt(st.nextToken());
        rx = Integer.parseInt(st.nextToken());
        rd = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        while(true) {
            if(map[ry][rx] == 0) {
                map[ry][rx] = 2;
                ans++;
            }
            boolean roundVisited = false;
            for(int d = 0; d < 4; d++) {
                int ny = ry+dy[d];
                int nx = rx+dx[d];
                if(0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] == 0) roundVisited = true;
            }

            if(roundVisited) {
                if(--rd == -1) rd = 3;
                int ny = ry+dy[(rd+2)%4];
                int nx = rx+dx[(rd+2)%4];
                if(map[ny][nx] == 0) {
                    ry = ny;
                    rx = nx;
                }
            } else {
                int ny = ry+dy[rd];
                int nx = rx+dx[rd];
                if(map[ny][nx] == 1) break;
                ry = ny;
                rx = nx;
            }
        }
        System.out.println(ans);
        br.close();
    }


}