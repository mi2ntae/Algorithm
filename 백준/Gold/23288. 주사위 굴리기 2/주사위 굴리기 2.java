import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	private static int d;
	private static int N, M, K;
	private static int x, y;
	private static int[] dice;
	private static int ans;
	private static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		dice = new int[6];	// 뒤 ,왼, 위, 오, 앞, 아래
		dice[0] = 2;
		dice[1] = 4;
		dice[2] = 1;
		dice[3] = 3;
		dice[4] = 5;
		dice[5] = 6;
		d = 2;
		while(K-- > 0) {
			move();
		}
		System.out.println(ans);
		br.close();
	}
	
	private static void move() {
		int newx = x+dx[d];
		int newy = y+dy[d];
		if(0 > newx || newx >= M || 0 > newy || newy >= N) {
			if(d == 0) d = 3;
			else if(d == 1) d = 2;
			else if(d == 2) d = 1;
			else d = 0;
		}
		newx = x+dx[d];
		newy = y+dy[d];
		if(d == 0) {
			int tmp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[4];
			dice[4] = dice[5];
			dice[5] = tmp;
		} else if(d == 1) {
			int tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[3];
			dice[3] = dice[5];
			dice[5] = tmp;
		} else if(d == 2) {
			int tmp = dice[3];
			dice[3] = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = tmp;
		} else {
			int tmp = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[2];
			dice[2] = dice[0];
			dice[0] = tmp;
		}
		
		ans += map[newy][newx] * bfs(newy, newx, map[newy][newx]);
		x = newx;
		y = newy;
		if(dice[5] < map[newy][newx]) {
			if(d == 0) d = 1;
			else if(d == 1) d = 3;
			else if(d == 2) d = 0;
			else d = 2;
		} else if(dice[5] > map[newy][newx]) {
			if(d == 0) d = 2;
			else if(d == 1) d = 0;
			else if(d == 2) d = 3;
			else d = 1;
		}
	}
	
	private static int bfs(int y, int x, int val) {
		int res = 1;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		v[y][x] = true;
		q.offer(new int[] {y, x});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = cur[0]+dy[i];
				int nx = cur[1]+dx[i];
				if(0 <= ny && ny < N && 0 <= nx && nx < M
					&& !v[ny][nx] && map[ny][nx] == val) {
					res++;
					v[ny][nx] = true;
					q.offer(new int[] {ny, nx});
				}
			}
		}
		return res;
	}
}