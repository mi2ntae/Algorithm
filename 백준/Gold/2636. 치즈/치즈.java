import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {-1, 0, 0, 1};
	private static int[] dx = {0, -1, 1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int chCnt = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) chCnt++;
			}
		}
		
		int time = 0;
		int beforeCnt = 0;
		boolean[][] v = new boolean[N][M];
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for(int i = 1; i < N-1; i++) {
			v[i][0] = true;
			v[i][M-1] = true;
			q.offer(new int[] {i, 0});
			q.offer(new int[] {i, M-1});
		}
		for(int i = 1; i < M-1; i++) {
			v[0][i] = true;
			v[N-1][i] = true;
			q.offer(new int[] {0, i});
			q.offer(new int[] {N-1, i});
		}
		while(chCnt > 0) {
			ArrayDeque<int[]> nq = new ArrayDeque<>();
			time++;
			beforeCnt = chCnt;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				for(int d = 0; d < 4; d++) {
					int ny = cur[0]+dy[d];
					int nx = cur[1]+dx[d];
					if(0 <= ny && ny < N && 0 <= nx && nx < M && !v[ny][nx]) {
						v[ny][nx] = true;
						if(map[ny][nx] == 1) {
							chCnt--;
							nq.offer(new int[] {ny, nx});
						} else q.offer(new int[] {ny, nx});
					}
				}
			}
			q = nq;
		}
		System.out.println(time+"\n"+beforeCnt);
		br.close();
	}
}