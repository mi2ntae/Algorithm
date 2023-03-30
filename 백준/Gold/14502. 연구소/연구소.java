import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	private static ArrayList<int[]> walls;
	private static ArrayList<int[]> viruses;
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	private static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		walls = new ArrayList<>();
		viruses = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) walls.add(new int[] {i, j});
				else if(map[i][j] == 2) viruses.add(new int[] {i, j});
			}
		}
		comb(0, 0, new int[3][2]);
		System.out.println(ans);
		br.close();
	}
	
	private static void comb(int cnt, int start, int[][] w) {
		if(cnt == 3) {
			for(int i = 0; i < 3; i++) map[w[i][0]][w[i][1]] = 1;
			getSafe();
			for(int i = 0; i < 3; i++) map[w[i][0]][w[i][1]] = 0;
			return;
		}
		
		for(int i = start; i < walls.size(); i++) {
			w[cnt] = new int[] {walls.get(i)[0], walls.get(i)[1]};
			comb(cnt+1, i+1, w);
		}
	}

	private static void getSafe() {
		boolean[][] v = new boolean[N][M];
		for(int[] yx : viruses) {
			v[yx[0]][yx[1]] = true;
			dfs(yx[0], yx[1], v);
		}
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 && !v[i][j]) res++;
			}
		}
		ans = ans < res ? res : ans;
	}
	
	private static void dfs(int i, int j, boolean[][] v) {
		for(int d = 0; d < 4; d++) {
			int ny = i+dy[d];
			int nx = j+dx[d];
			if(0 <= ny && ny < N && 0 <= nx && nx < M 
				&& !v[ny][nx] && map[ny][nx] == 0) {
				v[ny][nx] = true;
				dfs(ny, nx, v);
			}
		}
	}
}