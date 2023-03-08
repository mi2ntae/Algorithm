import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] costs = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) costs[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] memo = new int[N][3];
		for(int i = 0; i < 3; i++) memo[0][i] = costs[0][i];
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j <3; j++) {
				if(j == 0) memo[i][j] = Math.min(memo[i-1][1], memo[i-1][2]);
				else if(j == 1) memo[i][j] = Math.min(memo[i-1][0], memo[i-1][2]);
				else memo[i][j] = Math.min(memo[i-1][0], memo[i-1][1]);
				memo[i][j] += costs[i][j];
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) ans = memo[N-1][i] < ans ? memo[N-1][i] : ans;
		System.out.println(ans);
		br.close();
	}
}