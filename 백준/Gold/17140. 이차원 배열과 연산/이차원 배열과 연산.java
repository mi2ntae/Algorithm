import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int maxr = 3;
    private static int maxc = 3;
    private static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int k = Integer.parseInt(st.nextToken());
        map = new int[100][100];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;
        for(int t = 0; t <= 100; t++) {
            if(map[r][c] == k) {
                ans = t;
                break;
            }
            if(maxr >= maxc) calR();
            else calC();
        }
        System.out.println(ans);
        br.close();
    }

    private static void calR() {
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1] == 0 ? o1[0]-o2[0] : o1[1]-o2[1]);
        int tmpc = 0;
        for(int i = 0; i < maxr; i++) {
            int[] cnt = new int[101];
            for(int j = 0; j < 100; j++) {
                if(map[i][j] == 0) continue;
                cnt[map[i][j]]++;
            }
            for(int p = 1; p < 101; p++) {
                if(cnt[p] == 0) continue;
                heap.offer(new int[]{p, cnt[p]});
            }

            for(int idx = 0; idx < 100; idx++){
                if(heap.size() > 0) {
                    int[] cur = heap.poll();
                    map[i][idx++] = cur[0];
                    tmpc = tmpc < idx ? idx : tmpc;
                    if(idx == 100) break;
                    map[i][idx] = cur[1];
                    tmpc = tmpc < idx+1 ? idx+1 : tmpc;
                } else map[i][idx] = 0;
            }
            heap.clear();
        }
        maxc = tmpc;
    }

    private static void calC(){
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1] == 0 ? o1[0]-o2[0] : o1[1]-o2[1]);
        int tmpr = 0;
        for(int i = 0; i < maxc; i++) {
            int[] cnt = new int[101];
            for(int j = 0; j < 100; j++) {
                if(map[j][i] == 0) continue;
                cnt[map[j][i]]++;
            }
            for(int p = 1; p < 101; p++) {
                if(cnt[p] == 0) continue;
                heap.offer(new int[]{p, cnt[p]});
            }

            for(int idx = 0; idx < 100; idx++){
                if(heap.size() > 0) {
                    int[] cur = heap.poll();
                    map[idx++][i] = cur[0];
                    tmpr = tmpr < idx ? idx : tmpr;
                    if(idx == 100) break;
                    map[idx][i] = cur[1];
                    tmpr = tmpr < idx+1 ? idx+1 : tmpr;
                } else map[idx][i] = 0;
            }
            heap.clear();
        }
        maxr = tmpr;
    }
}