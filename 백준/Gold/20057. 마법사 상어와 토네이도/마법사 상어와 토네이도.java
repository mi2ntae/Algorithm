import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {0, 1, 0, -1};
	private static int[] dx = {-1, 0, 1, 0};
	private static int N;
	private static int[][] map;
	private static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int y = N/2;
		int x = N/2;
		int cnt = 0;
		int k = 1;
		int d = 0;
		int p = 2;
		int newx = x;
		int newy = y;
		while(newx+dx[d] >= 0) {
			newy += dy[d];
			newx += dx[d];
			tonado(newy, newx, d);
			if(++cnt == k) {
				p--;
				cnt = 0;
				d = (d+1)%4;
			}
			if(p == 0) {
				p = 2;
				k++;
			}
		}
		System.out.println(ans);
		br.close();
	}
	private static void tonado(int y, int x, int d) {
		int morae = map[y][x];
		int p10 = (int)(morae*0.1);
		int p7 = (int)(morae*0.07);
		int p5 = (int)(morae*0.05);
		int p2 = (int)(morae*0.02);
		int p1 = (int)(morae*0.01);
		
		if(d == 0 || d == 2) {
			addMorae(y-2, x, p2);
			addMorae(y-1, x, p7);
			addMorae(y+1, x, p7);
			addMorae(y+2, x, p2);
			if(d == 0) {
				addMorae(y-1, x-1, p10);
				addMorae(y-1, x+1, p1);
				addMorae(y+1, x-1, p10);
				addMorae(y+1, x+1, p1);
				addMorae(y, x-2, p5);
				addMorae(y, x-1, morae-p10*2-p7*2-p5-p2*2-p1*2);
			} else {
				addMorae(y-1, x+1, p10);
				addMorae(y-1, x-1, p1);
				addMorae(y+1, x+1, p10);
				addMorae(y+1, x-1, p1);
				addMorae(y, x+2, p5);
				addMorae(y, x+1, morae-p10*2-p7*2-p5-p2*2-p1*2);
			}
		}
		else {
			addMorae(y, x-2, p2);
			addMorae(y, x-1, p7);
			addMorae(y, x+1, p7);
			addMorae(y, x+2, p2);
			if(d == 1) {
				addMorae(y-1, x-1, p1);
				addMorae(y+1, x-1, p10);
				addMorae(y-1, x+1, p1);
				addMorae(y+1, x+1, p10);
				addMorae(y+2, x, p5);
				addMorae(y+1, x, morae-p10*2-p7*2-p5-p2*2-p1*2);
				
			} else {
				addMorae(y+1, x-1, p1);
				addMorae(y-1, x-1, p10);
				addMorae(y+1, x+1, p1);
				addMorae(y-1, x+1, p10);
				addMorae(y-2, x, p5);
				addMorae(y-1, x, morae-p10*2-p7*2-p5-p2*2-p1*2);
			}
		}
		map[y][x] = 0;
	}
	
	private static void addMorae(int y, int x, int num) {
		if(0 <= y && y < N && 0 <= x && x < N) map[y][x] += num;
		else ans += num;
	}
}