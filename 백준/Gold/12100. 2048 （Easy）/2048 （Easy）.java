import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int ans;
    private static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] mapU = new int[N][N];
        int[][] mapD = new int[N][N];
        int[][] mapL = new int[N][N];
        int[][] mapR = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                mapU[i][j] = map[i][j];
                mapD[i][j] = map[i][j];
                mapL[i][j] = map[i][j];
                mapR[i][j] = map[i][j];
            }
        }

        move(0, 0, mapU);
        move(0, 1, mapD);
        move(0, 2, mapL);
        move(0, 3, mapR);

        System.out.println(ans);
        br.close();
    }

    private static void move(int cnt, int d, int[][] map) {
        if(cnt == 5) {
            int res = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) res = res < map[i][j] ? map[i][j] : res;
            }
            ans = ans < res ? res : ans;
            return;
        }

        if(d == 0) up(map);
        else if(d == 1) down(map);
        else if(d == 2) left(map);
        else if(d == 3) right(map);

        int[][] mapU = new int[N][N];
        int[][] mapD = new int[N][N];
        int[][] mapL = new int[N][N];
        int[][] mapR = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                mapU[i][j] = map[i][j];
                mapD[i][j] = map[i][j];
                mapL[i][j] = map[i][j];
                mapR[i][j] = map[i][j];
            }
        }

        move(cnt+1, 0, mapU);
        move(cnt+1, 1, mapD);
        move(cnt+1, 2, mapL);
        move(cnt+1, 3, mapR);
    }
    private static void up(int[][] map) {
        for(int i = 0; i < N; i++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            int bef = 0;
            for(int j = 0; j < N; j++) {
                int cur = map[j][i];
                if(cur == 0) continue;
                if(bef == cur) {
                    q.pollLast();
                    q.offer(cur*2);
                    bef = 0;
                } else {
                    q.offer(cur);
                    bef = cur;
                }
            }
            for(int j = 0; j < N; j++) map[j][i] = 0;
            int k = 0;
            while(!q.isEmpty()) map[k++][i] = q.poll();
        }
    }

    private static void down(int[][] map) {
        for(int i = 0; i < N; i++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            int bef = 0;
            for(int j = N-1; j >= 0; j--) {
                int cur = map[j][i];
                if(cur == 0) continue;
                if(bef == cur) {
                    q.pollLast();
                    q.offer(cur*2);
                    bef = 0;
                } else {
                    q.offer(cur);
                    bef = cur;
                }
            }
            for(int j = 0; j < N; j++) map[j][i] = 0;
            int k = N-1;
            while(!q.isEmpty()) map[k--][i] = q.poll();
        }
    }

    private static void left(int[][] map) {
        for(int i = 0; i < N; i++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            int bef = 0;
            for(int j = 0; j < N; j++) {
                int cur = map[i][j];
                if(cur == 0) continue;
                if(bef == cur) {
                    q.pollLast();
                    q.offer(cur*2);
                    bef = 0;
                } else {
                    q.offer(cur);
                    bef = cur;
                }
            }
            for(int j = 0; j < N; j++) map[i][j] = 0;
            int k = 0;
            while(!q.isEmpty()) map[i][k++] = q.poll();
        }
    }

    private static void right(int[][] map) {
        for(int i = 0; i < N; i++) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            int bef = 0;
            for(int j = N-1; j >= 0; j--) {
                int cur = map[i][j];
                if(cur == 0) continue;
                if(bef == cur) {
                    q.pollLast();
                    q.offer(cur*2);
                    bef = 0;
                } else {
                    q.offer(cur);
                    bef = cur;
                }
            }
            for(int j = 0; j < N; j++) map[i][j] = 0;
            int k = N-1;
            while(!q.isEmpty()) map[i][k--] = q.poll();
        }
    }
}