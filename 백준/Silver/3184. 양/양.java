import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	
	private static int R, C;
	private static char[][] map;
	private static int oans, vans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String a = br.readLine();
			for(int j = 0; j < C; j++) map[i][j] = a.charAt(j);
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] v = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(v[i][j]) continue;
				if(map[i][j] == 'o' || map[i][j] == 'v') bfs(i, j, q, v);
			}
		}
		System.out.println(oans+" "+vans);
		br.close();
	}
	
	private static void bfs(int i, int j, ArrayDeque<int[]> q, boolean[][] v) {
		int os = 0;
		int vs = 0;
		v[i][j] = true;
		if(map[i][j] == 'o') os++;
		else vs++;
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0; d < 4; d++) {
				int ny = cur[0]+dy[d];
				int nx = cur[1]+dx[d];
				if(0 <= ny && ny < R && 0 <= nx && nx < C
					&& !v[ny][nx] && map[ny][nx] != '#') {
					v[ny][nx] = true;
					if(map[ny][nx] == 'o') os++;
					else if(map[ny][nx] == 'v') vs++;
					q.offer(new int[] {ny, nx});
				}
			}
		}
		if(os <= vs) vans += vs;
		else oans += os;
	}
}