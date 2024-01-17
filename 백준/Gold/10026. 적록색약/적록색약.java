import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int i = 0; i < N; i++){
            String k = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = k.charAt(j);
            }
        }

        boolean[][] notV = new boolean[N][N];
        boolean[][] isV = new boolean[N][N];
        int notCnt = 0;
        int isCnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!notV[i][j]) {
                    notCnt++;
                    notV[i][j] = true;
                    notDfs(i, j, map, notV);
                }
                if(!isV[i][j]) {
                    isCnt++;
                    isV[i][j] = true;
                    isDfs(i, j, map, isV);
                }
            }
        }
        System.out.println(notCnt+" "+isCnt);
        br.close();
    }

    private static void notDfs(int i, int j, char[][] map, boolean[][] v) {
        for(int d = 0; d < 4; d++) {
            int ny = i+dy[d];
            int nx = j+dx[d];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(v[ny][nx] || map[i][j] != map[ny][nx]) continue;
            v[ny][nx] = true;
            notDfs(ny, nx, map, v);
        }
    }

    private static void isDfs(int i, int j, char[][] map, boolean[][] v) {
        for(int d = 0; d < 4; d++) {
            int ny = i+dy[d];
            int nx = j+dx[d];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(v[ny][nx]) continue;
            if(map[i][j] == 'B' && map[ny][nx] != 'B') continue;
            if(map[i][j] != 'B' && map[ny][nx] == 'B') continue;
            v[ny][nx] = true;
            isDfs(ny, nx, map, v);
        }
    }

}