import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {0, 0, -1, 1};
	private static int[] dx = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		int[] coms = new int[K];
		st = new StringTokenizer(br.readLine(),  " ");
		for(int i = 0; i < K; i++) coms[i] = Integer.parseInt(st.nextToken())-1;
		
		int[] dice = new int[6];	// 뒤 ,왼, 위, 오, 앞, 아래
		for(int k = 0; k < K; k++) {
			int d = coms[k];
			int newx = x+dy[d];
			int newy = y+dx[d];
			if(0 > newx || newx >= N || 0 > newy || newy >= M) continue;
			if(d == 0) {
				int tmp = dice[3];
				dice[3] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[5];
				dice[5] = tmp;
			} else if(d == 1) {
				int tmp = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = dice[5];
				dice[5] = tmp;
			} else if(d == 2) {
				int tmp = dice[0];
				dice[0] = dice[2];
				dice[2] = dice[4];
				dice[4] = dice[5];
				dice[5] = tmp;
			} else {
				int tmp = dice[5];
				dice[5] = dice[4];
				dice[4] = dice[2];
				dice[2] = dice[0];
				dice[0] = tmp;
			}
			if(map[newx][newy] == 0) map[newx][newy] = dice[5];
			else {
				dice[5] = map[newx][newy];
				map[newx][newy] = 0;
			}
			sb.append(dice[2]+"\n");
			x = newx;
			y = newy;
		}
		System.out.println(sb);
		br.close();
	}
}