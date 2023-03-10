import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	private static int[] dr = {-1, -1, 1, 1};
	private static int[] dc = {-1, 1, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[][] coms = new int[M][2];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 2; j++) coms[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<int[]> cloud = new ArrayDeque<>();
		cloud.offer(new int[] {N-1, 0});
		cloud.offer(new int[] {N-1, 1});
		cloud.offer(new int[] {N-2, 0});
		cloud.offer(new int[] {N-2, 1});
		
		int ans = 0;
		for(int m = 0; m < M; m++) {
			int d = coms[m][0]-1;
			int s = coms[m][1];
			boolean[][] v = new boolean[N][N];
			int size = cloud.size();
			while(size-- > 0) {
				int[] cur = cloud.poll();
				int cy = cur[0];
				int cx = cur[1];
				cy = (cy+(dy[d]*s))%N;
				if(cy < 0) cy = N+cy;
				cx = (cx+(dx[d]*s))%N;
				if(cx < 0) cx = N+cx;
				v[cy][cx] = true;
				map[cy][cx] += 1;
				cloud.offer(new int[] {cy, cx});
			}
			while(!cloud.isEmpty()) {
				int[] cur = cloud.poll();
				int cy = cur[0];
				int cx = cur[1];
				int cnt = 0;
				for(int dd = 0; dd < 4; dd++) {
					int ny = cy+dr[dd];
					int nx = cx+dc[dd];
					if(0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx] > 0) cnt++;
				}
				map[cy][cx] += cnt;
			}
			ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] >= 2 && !v[i][j]) {
						map[i][j] -= 2;
						cloud.offer(new int[] {i, j});
					}
					ans += map[i][j];
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
}