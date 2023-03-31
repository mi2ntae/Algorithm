import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static char[][] map;
	private static int oy, ox;
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = a.charAt(j);
				if(map[i][j] == '0') {
					oy = i;
					ox = j;
					map[i][j] = '.';
				} else if(map[i][j] == '1') map[i][j] = 'p';
			}
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][][] v = new boolean[N][M][64];
		v[oy][ox][0] = true;
		q.offer(new int[] {oy, ox, 0, 0});
		
		int ans = 0;
		q: while(!q.isEmpty()) {
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int keys = cur[2];
			int cnt = cur[3];
			for(int d = 0; d < 4; d++) {
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(0 <= ny && ny < N && 0 <= nx && nx < M 
					&& !v[ny][nx][keys] && map[ny][nx] != '#') {
					v[ny][nx][keys] = true;
					if(map[ny][nx] == 'p') {
						ans = cnt+1;
						break q;
					} 
					else if(map[ny][nx] == '.') {
						q.offer(new int[] {ny ,nx, keys, cnt+1});
					}
					else if(map[ny][nx] == 'A' || map[ny][nx] == 'B' || map[ny][nx] == 'C' ||
							map[ny][nx] == 'D' || map[ny][nx] == 'E' || map[ny][nx] == 'F') {
						int k = map[ny][nx] - 'A';
						if ((keys & (1<<k)) != 0) q.offer(new int[] {ny, nx, keys, cnt+1});
					} else {
						int k = map[ny][nx] - 'a';
						v[ny][nx][keys | 1<<k] = true;
						q.offer(new int[] {ny, nx, keys | 1<<k, cnt+1});
					}
				}
			}
		}
		System.out.println(ans == 0 ? -1 : ans);
		br.close();
	}
}