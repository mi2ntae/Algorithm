import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 10; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		ans = Integer.MAX_VALUE;
		dfs(0, 0, 0, 0, 0, 0, 0);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
		br.close();
	}
	private static void dfs(int i, int j, int cnt1, int cnt2, int cnt3, int cnt4, int cnt5) {
		if(i == 10) {
			boolean isCovered = true;
			for(int y = 0; y < 10; y++) {
				for(int x = 0; x < 10; x++) {
					if(map[y][x] == 1) isCovered = false;
				}
			}
			if(isCovered) ans = Math.min(ans, cnt1+cnt2+cnt3+cnt4+cnt5);
			return;
		}
		if(j == 10) {
			dfs(i+1, 0, cnt1, cnt2, cnt3, cnt4, cnt5);
			return;
		}
		if(map[i][j] == 0) dfs(i, j+1, cnt1, cnt2, cnt3, cnt4, cnt5);
		else {
			if(cnt1 < 5) {
				map[i][j] = 0;
				dfs(i, j+1, cnt1+1, cnt2, cnt3, cnt4, cnt5);
				map[i][j] = 1;
			}
			if(cnt2 < 5) {
				boolean isOkay = true;
				for(int y = i; y < i+2; y++) {
					for(int x = j; x < j+2; x++) {
						if(y >= 10 || x >= 10 || map[y][x] == 0) isOkay = false; 
					}
				}
				if(isOkay) {
					for(int y = i; y < i+2; y++) {
						for(int x = j; x < j+2; x++) map[y][x] = 0;
					}
					dfs(i, j+2, cnt1, cnt2+1, cnt3, cnt4, cnt5);
					for(int y = i; y < i+2; y++) {
						for(int x = j; x < j+2; x++) map[y][x] = 1;
					}
				}
			}
			if(cnt3 < 5) {
				boolean isOkay = true;
				for(int y = i; y < i+3; y++) {
					for(int x = j; x < j+3; x++) {
						if(y >= 10 || x >= 10 || map[y][x] == 0) isOkay = false; 
					}
				}
				if(isOkay) {
					for(int y = i; y < i+3; y++) {
						for(int x = j; x < j+3; x++) map[y][x] = 0;
					}
					dfs(i, j+3, cnt1, cnt2, cnt3+1, cnt4, cnt5);
					for(int y = i; y < i+3; y++) {
						for(int x = j; x < j+3; x++) map[y][x] = 1;
					}
				}
			}
			if(cnt4 < 5) {
				boolean isOkay = true;
				for(int y = i; y < i+4; y++) {
					for(int x = j; x < j+4; x++) {
						if(y >= 10 || x >= 10 || map[y][x] == 0) isOkay = false; 
					}
				}
				if(isOkay) {
					for(int y = i; y < i+4; y++) {
						for(int x = j; x < j+4; x++) map[y][x] = 0;
					}
					dfs(i, j+4, cnt1, cnt2, cnt3, cnt4+1, cnt5);
					for(int y = i; y < i+4; y++) {
						for(int x = j; x < j+4; x++) map[y][x] = 1;
					}
				}
			}
			if(cnt5 < 5) {
				boolean isOkay = true;
				for(int y = i; y < i+5; y++) {
					for(int x = j; x < j+5; x++) {
						if(y >= 10 || x >= 10 || map[y][x] == 0) isOkay = false; 
					}
				}
				if(isOkay) {
					for(int y = i; y < i+5; y++) {
						for(int x = j; x < j+5; x++) map[y][x] = 0;
					}
					dfs(i, j+5, cnt1, cnt2, cnt3, cnt4, cnt5+1);
					for(int y = i; y < i+5; y++) {
						for(int x = j; x < j+5; x++) map[y][x] = 1;
					}
				}
			}
		}
	}
}