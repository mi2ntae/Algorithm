import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	private static int N, M;
	private static char[][] map;
	
	private static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < M; j++) map[i][j] = a.charAt(j);
		}
		
		int[][] v = new int[N][M];
		int z = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(v[i][j] != 0) continue;
				dfs(i, j, v, z++);
			}
		}
		System.out.println(ans);
		br.close();
	}
	private static void dfs(int i, int j, int[][] v, int z) {
		v[i][j] = z;
		int d = pos(map[i][j]);
		int newy = i+dy[d];
		int newx = j+dx[d];
		if(v[newy][newx] != 0) {
			if(v[newy][newx] == z) ans++;
			return;
		}
		dfs(newy, newx, v, z);
	}
	
	private static int pos(char a) {
		if(a == 'D') return 3;
		else if (a == 'L') return 1;
		else if (a == 'R') return 2;
		else return 0;
	}
}