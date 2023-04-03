import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = {1, 0, 0, -1};
	private static int[] dx = {0, -1, 1, 0};
	private static int[][] dt = {{1, 2}, {3, 0}, {0, 3}, {2, 1}};
	private static int d = 2;
	private static int y, x;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean isOkay = true;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			if(com.equals("TURN")) d = dt[d][k];
			else {
				int ny = y + dy[d]*k;
				int nx = x + dx[d]*k;
				if(ny < 0 || ny > M || nx < 0 || nx > M) isOkay = false;
				y = ny;
				x = nx;
			}
		}
		if(isOkay) System.out.println(x+" "+y);
		else System.out.println(-1);
		br.close();
	}
}