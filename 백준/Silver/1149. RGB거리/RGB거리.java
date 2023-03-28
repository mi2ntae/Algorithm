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
			costs[i][0] = Integer.parseInt(st.nextToken());
			costs[i][1] = Integer.parseInt(st.nextToken());
			costs[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] memo = new int[N][3];
		memo[0][0] = costs[0][0];
		memo[0][1] = costs[0][1];
		memo[0][2] = costs[0][2];
		for(int i = 1; i < N; i++) {
			memo[i][0] = Integer.min(memo[i-1][1], memo[i-1][2]) + costs[i][0];
			memo[i][1] = Integer.min(memo[i-1][0], memo[i-1][2]) + costs[i][1];
			memo[i][2] = Integer.min(memo[i-1][0], memo[i-1][1]) + costs[i][2];
		}
		int ans = memo[N-1][0];
		ans = ans < memo[N-1][1] ? ans : memo[N-1][1];
		ans = ans < memo[N-1][2] ? ans : memo[N-1][2];
		System.out.println(ans);
		br.close();
	}
}