import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MAX_VALUE;
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[N][M];
		v[0][0] = true;
		q.offer(new int[] {0, 0, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(map[cur[0]][cur[1]] == 2) ans = Math.min(ans, cur[2]+N-1-cur[0]+M-1-cur[1]);
			if(cur[0] == N-1 && cur[1] == M-1) ans = Math.min(ans, cur[2]);
			for(int d = 0; d < 4; d++) {
				int newy = cur[0]+dy[d];
				int newx = cur[1]+dx[d];
				if(0 <= newy && newy < N && 0 <= newx && newx < M
					&& !v[newy][newx] && map[newy][newx] != 1) {
					v[newy][newx] = true;
					q.offer(new int[] {newy, newx, cur[2]+1});
				}
			}
		}
		System.out.println(ans > T ? "Fail" : ans);
		br.close();
	}
}