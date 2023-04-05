import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			row: for(int y = 0; y < N; y++) {
				int bef = map[y][0];
				int count = 1;
				
				for(int x = 1; x < N; x++) {
					int cur = map[y][x];
					if(Math.abs(cur-bef) > 1) continue row;
					if(cur == bef) count++;	
					else {
						if(bef < cur) {
							if(count < X) continue row;	
							count = 1;
						} else {
							for(int k = 1; k < X; k++) {
								if(x+k >= N || map[y][x+k] != cur) continue row;
							}
							x += X-1;
							count = 0;
						}
					}
					bef = cur;
				}
				ans++;
			}
			col: for(int x = 0; x < N; x++) {
				int bef = map[0][x];
				int count = 1;
				
				for(int y = 1; y < N; y++) {
					int cur = map[y][x];
					if(Math.abs(cur-bef) > 1) continue col;
					if(cur == bef) count++;
					else {
						if(bef < cur) {
							if(count < X) continue col;
							count = 1;
						} else {
							for(int k = 1; k < X; k++) {
								if(y+k >= N || map[y+k][x] != cur) continue col;
							}
							y += X-1;
							count = 0;
						}
					}
					bef = cur;
				}
				ans++;
			}
			sb.append("#"+t+" "+ans+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}