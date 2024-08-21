import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map;
    private static int cnt;
    private static int[] dy = {-1, 0, 0, 1};
    private static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num != 0) cnt++;
                map[i][j] = num;
            }
        }

        int year = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        while(true) {
            year++;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] > 0) continue;
                    for(int d = 0; d < 4; d++) {
                        int ny = i+dy[d];
                        int nx = j+dx[d];
                        if (0 <= ny && ny < N && 0 <= nx && nx < M) q.offer(new int[]{ny, nx});
                    }
                }
            }

            while(!q.isEmpty()) {
                int[] cur = q.poll();
                if(--map[cur[0]][cur[1]] == 0) cnt--;
            }

            boolean[][] v = new boolean[N][M];
            int curCnt = 0;
            boolean find = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] <= 0) continue;
                    find = true;
                    v[i][j] = true;
                    q.offer(new int[]{i, j});
                    curCnt++;

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for(int d = 0; d < 4; d++) {
                            int ny = cur[0]+dy[d];
                            int nx = cur[1]+dx[d];
                            if (0 <= ny && ny < N && 0 <= nx && nx < M && !v[ny][nx] && map[ny][nx] > 0) {
                                v[ny][nx] = true;
                                curCnt++;
                                q.offer(new int[]{ny, nx});
                            }
                        }
                    }
                    break;
                }
                if(find) break;
            }
            if(curCnt != cnt) break;
            if(cnt == 0) {
                year = 0;
                break;
            }
        }

        System.out.println(year);
        br.close();
    }
}