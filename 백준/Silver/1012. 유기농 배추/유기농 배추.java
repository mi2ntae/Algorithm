import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			ArrayDeque<int[]> q = new ArrayDeque<>();
			boolean[][] v = new boolean[N][M];
			int ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(v[i][j] || map[i][j] == 0) continue;
					ans++;
					v[i][j] = true;
					q.offer(new int[] {i, j});
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for(int d = 0; d < 4; d++) {
							int ny = cur[0]+dy[d];
							int nx = cur[1]+dx[d];
							if(0 <= ny && ny < N && 0 <= nx && nx < M 
								&&!v[ny][nx] && map[ny][nx] == 1) {
								v[ny][nx] = true;
								q.offer(new int[] {ny, nx});
							}
						}
					}
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}