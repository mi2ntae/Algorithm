import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] costs;
	private static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) costs[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int start = 0; start < N; start++) {
			boolean[] v = new boolean[N];
			v[start] = true;
			dfs(start, start, 1, v, 0);
		}
		System.out.println(ans);
		br.close();
	}
	
	private static void dfs(int start, int now, int count, boolean[] v, int cost) {
		if(count == N) {
			int home = costs[now][start];
			if(home != 0) ans = ans > home+cost ? home+cost : ans;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(costs[now][i] == 0 || v[i]) continue;
			v[i] = true;
			dfs(start, i, count+1, v, cost+costs[now][i]);
			v[i] = false;
		}
	}
}