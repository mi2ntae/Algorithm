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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paint = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) paint[i][j] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][m];

        int ans = 0;
        int maxP = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(v[i][j] || paint[i][j] == 0) continue;
                v[i][j] = true;
                ans++;
                int tmpP = 1;
                q.offer(new int[]{i, j});
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for(int d = 0; d < 4; d++) {
                        int ny = cur[0] + dy[d];
                        int nx = cur[1] + dx[d];
                        if(0 <= ny && ny < n && 0 <= nx && nx < m && paint[ny][nx] == 1 && !v[ny][nx]) {
                            tmpP++;
                            v[ny][nx] = true;
                            q.offer(new int[]{ny, nx});
                        }
                    }
                }
                maxP = maxP < tmpP ? tmpP : maxP;
            }
        }
        System.out.println(ans+"\n"+maxP);
        br.close();
    }
}