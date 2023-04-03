import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[M][N];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int i = y1; i < y2; i++) {
				for(int j = x1; j < x2; j++) map[i][j] = true;
			}
		}
		int ans = 0;
		ArrayList<Integer> ansL = new ArrayList<>();
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j]) continue;
				ans++;
				int res = 1;
				map[i][j] = true;
				q.offer(new int[] {i, j});
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					for(int d = 0; d < 4; d++) {
						int ny = cur[0]+dy[d];
						int nx = cur[1]+dx[d];
						if(0 <= ny && ny < M && 0 <= nx && nx < N
							&& !map[ny][nx]) {
							res++;
							map[ny][nx] = true;
							q.offer(new int[] {ny, nx});
						}
					}
				}
				ansL.add(res);
			}
		}
		sb.append(ans+"\n");
		Collections.sort(ansL);
		for(int num : ansL) sb.append(num+" ");
		System.out.println(sb);
		br.close();
	}
}