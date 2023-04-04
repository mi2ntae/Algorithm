import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		aa: for(int y = 0; y < N; y++) {
			int bef = map[y][0];
			int count = 0;
			
			for(int x = 0; x < N; x++) {
				int cur = map[y][x];
				if(Math.abs(cur-bef) > 1) continue aa;
				if(cur == bef) count++;
				else {
					if(bef < cur) {
						if(count < L) continue aa;
						count = 1;
					} else {
						for(int k = 1; k < L; k++) {
							if(x+k >= N || map[y][x+k] != cur) continue aa;
						}
						count = 1-L;
					}
				}
				bef = cur;
			}
			ans++;
		}
		bb: for(int x = 0; x < N; x++) {
			int bef = map[0][x];
			int count = 0;
			
			for(int y = 0; y < N; y++) {
				int cur = map[y][x];
				if(Math.abs(cur-bef) > 1) continue bb;
				if(cur == bef) count++;
				else {
					if(bef < cur) {
						if(count < L) {
							continue bb;
						}
						count = 1;
					} else {
						for(int k = 1; k < L; k++) {
							if(y+k >= N || map[y+k][x] != cur) continue bb;
						}
						count = 1-L;
					}
				}
				bef = cur;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
