import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	private static int N, M, K;
	private static char[][] map;
	private static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	private static Map<String, Integer> s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < M; j++) map[i][j] = a.charAt(j);
		}
		s = new HashMap<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dfs(1, i, j, new StringBuilder());
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < K; i++) {
			String a = br.readLine();
			if(s.get(a) == null) sb.append(0+"\n");
			else sb.append(s.get(a)+"\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void dfs(int cnt, int i, int j, StringBuilder sb) {
		if(cnt > 5) return;
		sb.append(map[i][j]);
		String k = sb.toString();
		if(s.get(k) == null) s.put(k, 1);
		else s.put(k, s.get(k)+1);
		for(int d = 0; d < 8; d++) {
			int ny = (i+dy[d])%N;
			int nx = (j+dx[d])%M;
			if(ny < 0) ny += N;
			if(nx < 0) nx += M;
			dfs(cnt+1, ny, nx, sb);
		}
		sb.deleteCharAt(sb.length()-1);
	}
}