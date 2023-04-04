import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] qy = {-1, -1, -1, 0, 0, 1, 1, 1};
	private static int[] qx = {-1, 0, 1, -1, 1, -1, 0, 1};
	private static int[] ky = {-2, -2, -1, 1, 2, 2, 1, -1};
	private static int[] kx = {-1, 1, 2, 2, 1, -1, -2, -2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] nSafe = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		int qCnt = Integer.parseInt(st.nextToken());
		for(int i = 0; i < qCnt; i++) {
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 1;
			nSafe[y][x] = true;
		}
		st = new StringTokenizer(br.readLine());
		int nCnt = Integer.parseInt(st.nextToken());
		for(int i = 0; i < nCnt; i++) {
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 2;
			nSafe[y][x] = true;
		}
		st = new StringTokenizer(br.readLine());
		int pCnt = Integer.parseInt(st.nextToken());
		for(int i = 0; i < pCnt; i++) {
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 3;
			nSafe[y][x] = true;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					int k = 1;
					boolean[] block = new boolean[8];
					while(k < 1000) {
						int ok = 0;
						for(int d = 0; d < 8; d++) {
							int ny = i+qy[d]*k;
							int nx = j+qx[d]*k;
							if(block[d] || 0 > ny || ny >= N || 0 > nx || nx >= M) continue;
							if(map[ny][nx] != 0) {
								block[d] = true;
								continue;
							}
							nSafe[ny][nx] = true;
							ok++;
						}
						if(ok == 0) break;
						k++;
					}
				}
				else if(map[i][j] == 2) {
					for(int d = 0; d < 8; d++) {
						int ny = i+ky[d];
						int nx = j+kx[d];
						if(0 > ny || ny >= N || 0 > nx || nx >= M
							&& map[ny][nx] != 0 && nSafe[ny][nx]) continue;
						nSafe[ny][nx] = true;
					}
				}
			}
		}
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!nSafe[i][j]) ans++;
			}
		}
		System.out.println(ans);
		br.close();
	}
}