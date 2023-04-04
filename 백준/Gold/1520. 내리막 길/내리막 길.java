import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] memo;
	private static int[][] map;
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		memo = new int[N][M];
		for(int[] i : memo) Arrays.fill(i, -1);
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(dfs(0, 0));
		br.close();
	}
	
	private static int dfs(int y, int x) {
		if(memo[y][x] != -1) return memo[y][x];
		if(y == N-1 && x == M-1) return 1;
		int res = 0;
		for(int d = 0; d < 4; d++) {
			int ny = y+dy[d];
			int nx = x+dx[d];
			if(0 <= ny && ny < N && 0 <= nx && nx < M
				&& map[y][x] > map[ny][nx]) {
				res += dfs(ny, nx);
			}
		}
		memo[y][x] = res;
		return memo[y][x];
	}
}