import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
		int MAX = 1001;
		int ans = Integer.MAX_VALUE;
		for(int k = 0; k < 3; k++) {
			if(k == 0) {
				memo[0][0] = costs[0][0];
				memo[0][1] = MAX;
				memo[0][2] = MAX;
			} else if(k == 1) {
				memo[0][0] = MAX;
				memo[0][1] = costs[0][1];
				memo[0][2] = MAX;
			} else {
				memo[0][0] = MAX;
				memo[0][1] = MAX;
				memo[0][2] = costs[0][2];
			}
			
			for(int i = 1; i < N; i++) {
				memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2])+costs[i][0];
				memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2])+costs[i][1];
				memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1])+costs[i][2];
			}
			
			if(k == 0) {
				ans = Math.min(ans, memo[N-1][1]);
				ans = Math.min(ans, memo[N-1][2]);
			} else if(k == 1) {
				ans = Math.min(ans, memo[N-1][0]);
				ans = Math.min(ans, memo[N-1][2]);
			} else {
				ans = Math.min(ans, memo[N-1][0]);
				ans = Math.min(ans, memo[N-1][1]);
			}
		}
		System.out.println(ans);
		br.close();
	}
}