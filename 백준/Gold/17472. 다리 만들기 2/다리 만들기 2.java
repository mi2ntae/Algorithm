import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class Bridge implements Comparable<Bridge>{
		public int s;
		public int d;
		public int w;
		
		public Bridge(int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}

		@Override
		public int compareTo(Bridge o) {
			return Integer.compare(w, o.w);
		}
		
	}
	
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	private static int N, M;
	private static int[][] map;
	private static PriorityQueue<Bridge> bridges;
	private static int[] u;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] v = new boolean[N][M];
		int num = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0 || v[i][j]) continue;
				makeIsland(i, j, num++, v);
			}
		}
		
		u = new int[num];
		for(int i = 1; i < num; i++) u[i] = i;
		
		bridges = new PriorityQueue<>();
		makeRowBridge();
		makeColBridge();
		
		int con = 0;
		int ans = 0;
		while(!bridges.isEmpty()) {
			Bridge b = bridges.poll();
			if(union(b.s, b.d)) {
				ans += b.w;
				con++;
			}
			if(con == num-2) break;
		}
		System.out.println(con == num-2 ? ans : -1);
		br.close();
	}
	
	private static void makeIsland(int i, int j, int num, boolean[][] v){
		v[i][j] = true;
		map[i][j] = num;
		for(int d = 0; d < 4; d++) {
			int ny = i+dy[d];
			int nx = j+dx[d];
			if(0 <= ny && ny < N && 0 <= nx && nx < M
				&& !v[ny][nx] && map[ny][nx] != 0) makeIsland(ny, nx, num, v);
		}
	}
	
	private static void makeRowBridge() {
		for(int i = 0; i < N; i++) {
			boolean isBridge = false;
			int is1 = 0;
			int is2 = 0;
			int cnt = 0;
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					if(!isBridge) {
						isBridge = true;
						is1 = map[i][j];
						cnt = 0;
					} else {
						if(map[i][j] == is1) {
							cnt = 0;
							continue;
						}
						if(cnt >= 2) {
							is2 = map[i][j];
							Bridge b = new Bridge(is1, is2, cnt);
							bridges.offer(b);
						}
						is1 = map[i][j];
						cnt = 0;
					}
				} else cnt++;
			}
		}
	}
	
	private static void makeColBridge() {
		for(int i = 0; i < M; i++) {
			boolean isBridge = false;
			int is1 = 0;
			int is2 = 0;
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(map[j][i] != 0) {
					if(!isBridge) {
						isBridge = true;
						is1 = map[j][i];
						cnt = 0;
					} else {
						if(map[j][i] == is1) {
							cnt = 0;
							continue;
						}
						if(cnt >= 2) {
							is2 = map[j][i];
							Bridge b = new Bridge(is1, is2, cnt);
							bridges.offer(b);
						}
						is1 = map[j][i];
						cnt = 0;
					}
				} else cnt++;
			}
		}
	}
	
	private static int uFind(int a) {
		if(u[a] == a) return a;
		return u[a] = uFind(u[a]);
	}
	
	private static boolean union(int a, int b) {
		int ua = uFind(a);
		int ub = uFind(b);
		if(ua == ub) return false;
		u[ub] = ua;
		return true;
	}
}